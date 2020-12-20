package com.qq.dao;

import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public abstract class BaseDao<T>{
    private static DruidDataSource dataSource = null;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private static void initDruidDataSource(){
        dataSource = new DruidDataSource();
        Properties properties = new Properties();
        try {
            properties.load(BaseDao.class.getClassLoader().getResourceAsStream("config/DataSourceConfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource.configFromPropety(properties);
    }

    private Connection initConnection() throws SQLException, SQLException {
        initDruidDataSource();
        connection = dataSource.getConnection();
        return connection;
    }

    public int executeUpdate(String sql, Object ... params){
        try {
            initConnection();
            preparedStatement = connection.prepareStatement(sql);
            //执行语句之前，要先为每个问号赋值
            for(int i = 0; i < params.length; i++){
                preparedStatement.setObject(i + 1, params[i]);
            }
            //执行SQL语句并返回
            return preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            release(null, null, preparedStatement, connection);
            dataSource.close();
        }
        return 0;
    }

    public List<T> executeQuery(String sql, Object ... params){
        List<T> list = new ArrayList<>();
        try {
            initConnection();
            preparedStatement = connection.prepareStatement(sql);
            for(int i = 0; i < params.length; i++){
                preparedStatement.setObject(i + 1, params[i]);
            }
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                T t = mappingEntity(resultSet);
                list.add(t);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            release(resultSet, null, preparedStatement, connection);
            dataSource.close();
        }
        return list;
    }

    /** 模板方法 - 谁调用，谁实现 */
    public abstract T mappingEntity(ResultSet resultSet) throws SQLException;

    private void release(ResultSet resultSet, Statement statement, PreparedStatement preparedStatement, Connection connection){
        try {
            close(resultSet);
            close(statement);
            close(preparedStatement);
            close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void close(AutoCloseable closeable) throws Exception {
        if(Objects.nonNull(closeable)){
            closeable.close();
        }
    }
}

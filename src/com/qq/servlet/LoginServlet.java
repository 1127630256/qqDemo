package com.qq.servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.common.ServerResponse;
import com.qq.entity.EcqUsers;
import com.qq.service.EcqUsersService;
import com.qq.service.impl.EcqUserServiceImpl;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {

    private  EcqUsersService ecqUsersService = new EcqUserServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置字符编码为utf-8
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        System.out.println(username+"--------"+password);
        EcqUsers ecqUsers = ecqUsersService.selectByNameAndPwd(username,password);
        ObjectMapper jsonStr = new ObjectMapper();
        ServerResponse<EcqUsers> serverResponse;
        System.out.println(ecqUsers);
        if (Objects.isNull(ecqUsers)){
            serverResponse = new ServerResponse<>(0);
            String user = jsonStr.writeValueAsString(serverResponse);
            out.write(user);
        }else {
            serverResponse = new ServerResponse<>(1,ecqUsers,"index.html");
            String user = jsonStr.writeValueAsString(serverResponse);
            System.out.println(user);
            out.write(user);
        }
        out.close();
    }
}

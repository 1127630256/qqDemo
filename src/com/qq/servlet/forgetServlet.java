package com.qq.servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.common.ServerResponse;
import com.qq.entity.EcqUsers;
import com.qq.service.EcqUsersService;
import com.qq.service.impl.EcqUserServiceImpl;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/forget")
public class forgetServlet extends javax.servlet.http.HttpServlet {

    private  EcqUsersService ecqUsersService = new EcqUserServiceImpl();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws  IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String memo = request.getParameter("memo");
        String pwd = request.getParameter("pwd");
        EcqUsers ecqUsers = ecqUsersService.selectByNameAndMemo(username, memo);
        System.out.println("查询到的对象" +ecqUsers);
        response.setContentType("text/json;charset=UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        ServerResponse<EcqUsers> serverResponse;
        if (Objects.isNull(ecqUsers)){
            serverResponse = new ServerResponse<>(0);
            String valueAsString = objectMapper.writeValueAsString(serverResponse);
            System.out.println("账号或密保错误"+valueAsString);
            response.getWriter().write(valueAsString);
        }else {
            ecqUsersService.updatePwd(username,pwd);
            serverResponse = new ServerResponse<>(1, ecqUsers, "login.html");
            String valueAsString = objectMapper.writeValueAsString(serverResponse);
            System.out.println("账号或密保正确" + valueAsString);
            response.getWriter().write(valueAsString);
        }
    }
}

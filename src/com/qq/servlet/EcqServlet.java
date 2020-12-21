package com.qq.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.entity.EcqUsers;
import com.qq.service.EcqUsersService;
import com.qq.service.impl.EcqUserServiceImpl;
import com.qq.util.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/ecq")
public class EcqServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        EcqUsersService ecqUsersService = new EcqUserServiceImpl();
        EcqUsers nameAndFace = ecqUsersService.findNameAndFace(name);
        Result result = new Result();
        if (nameAndFace == null){
            result.setFlag(true);
            result.setErrorMsg("可以注册");
        }else{
            result.setFlag(false);
            result.setErrorMsg("已有该用户，不可以注册");
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(result);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }
}

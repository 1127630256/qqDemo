package com.qq.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.entity.EcqUsers;
import com.qq.service.EcqUsersService;
import com.qq.service.impl.EcqUserServiceImpl;
import com.qq.util.Result;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/ecqUsersServlet")
public class EcqUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            System.out.println(name);
            String age = request.getParameter("age");
            String sex = request.getParameter("sex");
            String password = request.getParameter("password");
            String username = request.getParameter("username");
            String xz = request.getParameter("xz");
            String xuex = request.getParameter("xuex");
            String mibao = request.getParameter("mibao");
            Result result = new Result();
            boolean b = true;
            boolean f = false;
            EcqUsers ecqUsers = new EcqUsers();
            EcqUsersService ecqUsersService = new EcqUserServiceImpl();
            ecqUsers.setNickname(name);
            ecqUsers.setSex(sex);
            ecqUsers.setLoginpwd(password);
            ecqUsers.setRealname(username);
            Integer ags = Integer.parseInt(age);
            Integer xingz = Integer.parseInt(xz);
            Integer xuexin = Integer.parseInt(xuex);
            ecqUsers.setAge(ags);
            ecqUsers.setStar(xingz);
            ecqUsers.setBlood(xuexin);
            ecqUsers.setMemo(mibao);
            boolean count = ecqUsersService.BuddyListener(ecqUsers);
            if(count) {
                result.setFlag(b);
                result.setErrorMsg("注册成功");
                result.setData(ecqUsers);
            }else {
                result.setFlag(f);
                result.setErrorMsg("注册失败");
            }
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(result);
            System.out.println("1");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

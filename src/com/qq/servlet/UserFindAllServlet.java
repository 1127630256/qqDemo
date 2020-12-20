package com.qq.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import com.qq.entity.EcqUsers;
import com.qq.service.EcqUsersService;
import com.qq.service.impl.EcqUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/userFindAll")
public class UserFindAllServlet extends HttpServlet {
    private EcqUsersService ecqUsersService= new EcqUserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String hostIdStr = request.getParameter("hostId");
        int hostId = Integer.parseInt(hostIdStr);
        List<EcqUsers> allFriend = ecqUsersService.findAllFriend(hostId);
        ObjectMapper mapper=new ObjectMapper();
        String allFriendJson = mapper.writeValueAsString(allFriend);
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(allFriendJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

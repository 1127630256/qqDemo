package com.qq.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qq.entity.EcqUsers;
import com.qq.service.EcqFriendShipsService;
import com.qq.service.EcqUsersService;
import com.qq.service.impl.EcqFriendShipsServiceImpl;
import com.qq.service.impl.EcqUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteFriend")
public class deleteFriendServlet extends HttpServlet {
    EcqUsersService ecqUsersService=new EcqUserServiceImpl();
    EcqFriendShipsService ecqFriendShipsService=new EcqFriendShipsServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hostIdStr = request.getParameter("hostId");
        String nickName = request.getParameter("nickName");
        System.out.println(nickName);
        int hostId = Integer.parseInt(hostIdStr);
        EcqUsers ecqUsers = ecqUsersService.findNameAndFace(nickName);
        Boolean flag = ecqFriendShipsService.deleteEcqFriend(hostId, ecqUsers.getUserid());
        ObjectMapper objectMapper=new ObjectMapper();
        String flagJosn = objectMapper.writeValueAsString(flag);
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(flagJosn);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

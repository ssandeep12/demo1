package com.test.curd.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.curd.dao.DaoPerson;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{
		System.out.println("Delete Controller");
		String sid = request.getParameter("personid");
		System.out.println(sid);
		int personid=Integer.parseInt(sid);
		DaoPerson dao= new DaoPerson();
		dao.delete(personid);
	RequestDispatcher rd=request.getRequestDispatcher("view");
	rd.include(request, response);
	
	
	}

}

package com.test.curd.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.curd.dao.DaoPerson;
import com.test.curd.model.Person;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Persons</h1>");

		String sid = request.getParameter("personid");
		int personid = Integer.parseInt(sid);
		System.out.println(personid);
		
		
		DaoPerson dao=new DaoPerson();
		Person person=dao.getRecordBypersonid(personid)	;
		System.out.println("p is++" +person);
		request.setAttribute("person", person);
		RequestDispatcher rd=request.getRequestDispatcher("Edit.jsp");
		rd.include(request, response);
		
	}

}

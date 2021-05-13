package com.test.curd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.curd.dao.DaoPerson;
import com.test.curd.model.Person;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='userform.jsp'>Add New Person</a>");
		out.println("<h1>Persons List</h1>");

		DaoPerson dao= new DaoPerson();
		List<Person> list = dao.getAllPersons();
		
		request.setAttribute("list", list);
		RequestDispatcher rd= request.getRequestDispatcher("viewPersons.jsp");
		
		rd.forward(request, response);
		

		out.close();
	}

}

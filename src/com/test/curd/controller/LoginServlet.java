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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("Enter into doPost method");
		String name = request.getParameter("personname");
		String password = request.getParameter("personpassword");
		System.out.println("personname is" + name);
		System.out.println("password is" + password);
		/*
		 * HttpSession session=request.getSession();
		 * session.setAttribute("personname", name);
		 */

		DaoPerson dao = new DaoPerson();

		if (name != null && name != "") {
			boolean status = dao.validate(name);

			if (status) {
				RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
				rd.forward(request, response);
			}else {
				out.print("person name error");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}

		} 

	}

}

package com.test.curd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.curd.dao.DaoPerson;
import com.test.curd.model.Person;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Person p = new Person();
		DaoPerson dao = new DaoPerson();

		System.out.println("hello Srevlet");

		String btn = request.getParameter("btn");
		System.out.println(btn);
		if (btn.equals("UpdatePetrson")) {

			String personId = request.getParameter("personid");
			int personid = Integer.parseInt(personId);
			System.out.println(personid);
			String name = request.getParameter("personname");
			String password = request.getParameter("personpassword");
			String dept = request.getParameter("persondept");
			String behaviour = request.getParameter("personbehaviour");
			String city = request.getParameter("personcity");

			p.setPersonid(personid);
			p.setPersonname(name);
			p.setPersonpassword(password);
			p.setPersondept(dept);
			p.setPersonbehaviour(behaviour);
			p.setPersoncity(city);

			int status1 = dao.update(p);

			System.out.println(status1);
			System.out.println("for update Method Person =====" + p);

			if (status1 != 0) {
				System.out.println("succussfully Updated");
				 response.sendRedirect("/ServletJspCurd/view");

			} else {
				out.print("Error While Updating");
				RequestDispatcher rd = request.getRequestDispatcher("view");
				rd.forward(request, response);

			}

		} else if (btn.equals("AddPerson")){

			String name = request.getParameter("personname");
			String password = request.getParameter("personpassword");
			String dept = request.getParameter("persondept");
			String behaviour = request.getParameter("personbehaviour");
			String city = request.getParameter("personcity");

			p.setPersonname(name);
			p.setPersonpassword(password);
			p.setPersondept(dept);
			p.setPersonbehaviour(behaviour);
			p.setPersoncity(city);
			System.out.println("for Save Method Person =====" + p);
			int status = dao.save(p);
			System.out.println(status);
			if (status > 0) {
				
				System.out.print("saved Successfully");
				 response.sendRedirect("/ServletJspCurd/view");

			} else {
				System.out.print("Error While saving");
				RequestDispatcher rd = request.getRequestDispatcher("userform.jsp");
				rd.forward(request, response);
			}

		}
	}
}

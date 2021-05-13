package com.test.curd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.curd.model.Person;

public class DaoPerson {

	public boolean validate(String name) {
		boolean status = false;

		Connection con = null;
		try {
			con = getDBConnection();
			PreparedStatement ps = con.prepareStatement("select * from persondetails where personname=?");

			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			System.out.println("status...." + status);

		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}

	private static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		Connection con;
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/personinfo", "root", "admin");
		return con;
	}

	public static int save(Person p) {
		int status = 0;
		try {
			Connection con = getDBConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into persondetails(personname,personpassword,persondept,personbehaviour,personcity) values(?,?,?,?,?)");
			ps.setString(1, p.getPersonname());
			ps.setString(2, p.getPersonpassword());
			ps.setString(3, p.getPersondept());
			ps.setString(4, p.getPersonbehaviour());
			ps.setString(5, p.getPersoncity());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public  List<Person> getAllPersons() {
		List<Person> list = new ArrayList<Person>();

		try {
			Connection con = getDBConnection();
			PreparedStatement ps = con.prepareStatement("select * from persondetails");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Person p = new Person();
				p.setPersonid(rs.getInt("personid"));
				p.setPersonname(rs.getString("personname"));
				p.setPersonpassword(rs.getString("personpassword"));
				p.setPersondept(rs.getString("persondept"));
				p.setPersonbehaviour(rs.getString("personbehaviour"));
				p.setPersoncity(rs.getString("personcity"));

				list.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public static int update(Person p) {
		int status = 0;
		try {
			Connection con = getDBConnection();
			PreparedStatement ps = con.prepareStatement(
					"update persondetails set personname=?,personpassword=?,persondept=?,personbehaviour=?,personcity=? where personid=?");
			ps.setString(1, p.getPersonname());
			ps.setString(2, p.getPersonpassword());
			ps.setString(3, p.getPersondept());
			ps.setString(4, p.getPersonbehaviour());
			ps.setString(5, p.getPersoncity());
			ps.setInt(6, p.getPersonid());
			status = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public  Person getRecordBypersonid(int personid) {
		Person p = null;
		try {
			Connection con = getDBConnection();
			PreparedStatement ps = con.prepareStatement("select * from persondetails where personid=?");
			ps.setInt(1, personid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Person();
				p.setPersonid(rs.getInt("personid"));
				p.setPersonname(rs.getString("personname"));
				p.setPersonpassword(rs.getString("personpassword"));
				p.setPersondept(rs.getString("persondept"));
				p.setPersonbehaviour(rs.getString("personbehaviour"));
				p.setPersoncity(rs.getString("personcity"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return p;
	}
	  public static int delete(int personid){  
	        int status=0;  
	        try{  
	            Connection con=DaoPerson.getDBConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from persondetails where personid=?");  
	            ps.setInt(1,personid);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
}

package com.test.curd.model;




import java.io.Serializable;

public class Person implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int personid;
	private String personname;
	private String personpassword;
	private String persondept;
	private String personbehaviour;
	private String personcity;
	public int getPersonid() {
		return personid;
	}
	public void setPersonid(int personid) {
		this.personid = personid;
	}
	public String getPersonname() {
		return personname;
	}
	public void setPersonname(String personname) {
		this.personname = personname;
	}
	public String getPersonpassword() {
		return personpassword;
	}
	public void setPersonpassword(String personpassword) {
		this.personpassword = personpassword;
	}
	public String getPersondept() {
		return persondept;
	}
	public void setPersondept(String persondept) {
		this.persondept = persondept;
	}
	public String getPersonbehaviour() {
		return personbehaviour;
	}
	public void setPersonbehaviour(String personbehaviour) {
		this.personbehaviour = personbehaviour;
	}
	public String getPersoncity() {
		return personcity;
	}
	public void setPersoncity(String personcity) {
		this.personcity = personcity;
	}
	public Person(int personid, String personname, String personpassword, String persondept, String personbehaviour,
			String personcity) {
		super();
		this.personid = personid;
		this.personname = personname;
		this.personpassword = personpassword;
		this.persondept = persondept;
		this.personbehaviour = personbehaviour;
		this.personcity = personcity;
	}
	@Override
	public String toString() {
		return "Person [personid=" + personid + ", personname=" + personname + ", personpassword=" + personpassword
				+ ", persondept=" + persondept + ", personbehaviour=" + personbehaviour + ", personcity=" + personcity
				+ "]";
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

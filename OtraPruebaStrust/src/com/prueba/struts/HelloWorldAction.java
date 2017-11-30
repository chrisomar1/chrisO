package com.prueba.struts;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	
	public String execute() throws Exception
	{
		if("SECRET".equals(name))
		{
			return "SUCCESS".toLowerCase();
		}
		else
		{
			return "ERROR".toLowerCase();
		}
	}	
		public String getName()
		{
			return name;
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
	
	

}

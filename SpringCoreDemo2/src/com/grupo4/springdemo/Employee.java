package com.grupo4.springdemo;

public class Employee {
    int eId;
    String eName;
    String eAddress;
    
    public Employee()
    {
    	System.out.println(" --- Object Created --- ");
    }

	public Employee(int eId, String eName, String eAddress) {
		
		this.eId = eId;
		this.eName = eName;
		this.eAddress = eAddress;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteAddress() {
		return eAddress;
	}

	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", eName=" + eName + ", eAddress=" + eAddress + "]";
	}
	
	public void myInit()
	{
		System.out.println("-- Object Initializaed --");
	}
			
	public void myDestroy()
	{
		System.out.println("-- Object Destroyed --");
	}
    

}

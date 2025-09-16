package pack1;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CustomerBean implements Serializable  
{
	private String uName;
	private String uPassword;
	private String uFirstName;
	private String uLastName;
	private String uAddress;
	private String uMailId;
	private String uPhone;
	
	public CustomerBean() {}

	public String getuName() 
	{
		return uName;
	}

	public void setuName(String uName) 
	{
		this.uName = uName;
	}

	public String getuPassword() 
	{
		return uPassword;
	}

	public void setuPassword(String uPassword) 
	{
		this.uPassword = uPassword;
	}

	public String getuFirstName() 
	{
		return uFirstName;
	}

	public void setuFirstName(String uFirstName)
	{
		this.uFirstName = uFirstName;
	}

	public String getuLastName() {
		return uLastName;
	}

	public void setuLastName(String uLastName) 
	{
		this.uLastName = uLastName;
	}

	public String getuAddress()
	{
		return uAddress;
	}

	public void setuAddress(String uAddress)
	{
		this.uAddress = uAddress;
	}

	public String getuMailId() 
	{
		return uMailId;
	}

	public void setuMailId(String uMailId)
	{
		this.uMailId = uMailId;
	}

	public String getuPhone() 
	{
		return uPhone;
	}

	public void setuPhone(String uPhone) 
	{
		this.uPhone = uPhone;
	}	
}
package step_definition;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObject.AddcustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class Baseclass {
	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage addcust;
	public SearchCustomerPage searchcust;
	
	//create random emailid
	public static String randomestring()
	{
	String generatedString1 =	RandomStringUtils.randomAlphabetic(5);
	return(generatedString1);
	}


}

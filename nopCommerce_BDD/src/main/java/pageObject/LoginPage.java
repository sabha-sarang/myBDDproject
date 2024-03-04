package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
private WebDriver driver;
	
	//locators
	private By emailInputLocator = By.name("Email");
	private By passwordInputLocator = By.name("Password");
    private By loginButtonLocator = By.xpath("//button[text()='Log in']");
    private By logoutLinkLocator = By.linkText("Logout");
    
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	//methods
	public void enterEmail(String email)
	{
	WebElement emailInput =driver.findElement(emailInputLocator);
	emailInput.clear();
	emailInput.sendKeys(email);
    }
	
	public void enterPassword(String password)
	{
		WebElement passwordInput =driver.findElement(passwordInputLocator);
		passwordInput.clear();
		passwordInput.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
	WebElement loginButton=driver.findElement(loginButtonLocator);	
	loginButton.click();
	}
	
	public void clickLogout()	{
    WebElement logoutButton= driver.findElement(logoutLinkLocator);
    logoutButton.click();
	}
	
    public void login( String email, String password)
    {
    	enterEmail(email);
    	enterPassword(password);
    	clickLoginButton();
    	 }
}
package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {
     
  public WebDriver driver;
	
    //constructor
	public AddcustomerPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	//locators
	 By Customers_menu = By.xpath("//a[@href='#'] //p[contains(text(),'Customers')]");
	 By Customers_menuitem = By.xpath("//a[@href='/Admin/Customer/List'] //p[contains(text(),'Customers')]");
     By AddNewButton = By.xpath("//a[@class='btn btn-primary']");
     By EnterEmail = By.id("Email");
     By EnterPassword = By.id("Password");
	 By EnterFirstName = By.id("FirstName");
     By EnterLastName = By.id("LastName");
     By CustomerRoles = By.xpath("//body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");
     By itemAdministrators= By.xpath("//li[contains(text(),'Administrators')]");
     By itemRegistered= By.xpath("//li[contains(text(),'Registered')]");
     By itemGuests= By.xpath("//li[contains(text(),'Guests')]");
     By itemVendors= By.xpath("//li[contains(text(),'Vendors')]");
     By drpVendors= By.xpath("//*[@id='VendorId']");
     By MaleGender= By.id("Gender_Male");
     By FemaleGender= By.id("Gender_Female");
     By EnterDob= By.xpath("//input[@id='DateOfBirth']");
     By CompanyName= By.id("Company");
     By AdminContent= By.id("AdminComment");
     By SaveButton = By.name("save");
     
     public String getPageTitle()
     {
    	return driver.getTitle();
     }
     public void clickOnCustomersMenu()
     {
     driver.findElement(Customers_menu).click();
     }
    
     public void clickOnCustomersMenuItem()
     {
     driver.findElement(Customers_menuitem).click();
     }
    
     public void clickOnAddnew()
     {
     driver.findElement(AddNewButton).click(); 
     }
    
     public void setEmail(String email)
     {
     driver.findElement(EnterEmail).sendKeys(email);
     }
    
     public void setPassword(String password)
     {
     driver.findElement(EnterPassword).sendKeys(password);

     }
    
     public void setCustomerRoles(String role) throws InterruptedException
     {
    	 if(!role.equals("Vendors"))
    	 {
   WebElement regclick =driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span/span"));
   JavascriptExecutor js= (JavascriptExecutor)driver;
   	js.executeScript("arguments[0].click()",regclick);

    	 }
    	
    	driver.findElement(CustomerRoles).click();
    	 

    	
    	WebElement listitem;
    	Thread.sleep(3000);
    	
    	if(role.equals("Administrators"))
    	{
    		listitem=driver.findElement(itemAdministrators);
    	}
    	else if(role.equals("Guests")) {
    		listitem=driver.findElement(itemGuests);
    	}
    	else if(role.equals("Registered")) {
    		listitem=driver.findElement(itemRegistered);
    	}
    	else if(role.equals("Vendors")) {
    		listitem=driver.findElement(itemVendors);
    	}
    		else
    		{
    			listitem=driver.findElement(itemGuests);

    		}
    	listitem.click();
    	Thread.sleep(3000);
    	
    	//JavascriptExecutor js= (JavascriptExecutor)driver;
    //	js.executeScript("argument[0].click();" ,listitem);
     }
      
     public void setManagerOfVendor(String value)
     {
    	 Select drp= new Select(driver.findElement(drpVendors));
    	 drp.selectByVisibleText(value);
     }
     
     public void setGender(String gender) {
    	 if(gender.equals("Male"))
    	 {
    		 driver.findElement(MaleGender).click();
    	 }
    	 else if(gender.equals("Female"))
    	 {
    		 driver.findElement(FemaleGender).click();
    	 }
    	 else
    	 {
    		 driver.findElement(MaleGender).click();
           }
     }
      public void setFirstName(String fname)
      {
    	  driver.findElement(EnterFirstName).sendKeys(fname);
      }
      public void setLastName(String lname)
      {
    	  driver.findElement(EnterLastName).sendKeys(lname);
      }
      
      public void setDob(String dob)
      {
    	  driver.findElement(EnterDob).sendKeys(dob);
      }
      
      public void setCompanyName(String comname)
      {
    	  driver.findElement(CompanyName).sendKeys(comname);
      }
      
      public void setAdminContent(String content)
      {
    	  driver.findElement(AdminContent).sendKeys(content);
      }
      
      public void clickOnSave()
      {
    	  driver.findElement(SaveButton).click();
      }
      
    
}
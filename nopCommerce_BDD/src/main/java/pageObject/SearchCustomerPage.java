package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.WaitHelper;

public class SearchCustomerPage {
public WebDriver driver;
WaitHelper waithelper;

public SearchCustomerPage(WebDriver driver)
{
	this.driver=driver;
	waithelper= new WaitHelper(driver);
}
     By SearchEmail = By.id("SearchEmail");
      By SearchFirstName = By.name("SearchFirstName");
      By SearchLastName = By.name("SearchLastName");
      By SearchMonthDob = By.id("SearchMonthOfBirth");
      By SearchDayDob = By.id("SearchDayOfBirth");
      By SearchByCompany= By.id("SearchCompany");
      By GetCustomerRoles= By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
      By GetitemAdministrators= By.xpath("//li[contains(text(),'Administrators')]");
      By GetitemRegistered= By.xpath("//li[contains(text(),'Registered')]");
      By GetitemGuests= By.xpath("//li[contains(text(),'Guests')]");
      By GetitemVendors= By.xpath("//li[contains(text(),'Vendors')]");
      By SearchButton = By.id("search-customers");
      By tableSearchResults=By.xpath("//table[@role='grid']");
      @FindBy(xpath="//table[@id='customers-grid']")
      WebElement table;
      
      By tableRows= By.xpath("//table[@id='customers-grid']//tbody/tr");
      By tableColumns= By.xpath("//table[@id='customers-grid']//tbody/tr/td");

      public void setEmail(String email) throws InterruptedException
      {
    	Thread.sleep(3000);
      WebElement getEmail= driver.findElement(SearchEmail);
      getEmail.clear();
      getEmail.sendKeys(email);
    	 
      }
      
      public void setfirstName(String fname) throws InterruptedException
      {
        Thread.sleep(3000);
       WebElement getFirstName =  driver.findElement(SearchFirstName);
       getFirstName.clear();
       getFirstName.sendKeys(fname);
      }
   
      public void setlastName(String lname) throws InterruptedException
      {
    	  Thread.sleep(3000);
       WebElement getLastName =  driver.findElement(SearchLastName);
       getLastName.clear();
       getLastName.sendKeys(lname);
      }

      public void clickSearch() throws InterruptedException
      {
    	  Thread.sleep(3000);
    	  driver.findElement(SearchButton).click();
    	  Thread.sleep(3000);
      }
      
      public int getNoOfRows()
      {
		List<WebElement> rows=driver.findElements(tableRows);
		return(rows.size());
    	  
      }
      
      public int getNoOfColumns()
      {
		List<WebElement> Columns=driver.findElements(tableColumns);
		return(Columns.size());
    	  
      }
  
      public boolean searchCustomerByEmail(String email)
      {
    	  boolean flag=false;
    	  for(int i=0;i<=getNoOfRows();i++)
    	  {
    		 String emailid =driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr/td[2]")).getText();
    	 if(emailid.equals("brenda_lindgren@nopCommerce.com"))
    	 {
    	  flag=true;
    	  }
      }
    	  return flag;
      }
      
      public boolean searchCustomerByName(String Name)
      {
    	  boolean flag=false;
    	  for(int i=1;i<=getNoOfRows();i++)
    	  {
    		 String name =driver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr/td[3]")).getText();
    		 String names[] = name.split(" ");
    	 if(names[0].equals("Brenda") && names[1].equals("Lindgren"))
    	 {
    	  flag=true;
    	  }
      }
    	  return flag;
      }
}
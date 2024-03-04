package step_definition;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.AddcustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class LoginStepdefinition extends Baseclass{
	
		
	@Given("User launch Chrome Browser")
	public void user_launch_chrome_browser() {
		driver= new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login");
	 lp= new LoginPage(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	  driver.get(url);
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.enterEmail(email);
	    lp.enterPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
	   lp.clickLoginButton();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
	if(driver.getPageSource().contains("Login was unsuccessful."))
   {
	driver.close();
	Assert.assertTrue(false);
   }else {
	Assert.assertEquals(title, driver.getTitle());
   }
	}
	
	
	@When("User click on Log Out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	   lp.clickLogout();
	   Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
	   driver.close();
	}

  //customer feature
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	   addcust= new AddcustomerPage(driver);
	   Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		addcust.clickOnCustomersMenu();
	   	}
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(2000);
	   addcust.clickOnCustomersMenuItem();
	   }

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		addcust.clickOnAddnew();
		Thread.sleep(20000);
	   	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
	Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());   
	}
	

   @When("User enter customer info")
   public void user_enter_customer_info() throws InterruptedException {
   String email= randomestring()+"@gmail.com";
   addcust.setEmail(email);
   addcust.setPassword("test123");
   addcust.setGender("Male");
   addcust.setFirstName("sara");
   addcust.setLastName("sarang");
   addcust.setDob("10/06/2001");
   addcust.setCompanyName("busyQA");
   //Registered-default
   //customer cannot be both "guests and registered customer role
   //add customer to guests or registered customer role
   addcust.setCustomerRoles("Guest");
   Thread.sleep(2000);
   addcust.setManagerOfVendor("Vendor 2");
    addcust.setAdminContent("this is testing...");
   }
   
   @When("click on Save button")
   public void click_on_save_button() throws InterruptedException {
     addcust.clickOnSave();
     Thread.sleep(2000);
   }
   
   @Then("User can view confirmation message {string}")
   public void user_can_view_confirmation_message(String msg) {
	   Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
			   .contains("The new customer has been added successfully."));
   }
//steps for searching a customer using Email ID
   @When("Enter customer Email")
   public void enter_customer_email() throws InterruptedException {
       searchcust= new SearchCustomerPage(driver);
       searchcust.setEmail("brenda_lindgren@nopCommerce.com");
   }
   @When("Click on search button")
   public void click_on_search_button() throws InterruptedException {
	   searchcust.clickSearch();
	   Thread.sleep(3000);
       }
   @Then("User should find Email in the Search table")
   public void user_should_find_email_in_the_search_table() {
    boolean status= searchcust.searchCustomerByEmail("brenda_lindgren@nopCommerce.com");
    Assert.assertEquals(true, status);
      }

   //search customer by name
     @When("Enter customer FirstName")
   public void enter_customer_first_name() throws InterruptedException {
    	 searchcust= new SearchCustomerPage(driver);
    	 searchcust.setfirstName("Brenda");
   }
   @When("Enter customer LastName")
   public void enter_customer_last_name() throws InterruptedException {
	   //Thread.sleep(2000);
       searchcust.setlastName("Lindgren");
   }
   @Then("User should find Name in search table")
   public void user_should_find_name_in_search_table() {
	boolean status =   searchcust.searchCustomerByName("Brenda Lindgren");
	  Assert.assertEquals(true, status);
	   }
  
    
	


	
	
	
}

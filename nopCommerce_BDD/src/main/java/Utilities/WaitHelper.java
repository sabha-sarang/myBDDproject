package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
public WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitForElementtoAppear(By findBy)
    {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }
	
}

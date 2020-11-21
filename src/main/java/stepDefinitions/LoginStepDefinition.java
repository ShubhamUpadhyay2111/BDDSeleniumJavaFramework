package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStepDefinition {

	WebDriver driver;

	@Given("^User is already on Login Page$")
	public void user_is_already_on_Login_Page(){
		System.setProperty("webdriver.chrome.driver","D:\\Workspace\\FreeCrmBDDFramework\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://freecrm.co.in/");
	}

	@When("^Title of Login Page is Free CRM$")
	public void title_of_Login_Page_is_Free_CRM(){
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Free CRM #1 cloud software for any business large or small", title);
	}

	@Then("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_username_and_password(String username, String password) {
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

	@Then("^User clicks on LoginButton$")
	public void user_clicks_on_LoginButton() {
		WebElement loginBtn=  driver.findElement(By.xpath("//a[@class = \"btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left\"]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginBtn);
	}

	@Then("^User clicks on Login$")
	public void user_clicks_on_Login() {
		WebElement loginBtn= driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginBtn);
	}

	@Then("^User is on Home Page$")
	public void user_is_on_Home_Page() {
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Cogmento CRM", title);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
		killAllChromedriver();
	}

	public static void killAllChromedriver() {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

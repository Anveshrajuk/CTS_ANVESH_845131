package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Browser_waits;

public class Login_page extends Browser_waits { // Login page

	// getting xpath for user
	By usr = By.xpath("//input[@id='user-name']");

	// getting xpath for password
	By pwd = By.xpath("//input[@id='password']");

	// getting xpath for click
	By CLCK = By.xpath("//input[@class='btn_action']");

	WebDriver dr;

	public Login_page(WebDriver dr) {
		// initializing constructor
		this.dr = dr;
	}

	public void Username(String name) // Entering the Username
	{
		WebElement wt1 = WaitForElement(usr, 20);
		wt1.sendKeys(name);
	}

	public void Password(String passwd) // Entering the Password
	{
		WebElement wt2 = WaitForElement(pwd, 20);
		wt2.sendKeys(passwd);
	}

	public void CLK_BTN() // Clicking the Login Button
	{
		WebElement wt3 = WaitForElement(CLCK, 20);
		wt3.click();
	}

	public void Total_Login(String Usrname, String Pswd) // Calling all the Login Functions
	{
		System.out.println(Usrname + " " + Pswd);
		this.Username(Usrname);
		this.Password(Pswd);
		this.CLK_BTN();

	}

}

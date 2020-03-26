package Test_Cases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EXCEL.Read_excel;
import Pages.About_Page;
import Pages.AddtoCart_Page;
import Pages.Login_page;
import utilities.Browser_waits;



public class saucedemo_ch extends Read_excel {
 static WebDriver dr;
	 
	 @BeforeClass
	  public void beforeMethod()
	 {
		 get_Excel();
		 }
 
	 
	 @Test(dataProvider="logindata")
  public void Logindata(String Username,String Password) throws InterruptedException {
	 System.out.println("running succesfully");
	 dr=Browser_waits.Launch_browser("CHROME","https://www.saucedemo.com/");  //opening the chrome browser and url given.
	 Login_page Ln=new Login_page(dr);
	   System.out.println(Username+" "+Password);
	Ln.Total_Login(Username,Password);   //Entering username, password and clicking login button were happening here.
  }
  
	 
	 @DataProvider(name="logindata")
  public String[][] data_Provider() 
   {
	  System.out.println("return data");
	  return testdata;
  }
  
  
  public void searchA2B()
  {
	  AddtoCart_Page A1=new AddtoCart_Page(dr);
	  A1.SearchA2Z();
	  A1.Addtocart_btn();
  }
  
  
  public void AboutPage() throws InterruptedException
  {
	  About_Page A2=new About_Page(dr);
	  A2.link_for_aboutpage();
	  A2.About_Saucedemo();
	  A2.any_btn();
  }
  
  @AfterMethod()
  public void hd() throws  IOException, InterruptedException
  {
	  searchA2B();
		AboutPage(); 
		Browser_waits.screen_shot();
		dr.close();
  }
}
  

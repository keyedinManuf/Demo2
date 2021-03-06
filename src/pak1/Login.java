package pak1;

import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;


public class Login 
{
	public static WebDriver dr = new FirefoxDriver();
	@BeforeTest
	  public void beforeTest() throws IOException 
	  {
		  dr.manage().window().maximize();
		  dr.get(Attributes().getProperty("URL"));
	  }

	@Test
	  public Properties Attributes() throws IOException
	  {
		System.out.println("Prop Attributes");
		FileReader ff = new FileReader("D:/test/0_KeyedTestNG/src/pak2/KeyedIN_Attributes");
		Properties pp = new Properties();
		pp.load(ff);
		return(pp);
	  }
	
	@Test
	  public Properties Testdata() throws IOException 
	  {
		System.out.println("Prop Testdata");
		FileReader ff = new FileReader("D:/test/0_KeyedTestNG/src/pak2/KeyedIN_TestData");
		Properties pp = new Properties();
		pp.load(ff);
		return(pp);  
	  }
	
	@Test (priority=0)
	  public void Login1() throws IOException 
	  {
		try{
			System.out.println("Start Login");
			dr.findElement(By.xpath("/html/body/div/div/form/ul/li[1]/input")).sendKeys("lizc-admin");
			dr.findElement(By.xpath("/html/body/div/div/form/ul/li[2]/input")).sendKeys("password");
			dr.findElement(By.xpath("/html/body/div/div/form/ul/li[3]/input")).click();
			String Str1 = dr.getPageSource();
			String Str2 = "User Name";
			if(Str1.contains(Str2))
			{
				System.out.println("Yet To Login");
			}
			else
			{
				System.out.println("Logged In Successfully");
			}	
			}catch(NoSuchElementException e){
				System.out.println(e);
				System.out.println("rest of the code...");
			}
	  }
}

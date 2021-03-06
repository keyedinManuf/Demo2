package pak0;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;


public class DemoSOManipulation
{
	public static WebDriver dr = new FirefoxDriver();
	public static String Str;
	
	@Test(enabled=true)
	  public void Login() throws IOException
	  {
		try{
			dr.manage().window().maximize();
			dr.get("http://kimdev01.keyedinuat.com/Dev03/Tab/71");
			WebDriverWait wait = new WebDriverWait(dr, 30);
			wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("/html/body/div/div/form/ul/li[1]/label"), "User Name"));
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
	
	@Test (priority=1)
	  public void AddSO() 
	  {
		System.out.println("************** SALES ORDER CREATION **************");
		dr.findElement(By.xpath(".//a[@href='/Dev03/Form/Create/70']")).click();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[5]/div/input")).sendKeys("Test");
		dr.findElement(By.xpath("html/body/div[5]/ul/li[2]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[5]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[6]/div/input")).sendKeys("KI Bikes");
		dr.findElement(By.xpath("html/body/div[6]/ul/li[1]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[6]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[7]/div/input")).sendKeys("CAD - Canadian Dollars");
		dr.findElement(By.xpath("html/body/div[7]/ul/li[1]/div")).click();
		dr.findElement(By.xpath("html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[8]/div[2]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		dr.findElement(By.xpath("html/body/div[8]/div/input")).sendKeys("Mark B");
		dr.findElement(By.xpath("html/body/div[8]/ul/li[1]/div")).click();
		dr.findElement(By.xpath(".//button[@class='btn btn-xs btn-success']")).click();
		WebElement WE1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
		Str = WE1.getText();
		System.out.println("New Sales Order Created Succesfully & Order Number is: "+Str);	  
		
		//Add Sales Order Items against created SO
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/button[3]")).click();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[3]/div[1]/div/div/div[2]/div/div[1]/span/div/a/span[1]")).click();
		WebElement wb1 = dr.findElement(By.xpath("/html/body/div[5]/ul"));
		List<WebElement> l1 = wb1.findElements(By.xpath("/html/body/div[5]/ul/li"));
		Random rand = new Random(System.currentTimeMillis());
		WebElement links = l1.get(rand.nextInt(l1.size()));
		System.out.println("Rval: "+l1.size());
		links.click();
		
	  }
	
	@Test (priority=2)
	  public void SearchSO() throws IOException
	  {
		System.out.println("************** SALES ORDER SEARCH **************");
		dr.get("http://kimdev01.keyedinuat.com/Dev03/Tab/71");
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).click();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).sendKeys(Str);
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[9]/button[1]")).click();

		List<WebElement> V2 = dr.findElements(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
		int C2 = V2.size();
			if(C2==0)
			{
				System.out.println("Entered Order Number "+ Str +" is not filtered in the below list");
			}
				else
				{
					System.out.println("Entered Order Number "+ Str +" is filtered in the below list");
				}
	  }
	
	@Test (priority=3)
	public void EditSO() throws InterruptedException
	{
		System.out.println("************** SALES ORDER EDIT **************");
		dr.get("http://kimdev01.keyedinuat.com/Dev03/Tab/71");
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).click();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[1]/input[1]")).sendKeys(Str);
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[2]/ul/li[9]/button[1]")).click();
		Thread.sleep(10000);
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/div[2]/a[6]")).click();
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr/td[1]/div[2]/ul/li[2]")).click();

		System.out.println("Click");		
		//Save
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[3]/div/button[1]")).click();
		
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String S1 = "Some of the items in this list are not valid";
		String S2 = dr.getPageSource();
		
/*		if(S2.contains(S1))
		{
			System.out.println("Unable to Update Sales Order due to invalid Sales Order Items");
		}
		else
		{	*/
			WebElement WB1 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
			String OrderNum = WB1.getText();
			System.out.println(OrderNum+" is updated successfully");
		}/*
	}*/
	
	@Test (priority=4)
	  public void ViewSO() throws IOException
	  {
		System.out.println("************** SALES ORDER VIEW **************");
		dr.get("http://kimdev01.keyedinuat.com/Dev03/Tab/71");
		String x1 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x2 = "]/td[1]/div[2]/a[6]";
		String x3 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x4 = "]/td[1]/div[2]/ul/li[3]";
		WebElement table = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int TableSize = allRows.size()-1;
		Random rand = new Random(System.currentTimeMillis());
		int rval = rand.nextInt(TableSize);
		System.out.println("Row number: "+rval);
		dr.findElement(By.xpath(x1+rval+x2)).click();
		dr.findElement(By.xpath(x3+rval+x4)).click();		
		WebElement WW2 = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div/fieldset[1]/div/div/div/div[1]/div[1]/div/div/div[2]/div/div[1]/span"));
		System.out.println("Viewed Order Number is: "+WW2.getText());
	  }
	
	@Test (priority=5)
	  public void DeleteSO() throws IOException
	  {
		System.out.println("************** SALES ORDER DELETE **************");
		dr.get("http://kimdev01.keyedinuat.com/Dev03/Tab/71");
		//Random Order Navigate
		String x1 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x2 = "]/td[1]/div[2]/a[6]";
		//Random Delete Button
		String x3 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x4 = "]/td[1]/div[2]/ul/li[5]";
		//Random Order Number
		String x5 = "/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table/tbody/tr[";
		String x6 = "]/td[3]/div/a";
		WebElement table = dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[2]/div/div[2]/div[3]/div[2]/div/table"));
		List<WebElement> allRows = table.findElements(By.tagName("tr"));
		int TableSize = allRows.size();
		Random rand = new Random(System.currentTimeMillis());
		int rval = rand.nextInt(TableSize);
		System.out.println("Row Number: "+rval);
		dr.findElement(By.xpath(x1+rval+x2)).click();
		String S1 = dr.findElement(By.xpath(x5+rval+x6)).getText();
		System.out.println("Deleted Order Number is: "+S1);
		dr.findElement(By.xpath(x3+rval+x4)).click();	
		dr.findElement(By.xpath("/html/body/div[2]/div/div[1]/div[1]/div/form/div[1]/button[1]")).click();
	  }
	
	@AfterTest
	   public void Quit()
	   {
		//dr.quit();
	   }
}
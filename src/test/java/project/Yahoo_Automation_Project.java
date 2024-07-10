package project;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Yahoo_Automation_Project {
	WebDriver driver;
	@BeforeTest
	public void bt()
	{
		driver=new ChromeDriver();
		
		
	}
	@BeforeMethod
	public void bm()
	{
		driver.manage().window().maximize();
		driver.get("https://in.search.yahoo.com/?fr2=inr");
	}
	@Test
	public void testa() throws AWTException, IOException
	{
	
	driver.findElement(By.xpath("//*[@id=\"ymail\"]/div")).click();
	driver.findElement(By.xpath("/html/body/div[1]/a")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys("achunonu@yahoo.com");
	driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"login-passwd\"]")).sendKeys("chefmonicabing");
	driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	// CHECK IF THE LOGO IS PRESENT
	 WebElement logo = driver.findElement(By.xpath("//*[@id=\"ybar-logo\"]/img[2]"));
	    if(logo.isDisplayed())
	    {
	    	System.out.println("Logo is present");
	    }
	    else
	    {
	    	System.out.println("Logo is absent");
	    }
	    // TITLE VERIFICATION
	    String t = driver.getTitle();
	    System.out.println(t+"TITLE= ");
	    String e="(1 unread) – achunonu@yahoo.com – Yahoo Mail";
	    if(t.equals(e))
	    {
	    	System.out.println("Title Verification Passed");
	    }
	    
	    else
	    	
	    {
	    	System.out.println("Title Verification Failed");
	    }
	    
	// RESPONSE CODE
	    URL ob=new URL("https://in.mail.yahoo.com/d/folders/1?.intl=in&.lang=en-IN&pspid=958631386&activity=header-mail&guce_referrer=aHR0cHM6Ly9sb2dpbi55YWhvby5jb20v&guce_referrer_sig=AQAAAD6iEMRP4_OVGC9gUD5Hf5yy9QjUpCfk0lfFtNYdyJtTkBEFKBzVfFf4rovz1B9CA8cqziZg78gGGP98ODOjkXex3DflwUiQSqWhzZQRMNhSUSplyt0SYvCJDFj0E4lnRoiGz2GRa28vLRzwA9xMBb5B2AKcJoa76YQ66owPc6Iz");
	       HttpURLConnection ref=(HttpURLConnection)ob.openConnection();
	       if(ref.getResponseCode()==200)
	       {
	    	   System.out.println("It's Working");
	       }
	       else
	       {
	    	   System.out.println("Not Working");
	       }
	
	
	// LINKS AND MENUS
	 List<WebElement> l = driver.findElements(By.tagName("a"));
	    for(WebElement w:l)
	         {
	    	String link=w.getAttribute("href");
	    	String name=w.getText();
	    	System.out.println(link+"-------"+name);
	         }
	    
	    
	    List<WebElement> m = driver.findElements(By.id("HeaderNavigation"));
	    for(WebElement w:m)
	    {
	    	String menu=w.getText();
	    	System.out.println("Menu : "+menu);
	    }
	
	
	// WINDOW HANDLING
	String parentwindow=driver.getWindowHandle();
	driver.findElement(By.xpath("//*[@id=\"ybar-topnavigation\"]/ul/li[10]/div[1]/a")).click();

	Set<String> allwindowhandles=driver.getWindowHandles();
	for(String handle:allwindowhandles)
	{
		if(!handle.equalsIgnoreCase(parentwindow))
		{
			driver.switchTo().window(handle);
			WebElement search = driver.findElement(By.xpath("//*[@id=\"yschsp\"]"));
             search.click();
             search.sendKeys("Animal Kingdom");
             search.sendKeys(Keys.ENTER);
                                                                                                               
		}
		
driver.switchTo().window(parentwindow)		;
}
	// TO SEND AN EMAIL WITH ATTACHMENT
  driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/nav/div/div[1]/a")).click();
  driver.findElement(By.xpath("//*[@id=\"message-to-field\"]")).sendKeys("aayishasalam@yahoo.com");
  driver.findElement(By.xpath("//*[@id=\"compose-subject-input\"]")).sendKeys("Project Details");
  driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[2]/div/div[2]/div[1]/div[2]/div/div/div[2]/div/div/div[2]/div[1]/div/div[2]/div/div[1]/div")).sendKeys("All documents are attched with this email");
  driver.findElement(By.xpath("//*[@id=\"mail-app-component\"]/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/span[1]/div/div/div/button/span")).click();
  driver.findElement(By.xpath("//*[@id=\"app\"]/div[7]/div/div[1]/div/ul/li[3]/button/span/span")).click();
  fileUpload("F:\\project.pdf");
	}
	private void fileUpload(String s) throws AWTException {
		StringSelection f=new StringSelection(s);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(f, null);
		
		Robot r=new Robot();
		r.delay(3000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//*[@id=\"mail-app-component\"]/div[2]/div/div/div[2]/div/div/div[2]/div[2]/div/button")).click();
				
	}
}

	

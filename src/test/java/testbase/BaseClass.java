package testbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager; //for logger
import org.apache.logging.log4j.Logger; //for logger

public class BaseClass {
	
	public Logger logger;// for Logging
	
	public static WebDriver driver;
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")   // getting browser parameter from testng.xml
	public void setup(String br)
	{
		
		//rb=ResourceBundle.getBundle("config");
		rb = ResourceBundle.getBundle("config");
		logger = LogManager.getLogger(this.getClass());// for Logger  
		
		//launch right browser based on parameter
		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//driver.get("http://localhost/opencart/upload/");
		driver.get(rb.getString("url"));
		driver.manage().window().maximize();
	}

	@AfterClass
	public void teadDown() {
		driver.quit();
	}

	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	public String captureScreen(String tname)
	{
		String timeStamp=new SimpleDateFormat("yyyy/mm/dd/hh/mm/ss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		//String dest=System.getProperty("user+dir")+"\\screenshots\\"+tname+"-"+timestamp+".png";
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
		
		try
		{
			FileUtils.copyFile(src,new File(destination));
		}
		catch(IOException e1)
		{
			e1.printStackTrace();
			
			
		}
return destination;
	}
}

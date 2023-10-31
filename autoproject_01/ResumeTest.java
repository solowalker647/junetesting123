package maventest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mavenpkg.Demo;

public class ResumeTest {
WebDriver driver;
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
		driver.get("https://zety.com/");
	}
	@Test
	public void test() throws Exception
	{
		Demo r=new Demo(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		r.mouseover();
		r.logodisplay();
		r.titleverification();
		r.contentverification();
		r.handlewindow();
		r.initial_page();
		r.upload();
		r.pages("abigale23@gmail.com");
		r.job("Sales associate", "H&M");
		r.scrolldown();
		r.screenshot();
		r.home();
		r.login();
		r.ddriven();
	}

}

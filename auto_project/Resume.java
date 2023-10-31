package mavenpkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class Resume {
	WebDriver driver;
	By logo1=By.xpath("/html/body/header/div/div[1]/a/svg");
	By logo=By.xpath("/html/body/header/div/div[1]/a");
	By try_res_builder=By.xpath("/html/body/section[1]/div[1]/a");
	By create_resume_now=By.xpath("/html/body/main/section[1]/div/div/div/div/div[1]/a");
	By resume=By.xpath("//*[@id=\"content\"]/div[3]/div/div[2]/div[1]/div/div[2]/div");
	By choose_template=By.xpath("//*[@id=\"use_this_template_btn\"]");
	By choose_later=By.xpath("//*[@id=\"skipTemplates\"]");

	By next=By.xpath("//*[@id=\"loader-animate\"]/div[3]/button[2]");
	By create_new_resume=By.xpath("/html/body/div[3]/div/div/div/div[3]/button[1]");
	By upload_photo=By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div/button");
	By upload_photo2=By.xpath("/html/body/div[4]/div/div/div/section/div/div[1]/div[1]/div/div[1]/span");
	By next_workhistory=By.xpath("//*[@id=\"content\"]/div[3]/button[1]");
	By email=By.xpath("//*[@id=\"EMAI\"]");
	By tools=By.xpath("/html/body/header/div/div[2]/nav/ul/li[1]/span");
	By resume_checker=By.xpath("/html/body/header/div/div[2]/nav/ul/li[1]/div/ul/li[1]/a");
	By skip_for_now=By.xpath("//*[@id=\"content\"]/div[2]/button[3]");
	By next2=By.xpath("//*[@id=\"content\"]/div[2]/button[1]");
	By job_title=By.xpath("//*[@id=\"position\"]");
	By employer=By.xpath("//*[@id=\"company\"]");
	By start_date=By.xpath("//*[@id=\"fromCal\"]");
	By year=By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[3]/div[1]/div[2]/div[1]/button[2]");
	By year1=By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[3]/div[1]/div[2]/div[2]/div/div/button[2]");
	By month=By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[3]/div[1]/div[2]/div[2]/div/div/button[10]/abbr");
	By currently_wrking=By.xpath("//*[@id=\"content\"]/div[2]/div/div/div/div[3]/div[2]/div[2]/label");
	By next3=By.xpath("//*[@id=\"btn_expr_next_2\"]");
	By resume1=By.xpath("/html/body/header/div/div[2]/nav/ul/li[2]/span");
	By resume_format=By.xpath("/html/body/header/div/div[2]/nav/ul/li[2]/div/ul/li[3]/a");
	By no_thanks=By.xpath("//*[@id=\"modal-btn-primary\"]");
	By terms_conditions=By.xpath("//*[@id=\"upperFooter\"]/div/ul/li[1]/a");
	By my_account=By.xpath("/html/body/header/div/div[2]/a");
	By email_1=By.id("widget-user-email");
	By pass_1=By.id("widget-user-password");
	By sign_in=By.xpath("//*[@id=\"btnSignIn\"]");
	By home=By.xpath("https://zety.com/");
	
	
	public Resume(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void home() 
		{
		driver.navigate(). to("https://zety.com");
		

		
		}
	public void logodisplay()
	{
	WebElement va=driver.findElement(logo);
	boolean bo=va.isDisplayed();
	if(bo)
	{
	System.out.println("logo displayed");
	}
	else
	{
	System.out.println("logo not displayed");
	}
	}
	
	public void initial_page()  {
		
		driver.findElement(try_res_builder).click();
		driver.findElement(create_resume_now).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(choose_later).click();
		driver.findElement(next).click();
	}
	
	public void scrolldown() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,1000)", "");
		//driver.findElement(create_new_resume).click();
	}
	
	public void pages(String mail) {
		driver.findElement(email).sendKeys(mail);
		driver.findElement(next_workhistory).click();
		driver.findElement(skip_for_now).click();
		driver.findElement(next2).click();
	}
	
	public void upload() throws Exception{
		{
			driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div/button")).click();
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/section/div/div[1]/div[1]/div/div[1]/span")).click();
			fileUpload("\"C:\\Users\\Merin\\Downloads\\desktop-wallpaper-aesthetic-background-laptop-aesthetic-cartoon.jpg\"");
			driver.findElement(By.xpath("/html/body/div[4]/div/div/div/section/div[2]/div[2]/button[1]")).click();
		}
	}
	private void fileUpload(String p)  throws AWTException
	{
		StringSelection strSelection=new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		Robot robot=new Robot();
		robot.delay(3000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void job(String jobtitle,String emplr){
		driver.navigate().refresh();
		driver.findElement(job_title).sendKeys(jobtitle);
		driver.findElement(employer).sendKeys(emplr);
		driver.findElement(start_date).click();
		driver.findElement(year).click();
		driver.findElement(year1).click();
		driver.findElement(month).click();
		driver.findElement(currently_wrking).click();
		driver.findElement(next3).click();
		driver.findElement(no_thanks).click();
	}
	
	public void titleverification()
	{
		String title=driver.getTitle();
		String t="Zety - Professional Resume & Cover Letter Tools For Any Job";
		if(title.equals(t))
		{
			System.out.println("title same");
		}
		else
		{
			System.out.println("title different");
		}
	}
	
	public void contentverification()
	{
		String contnt=driver.getPageSource();
		if(contnt.contains("zety"))
		{
			System.out.println("this page contains the word zety");
		}
		else
		{
			System.out.println("this page does not contains the word zety");
		}
	}
	
	public void screenshot() throws IOException
	{
		File src=(((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE));
		FileHandler.copy(src, new File("C:\\sample\\scrnsht\\sky.png"));
	}	
	public void mouseover()
	{
		Actions act=new Actions(driver);
		WebElement am=driver.findElement(tools);
		act.moveToElement(am);
		act.perform();
		driver.findElement(resume_checker).click();
		driver.navigate().back();
	}
	public void ddriven() throws Exception 
	{ 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//driver.findElement(my_account).click();
		File f=new File("C:\\sample\\resdem01.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		System.out.println(sh.getLastRowNum());
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		for(int i=1;i<sh.getLastRowNum();i++)
		{
			String username=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("username="+username);
			String pswd=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println(pswd);
			
			//driver.findElement(email_1).clear();
			driver.findElement(email_1).sendKeys(username);
			//driver.findElement(pass_1).clear();
			driver.findElement(pass_1).sendKeys(pswd);
			driver.findElement(sign_in).click();
			
			//String actualurl=driver.getCurrentUrl();
			//System.out.println(actualurl);
//			driver.close();

		}
	}
	
	public void handlewindow()
	{
	//driver.findElement(By.xpath("/html/body/section[1]/div[1]/a")).click();	
	 driver.findElement(By.xpath("/html/body/div[4]/section[4]/div/div/a")).click();
		String parentWindow=driver.getWindowHandle(); 
		/*driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", "");
		driver.findElement(By.xpath("/html/body/form/footer/section[1]/div/ul/li[1]/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
		
		Set<String>childwindow=driver.getWindowHandles();
		for(String handle:childwindow)
		{
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.close();

			}
		}
		
	driver.switchTo().window(parentWindow);
		//driver.navigate().back();
	}

	public void login()
	{
		String parentWindow=driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/header/div/div[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Set<String>childwindows=driver.getWindowHandles();
		for(String handles:childwindows)
		{
			if(!handles.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handles);
				

			}
		}
		
	
	}
	
	

}

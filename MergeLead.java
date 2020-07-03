package selenium.assignments;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MergeLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Launch URL "http://leaftaps.com/opentaps/control/login"
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Enter UserName and Password Using Id Locator
		driver.findElementById("username").sendKeys("Demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");

		//Click on Login Button using Class Locator
		driver.findElementByClassName("decorativeSubmit").click();

		//Click on CRM/SFA Link
		driver.findElementByLinkText("CRM/SFA").click();

		driver.findElementByXPath("//a[text()='Contacts']").click();
		driver.findElementByXPath("//a[text()='Merge Contacts']").click();
		driver.findElementByXPath("//img[@alt=\"Lookup\"]").click();
		String mainWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		for (String newWindow : windowHandles) {
			driver.switchTo().window(newWindow);

		}
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")));
		WebElement link = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a"));
		link.click();
		driver.switchTo().window(mainWindow);


		driver.findElementByXPath("(//img[@alt='Lookup'])[2]").click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println(windowHandles1);
		for (String newWindow1 : windowHandles1) {
			driver.switchTo().window(newWindow1);

		}
		WebDriverWait wait1 = new WebDriverWait(driver,30);
		wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a")));
		WebElement link1 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]//a"));
		link1.click();
		driver.switchTo().window(mainWindow);
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
		driver.quit();
	}

}



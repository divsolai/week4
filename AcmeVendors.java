package selenium.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AcmeVendors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Launch URL: https://acme-test.uipath.com/account/login
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/account/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Enter UserName (kumar.testleaf@gmail.com) and TAB
		driver.findElementById("email").sendKeys("kumar.testleaf@gmail.com", Keys.TAB);

		// Enter Password (leaf@12)
		driver.findElementById("password").sendKeys("leaf@12");

		// Click Login
		driver.findElementById("buttonLogin").click();

		// Mouse Over on Vendors

		WebElement vendor = driver.findElementByXPath("(//button[@type='button'])[6]");
		Actions builder = new Actions(driver);
		builder.moveToElement(vendor).perform();

		// Click Search Vendor
		WebElement searchVendor = driver.findElementByXPath("//a[text()='Search for Vendor']");
		builder.moveToElement(searchVendor).click().perform();

		// Enter Vendor Name (Blue Lagoon)
		WebElement vendorName = driver.findElementById("vendorName");
		vendorName.sendKeys("Blue Lagoon");

		// Click Search
		driver.findElementById("buttonSearch").click();

		// Find the Country Name based on the Vendor
		WebElement webTable = driver.findElementByClassName("table");
		List<WebElement> allRows = webTable.findElements(By.tagName("tr"));
		//System.out.println(allRows.size());
		for (int i = 1; i < allRows.size(); i++) {
			WebElement eachRow = allRows.get(i);
			List<WebElement> AllCol = eachRow.findElements(By.tagName("td"));
		
				if(AllCol.get(0).getText().equals("Blue Lagoon"))
				{
					System.out.println(" The Vendor's Country is " + AllCol.get(4).getText());
				}
				
		}

		// Click Log
		driver.findElementByXPath("//a[text()='Log Out']").click();

		// Close browser
		driver.close();
         
	}
	}




package selenium.assignments;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZoomCar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Launch URL: https://www.zoomcar.com/chennai
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zoomcar.com/chennai");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Click on the Start your wonderful journey link
		driver.findElementByXPath("//a[@class='search']").click();

		//In the Search page, Click on any pick up point under POPULAR PICK-UP
		driver.findElementByXPath("(//div[@class='items'])[2]").click();

		//Click on the Next button
		driver.findElementByXPath(" //button[@class='proceed']").click();



		Date date = new Date(); // Get the current date
		DateFormat sdf = new SimpleDateFormat("dd"); //Get only the date (and not month, year, time etc)
		String today = sdf.format(date); // Get today's date
		int tomorrow = Integer.parseInt(today)+1; // Convert to integer and add 1 to it
		int finaldate = tomorrow +1;
		System.out.println(finaldate);
		System.out.println(tomorrow);
		String date1 = Integer.toString(tomorrow);
		String date2 =Integer.toString(finaldate);
		System.out.println("The tomorrows date is " + date1);
		System.out.println("the day after tomorrow date is " + date2);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		//Specify the Start Date as tomorrow Date
		List<WebElement> days = driver.findElements(By.xpath("//div[@class= 'day']"));
		for (WebElement nextday : days) {
			if(nextday.getAttribute("innerHTML").contains(date1)) {
				nextday.click();
				break;
			}
		}
		
		driver.findElementByXPath(" //button[@class='proceed']").click();
		
		List<WebElement> days1 = driver.findElements(By.xpath("//div[@class= 'day']"));
		for (WebElement nextday1 : days1) {
			if(nextday1.getAttribute("innerHTML").contains(date2)) {
				nextday1.click();
				break;
			}
		}
		
		driver.findElementByXPath(" //button[@class='proceed']").click();
		Thread.sleep(3000);
				
		List<WebElement> numberofResult = driver.findElementsByXPath("//div[@class='car-item']");
		int size = numberofResult.size();
		System.out.println("Number of Results displayed from Search : " +size);

		Map<String,Integer> map = new LinkedHashMap<String,Integer>();
		List<WebElement> carNames = driver.findElements(By.xpath("//div[@class='details']//h3"));
		List<WebElement> price = driver.findElements(By.xpath("//div[@class='price']"));
		for(int i=0;i< carNames.size();i++)
		{
			String name = carNames.get(i).getText();
			String pr = price.get(i).getText().replaceAll("[^0-9]", "");
			map.put(name, Integer.parseInt(pr))  ;  
			
		}
System.out.println(map);

int maxvalue = Collections.max(map.values());
System.out.println("Maximum value is "  +maxvalue);

// Click on the Book Now button for maximum price
for (Entry<String, Integer> eachEntry : map.entrySet()) {
	if (eachEntry.getValue() == maxvalue) {
		System.out.println(
				"The Carname of the max price car is: " + eachEntry.getKey() + "----->" + eachEntry.getValue());
		driver.findElementByXPath("//h3[contains(text(),'" + eachEntry.getKey()
				+ "')]/parent::div/following-sibling::div//div//button").click();

		
	}
}
	}
}



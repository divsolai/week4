package selenium.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		driver.findElement(By.id("Click1")).click();
		driver.switchTo().defaultContent();
		int size = driver.findElements(By.xpath("//iframe")).size();
		int count = size;
		System.out.println("The number of outer frames is " + size);
	    for(int i=0; i< size; i++)
	   {
	    	driver.switchTo().frame(i);
		     count = count + driver.findElementsByTagName("iframe").size();
		     driver.switchTo().defaultContent();
	   }
			System.out.println(" the total number of frames is " + count);
			}
			
		}

	



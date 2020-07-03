package selenium.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		WebElement eleTable = driver.findElementById("table_id");
		List<WebElement> allRows = eleTable.findElements(By.tagName("tr"));
		System.out.println("The total number of rows in the table" + allRows.size());
		for (int i = 1; i < allRows.size(); i++) {
			WebElement eachRow = allRows.get(i);
			List<WebElement> AllCol = eachRow.findElements(By.tagName("td"));
			for (int j = 1; j < AllCol.size(); j++) {
				WebElement cell = AllCol.get(j);
				String text = cell.getText();
				System.out.println(text + "\t");
			}
			System.out.println(" The number of colums in the table" + AllCol.size());
		}

		System.out.println("------------------------------------------------------");
		// to print the data in 2nd row
		WebElement secondRow = allRows.get(2);
		List<WebElement> secondRowCol = secondRow.findElements(By.tagName("td"));
		WebElement cell1 = secondRowCol.get(1);
		String text1 = cell1.getText();
		System.out.println("The progress value of learn to interact with elements is "+text1);
		
		System.out.println("------------------------------------------------------");
		List<WebElement> progress = driver.findElementsByXPath("//table//tr//td[2]");
		List<Integer> percent = new ArrayList<Integer>();
		for (WebElement eachp : progress) {
			String text = eachp.getText();
			percent.add(Integer.parseInt(text.replaceAll("%", "")));
		}
		Integer min = Collections.min(percent);
		System.out.println(min);
		
		for (int i = 1; i < allRows.size(); i++) {
			WebElement eachRow = allRows.get(i);
			List<WebElement> AllCol = eachRow.findElements(By.tagName("td"));
			if((Integer.parseInt(AllCol.get(1).getText().replace("%",""))== min)) {
				driver.findElementByXPath("((//table//tr//td[2])[3]/following-sibling::td)[1]/input").click();
				System.out.println("the checkbox is clicked successfully");
			}
		
		
			}
	}
}



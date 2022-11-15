package selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.e-procurement.metro.tokyo.lg.jp/index.jsp");
		WebElement element = driver.findElement(By.cssSelector("body > div.noticeofurlchange > div > button"));
		element.click();
		element = driver.findElement(By.cssSelector("#category_menu > ul > li.cat_menu_1 > a:nth-child(1) > img"));
		element.click();

		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String win1 = it.next();
		String win2 = it.next();
		driver.switchTo().window(win2);
		Thread.sleep(200);
		element = driver.findElement(By.id("topMenuBtn03"));
		element.click();
		Thread.sleep(100);

		element = driver.findElement(By.name("StartDateYY"));
		element.sendKeys("4");
		element = driver.findElement(By.name("StartDateMM"));
		element.sendKeys("11");
		element = driver.findElement(By.name("StartDateDD"));
		element.sendKeys("15");
		Thread.sleep(50);
		element = driver.findElement(By.name("EndDateYY"));
		element.sendKeys("4");
		element = driver.findElement(By.name("EndDateMM"));
		element.sendKeys("12");
		element = driver.findElement(By.name("EndDateDD"));
		element.sendKeys("14");
		Thread.sleep(50);
		element = driver.findElement(By.xpath("//tr[3]/td/table[2]/tbody/tr/td/a"));
		element.click();

//		テーブル指定先　確認用
//		WebElement table = driver.findElement(By.cssSelector("table.list-data > tbody"));
//		System.out.println(table.getText());

		List<WebElement> tr = driver.findElements(By.cssSelector("table.list-data > tbody > tr"));
		for (WebElement list : tr) {
//				System.out.println(list.getText());

			List<WebElement> td = list.findElements(By.tagName("td"));
			for(WebElement data : td) {
			
			int count = 0;
			if(count < 3) {
				System.out.print(data.getText() + "\t");
				count++;
			}
			
			System.out.println(data.getAttribute("href"));
			System.out.println("-----------------------------");
			}
			/* やりかけ 
			 * String date = td.findElement(By.className("light-green")).getText();
			 * String num = td.findElement(By.cssSelector("td:nth-child(2)")).getText(); 
			 * //body > div.contents > div > form > table.list-data > tbody > tr:nth-child(2)
			 * 		> td:nth-child(2) // body > div.contents > div > form > table.list-data >
			 * 		tbody > tr:nth-child(3) > td:nth-child(2)
			 * String title = td.findElement(By.cssSelector("td:nth-child(3)")).getText(); 
			 * String url = td.findElement(By.cssSelector("td:nth-child(3) > a")).getAttribute("href");
			 * System.out.println(date + "\t" + num + "\t" + title + "\t" + url);
			 */

		}

		driver.close();

	}

}

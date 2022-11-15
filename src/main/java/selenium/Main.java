package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.co.jp/");
		WebElement element = driver.findElement(By.cssSelector("div.a4bIc > input"));
		element.sendKeys("selenium");
		Thread.sleep(500);
		element.sendKeys(Keys.ENTER);
		List<WebElement> list = driver.findElements(By.className("MjjYud"));
		System.out.println("**リンクの一番上の文言**\n");
		System.out.println(list.get(0).getText());
		Thread.sleep(500);
		driver.close();
		
//		複数の要素（テーブルなど）を受け取る。
//		List<WebElement> list = driver.findElements(By.cssSelector("div.a4bIc"));
		
	}

}

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

		driver.get("https://rakuplus.jp/");
		Thread.sleep(50);
		WebElement element = driver.findElement(By.id("user_login"));
		element.sendKeys("kumi.shirai@rakus-partners.co.jp");
		Thread.sleep(50);
		element = driver.findElement(By.id("user_pass"));
		element.sendKeys("kumi.shirai@rakus-partners.co.jp");
		Thread.sleep(50);
		element = driver.findElement(By.id("wp-submit"));
		element.click();

		element = driver.findElement(By.partialLinkText("2022年10月入社QAエンジニア新入社員紹介"));
		element.click();

		List<WebElement> divList = driver.findElements(By.cssSelector("section.entry-content.cf > div"));
		System.out.println("**同期の情報**");
		int count = 0;
		for (WebElement elm : divList) {
			if (count > 0) {//　関係ないdivをスキップする
				WebElement human = elm.findElement(By.className("sgb-space-bottom"));
				String name = human.getText();
				System.out.print(name + " (");
				human = elm.findElement(By.cssSelector("div.is-layout-flow.wp-block-column.is-vertically-aligned-top.visual > p"));
				String name2 = human.getText();
				System.out.println(name2 +")");
				human = elm.findElement(By.tagName("img"));
				String url = human.getAttribute("src");
				System.out.println(url);
			}
			System.out.println("----------------------------------");
			count ++;
		}
//		for(WebElement elm : list) {
//			elm = driver.findElement(By.className("sgb-space-bottom"));
//			System.out.println(elm.getText());
//			elm = driver.findElement(By.cssSelector("div.is-layout-flow.wp-block-column.is-vertically-aligned-top.visual > p"));
////			#\31  > div.is-layout-flow.wp-block-column.is-vertically-aligned-top.visual > p
//			System.out.println(elm.getText());
//			elm = driver.findElement(By.className("js-smartphoto"));
//			System.out.println(elm.getText());
//		}

		Thread.sleep(500);
		driver.close();

//		複数の要素（テーブルなど）を受け取る。
//		List<WebElement> list = driver.findElements(By.cssSelector("div.a4bIc"));

	}

}

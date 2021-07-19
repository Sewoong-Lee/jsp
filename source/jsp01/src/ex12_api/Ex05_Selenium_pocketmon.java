package ex12_api;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Ex05_Selenium_pocketmon {

	public static void main(String[] args) throws IOException {

		//포켓몬 도감 만들기
		System.setProperty("webdriver.chrome.driver", "D:/크롬 드라이버/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		//얘 넣으면 화면 돌아가는게 안보임
		//options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		String url = "https://www.pokemonkorea.co.kr/pokedex";
		driver.get(url);
//		System.out.println(driver.getPageSource());
		driver.manage().window().maximize();
		
		//자바스크립트 실행 드라이버
		JavascriptExecutor js = (JavascriptExecutor) driver;

		//스크롤 30번
		for(int i=0; i<30; i++) {
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
			js.executeScript("window.scrollBy(0,1000)");
			
		}
		
		
		List<WebElement> el1 = driver.findElements(By.className("img-fluid"));
		
		for (int i = 0; i < el1.size(); i++) {
			//src = 다운로드 url
			String srcUrl = el1.get(i).getAttribute("src");
			String filename = srcUrl.substring(srcUrl.length()-10,srcUrl.length());
			System.out.println(filename);
			try(InputStream in = new URL(srcUrl).openStream()){
				Path imagePath = Paths.get("D:/download/" + filename); 
				Files.copy(in, imagePath);  //파일 카피
			}
		}

		try {
			if(driver != null) {
				driver.close();
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	
	}

}

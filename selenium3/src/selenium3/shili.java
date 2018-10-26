package selenium3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class shili {
	public WebDriver d;
	
	public void huohu(){
		System.setProperty("webdriver.gecko.driver", "E:/geckodriver.exe");
	    d = new FirefoxDriver();
	    d.get("http:\\www.baidu.com");
	    d.findElement(By.id("kw")).sendKeys("skdj");
	}

	public static void main(String[] args) {
		shili s = new shili();
		s.huohu();
	}

}

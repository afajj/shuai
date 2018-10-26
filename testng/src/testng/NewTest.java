package testng;


import org.databene.benerator.anno.Source;
import org.databene.feed4testng.FeedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class NewTest extends FeedTest {
	
	public WebDriver d;//WebDriver是功能引用的类，做一个全局变量，变量名叫d
	public WebElement s;
	
	@DataProvider
//	public Object[][] dp() {
//    return new Object[][] {
//    		{"aa","12345678"},{"bb","12345678"},{"cc","12345678"}
//    };
//  }
	
  @Test(dataProvider="feeder")
  @Source("aa.xls")
  public void f(String ming,String ma,String yan) throws InterruptedException {
	  System.out.println("F");
	  d.findElement(By.name("loginName")).sendKeys(ming);
	  d.findElement(By.name("loginpwd")).sendKeys(ma);
	  Thread.sleep(3000);
	  d.findElement(By.xpath(".//input[@value='登录']")).click();
	  
	  String xinxi = d.findElement(By.className("blueText")).getText();//将定位的文本赋值给xinxi
	  System.out.println(xinxi);
      Assert.assertEquals(xinxi, "安全退出");
	  Thread.sleep(3000);
  }
  

	
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("BM");
	  
//	  System.setProperty("webdriver.firefox.bin");
	  d = new FirefoxDriver();
	  d.get("http://localhost:8080/test/mer.do?method=browseIndexMer");
  }

  @AfterMethod
  public void aftermethod() {
	  System.out.println("AM");

  }


//  @DataProvider
//  public Object[][] dp() {
//    return new Object[][] {
//      new Object[] { 1, "a" },
//      new Object[] { 2, "b" },
//    };
//  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("BC");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("AC");
  }

}

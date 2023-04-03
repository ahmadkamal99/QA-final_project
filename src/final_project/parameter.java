package final_project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class parameter {


	WebDriver driver=new EdgeDriver();
	
	SoftAssert myAssert=new SoftAssert();
	
	@BeforeTest
	public void BeforeTest1() {
		
	} 
}

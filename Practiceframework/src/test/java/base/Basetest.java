package base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	
	
	public static  WebDriver driver;
	public static Properties prop;
	public static FileReader fr;
	public Basetest() {
		
		try {
			
			fr = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\configations\\config.properties");
			prop= new Properties();
			prop.load(fr);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization( ) {
		 
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get(prop.getProperty("url"));
			
			
		}
	else if (prop .getProperty("browser").equalsIgnoreCase("edge")) {
		
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.get(prop.getProperty("url"));
		
			
		}
	else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			
			WebDriverManager.edgedriver().setup();
			driver=new FirefoxDriver();
			driver.get(prop.getProperty("url"));
			
	}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
		
		}


	

}

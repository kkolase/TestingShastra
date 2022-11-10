package com.testingshsatra.keywords;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.log4testng.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class UIKeywords {
	public static RemoteWebDriver driver;
	private static final Logger log=Logger.getLogger(UIKeywords.class);
	
	public static void openBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("IE")) { 
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();

		} else if(browserName.isEmpty()) {
			browserName="Chrome";
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			log.info("Setting default browser as Chrome");
		} else {
			browserName="Chrome";
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			log.info("Setting default browser as Chrome");
		}
	}

	public static void launchURL(String url) {
		driver.get(url);
		log.info(url + "url is launched successfully!!");
		driver.manage().window().maximize();
	}

	public static void tearDown() {
		driver.close();
		log.info("Browser is closed successfully!!");
	}

	public static void getTitle() {
		String title= driver.getTitle();
		log.info(title);
		System.out.println(title);
	}

	public static void switchToWindow(String byTitle) {
	//	String prentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
	//	String title=driver.getTitle();
		for(String window:windows) {
			if(driver.switchTo().window(window).getTitle().equals(byTitle)) {
				log.info("Switched on WIndow: "+byTitle);
				break;
			}
		}
	}
	
	private static WebElement getWebElement(String locatorType , String locatorValue) {
		WebElement element=null;
		if(locatorType.equalsIgnoreCase("xpath")) {
			element=driver.findElement(By.xpath(locatorValue));
		}else if(locatorType.equalsIgnoreCase("css")) {
			element=driver.findElement(By.cssSelector(locatorValue));
		}else if(locatorType.equalsIgnoreCase("id")) {
			element=driver.findElement(By.id(locatorValue));
		}else if(locatorType.equalsIgnoreCase("class")) {
			element=driver.findElement(By.className(locatorValue));
		}else if(locatorType.equalsIgnoreCase("tagName")) {
			element=driver.findElement(By.tagName(locatorValue));
		}else if(locatorType.equalsIgnoreCase("linkText")) {
			element=driver.findElement(By.linkText(locatorValue));
		}else if(locatorType.equalsIgnoreCase("partialLinkText")) {
			element=driver.findElement(By.partialLinkText(locatorValue));
		}else if(locatorType.equalsIgnoreCase("name")) {
			element=driver.findElement(By.name(locatorValue));
		}else {
			log.error("Invalid locator type" + locatorType);// xpath XPTHLINKTEXT
		}
		return element;
	}
	

	public static void getTexts(String locatorType,String locatorValue, String text) {
		getWebElement(locatorType, locatorValue).sendKeys(text);
	}

	public static void KeyboardkeyPress(int keyCode) {
		Robot robo=null;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
			log.info("Robot does not instante");
		}
		robo.keyPress(keyCode);
	}

	public static List<String> getTexts(By element) {
		List<WebElement> elements = driver.findElements(element);
		List<String> texts = new ArrayList<String>();
		for (WebElement elmnt:elements) {
			texts.add(elmnt.getText());
		}
		return texts;
	}

//	public static void enterText(By element, String textValue) {
//		driver.findElement(element).sendKeys(textValue);
//	}

	public static void enterText(String locatorType, String locatorValue, String textValue ) {
		getWebElement(locatorType, locatorValue).sendKeys(textValue);
	}


	//	Click on webElement
	public static void clickButton(By clickElement)  {
		driver.findElement(clickElement).click();
	}

	//	Mouse move
	public static void mouseMove(String locatorType , String locatorValue) {
		Actions act=new Actions(driver);
		act.moveToElement(getWebElement(locatorType, locatorValue)).build().perform();	
	}

	//	Click on webElement
	public static void click(String locatorType , String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}	

	public static void screenshotAshot() {
		AShot ashot=new AShot();
		ashot.shootingStrategy(ShootingStrategies.viewportPasting(2000));
		Screenshot sc=ashot.takeScreenshot(driver);
		BufferedImage img=sc.getImage();
		try {
			ImageIO.write(img, "JPG", new File("UsingAshot1.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			log.info("Ashot does not instiatoate");
		}
		
		
	}

	public static void screenshotSelenium() {
		String baseDir= System.getProperty("user.dir");
		//TakesScreenshot ts=driver.getScreenshotAs(OutputType.FILE);
		File file =driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(baseDir+"\\Screenshots\\HomePage.jpg"));
//			C:\Users\dayanand.mhetre\eclipse-workspace\fasttrackScreenshots
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static List<WebElement> getWebElements(String locatorType , String locatorValue) {
		List<WebElement> elements=new ArrayList<WebElement>();
		if(locatorType.equalsIgnoreCase("xpath")) {
			elements=driver.findElements(By.xpath(locatorValue));
		}else if(locatorType.equalsIgnoreCase("css")) {
			elements=driver.findElements(By.cssSelector(locatorValue));
		}else if(locatorType.equalsIgnoreCase("id")) {
			elements=driver.findElements(By.id(locatorValue));
		}else if(locatorType.equalsIgnoreCase("class")) {
			elements=driver.findElements(By.className(locatorValue));
		}else if(locatorType.equalsIgnoreCase("tagName")) {
			elements=driver.findElements(By.tagName(locatorValue));
		}else if(locatorType.equalsIgnoreCase("linkText")) {
			elements=driver.findElements(By.linkText(locatorValue));
		}else if(locatorType.equalsIgnoreCase("partialLinkText")) {
			elements=driver.findElements(By.partialLinkText(locatorValue));
		}else if(locatorType.equalsIgnoreCase("name")) {
			elements=driver.findElements(By.name(locatorValue));
		}else {
			log.error("Invalid locator type" + locatorType);// xpath XPTHLINKTEXT
		}
		return elements;
	}


public static List<String> getTexts(String locatorType, String locatorValue) {
	List<WebElement> elements = getWebElements(locatorType,locatorValue);
	List<String> texts = new ArrayList<String>();
	for (WebElement elmnt:elements) {
		texts.add(elmnt.getText());
	}
	return texts;
}


// THese methods for POM
public static void clickForPOM(WebElement element) {
	element.click();
}

public static void getTextPOM(WebElement element) {
	element.getText();
}
}

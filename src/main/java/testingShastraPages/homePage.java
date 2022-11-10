package testingShastraPages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingshsatra.keywords.UIKeywords;


public class homePage {
	public homePage(){
		PageFactory.initElements(UIKeywords.driver, this); //  driverInstance and class
	}
	
	//PageFactory
	@FindBy (xpath="//a[text()='Home']")
	public WebElement Home;
	
	@FindBy(xpath="(//div[@class=\\\"slider_title wow fadeInUp\\\"])[2]")
	public WebElement HomeText;
	
	@FindBy(xpath="//a[text()=\"Courses\"]")
	public WebElement CoursesTab;
	
	@FindBy(xpath="//a[text()=\"Automation testing (java)\"]")
	public WebElement TextAutomationtestingjava;
	
//	public homePage() {
//		Home=UIKeywords.driver.findElement(By.xpath("//a[text()='Home']"));
//		HomeText=UIKeywords.driver.findElement(By.xpath("(//div[@class=\"slider_title wow fadeInUp\"])[2]"));	
//		CoursesTab=UIKeywords.driver.findElement(By.xpath("//a[text()=\"Courses\"]"));
//		TextAutomationtestingjava =UIKeywords.driver.findElement(By.xpath("//a[text()=\"Automation testing (java)\"]"));	
//}

	public void clickOnHomePage() {
		UIKeywords.clickForPOM(Home);
	}
	public void clickOnCourses() {
		UIKeywords.clickForPOM(CoursesTab);
	}
	public String getTextHome() {
		UIKeywords.getTextPOM(HomeText);
		return null;
	}
	public void getTextCourses() {
		String CoursesjavaText= TextAutomationtestingjava.getText();
		System.out.println(CoursesjavaText);
	}
	public void clickOnJavaAutomationOption() {
		UIKeywords.clickForPOM(TextAutomationtestingjava);
		
	}
	
}

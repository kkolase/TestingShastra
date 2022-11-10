import org.apache.log4j.Logger;
//import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.testingshsatra.keywords.UIKeywords;
import com.testingshstra.util.PropUtil;
import com.testingshstra.util.WaitFor;

import testingShastraPages.homePage;



// This page contains all test cases for courses tab
public class HomePageTest {
	static PropUtil repo = new PropUtil();
	UIKeywords keyword=new UIKeywords();
	//static WaitFor wait=new WaitFor();
	private static final Logger log = Logger.getLogger(HomePageTest.class);

	@Test
//	this test case will click on course tab and get test of Automation testing java option
	public void To_Verify_Click_On_Courses() throws InterruptedException {
		UIKeywords.openBrowser(repo.getEnvData("ChromeBrowser"));
		UIKeywords.launchURL(repo.getEnvData("TestingShastraURL"));
		
		//homePage home= new homePage();
		//homePage home= PageFactory.initElements(UIKeywords.driver, homePage.class); //  driverInstance and class
		
		homePage home= new homePage();
		
		Thread.sleep(5000);
		//home.clickOnHomePage();
		//WaitFor.waitelementToBeClickablePOM(home.HomeText);
		
		WaitFor.waitelementToBeClickablePOM(home.CoursesTab);
		home.clickOnCourses();
		WaitFor.waitelementToBeClickablePOM(home.TextAutomationtestingjava);
		home.getTextCourses();
		log.info("pass");
	}
	
	@Test
	public void To_Verify_Click_On_Java_Automation_Option() throws InterruptedException {
		UIKeywords.openBrowser(repo.getEnvData("ChromeBrowser"));
		UIKeywords.launchURL(repo.getEnvData("TestingShastraURL"));
		homePage home= new homePage();
		Thread.sleep(5000);
		WaitFor.waitelementToBeClickablePOM(home.CoursesTab);
		home.clickOnCourses();
		WaitFor.waitelementToBeClickablePOM(home.TextAutomationtestingjava);
		home.getTextCourses();
		home.clickOnJavaAutomationOption();
		log.info("pass");
	}
	
}

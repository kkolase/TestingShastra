package com.stepdefination;


import org.openqa.selenium.By;

import com.testingshsatra.keywords.UIKeywords;
import com.testingshstra.util.PropUtil;
//import com.testingshstra.util.WaitFor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testingShastraPages.homePage;

public class CoursesSteps {
	static PropUtil repo = new PropUtil();
	homePage home= new homePage();
	
	@Given("chrome browser is opened")
	public void openBrowser() {
		UIKeywords.openBrowser("Chrome");
	}
	@And("url is launched")
	public void launchURL() {
		UIKeywords.launchURL(repo.getEnvData("TestingShastraURL"));
	}
	
	@And("wait Karo Courses visible honay tak")
	public void waitForCoursesVisable() throws InterruptedException {
//		WaitFor.waitelementToBeClickablePOM(home.CoursesTab);
		Thread.sleep(8000);
	}
	
	@When("user click on courses tab")
	public void clickOnCourseTab() {
		//home.clickOnCourses();
		UIKeywords.driver.findElement(By.xpath("//a[text()=\"Courses\"]")).click();
	}
	
	@Then("Courses options should display")
	public void Coursesoptions() {
		home.getTextCourses();
	} 
	
	@And("wait Karo options visible honay tak")
	public void waitForCoursesOptVisable() throws InterruptedException {
//		WaitFor.waitelementToBeClickablePOM(home.CoursesTab);
		Thread.sleep(8000);
	}

	@And("Browser band kar do")
	public void CloseBrowser() {
	UIKeywords.tearDown();
	
	}
	
	@When("click on Recent placement tab")
	public void clickOnRecentPlacementTab() {
		//home.clickOnCourses();
		UIKeywords.driver.findElement(By.xpath("//a[text()=\"Recent Placements\"]")).click();
}
	@Then("GetText")
	public void getText() {
		UIKeywords.getTexts(By.xpath("//a[text()=\"Recent Placements\"]"));
		 
}
}	
	
	
package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class TestSuite extends Utility {
    String baseUrl = "https://www.amazon.co.uk/";

    @Before
        public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void amazon(){
        //accepting cookies
        clickOnElement(By.xpath("//input[@id='sp-cc-accept']"));
        //sending element to textbox
        sendTextToElement(By.xpath("//input[@id='twotabsearchtextbox']"),"Dell Laptop");
        clickOnElement(By.xpath("//input[@id='nav-search-submit-button']"));
        clickOnElement(By.xpath("//li[@id='p_89/Dell']//i[@class='a-icon a-icon-checkbox']"));
        verifyTextMessages("verifying the products","1-24 of over 1,000 results for \"Dell Laptop\"",By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        //getting names of all dell laptops in amazon website
        List <WebElement> namesList = driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/child::span"));
        for (WebElement ListOfNames:namesList) {
            System.out.println(ListOfNames.getText());
        }
    }
    @After
    public void tearDown(){
        closeBrowser();
    }

}

package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldNavigateToRegisterPageSuccessfully(){
        driver.findElement(By.xpath("//a[@class = 'ico-register']")).click();
        String expectedMessage = "Register";
        WebElement actualElement = driver.findElement(By.xpath("//h1[text() ='Register']"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Register", expectedMessage,actualMessage);

    }
    @Test
    public void userShouldRegisterAccountSuccessfully(){
        driver.findElement(By.xpath("//a[@class = 'ico-register']")).click();
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.name("FirstName")).sendKeys("Sandip");
        driver.findElement(By.name("LastName")).sendKeys("Ghevariya");
        driver.findElement(By.name("DateOfBirthDay")).sendKeys("29");
        driver.findElement(By.name("DateOfBirthMonth")).sendKeys("March");
        driver.findElement(By.name("DateOfBirthYear")).sendKeys("1995");
        driver.findElement(By.id("Email")).sendKeys("sandydsecret@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("Sandy@24");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Sandy@24");
        driver.findElement(By.name("register-button")).click();
        String expectedMessage ="Your registration completed";
        WebElement actualElement = driver.findElement(By.xpath("//div[@class ='result']"));
        String actualMessage = actualElement.getText();
        Assert.assertEquals("Not found",expectedMessage,actualMessage);

    }

}

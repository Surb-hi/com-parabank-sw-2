package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid username
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.sendKeys("surbhi2");
        //Enter valid password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("surbhi123");
        //Click on ‘LOGIN’ button
        WebElement loginbuttonField = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginbuttonField.click();
        //Verify the ‘Accounts Overview’ text is display
        String expectedMsg = "Accounts Overview";

        WebElement actualresult = driver.findElement(By.xpath("//h1[text()='Accounts Overview']"));
        String actualMsg = actualresult.getText();
        System.out.println(actualMsg);

        Assert.assertEquals("Invalid account details", actualMsg, expectedMsg);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter invalid username
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.sendKeys("surbhi");
        //Enter invalid password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("surbhi13");
        //Click on Login button
        WebElement loginbuttonField = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginbuttonField.click();
        //Verify the error message ‘The username and password could not be verified.’
        String expectedMsg = "The username and password could not be verified.";

        WebElement actualresult = driver.findElement(By.xpath("//p[contains(text(),'The username and password could not be verified.')]"));
        String actualMsg = actualresult.getText();
        System.out.println(actualMsg);

        Assert.assertEquals("Invalid details", actualMsg, expectedMsg);

    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Enter valid username
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.sendKeys("surbhi2");
        //Enter valid password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("surbhi123");
        //Click on ‘LOGIN’ button
        WebElement loginbuttonField = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginbuttonField.click();
        //Click on ‘Log Out’ link
        WebElement logoutbuttonField = driver.findElement(By.xpath("//a[text()='Log Out']"));
        logoutbuttonField.click();
        //Verify the text ‘Customer Login
        String expectedMsg = "Customer Login";

        WebElement actualresult = driver.findElement(By.xpath("//h2[text()='Customer Login']"));
        String actualMsg = actualresult.getText();
        System.out.println(actualMsg);

        Assert.assertEquals("Invalid account details", actualMsg, expectedMsg);
    }

    @After
    public void tearDown() {
        //closebrowser();
    }
}

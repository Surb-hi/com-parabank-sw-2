package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //click on the ‘Register’ link
        WebElement registerField = driver.findElement(By.xpath("//a[text()='Register']"));
        registerField.click();

        //Verify the text ‘Signing up is easy!’
        String expectedMsg = "Signing up is easy!";

        WebElement actualresult = driver.findElement(By.xpath("//h1[text()='Signing up is easy!']"));
        String actualMsg = actualresult.getText();
        System.out.println(actualMsg);

        Assert.assertEquals("Signup page is not Display", actualMsg, expectedMsg);
    }

    @Test
    public void userSholdRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        WebElement registerField = driver.findElement(By.xpath("//a[text()='Register']"));
        registerField.click();
        //Enter First name
        WebElement firstnameField = driver.findElement(By.xpath("//input[@name='customer.firstName']"));
        firstnameField.sendKeys("surbhi");
        // Enter Last name
        WebElement lastnameField = driver.findElement(By.xpath("//input[@name='customer.lastName']"));
        lastnameField.sendKeys("patel");
        //Enter Address
        WebElement addressField = driver.findElement(By.xpath("//input[@name='customer.address.street']"));
        addressField.sendKeys("107 low street");
        //Enter City
        WebElement cityField = driver.findElement(By.xpath("//input[@name='customer.address.city']"));
        cityField.sendKeys("Birmingham");
        //Enter State
        WebElement stateField = driver.findElement(By.xpath("//input[@name='customer.address.state']"));
        stateField.sendKeys("East middlan");
        //Enter Zip Code
        WebElement zipcodeField = driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
        zipcodeField.sendKeys("Bh17 8lv");
        //Enter Phone
        WebElement phoneField = driver.findElement(By.xpath("//input[@name='customer.phoneNumber']"));
        phoneField.sendKeys("07979057910");
        //Enter SSN
        WebElement ssnField = driver.findElement(By.xpath("//input[@name='customer.ssn']"));
        ssnField.sendKeys("123456789");
        //Enter Username
        WebElement usernameField = driver.findElement(By.xpath("//input[@name='customer.username']"));
        usernameField.sendKeys("surbhi2");
        //Enter Password
        WebElement passwordField = driver.findElement(By.xpath("//input[@name='customer.password']"));
        passwordField.sendKeys("surbhi123");
        //Enter Confirm password
        WebElement confirmpasswordField = driver.findElement(By.xpath("//input[@name='repeatedPassword']"));
        confirmpasswordField.sendKeys("surbhi123");
        //Click on REGISTER button
        WebElement registerbuttonField = driver.findElement(By.xpath("//input[@value='Register']"));
        registerbuttonField.click();

        //Verify the text 'Your account was created successfully. You are now logged in.’
        String expectedMsg = "Your account was created successfully. You are now logged in.";

        WebElement actualresult = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));
        String actualMsg = actualresult.getText();
        System.out.println(actualMsg);

        Assert.assertEquals("Invalid details", actualMsg, expectedMsg);

    }

    @After
    public void tearDown() {
       // closebrowser();
    }
}




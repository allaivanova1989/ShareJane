import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RegistrationTest {
    WebDriver driver;

    @BeforeTest
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");

    }

    @AfterTest
    public void closePage() {
        driver.quit();
    }

    @Test
    public void inputValidData() {
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Alex");
        WebElement lastNameinput = driver.findElement(By.name("last_name"));
        lastNameinput.sendKeys("Ivanov");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("baby20086@rambler.ru");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("12345Ai");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("12345Ai");
//        // нажимаем кнопку register
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();
//        // Убедиться что регистрация произошла
        boolean isDisplayed = driver.findElement(By.cssSelector(".confirmation_message")).isDisplayed();
        Assert.assertTrue(isDisplayed, "We have a bug. Account was not created.");

    }

    @Test
    public void emptyInput() {
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("");
        WebElement lastNameinput = driver.findElement(By.name("last_name"));
        lastNameinput.sendKeys("");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("");
        // нажимаем кнопку register
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();
        // Убедиться что регистрация не произошла
        boolean isDisplayed = driver.findElement(By.cssSelector(".error_message")).isDisplayed();
        Assert.assertTrue(isDisplayed, "We have a bug. The registration form is not working correctly ");


    }

    @Test
    public void inputInvalidEmail() {
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Alex");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("baby20086");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("123456789");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("123456789");
        // нажимаем кнопку register
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();
        // Убедиться что регистрация не произошла
        boolean isDisplayed = driver.findElement(By.cssSelector(".error_message")).isDisplayed();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error_message")).getText(), "Oops, error on page. Some of your fields have invalid data or email was previously used", "We have a bug. The registration form is not working correctly ");

    }

    @Test
    public void inputInvalidPassword() {
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Alex");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("baby20086");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("-+*=");
        WebElement confirmPasswordInput = driver.findElement(By.name("password2"));
        confirmPasswordInput.sendKeys("-+*=");
        // нажимаем кнопку register
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();
        // Убедиться что регистрация не произошла
        boolean isDisplayed = driver.findElement(By.cssSelector(".error_message")).isDisplayed();
        Assert.assertEquals(driver.findElement(By.cssSelector(".error_message")).getText(), "Oops, error on page. the password must contain letters of the Latin alphabet, symbols and numbers", "We have a bug. The message does not contain information about an error in the password ");

    }

    @Test
    public void passwordVisibilityProtection() {
        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        firstNameInput.sendKeys("Alex");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("baby20086");
        WebElement passwordInput = driver.findElement(By.name("password1"));
        passwordInput.sendKeys("123456789");

        Assert.assertEquals(passwordInput.getAttribute("type"), "password", "We have a bug.The password is not secret. ");




    }
}

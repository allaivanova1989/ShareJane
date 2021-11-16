import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class SignUpTest {
    @Test
    public void zipCodeShouldAccept5Digits() {
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Ввести пять цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        // нажимаем кнопку continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        // Убедиться что мы настранице SignUp1
        try {
            boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        } catch (Exception e) {
            Assert.assertTrue(false, "We have a bug. Error message has not been displayed.");
        } finally {
            driver.quit();
        }
    }

    @Test
    public void zipCodeShouldAccept6Digits() {
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Ввести шесть цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");
        // нажимаем кнопку continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        // Убедиться что есть сообщение об ошибке
        try {
            boolean isDisplayed = driver.findElement(By.cssSelector(".error_message")).isDisplayed();
        } catch (Exception e) {
            Assert.assertTrue(false, "We have a bug. Error message has not been displayed.");
        } finally {
            driver.quit();
        }

    }

    @Test
    public void zipCodeShouldAccept4Digits() {
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        // Ввести четыре цифр
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");
        // нажимаем кнопку continue
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        // Убедиться что есть сообщение об ошибке
        try {
            boolean isDisplayed3 = driver.findElement(By.cssSelector(".error_message")).isDisplayed();
        } catch (Exception e) {
            Assert.assertTrue(false, "We have a bug. Error message has not been displayed.");
        } finally {
            driver.quit();
        }
    }

}

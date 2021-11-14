import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class SignUpTest {
    @Test
    public void ZipCodeShouldAccept5Digits() {
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
        boolean isDisplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDisplayed, "Oops, we have a bug");
        // Закрыть браузер
        driver.quit();
    }

    @Test
    public void ZipCodeShouldAccept6Digits() {
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver2 = new ChromeDriver();
        driver2.get("https://www.sharelane.com/cgi-bin/register.py");
        // Ввести шесть цифр
        WebElement zipCodeInput2 = driver2.findElement(By.name("zip_code"));
        zipCodeInput2.sendKeys("123456");
        // нажимаем кнопку continue
        WebElement continueButton2 = driver2.findElement(By.cssSelector("[value=Continue]"));
        continueButton2.click();
        // Убедиться что есть сообщение об ошибке
        boolean isDisplayed2 = driver2.findElement(By.cssSelector(".error_message")).isDisplayed();
        Assert.assertTrue(isDisplayed2, "Oops, we have a bug");
        // Закрыть браузер
        driver2.quit();

    }

    @Test
    public void ZipCodeShouldAccept4Digits() {
        // Открытие страницы https://www.sharelane.com/cgi-bin/register.py
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver3 = new ChromeDriver();
        driver3.get("https://www.sharelane.com/cgi-bin/register.py");
        // Ввести четыре цифр
        WebElement zipCodeInput3 = driver3.findElement(By.name("zip_code"));
        zipCodeInput3.sendKeys("1234");
        // нажимаем кнопку continue
        WebElement continueButton3 = driver3.findElement(By.cssSelector("[value=Continue]"));
        continueButton3.click();
        // Убедиться что есть сообщение об ошибке
        boolean isDisplayed3 = driver3.findElement(By.cssSelector(".error_message")).isDisplayed();
        Assert.assertTrue(isDisplayed3, "Oops, we have a bug");
        // Закрыть браузер
        driver3.quit();
    }

}

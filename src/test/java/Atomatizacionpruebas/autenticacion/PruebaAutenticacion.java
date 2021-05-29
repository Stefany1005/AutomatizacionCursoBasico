package Atomatizacionpruebas.autenticacion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PruebaAutenticacion {

    public static WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void autenticacionexitosa()
    {
        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");

        driver.findElement(By.id("menu-item-50")).click();
        try
        {
            Thread.sleep(5000);
        }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        boolean loginClass = driver.findElements(By.tagName("form")).get(1).getAttribute("class").equals("login");

        Assert.assertEquals("login", driver.findElement(By.xpath("//*[@class='u-column1 col-1']/h2")).getText());
        Assert.assertEquals("Login", driver.findElement(By.xpath("//*[@class='u-column1 col-1']/h2")).getText());
        Assert.assertEquals("Login", driver.findElement(By.cssSelector(".u-column1")).findElement(By.tagName("h2")).getText());
        Assert.assertEquals("Login",driver.findElement(By.className("u-column1")).findElement(By.tagName("h2")).getText());

        Assert.assertTrue(loginClass);
    }

    @After
    public void close()
    {
        driver.quit();
    }

}

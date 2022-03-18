package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
       // driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
       // driver.navigate().to("https://www.google.com");
    }

 /*   @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Iniciando Pruebas...");
        WebElement searchbox = driver.findElement(By.name("q"));
        searchbox.sendKeys("HandBook Devops");
        searchbox.submit();
        assertEquals("HandBook Devops - Buscar con Google", driver.getTitle());
    }*/

   /* @Test
  public void testhelloworld() {
    driver.get("http://localhost:8091/");
    driver.manage().window().setSize(new Dimension(836, 693));
    driver.findElement(By.id("floatingInput")).click();
    {
      WebElement element = driver.findElement(By.id("floatingInput"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("floatingInput")).sendKeys("luisa.c.hernandez@gmail.com");
    driver.findElement(By.id("floatingPassword")).sendKeys("djdjdj");
    driver.findElement(By.cssSelector("label > input")).click();
    driver.findElement(By.id("btn-sign-in")).click();
  }*/

  @Test
  public void TestCrearUsuario() {
    String mailNuevo="Grupo5"+String.valueOf(Math.random())+"@gmail.com";;
    driver.manage().window().maximize();
    driver.get("http://automationpractice.com//index.php");
    driver.manage().window().setSize(new Dimension(1480, 885));
    driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).sendKeys(mailNuevo);
    driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.findElement(By.id("id_gender2")).click();
    driver.findElement(By.id("customer_firstname")).click();
    driver.findElement(By.id("customer_firstname")).sendKeys("GrupoCinco");
    driver.findElement(By.id("customer_lastname")).click();
   // driver.findElement(By.id("customer_firstname")).click();
   // driver.findElement(By.id("customer_firstname")).sendKeys("Grupo");
    driver.findElement(By.id("customer_lastname")).sendKeys("Cinco");
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys("123456789");
    driver.findElement(By.cssSelector(".account_creation:nth-child(1) > .required:nth-child(5)")).click();

    {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("days")));
    }
   // driver.findElement(By.id("days")).click();
    
    driver.findElement(By.id("days")).click();
    {
      WebElement dropdown = driver.findElement(By.id("days"));
      //*[@id="days"]/option[2]
      dropdown.findElement(By.xpath("//option[2]")).click();
    }
    //driver.findElement(By.cssSelector("#days > option:nth-child(20)")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("months")));
    }
    driver.findElement(By.id("months")).click();
    {
      WebElement dropdown = driver.findElement(By.id("months"));
            //*[@id="months"]/option[13]  @value='8589934864'
            // Create object of the Select class
            Select se = new Select(driver.findElement(By.xpath("//*[@id='months']")));
            // Select the option by index
            se.selectByIndex(3);

    }
   
   {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("years")));
  }
    driver.findElement(By.id("years")).click();
    {
      WebElement dropdown = driver.findElement(By.id("years"));
      dropdown.findElement(By.xpath("//option[2]")).click();
     // dropdown.findElement(By.xpath("//option[. = 'regexp:1992\\s+']")).click();
    }

    
    driver.findElement(By.cssSelector("#years > option:nth-child(32)")).click();
    driver.findElement(By.cssSelector(".form-group > .row")).click();
    driver.findElement(By.id("company")).click();
    driver.findElement(By.id("address1")).click();
    driver.findElement(By.id("address1")).sendKeys("Santiago, Chile");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("Santiago");
    driver.findElement(By.cssSelector(".is_customer_param")).click();
    driver.findElement(By.id("id_state")).click();
    {
      WebElement dropdown = driver.findElement(By.id("id_state"));
      dropdown.findElement(By.xpath("//option[. = 'Kentucky']")).click();
    }
    driver.findElement(By.cssSelector("#id_state > option:nth-child(19)")).click();
    driver.findElement(By.id("postcode")).click();
    driver.findElement(By.id("postcode")).sendKeys("12345");
    driver.findElement(By.cssSelector(".required:nth-child(10)")).click();
    driver.findElement(By.id("id_country")).click();
    driver.findElement(By.cssSelector("#id_country > option:nth-child(2)")).click();
    driver.findElement(By.id("other")).click();
    driver.findElement(By.id("other")).sendKeys("Dejar en porteria");
    driver.findElement(By.id("phone")).click();
    driver.findElement(By.id("phone_mobile")).click();
    driver.findElement(By.id("phone_mobile")).sendKeys("9857474411");
    driver.findElement(By.cssSelector("#submitAccount .icon-chevron-right")).click();
    driver.findElement(By.linkText("Sign out")).click();
  }
}

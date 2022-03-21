package selenium;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        driver = new ChromeDriver();
       // driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
       // driver.navigate().to("https://www.google.com");
    }

 

  @Test
  public void TestCrearUsuario() {
    //para que cree un mail random siempre 
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
  
    driver.findElement(By.id("customer_lastname")).sendKeys("Cinco");
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys("123456789");
    driver.findElement(By.cssSelector(".account_creation:nth-child(1) > .required:nth-child(5)")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, 10);
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("days")));
    }
    //se elige dia de nacimiento
    driver.findElement(By.id("days")).click();
    {
      WebElement dropdown = driver.findElement(By.id("days"));
      dropdown.findElement(By.xpath("//option[2]")).click();
    }
    //se elige mes de nacimiento
    driver.findElement(By.id("months")).click();
    {
            Select se = new Select(driver.findElement(By.xpath("//*[@id='months']")));
            // Select the option by index
            se.selectByIndex(3);
    }
     //se elige anio de nacimiento
   {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("years")));
  }
    driver.findElement(By.id("years")).click();
    {
      WebElement dropdown = driver.findElement(By.id("years"));
      dropdown.findElement(By.xpath("//option[2]")).click();
    }
    //completa el resto de inforamcion
    
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
    driver.findElement(By.xpath("(//a[contains(text(),\'Dresses\')])[5]")).click();
    //eleccion de producto
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Printed Dress']")));
     ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , ele);
     //cambiar la cantidad
     driver.findElement(By.id("quantity_wanted")).click();
     driver.findElement(By.id("quantity_wanted")).clear();
     driver.findElement(By.id("quantity_wanted")).sendKeys("3");
  //Agregar al carro
  driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();

 
  ///Boton proceed to checkout
  wait = new WebDriverWait(driver, 20);
  WebElement ele2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
  ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , ele2);

    driver.findElement(By.cssSelector(".standard-checkout > span")).click();
    driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
    driver.findElement(By.id("cgv")).click();
    driver.findElement(By.cssSelector(".standard-checkout > span")).click();
    driver.findElement(By.cssSelector(".bankwire > span")).click();
    driver.findElement(By.cssSelector("#cart_navigation span")).click();

    assertTrue(driver.getTitle().contains("Order confirmation - My Store"));
    driver.close();
    driver.quit();
  }

  @Test
  public void TestComprar() {
    driver.manage().window().maximize();
    driver.get("http://automationpractice.com/index.php");

    driver.findElement(By.linkText("Sign in")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("grupocinco@gmail.com");
    driver.findElement(By.id("login_form")).click();
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys("123456789");
    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("(//a[contains(text(),\'Dresses\')])[5]")).click();
    //eleccion de producto
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Printed Dress']")));
     ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , ele);
     //cambiar la cantidad
     driver.findElement(By.id("quantity_wanted")).click();
     driver.findElement(By.id("quantity_wanted")).clear();
     driver.findElement(By.id("quantity_wanted")).sendKeys("2");
  //Agregar al carro
  driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();

 
  ///Boton proceed to checkout
  wait = new WebDriverWait(driver, 20);
  WebElement ele2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Proceed to checkout']")));
  ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , ele2);

    driver.findElement(By.cssSelector(".standard-checkout > span")).click();
    driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
    driver.findElement(By.id("cgv")).click();
    driver.findElement(By.cssSelector(".standard-checkout > span")).click();
    driver.findElement(By.cssSelector(".bankwire > span")).click();
    driver.findElement(By.cssSelector("#cart_navigation span")).click();
    assertTrue(driver.getTitle().contains("Order confirmation - My Store"));
    driver.close();
    driver.quit();
  }
  
}

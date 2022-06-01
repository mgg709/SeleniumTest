// Generated by Selenium IDE
package org.ual.hmis.equipo7;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class EliminacionTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  private int browser = 0;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	  String browserProperty = ""; 
		Boolean headless = false;
		
		try {
			browserProperty= System.getProperty("browserWebDriver");
		
			// run headless: clean test -DbrowserWebDriver=firefox -Dheadless=true
			if (System.getProperty("headless").equals("true")) {
				headless = true;
			}
		}catch(Exception e) {
			fail("Error en parámetros llamada a maven");
		}

		switch (browserProperty) {
		case "firefox": 
			// Firefox 
			// Descargar geckodriver de https://github.com/mozilla/geckodriver/releases
			// Descomprimir el archivo geckodriver.exe en la carpeta drivers

			//System.setProperty("webdriver.gecko.driver",  "drivers/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (headless) firefoxOptions.setHeadless(headless);
			driver = new FirefoxDriver(firefoxOptions);
			browser = 1;

			break;
		case "chrome": 
			// Chrome
			// Descargar Chromedriver de https://chromedriver.chromium.org/downloads
			// Descomprimir el archivo chromedriver.exe en la carpeta drivers

			//System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			if (headless) chromeOptions.setHeadless(headless);
			chromeOptions.addArguments("window-size=1920,1080");
			driver = new ChromeDriver(chromeOptions);
			browser = 0;

			break;

		default:
			fail("Please select a browser");
			break;
		}
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void eliminacinCasoCorrecto() {
    // Test name: Eliminación-CasoCorrecto
    // Step # | name | target | value
    // 1 | open | http://coresqlmgg.azurewebsites.net/ | 
    driver.get("http://coresqlmgg.azurewebsites.net/");
    // 2 | setWindowSize | 968x1039 | 
    driver.manage().window().setSize(new Dimension(968, 1039));
    // 3 | executeScript | return "hmis-" + Math.floor(Math.random()*1500000) | descripcionRandom
    vars.put("descripcionRandom", js.executeScript("return \"hmis-\" + Math.floor(Math.random()*1500000)"));
    // 4 | click | linkText=Create New | 
    driver.findElement(By.linkText("Create New")).click();
    // 5 | click | id=Description | 
    driver.findElement(By.id("Description")).click();
    // 6 | type | id=Description | ${descripcionRandom}
    driver.findElement(By.id("Description")).sendKeys(vars.get("descripcionRandom").toString());
    // 7 | type | id=CreatedDate | 2022-04-04
    String fecha = browser == 0 ? "04-04-2022" : "2022-04-04";
    driver.findElement(By.id("CreatedDate")).sendKeys(fecha);
    // 8 | click | css=.btn | 
    driver.findElement(By.cssSelector(".btn")).click();
    // 9 | storeXpathCount | xpath=//tbody/tr | RowsPrev
    vars.put("RowsPrev", driver.findElements(By.xpath("//tbody/tr")).size());
    // 10 | click | css=tr:nth-child(${RowsPrev}) a:nth-child(3) | 
    driver.findElement(By.cssSelector("tr:nth-child(" + vars.get("RowsPrev").toString() + ") a:nth-child(3)")).click();
    // 11 | click | css=.btn | 
    driver.findElement(By.cssSelector(".btn")).click();
    // 12 | storeXpathCount | xpath=//tbody/tr | RowsLater
    vars.put("RowsLater", driver.findElements(By.xpath("//tbody/tr")).size());
    // 13 | executeScript | return parseInt(${RowsPrev}) - parseInt(1) | NewRows
    vars.put("NewRows", js.executeScript("return parseInt(arguments[0]) - parseInt(1)", vars.get("RowsPrev")));
    // 14 | assert | RowsLater | ${NewRows} 
    assertEquals(vars.get("RowsLater").toString(), vars.get("NewRows").toString());
    // 15 | assertNotText | xpath=//tr[last()]/td[1] | ${descripcionRandom}
    boolean correcto = false;
    try {
    	correcto = driver.findElement(By.xpath("//tr[last()]/td[1]")).getText() != vars.get("descripcionRandom").toString();
    }
    catch (org.openqa.selenium.NoSuchElementException e) {
		correcto = true;
	}
    assertTrue(correcto);
  }
  @Test
  public void eliminacinCasoIncorrectoCancelado() {
    // Test name: Eliminación-CasoIncorrecto-Cancelado
    // Step # | name | target | value
    // 1 | open | http://coresqlmgg.azurewebsites.net/ | 
    driver.get("http://coresqlmgg.azurewebsites.net/");
    // 2 | setWindowSize | 968x1039 | 
    driver.manage().window().setSize(new Dimension(968, 1039));
    // 3 | executeScript | return "hmis-" + Math.floor(Math.random()*1500000) | descripcionRandom
    vars.put("descripcionRandom", js.executeScript("return \"hmis-\" + Math.floor(Math.random()*1500000)"));
    // 4 | click | linkText=Create New | 
    driver.findElement(By.linkText("Create New")).click();
    // 5 | click | id=Description | 
    driver.findElement(By.id("Description")).click();
    // 6 | type | id=Description | ${descripcionRandom}
    driver.findElement(By.id("Description")).sendKeys(vars.get("descripcionRandom").toString());
    // 7 | type | id=CreatedDate | 2001-01-25
    String fecha = browser == 0 ? "04-04-2022" : "2022-04-04";
    driver.findElement(By.id("CreatedDate")).sendKeys(fecha);
    // 8 | click | css=.btn | 
    driver.findElement(By.cssSelector(".btn")).click();
    // 9 | storeXpathCount | xpath=//tbody/tr | RowsPrev
    vars.put("RowsPrev", driver.findElements(By.xpath("//tbody/tr")).size());
    // 10 | click | css=tr:nth-child(${RowsPrev}) a:nth-child(3) | 
    driver.findElement(By.cssSelector("tr:nth-child(" + vars.get("RowsPrev").toString() + ") a:nth-child(3)")).click();
    // 11 | click | linkText=Back to List | 
    driver.findElement(By.linkText("Back to List")).click();
    // 12 | storeXpathCount | xpath=//tbody/tr | RowsLater
    vars.put("RowsLater", driver.findElements(By.xpath("//tbody/tr")).size());
    // 13 | assert | RowsLater | ${RowsPrev} 
    assertEquals(vars.get("RowsLater").toString(), vars.get("RowsPrev").toString());
    // 14 | assertText | xpath=//tr[last()]/td[1] | ${descripcionRandom}
    assertThat(driver.findElement(By.xpath("//tr[last()]/td[1]")).getText(), is(vars.get("descripcionRandom").toString()));
    // 15 | click | css=tr:nth-child(${RowsLater}) a:nth-child(3) | 
    driver.findElement(By.cssSelector("tr:nth-child(" + vars.get("RowsLater").toString() + ") a:nth-child(3)")).click();
    // 16 | click | css=.btn | 
    driver.findElement(By.cssSelector(".btn")).click();
  }
}

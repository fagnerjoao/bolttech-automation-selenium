package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    static WebDriver driver;

    public enum Browser {CHROME, FIREFOX}

    public static WebDriver getDriver(){
        return getDriver(Browser.CHROME);
    }

    public static WebDriver getDriver(Browser browser){

        if (driver == null){
            switch (browser){
                case CHROME:
                    driver = createChromeDriver();
                    break;
                case FIREFOX:
                    driver = createFirefoxDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Informe um navegador válido");
            }
        }

        return driver;
    }

    private static WebDriver createChromeDriver() {
        if (driver != null){
            driver.quit();
        }

        // Configuração do ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars", "--disable-gpu", "--window-size=1920,1200",
                "--ignore-certificate-errors", "--disable-notifications", "--disable-popup-blocking", "--incognito");

        // Inicialização do driver
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://automationexercise.com/");

        return driver;
    }

    private static WebDriver createFirefoxDriver() {
        if (driver != null){
            driver.quit();
        }

        // Inicialização do driver
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://automationexercise.com/");

        return driver;
    }


}
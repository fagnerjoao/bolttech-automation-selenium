package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        plugin = {"pretty", "html:target/reports/html/cucumberReport.html",
                "json:target/reports/json/cucumberReport.json",
                "junit:target/reports/junit/cucumberReport.xml"},
        tags = "@verify-product",
        glue = "steps"
)
public class Runner extends Driver {

    @AfterClass
    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}

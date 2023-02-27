package gun11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class IFrames {


    WebDriver driver;
    WebDriverWait wait;

    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    String url = "https://demoqa.com/frames";


    By sampleText = By.id("sampleHeading");


    @Test
    public void testFrame1(){
        driver.get(url);

        String frame1Id = "frame1";
        //int frame1Index = 0;
        WebElement frame1Element = driver.findElement(By.id("frame1"));

        driver.switchTo().frame(frame1Element);
        WebElement sT = wait.until(ExpectedConditions.visibilityOfElementLocated(sampleText));
        System.out.println(sT.getText());
        driver.switchTo().parentFrame();
        String mainText = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]")).getText();
        System.out.println(mainText);
        driver.quit();
    }


}


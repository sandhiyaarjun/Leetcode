package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().browserVersion("122.0.6261.95").setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://leetcode.com/");
        String title = driver.getCurrentUrl();
        String expected = "leetcode";
        if (title.contains(expected)) {
            System.out.println("Title contains " + expected);
        }
        System.out.println("end Test case: testCase01");
    }

    public void testCase02() throws InterruptedException {
        System.out.println("Start Test case: testCase02");
        driver.get("https://leetcode.com/");

        WebElement questionLink = driver.findElement(By.xpath("//*[@id='product']/div/div/div[1]/div/a/p"));
        // p[@class='link']/p[text()='View Questions ']
        questionLink.click();
        String problems = driver.getCurrentUrl();
        String expected0 = "problemset";
        if (problems.contains(expected0)) {
            System.out.println("Title contains " + expected0);
        }
        WebElement firstQues = driver.findElement(By.xpath("//div[@role='cell']/div/div/div/div/a[text()='Two Sum']"));
        String title1 = firstQues.getText();
        String expected1 = "Two Sum";
        if (title1.contains(expected1)) {
            System.out.println("1. " + expected1);
        }
        WebElement secondQues = driver
                .findElement(By.xpath("//div[@role='cell']/div/div/div/div/a[text()='Add Two Numbers']"));
        String title2 = secondQues.getText();
        String expected2 = "Add Two Numbers";
        if (title2.contains(expected2)) {
            System.out.println("2. " + expected2);
        }
        WebElement thirdQues = driver.findElement(By.xpath(
                "//div[@role='cell']/div/div/div/div/a[text()='Longest Substring Without Repeating Characters']"));
        String title3 = thirdQues.getText();
        String expected3 = "Longest Substring Without Repeating Characters";
        if (title3.contains(expected3)) {
            System.out.println("3. " + expected3);
        }
        WebElement fourthQues = driver
                .findElement(By.xpath("//div[@role='cell']/div/div/div/div/a[text()='Median of Two Sorted Arrays']"));
        String title4 = fourthQues.getText();
        String expected4 = "Median of Two Sorted Arrays";
        if (title4.contains(expected4)) {
            System.out.println("4. " + expected4);
        }
        WebElement fifthQues = driver
                .findElement(By.xpath("//div[@role='cell']/div/div/div/div/a[text()='Longest Palindromic Substring']"));
        String title5 = fifthQues.getText();
        String expected5 = "Longest Palindromic Substring";
        if (title5.contains(expected5)) {
            System.out.println("5. " + expected5);
        }
        System.out.println("end Test case: testCase02");
    }

}

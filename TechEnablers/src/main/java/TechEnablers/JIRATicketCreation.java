package TechEnablers;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JIRATicketCreation {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        System.out.println("Hello world!");
        driver.get("https://konavenkatesh2.atlassian.net/jira/servicedesk/projects/TEC/getting-started");
        driver.manage().window().maximize();
        Thread.sleep(7000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        By UserName = By.id("username");
        enterData(UserName,driver,"kona.venkatesh2@gmail.com");

        By Login_Button =   By.xpath("//button[@id='login-submit']/span");
        click(Login_Button,driver);

        By Password = By.id("password");
        enterData(Password,driver,"Venky@0321");
        click(Login_Button,driver);

        By Create_Button = By.xpath("//button[@id='createGlobalItem']/span");
        click(Create_Button,driver);

        Thread.sleep(8000);

        By Issue_Type_DD = By.xpath("//div[@id='issue-create.ui.modal.create-form.type-picker.issue-type-select']//div[@class=' css-2egbai']/div/span");
        click(Issue_Type_DD,driver);

        By Issue_Type_Option = By.xpath("//div[@id='react-select-5-option-6']");
        click(Issue_Type_Option,driver);

        By Summary_Field = By.id("summary-field");
        enterData(Summary_Field,driver,"Creating Ticket to Get approval for GCP");

        By Manager_DD = By.xpath("//input[@id='customfield_10003-field']");
        click(Manager_DD,driver);
        enterData(Manager_DD,driver,"Venkatesh");

        By Manager_DD_Option = By.xpath("//div[@class='css-yyrqoa']")   ;
        click(Manager_DD_Option,driver);

        By Create_Ticket = By.xpath("//button[@class='css-1jk3zmn']");
        click(Create_Ticket,driver);

        Thread.sleep(3000);
        driver.quit();
        //driver.close();

     }
    public static void click(By element,WebDriver driver)
    {
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(element));
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();

    }
    public static void enterData(By element,WebDriver driver,String data) throws TimeoutException
    {
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.presenceOfElementLocated(element));
        new WebDriverWait(driver,Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).sendKeys(data);
    }
}
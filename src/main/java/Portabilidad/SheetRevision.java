package Portabilidad;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Scanner;

public class SheetRevision extends Check{
    private String ID_Case;
    private  WebDriverWait wait;
    private  WebDriver driver;
    private final By IniciarButton = By.xpath("//div[@class='appmagic-button-label no-focus-outline']");
    private final By IntroduceCase = By.xpath("//input[@class='appmagic-text mousetrap block-undo-redo']");
    private final By PanIcon = By.xpath("(//div[@class='powerapps-icon no-focus-outline'])[4]");

    public SheetRevision()throws Exception{
    }
    public void GetDriver(){
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver , Duration.ofSeconds(5));
    }
    public void Switching(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
    }
    public void SwitchingOff(){
        driver.switchTo().defaultContent();
    }
    public void GetIdCase(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce the case Number: ");
         ID_Case = scan.next();
    }
    public void GoToVCTool(){
        driver.navigate().to("https://apps.powerapps.com/play/e/default-68283f3b-8487-4c86-adb3-a5228f18b893/a/5996516e-15f4-4d7f-a077-65b4ec5a037f?tenantId=68283f3b-8487-4c86-adb3-a5228f18b893&hint=fb40c2e7-cffd-4e5b-9711-ec3bd2f12dca&sourcetime=1699970459236");
        driver.manage().window().maximize();
    }
    public void InitiateVCTool(){
        Switching();
        wait.until(ExpectedConditions.elementToBeClickable(IniciarButton));
        driver.findElement(IniciarButton).click();
        SwitchingOff();
    }
    public void EnterToCases(){
        Actions actions= new Actions(driver);
        actions.keyDown(Keys.TAB).build().perform();
        actions.keyDown(Keys.TAB).build().perform();
        actions.keyDown(Keys.TAB).build().perform();
        actions.keyDown(Keys.ENTER).build().perform();
    }
    public void IntroduceCase(){
        Switching();
        wait.until(ExpectedConditions.elementToBeClickable(IntroduceCase));
        driver.findElement(IntroduceCase).sendKeys(ID_Case);
        SwitchingOff();
    }
    public void GetSpecificCase(){
        Switching();
        wait.until(ExpectedConditions.elementToBeClickable(PanIcon));
        driver.findElement(PanIcon).click();
        SwitchingOff();
    }
    public void DownloadFile()throws Exception{
     Thread.sleep(1500);
     getRobot().mouseMove(1331, 786);
     getRobot().mousePress(KeyEvent.BUTTON1_DOWN_MASK);
     getRobot().mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
     Thread.sleep(1000);
     getRobot().mouseMove(441, 516);
     getRobot().mousePress(KeyEvent.BUTTON1_DOWN_MASK);
     getRobot().mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
    }
    public void ShowFile()throws Exception{
        Thread.sleep(1500);
        getRobot().mouseMove(1302, 134);
        Thread.sleep(500);
        getRobot().mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        getRobot().mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
    }
    public void Exit(){
        driver.quit();
    }


     public static void main(String[] args)throws  Exception{
    SheetRevision sheetRevision = new SheetRevision();
    sheetRevision.GetIdCase();
    sheetRevision.GetDriver();
    sheetRevision.GoToVCTool();
    sheetRevision.InitiateVCTool();
    Thread.sleep(1500);
    sheetRevision.EnterToCases();
    sheetRevision.IntroduceCase();
    sheetRevision.GetSpecificCase();
    sheetRevision.DownloadFile();
    sheetRevision.ShowFile();
    Thread.sleep(500);
    sheetRevision.Exit();
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package testsharebus;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestShareBus {
    
     static String browser;
     static WebDriver driver;

    public static void main(String[] args) {
        
         setBrowser();  
         browserConfi(); 
         runTest();
    }
    
    public static void setBrowser(){
      
          browser = "chrome";        
  }
         
   public static void browserConfi(){
        
        System.getProperty("os.name");
        //System.out.println("my current os is"+System.getProperty("os.name"));
        
        if(System.getProperty("os.name").contains("Window")){
            System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver.exe");     
        }
        else if(System.getProperty("os.name").contains("Linux")){
            
            System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver");
        }
        else if(System.getProperty("os.name").contains("Mac")){
            System.setProperty("webdriver.chrome.driver","E:\\selenium\\chromedriver_win32\\chromedriver");
        }
        
        driver = new ChromeDriver();     
        driver.get("https://test.sharebus.co/");
       
        //maximize the browser window
        driver.manage().window().maximize();
        
        //manage timeout implicitywait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

  }   
   
   public static void runTest(){
         
       //SignUp ShareBus
         driver.findElement(By.xpath("//*[@id=\"app\"]/nav/div/ul/li/button")).click(); 
         driver.findElement(By.id("email")).sendKeys("brainstation23@yopmail.com"); 
         driver.findElement(By.id("password")).sendKeys("Pass@1234");
         driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/form/div[4]/button")).click(); 
         
         //SelectUser ShareBus
         driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[2]")).click(); 
         List<WebElement>SelectUsers=driver.findElements(By.xpath("/html/body/div[3]/div/ul//li"));
         System.out.println("Number of Options:"+SelectUsers.size());
         
         for(WebElement selectuser:SelectUsers){
             
             selectuser.findElement(By.xpath("/html/body/div[3]/div/ul/li[2]/div")).click();
             break;
         }
        
         driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/button")).click();
         
         
         //SetUp ShareBus Button
         JavascriptExecutor js=(JavascriptExecutor)driver;
         js.executeScript("window.scrollBy(0,1300)","");
       
         driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[4]/button")).click();
         
         //SetUp ShareBus form
         driver.findElement(By.id("startPoint")).sendKeys("Oslo, Norway");
      
       
         
         
        
         
         
         
         
         String title = driver.getTitle();
        // driver.close();
        // driver.quit();
        
}
}

    


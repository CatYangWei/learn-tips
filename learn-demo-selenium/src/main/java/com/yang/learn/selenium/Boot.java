package com.yang.learn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author yangweia
 * @title
 * @date 2019年03月07日
 * @since v1.0.0
 */
public class Boot {
    public static void main(String[] args)throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        WebElement search_text = driver.findElement(By.id("kw"));
        WebElement search_button = driver.findElement(By.id("su"));

        search_text.sendKeys("Java");
        search_text.clear();
        search_text.sendKeys("Selenium");
        search_button.click();
        //driver.findElement(By.name("TPL_username")).sendKeys("take花音00");
        //        driver.findElement(By.name("TPL_password")).sendKeys("155316BByy!!");
        //        driver.findElement(By.id("J_SubmitStatic")).click();
        System.in.read();
        driver.close();

    }
}

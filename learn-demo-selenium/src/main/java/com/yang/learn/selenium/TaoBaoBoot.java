package com.yang.learn.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author yangweia
 * @title
 * @date 2019年03月07日
 * @since v1.0.0
 */
public class TaoBaoBoot {
    public static void main(String[] args)throws Exception {
        System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.taobao.com");
        TimeUnit.SECONDS.sleep(1);
        WebElement loginButton = driver.findElement(By.linkText("亲，请登录"));
        loginButton.click();
        TimeUnit.SECONDS.sleep(10);

        //登录
        driver.get("https://cart.taobao.com/cart.htm");
        //driver.findElement(By.id("J_CheckBox_1095804216071")).click();
        TimeUnit.SECONDS.sleep(5);
        WebElement jsButton = driver.findElement(By.id("J_Go"));
        jsButton.click();
        System.in.read();
        driver.close();

    }
}

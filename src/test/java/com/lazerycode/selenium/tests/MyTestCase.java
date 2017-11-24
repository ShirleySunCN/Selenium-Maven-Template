package com.lazerycode.selenium.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.lazerycode.selenium.DriverBase;

/**
 * If you want to change class name,
 * note that the the current pom.xml only includes classes named as *TestCase.
 */
public class MyTestCase extends DriverBase {

	String getImageDir() {
		String imageDir = System.getenv("IMAGE_DIR");
		if (imageDir == null) {
			imageDir = ".";
		}
		return imageDir;
	}

    void screenshot(WebDriver driver, String fileName) {
        try {
            FileOutputStream screenshotStream = new FileOutputStream(new File(getImageDir(), fileName));
            screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            screenshotStream.close();
        } catch (IOException unableToWriteScreenshot) {
            System.err.println("Unable to write " + new File(getImageDir(), fileName).getAbsolutePath());
            unableToWriteScreenshot.printStackTrace();
        }
    }

    
    @Test
    public void test_01_010_010() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("http://www.bing.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.clear();
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Test
    public void test_02_010_020() throws Exception {
        // Create a new WebDriver instance
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        WebDriver driver = getDriver();

        // And now use this to visit Google
        driver.get("http://www.bing.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.clear();
        element.sendKeys("neko nanka");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElements(By.className("sb_pagN")).size() > 0;
            }
        });
        
        screenshot(driver, "02.010.020.png");

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
    }
}
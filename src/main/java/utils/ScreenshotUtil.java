package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.DriverManager;

public class ScreenshotUtil {

    public static String capture(String testName) {

        WebDriver driver = DriverManager.getDriver();

        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss")
                .format(new Date());

        String path = "reports/screenshots/" + testName + "_" + timestamp + ".png";

        File src = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
package com.klymchuk.luxoft.util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by iklymchuk on 5/20/16.
 */
public class ScreenshotListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
    }

    public void onTestSuccess(ITestResult iTestResult) {
    }

    public void onTestFailure(ITestResult result) {
        Reporter.setCurrentTestResult(result);
        File outputDirectory = new File(System.getProperty("user.dir"), "target/surefire-reports");
        try {
            outputDirectory.mkdirs();
            File outFile = new File(outputDirectory, "TEST-" + result.getName() + ".png");
            captureScreenshot(outFile);
            Reporter.log("<a href='" + outFile.getName() + "'>screenshot</a>");
        } catch (Exception e) {
            Reporter.log("Couldn't create screenshot");
            Reporter.log(e.getMessage());
        }
        Reporter.setCurrentTestResult(null);
    }

    private static void captureScreenshot(File outFile) throws Exception {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(image, "png", outFile);
    }

    public void onTestSkipped(ITestResult iTestResult) {
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    public void onStart(ITestContext iTestContext) {
    }

    public void onFinish(ITestContext iTestContext) {
    }
}

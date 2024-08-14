package Projects;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.JavascriptExecutor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class ActionsBot {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private final Logger logger;

    public ActionsBot(WebDriver driver, Wait<WebDriver> wait, Logger logger) {
        this.driver = driver;
        this.wait = wait;
        this.logger = logger;
    }

    @Step("Navigate to URL")
    public void navigate(String url){
        logger.info("Navigating to: "+url);
        driver.get(url);
    }

    @Step("Type into element")
    public void type(AppiumBy locator, CharSequence text){
        logger.info("Typing: "+text+", into: "+locator);
        wait.until(f -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });
    }

    @Step("Click on element")
    public void click(AppiumBy locator){
        logger.info("Clicking: "+locator);
        wait.until(f -> {
            try {
                logger.debug("Using Native Selenium Click");
                driver.findElement(locator).click();
            } catch (ElementClickInterceptedException exception){
                logger.debug("Using JavaScript Click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
            }
            return true;
        });
    }

    @Step
    public void dragAndDrop(AppiumBy fBy, AppiumBy sBy) {
        logger.info("dragAndDrop: "+fBy+" to "+sBy);
        wait.until(ExpectedConditions.presenceOfElementLocated(fBy));
        wait.until(ExpectedConditions.presenceOfElementLocated(sBy));
        new Actions(driver)
                .dragAndDrop(driver.findElement(fBy),driver.findElement(sBy))
                .build()
                .perform();
    }

//    @Step("Scrolling down to the element")
//    public void scrollDownToElementByXpath(By by) throws InterruptedException {
//        logger.info("Scrolling down to: " + by);
//        boolean isElementFound = false;
//            try {
//                WebElement element = driver.findElement(by);
//                if (element.isDisplayed()) {
//                    isElementFound = true;
//                }
//            } catch (Exception e) {
//                // Element not found, scroll down
//                driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
//            }
//    }

    @Step("Scrolling down to the element")
    public void scrollDownToElementByText(String text) {
        logger.info("Scrolling down to: " + text);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));

    }

    @Step("Swipe")
    public void swipeLeft(String start, By end, int num) throws InterruptedException {
        var isElementVisible = false;
        while(!isElementVisible){
            RemoteWebElement carousel = (RemoteWebElement) wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(start)));
            try{
                driver.findElement(end).isDisplayed();
                //isElementVisible = true;
                break;
            }catch(NoSuchElementException e){
                ((JavascriptExecutor) driver).executeScript("gesture: swipe", Map.of("elementId", carousel.getId(), "percentage", num, "direction", "left"));
            }catch (UnsupportedCommandException e){
                ((JavascriptExecutor) driver).executeScript("gesture: swipe", Map.of("elementId", carousel.getId(), "percentage", num, "direction", "left"));
                System.out.println(driver.findElement(end).getText());
                break;
            }
        }
    }

    @Step("Swipe")
    public void swipeRight(String start, By end, int num) throws InterruptedException {
        var isElementVisible = false;
        while(!isElementVisible){
            RemoteWebElement carousel = (RemoteWebElement) wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(start)));
            try{
                driver.findElement(end).isDisplayed();
                //isElementVisible = true;
                break;
            }catch(NoSuchElementException e){
                ((JavascriptExecutor) driver).executeScript("gesture: swipe", Map.of("elementId", carousel.getId(), "percentage", num, "direction", "right"));
            }catch (UnsupportedCommandException e){
                ((JavascriptExecutor) driver).executeScript("gesture: swipe", Map.of("elementId", carousel.getId(), "percentage", num, "direction", "right"));
                System.out.println(driver.findElement(end).getText());
                break;
            }
        }
    }


//    @Step("Get text from element")
//    public String getText(AppiumBy by) {
//        logger.info("Getting text from: " + by);
//        wait.until(f -> driver.findElement(by).isDisplayed());
//        return driver.findElement(by).getText();
//    }

    @Step("Check the element is displayed")
    public boolean isDisplayed(AppiumBy by) {
        logger.info("Check the element is displayed from: " + by);
        wait.until(f -> driver.findElement(by).isDisplayed());
        return driver.findElement(by).isDisplayed();
    }

//    public void waitUntilIsNotDisplayed(AppiumBy by) {
//        logger.info("Check and wait the element is not displayed from: " + by);
//        wait.until(f -> driver.findElements(by).isEmpty());
//    }
//
//    @Step("Get tag name from element")
//    public String getTagName(AppiumBy by) {
//        logger.info("Getting Tag name from: " + by);
//        wait.until(f -> driver.findElement(by).isDisplayed());
//        return driver.findElement(by).getTagName();
//    }
//
//    @Step
//    public List<String> getTextList(AppiumBy by) {
//        logger.info("getText: "+by);
//        return driver.findElements(by).stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//
//    }

//    @Step("Capturing Screenshot Evidence")
//    public void capturingScreenshotEvidence(AppiumBy parentBy,AppiumBy evidenceBy) {
//        wait.until(driver1 -> driver1.findElement(parentBy).isDisplayed() && driver1.findElement(evidenceBy).isDisplayed());
//        WebElement parentElement = driver.findElement(parentBy);
//        WebElement evidenceElement = driver.findElement(evidenceBy);
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", evidenceElement);
//
//        try (InputStream is = Files.newInputStream(parentElement.getScreenshotAs(OutputType.FILE).toPath())) {
//            Allure.attachment("image.png", is);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border = \"none\";", evidenceElement);
//
//    }

    public void fullScreenShot(By by) throws IOException {
        //formatting the picture name to a random generated numbers
        long msTime = System.currentTimeMillis();
        Date dt = new Date(msTime);
        String format = "yyMMddHHmmssSSS";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        String PhotoFileName = String.format("FullPagePhoto%s", sdf.format(dt).toString());
        String saveFilename = PhotoFileName + ".png" ;

        driver.findElement(by);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/main/resources/screenshots/" + saveFilename));

    }

    public void elementScreenShot(By by) throws IOException {
        //formatting the picture name to a random generated numbers
        long msTime = System.currentTimeMillis();
        Date dt = new Date(msTime);
        String format = "yyMMddHHmmssSSS";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        String PhotoFileName = String.format("ElementPhoto%s", sdf.format(dt).toString());
        String saveFilename = PhotoFileName + ".png" ;

        WebElement element = driver.findElement(by);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Create an instance of the screenshot
        BufferedImage fullImg = ImageIO.read(screenshot);

        // Get the location and size of the element
        Point point = element.getLocation();
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();

        // Crop the full screenshot to the element's size
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);

        // Save the screenshot to a file
        try {
            ImageIO.write(eleScreenshot, "png", new File("src/main/resources/screenshots/"+ saveFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void waitFor(By by){
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

//    public void dragAndDrop(By source, By destination){
//        RemoteWebElement drag = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(source));
//        RemoteWebElement drop = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(destination));
//
//        ((JavascriptExecutor) driver).executeScript("gesture: dragAndDrop", Map.of("sourceId", drag.getId(), "destinationId", drop.getId()));
//
//    }
}


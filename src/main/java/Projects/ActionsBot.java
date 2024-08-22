package Projects;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
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
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class ActionsBot {
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    private final Logger logger;

    public ActionsBot(WebDriver driver, Wait<WebDriver> wait, Logger logger) {
        this.driver = driver;
        this.wait = wait;
        this.logger = logger;
    }

    /**
     * navigate function accepts URL of the webPage we intend to visit.
     */
    @Step("Navigate to URL")
    public void navigate(String url){
        logger.info("Navigating to: {}", url);
        driver.get(url);
    }

    /**
     * type function accepts xpath of the element we intend to type on it's field
     * as first parameter, and string of the text we intend to send.
     */
    @Step("Type into element")
    public void type(AppiumBy locator, CharSequence text){
        logger.info("Typing: {}, into: {}", text, locator);
        wait.until(f -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });
    }

    /**
     * click function accepts xpath of the element we intend
     * to click.
     */
    @Step("Click on element")
    public void click(AppiumBy locator){
        logger.info("Clicking: {}", locator);
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

    /**
     * scrollDownToElementByXpath function accepts xpath of the element we intend
     * to scroll down until it's displayed on the screen.
     */
    @Step("Scroll down by xpath")
    public void scrollDownToElementByXpath(By by) throws InterruptedException {
        logger.info("Scrolling down to : {}", by);
        //var isElementFound = false;
        while (true) {
            try {
                driver.findElement(by).isDisplayed();
                    break;
            } catch (NoSuchElementException e) {
                // Element not found, scroll down
                driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
            } catch (UnsupportedCommandException e){
                driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
                break;
            }
        }
    }

    /**
     * scrollDownToElementByText function accepts string of the text we intend to
     * scroll down until it's displayed on the screen.
     */
    @Step("Scroll down by text")
    public void scrollDownToElementByText(String text) {
        logger.info("Scrolling down to: {}", text);
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+text+"\").instance(0))"));
    }

    /**
     * swipeLeft function accepts string of the accessibility as parameter,
     * and xpath of the element you intend to stop the swipe at as second parameter,
     * then int number for the speed of swiping "ex(50)" as third parameter.
     * and it will swipe from first parameter to second parameter.
     */
    @Step("Swipe left")
    public void swipeLeft(String start, By end, int num) {
        logger.info("swiping left from: {} to: {}", start, end);
        //var isElementVisible = false;
        while(true){
            RemoteWebElement carousel = (RemoteWebElement) wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(start)));
            try{
                driver.findElement(end).isDisplayed();
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

    /**
     * swipeRight function accepts string of the accessibility as parameter,
     * and xpath of the element you intend to stop the swipe at as second parameter,
     * then int number for the speed of swiping "ex(50)" as third parameter.
     * and it will swipe from first parameter to second parameter.
     */
    @Step("Swipe right")
    public void swipeRight(String start, By end, int num) {
        logger.info("Swiping right from: {} to: {}", start, end);
        //var isElementVisible = false;
        while(true){
            RemoteWebElement carousel = (RemoteWebElement) wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(start)));
            try{
                driver.findElement(end).isDisplayed();
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


    @Step
    public List<String> getTextList(By by) {
        logger.info("getText: {}", by);
        return driver.findElements(by).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }

    /**
     * fullScreenShot function accepts xpath as parameter, and it takes a screenshot
     * of the entire page.
     */
    @Step("Take a screenshot")
    public void fullScreenShot(By by) throws IOException {
        logger.info("Taking a full screenshot of : {}", by);
        //formatting the picture name to a random generated numbers
        long msTime = System.currentTimeMillis();
        Date dt = new Date(msTime);
        String format = "yyMMddHHmmssSSS";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        String PhotoFileName = String.format("FullPagePhoto%s", sdf.format(dt));
        String saveFilename = PhotoFileName + ".png" ;

        driver.findElement(by);
        TakesScreenshot ts = (TakesScreenshot)driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("src/main/resources/screenshots/" + saveFilename));

    }

    /**
     * elementScreenShot function accepts xpath as parameter. and it takes
     * a screenshot of the element with its size only.
     */
    @Step("Take a screenshot")
    public void elementScreenShot(By by) throws IOException {
        logger.info("Taking a screenshot of: {}", by);
        //formatting the picture name to a random generated numbers
        long msTime = System.currentTimeMillis();
        Date dt = new Date(msTime);
        String format = "yyMMddHHmmssSSS";
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.US);
        String PhotoFileName = String.format("ElementPhoto%s", sdf.format(dt));
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
            logger.error(e);
        }
    }

    /**
     * waitFor function accepts xpath as parameter, and it waits until the
     * element is present on the screen.
     */
    @Step("Wait for element")
    public void waitFor(By by){
        logger.info("Waiting for : {}", by);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * dragAndDrop function accepts string of the accessibility id as first parameter,
     * and another string of the accessibility id as second parameter. Then it drags
     * the first parameter and drop it at the second parameter location.
     */
    @Step("Drag and drop")
    public void dragAndDrop(String source, String destination){
        logger.info("Dragging: {} and dropping it at: {}", source, destination);
        RemoteWebElement drag = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId(source));
        RemoteWebElement drop = (RemoteWebElement) driver.findElement(AppiumBy.accessibilityId(destination));
        ((JavascriptExecutor) driver).executeScript("gesture: dragAndDrop", Map.of("sourceId", drag.getId(), "destinationId", drop.getId()));
    }

    /**
     * doubleTap function accepts xpath as a parameter. and it taps the element
     * 2 times.
     */
    @Step("Double tap")
    public void doubleTap(By Tap){
        logger.info("Double tapping the element: {}", Tap);
        RemoteWebElement doubleTapMe = (RemoteWebElement) driver.findElement(Tap);
        ((JavascriptExecutor) driver).executeScript("gesture: doubleTap", Map.of("elementId", doubleTapMe.getId()));
    }

    /**
     * longPress function accepts xpath as a parameter. and it presses the
     * element for 8 seconds long.
     */
    @Step("Long press")
    public void LongPress(By by){
        logger.info("Long pressing the element: {}", by);
        RemoteWebElement longPress = (RemoteWebElement) driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("gesture: longPress", Map.of("elementId", longPress.getId(), "pressure", 0.5, "duration", 800));
    }

}


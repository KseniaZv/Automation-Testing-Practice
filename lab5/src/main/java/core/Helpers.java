package core;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import controls.WebTypifiedElement;

public class Helpers {

	private static final Logger log = LogManager.getLogger(Helpers.class);
	static Lorem lorem = LoremIpsum.getInstance();

	public static void hoverClick(WebDriver driver, WebElement a, WebElement b) {
		try {
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) driver).executeScript(mouseOverScript, a);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript(mouseOverScript, b);
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", b);
		} catch (Exception ignored) {
		}
	}
	public static String getRandomTitle(int length){
		return lorem.getTitle(length);
	}
	public static String getRandomParagraphs(int length1, int length2){
		return lorem.getParagraphs(length1, length2);
	}
	public static String getRandomEmail(){return lorem.getEmail();}
	
	public static void check2StringIfEquals(String actual, String expected, String msg) {
		String actualNormalized = actual.trim().replaceAll(" +", " ");
		actualNormalized = actualNormalized.replaceAll("\\r\\n|\\r|\\n", " \n");
		String expectedNormalized = expected.trim().replaceAll(" +", " ");
		expectedNormalized =expectedNormalized.replaceAll("\\r\\n|\\r|\\n", "\n");
		log.debug("Check 2 strings if equals\nActual\t:" + actualNormalized+ "\nExpected:" + expectedNormalized);
		Assert.assertTrue(StringUtils.equals(actualNormalized, expectedNormalized), msg);
	}
}

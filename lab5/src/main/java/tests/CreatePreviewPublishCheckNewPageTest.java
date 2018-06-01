package tests;

import core.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class CreatePreviewPublishCheckNewPageTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(CreatePublishCheckNewPageTest.class);

    @Test
    public void create() {
        CreatePublishCheckNewPageTest.create();
    }

    @Test(dependsOnMethods = "create")
    public void preview() throws InterruptedException {
        Thread.sleep(1000);
        log.info("Previewing Page");
        wp.editPagePage.previewBtn.click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        log.info("Checking if preview is correct");
        wp.previewPage.preview(CreatePublishCheckNewPageTest.getTitle(), CreatePublishCheckNewPageTest.getText());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    @Test(dependsOnMethods = "preview")
    public void publish() throws InterruptedException {
        log.info("Publishing Page");
        wp.editPagePage.publish();
    }

    @Test(dependsOnMethods = "publish")
    public void checkSignOut() throws InterruptedException {
        log.info("Checking presence in table");
        wp.editPagePage.checkPresence(CreatePublishCheckNewPageTest.getTitle());

        LoginSignOutTest.signOutTest();
    }
}

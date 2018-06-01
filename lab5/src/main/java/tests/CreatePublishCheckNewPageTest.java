package tests;

import core.BaseTest;
import core.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class CreatePublishCheckNewPageTest extends BaseTest {
    private static String title = Helpers.getRandomTitle(5);
    private static String text = Helpers.getRandomParagraphs(2, 5);
    private static final Logger log = LogManager.getLogger(CreatePublishCheckNewPageTest.class);

    @Test
    public static void create() {
        LoginSignOutTest.loginTest();
        log.info("Creating new Page");
        wp.dp.addNewPage();
        wp.editPagePage.addNewPage(title, text);
        log.info("New Page created");
    }

    @Test(dependsOnMethods = "create")
    public static void publish() throws InterruptedException {
        log.info("Publishing Page");
        wp.editPagePage.publish();
    }

    @Test(dependsOnMethods = "publish")
    public void checkSignOut() {
        log.info("Checking presence in table");
        wp.editPagePage.checkPresence(title);

        LoginSignOutTest.signOutTest();
    }

    public static String getText() {
        return text;
    }

    public static String getTitle() {
        return title;
    }
}

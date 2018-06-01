package tests;

import core.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import core.BaseTest;


public class CreatePublishCheckNewPostTest extends BaseTest {
    private static String title = Helpers.getRandomTitle(5);
    private static String text = Helpers.getRandomParagraphs(1, 5);
    private static final Logger log = LogManager.getLogger(CreatePublishCheckNewPostTest.class);

    @Test
    public static void create() {
        LoginSignOutTest.loginTest();
        log.info("Creating new Post");
        wp.dp.addNewPost();
        wp.editPostPage.addNewPost(title, text);
        log.info("New Post created");
    }

    @Test(dependsOnMethods = "create")
    public void publish() throws InterruptedException {
        log.info("Publishing Post");
        wp.editPostPage.publish();
    }

    @Test(dependsOnMethods = "publish")
    public void checkSignOut() {
        log.info("Checking presence in table");
        wp.editPostPage.checkPresence(title);

        LoginSignOutTest.signOutTest();
    }
    public static String getTitle() {
        return title;
    }
}

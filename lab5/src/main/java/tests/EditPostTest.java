package tests;

import core.BaseTest;
import core.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditPostTest extends BaseTest {
    private static String newTitle = Helpers.getRandomTitle(5);
    private static String newText = Helpers.getRandomParagraphs(2, 5);
    private static final Logger log = LogManager.getLogger(EditPostTest.class);
    private boolean isPresent = false;

    @Test
    public void login() {
        LoginSignOutTest.loginTest();
    }

    @Test(dependsOnMethods = "login")
    public void checkIfPostPresent() {
        wp.dp.postBtn.click();
        if (wp.editPostPage.getNameIfExists() != null) {
            isPresent = true;
            log.info("There is a page to work on, called: " + wp.editPostPage.getNameIfExists());
        } else log.info("No pages.");
    }

    @Test(dependsOnMethods = "checkIfPostPresent")
    public void editPost() throws InterruptedException {
        Assert.assertTrue(isPresent);
        if (wp.editPostPage.editValidatePost(newTitle, newText)) {
            log.info("Validated pre edit");
            wp.previewPage.validateEdit(newTitle, newText);
            log.info("Validated post edit");
        } else {
            log.info("Failing the test");
            Assert.fail();
        }
    }

    @Test(dependsOnMethods = "editPost")
    public void signOut() {
        LoginSignOutTest.signOutTest();
    }
}

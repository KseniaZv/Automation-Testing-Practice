package tests;

import core.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class PostCreateMoveToDraftTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(PostCreateMoveToDraftTest.class);

    @Test
    public void create() {
        CreatePublishCheckNewPostTest.create();
    }

    @Test(dependsOnMethods = "create")
    public void moveToDraft() throws InterruptedException {
        log.info("Saving as a Draft");
        wp.editPostPage.saveDraft();
    }

    @Test(dependsOnMethods = "moveToDraft")
    public void checkDraftPresenceSignOut() {
        log.info("Checking presence of Draft in table");
        wp.editPostPage.checkDraftPresence(CreatePublishCheckNewPostTest.getTitle());
        LoginSignOutTest.signOutTest();
    }
}

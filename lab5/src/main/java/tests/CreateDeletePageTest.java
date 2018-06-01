package tests;

import core.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateDeletePageTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(CreateDeletePageTest.class);
    @Test
    public static void createPublish() throws InterruptedException {
        CreatePublishCheckNewPageTest.create();
        CreatePublishCheckNewPageTest.publish();
    }
    @Test(dependsOnMethods = "createPublish")
    public static void delete() {
        log.info("Checking presence in table");
        wp.editPagePage.checkPresence(CreatePublishCheckNewPageTest.getTitle());
        log.info("Deleting from table");
        wp.editPagePage.deletePage();
        log.info("Checking absence in table");
        Assert.assertTrue(wp.editPagePage.checkAbsence(CreatePublishCheckNewPageTest.getTitle()));
    }
    @Test(dependsOnMethods = "delete")
    public void signOut(){
        LoginSignOutTest.signOutTest();
    }
}

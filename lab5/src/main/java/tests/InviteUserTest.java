package tests;

import core.BaseTest;
import core.Helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InviteUserTest extends BaseTest {
    private static final Logger log = LogManager.getLogger(InviteUserTest.class);
    private List<String> roles = new ArrayList<>();

    @Test
    public void login() {
        LoginSignOutTest.loginTest();
    }

    @Test(dependsOnMethods = "login")
    public void invite() throws InterruptedException {
        roles.add("administrator");
        roles.add("editor");
        roles.add("author");
        roles.add("contributor");
        roles.add("follower");
        wp.dp.userBtn.click();
        wp.dp.addNewUserBtn.click();
        Random ran = new Random();
        int x = ran.nextInt(5);
        String role = roles.get(x);
        String user = Helpers.getRandomEmail();
        log.info("Adding new user: " + user + " as " + role);
        wp.invitationPage.inviteUser(user, role);
        log.info("User added");
    }

    @Test(dependsOnMethods = "invite")
    public void signOut() throws InterruptedException {
        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().back();
        LoginSignOutTest.signOutTest();
    }
}

package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import core.BaseTest;
import core.WPDriver;


public class LoginSignOutTest extends BaseTest {
	private static final Logger log = LogManager.getLogger(LoginSignOutTest.class);
	@Test
	public static void loginTest(){
	    wp = WPDriver.init(driver);
		wp.lp.login(configReader.getUserName(), configReader.getPassword());
		log.info("Logging in");
		wp.dp.pageTitle.equals("Dashboard");
		wp.dp.welcomeMsg.equals("Welcome to WordPress.com!");
		log.info("Checking if logged in");
	}
	@Test(dependsOnMethods = "loginTest")
	public static void signOutTest(){
	    log.info("Signing out");
		wp.dp.signOut(driver);
		log.info("Checking if signed out");
		wp.hp.signIn.checkIfClickable();
	}
}

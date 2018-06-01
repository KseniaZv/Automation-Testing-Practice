package core;

import org.openqa.selenium.WebDriver;

import poms.*;

public class WPDriver {
	
	private static WPDriver wpdriver;
	
	public LoginPage lp;
	public DashboardPage dp;
	public HomePage hp;

	public EditPostPage editPostPage;

	public EditPagePage editPagePage;

    public PreviewPage previewPage;
    public InvitationPage invitationPage;

    private WPDriver(WebDriver driver) {
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		hp = new HomePage(driver);

		editPostPage = new EditPostPage(driver);

		editPagePage = new EditPagePage(driver);

		previewPage = new PreviewPage(driver);
		invitationPage = new InvitationPage(driver);
	}
	
	public static WPDriver init(WebDriver driver) {
		if(wpdriver==null) {
			wpdriver = new WPDriver(driver);
		}
		return wpdriver;
	}
}
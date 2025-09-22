package Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Mytestcases extends mydata {
	WebDriver driver = new EdgeDriver();
	String url = "https://automationteststore.com/";

	@BeforeTest
	public void mysetup() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
	}

	@Test(priority = 1 , enabled=false)
	public void signuptest() throws InterruptedException {
		// هاي بحالة ا انو افوت واختار log in or signup وبعدها اكبس continoue بعدها ادخل
		// بيانات
		/*
		 * String regpage="https://automationteststore.com/index.php?rt=account/login";
		 * driver.navigate().to(regpage); WebElement
		 * contbtn=driver.findElement(By.xpath("//button[@title='Continue']"));
		 * contbtn.click();
		 */

		// في حال اروح مباشرة لصفحة انشاء الحساب url غير
		String regpage = "https://automationteststore.com/index.php?rt=account/create";
		driver.navigate().to(regpage);

		WebElement fieldFN = driver.findElement(By.id("AccountFrm_firstname"));
		WebElement fieldLN = driver.findElement(By.id("AccountFrm_lastname"));
		WebElement fieldEmail = driver.findElement(By.id("AccountFrm_email"));
		WebElement fieldPhone = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement fieldFax = driver.findElement(By.id("AccountFrm_fax"));
		WebElement fieldZipcode = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement fieldCountry = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement fieldState = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement fieldCity = driver.findElement(By.id("AccountFrm_city"));
		WebElement fieldAdress1 = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement fieldloginname = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement fieldPassword = driver.findElement(By.id("AccountFrm_password"));
		WebElement fieldPassconfirm = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement policybtn = driver.findElement(By.id("AccountFrm_agree"));
		WebElement contbtn = driver.findElement(By.cssSelector(".lock-on-click"));

		fieldFN.sendKeys(inputFn);
		fieldLN.sendKeys(inputLN);
		fieldEmail.sendKeys(inputEmail);
		fieldPhone.sendKeys(inputPhonenum);
		fieldZipcode.sendKeys("415848521");
		Select selectedCountry = new Select(fieldCountry);
		selectedCountry.selectByIndex(108);
		Select selectedstate = new Select(fieldState);
		Thread.sleep(3000);

		selectedstate.selectByValue(stateindex + "");
		String state = selectedstate.getFirstSelectedOption().getText();
		// enter value of state to city and adress
		fieldCity.sendKeys(state);
		fieldAdress1.sendKeys(state);
		fieldFax.sendKeys(inputFaxnum);
		fieldloginname.sendKeys(loginNameInput);
		fieldPassword.sendKeys(passinput);
		fieldPassconfirm.sendKeys(passinput);

		if (subscribebtn == 0)
			driver.findElement(By.id("AccountFrm_newsletter1")).click();
		else
			driver.findElement(By.id("AccountFrm_newsletter0")).click();
		policybtn.click();
		contbtn.click();

	}

	@Test(priority = 2 ,enabled =false)
	public void logout() {
		WebElement logoutbtn = driver.findElement(By.linkText("Logoff"));
		logoutbtn.click();
		// String actualoutput=driver.findElement(By.className("maintext")).getText();
		// String expectedresule="ACCOUNT LOGOUT";
		// org.testng.Assert.assertEquals(actualoutput, expectedresule);
		String expectedresule = "You have been logged off your account. It is now safe to leave the computer.";

		boolean actuallogoff = driver.getPageSource().contains(expectedresule);
		Assert.assertEquals(actuallogoff, true);
	}

	@Test(priority = 3, enabled = false)
	public void login() {
		WebElement logintag = driver.findElement(By.linkText("Login or register"));
		logintag.click();
		WebElement fieldloginName = driver.findElement(By.id("loginFrm_loginname"));
		WebElement fieldpassword = driver.findElement(By.id("loginFrm_password"));
		WebElement loginbtn = driver.findElement(By.xpath("//button[@title='Login']"));
		// xpath using selectorhup
		// WebElement
		// loginbtn=driver.findElement(By.xpath("//button[normalize-spae()='Login']"));

		fieldloginName.sendKeys(loginNameInput);
		fieldpassword.sendKeys(passinput);
		loginbtn.click();

		/*
		 * why false get answer from end abdalraheem
		 * 
		 * String expectedresultlogin="Welcome back "+inputFn;
		 * System.out.println(expectedresultlogin);
		 * System.out.println(driver.getPageSource().contains(expectedresultlogin));
		 * System.out.println(driver.getPageSource());
		 * 
		 * boolean actuallogin=driver.getPageSource().contains(expectedresultlogin);
		 * Assert.assertEquals(actuallogin,true);
		 */
	}

	@Test(priority = 4)
	public void addtocart() {
		driver.navigate().to(url);

		WebElement item1 = driver.findElement(By.xpath("(//a[@title='Add to Cart'])[1]"));
		WebElement item2 = driver.findElement(By.xpath("(//a[@title='Add to Cart'])[2]"));
		WebElement item3 = driver.findElement(By.xpath("(//a[@title='Add to Cart'])[10]"));

		item1.click();
		item2.click();
		item3.click();
	
	}
}
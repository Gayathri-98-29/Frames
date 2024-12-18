package testng;



	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;
	import org.openqa.selenium.chromium.ChromiumDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	import java.time.Duration;
	public class Guvilogin {
	
	    WebDriver d;
	    String url = "https://www.guvi.in/";

	    @BeforeTest
	    public void setUp(){
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-notifications");
	        d = new ChromeDriver(options);
	        d.get(url);
	        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	        d.manage().window().maximize();
	    }

	    @AfterTest
	    public void tearDown(){
	        //d.quit();
	    }

	    @Test
	    public void test1() throws InterruptedException {
	        //Clicking signup button
	        d.findElement(By.xpath("//a[@class='nav-link btn btn-primary text-white px-4']")).click();
	        Thread.sleep(2000);
	        //Sending Full Name
	        d.findElement(By.xpath("//input[@class='form-control']")).sendKeys("Yaashu");
	        //Sending Email
	        d.findElement(By.xpath("//input[@id='email']")).sendKeys("Yaashu20006@gmail.com");
	        //Sending Password
	        d.findElement(By.xpath("//input[@id='password']")).sendKeys("Lokki@0412");
	        //Sending Mobile Number
	        d.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("9940584856");
	        //Clicking Signup button
	        d.findElement(By.xpath("//a[@id='signup-btn']")).click();
	        //Current profile
	        WebElement dd = d.findElement(By.xpath("//select[@id='profileDrpDwn']"));
	        Select select = new Select(dd);
	        select.selectByIndex(1);
	        Thread.sleep(2000);
	        //Degree
	        WebElement dd1 = d.findElement(By.xpath("//select[@id='degreeDrpDwn']"));
	        Select select1 = new Select(dd1);
	        select1.selectByIndex(1);
	        Thread.sleep(2000);
	        //Year Of Passed Out
	        d.findElement(By.xpath("//input[@id='year']")).sendKeys("2019");
	        //Submitting Form
	        d.findElement(By.xpath("//a[@id='details-btn']")).click();
	        Thread.sleep(2000);
	        //Getting the Text From the page after SignUp
	        String str = d.findElement(By.tagName("h1")).getText();
	        Assert.assertEquals(str, "Welcome to GUVI!");
	        System.out.println(str);
	        //Get the Current URL
	        String title = d.getTitle();
	        System.out.println("The Title of the page: " + title);
	    }

	        //Login
	        @Test
	        public void test2() throws InterruptedException {
	        d.navigate().to("https://www.guvi.in/");
	        //Clicking Login Button
	        d.findElement(By.xpath("//a[@class='nav-link  text-primary text-center px-4']")).click();
	        Thread.sleep(2000);
	        //Sending Email
	        d.findElement(By.xpath("//input[@id='email']")).sendKeys("lokeshdharan1996@gmail.com");
	        //Sending Password
	        d.findElement(By.xpath("//input[@id='password']")).sendKeys("Lokki@0412");
	        //Clicking the CheckBox
	        d.findElement(By.xpath("//input[@id='logged-in']")).click();
	        //Clicking the Login Button
	        d.findElement(By.xpath("//a[@id='login-btn']")).click();
	        //Getting the Text From the page after Login
	        String str1 = d.findElement(By.xpath("//h1[@class='font-weight-bold mr-auto']")).getText();
	        Assert.assertEquals(str1 , "Online Courses");
	        System.out.println(str1);
	        //Getting the Title of the page
	        String title1 = d.getTitle();
	        System.out.println("The Title of the page: " + title1);



	        }







	}
}

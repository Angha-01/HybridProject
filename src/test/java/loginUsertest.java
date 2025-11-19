import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.PomClass.loginUserpom;
import com.utility.UtilityClass;

public class loginUsertest extends BaseClass{
	@BeforeTest
	public void setup() {
		launchweb();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void loginNewUser() throws IOException  {
		loginUserpom newuser=new loginUserpom();
		
			newuser.scrollpage();
			UtilityClass.takescreenshot("loginUser");
		
		
	}

	
}

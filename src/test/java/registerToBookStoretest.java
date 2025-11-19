import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.BaseClass.BaseClass;
import com.PomClass.registerToBookStorepom;
import com.utility.UtilityClass;

public class registerToBookStoretest extends BaseClass {
	
	
	

	@BeforeTest
	public void setup() throws IOException {
		launchweb();
		 loginUsertest logintest=new  loginUsertest();
		
		logintest.loginNewUser();
	}
	
	@AfterTest
	public void teardown() {
		//driver.close();
	}
	@Test
	public void registernewuser() throws InterruptedException, IOException  {
		
		registerToBookStorepom register=new registerToBookStorepom();
		register.registeruser();
		register.backTologin("angha", "angha12345");

		UtilityClass.takescreenshot("RegisterUser");		//register.backTologin();
		
	}
	
	
}


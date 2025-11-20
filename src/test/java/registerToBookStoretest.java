import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.BaseClass.BaseClass;

public class registerToBookStoretest extends BaseClass {
	
	
	

	@BeforeTest
	public void setup() throws IOException {
		launchweb();
		
	}
	
	@AfterTest
	public void teardown() {
		//driver.close();
	}
	@Test
	public void registernewuser() throws InterruptedException, IOException  {
		 loginUsertest logintest=new  loginUsertest();
			
			logintest.loginNewUser();
		
			
		
	}
	
	
}


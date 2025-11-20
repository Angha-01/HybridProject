import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;
import com.PomClass.elementpagepom;

public class elementpagetext extends BaseClass {
	
	@BeforeClass
	public void setup() throws InterruptedException, IOException {
		launchweb();
		
		
		
	}
	@AfterClass
	public void teardown() {
		driver.close();
	}
	
	@Test
	public void texteletext() throws IOException, InterruptedException {
//		loginUsertest logintest=new  loginUsertest();
//		logintest.loginNewUser();
		registerToBookStoretest registerbook=new registerToBookStoretest();
		registerbook.registernewuser();
		elementpagepom elepage=new elementpagepom();
		elepage.textelement();
		
		elepage.checkboxelement();
		
	}
	

}

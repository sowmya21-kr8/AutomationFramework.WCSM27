package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgPracticeTest {
	@Test
	public void createUserTest() {
		Assert.fail();
		System.out.println("user created");
	}

	//@Test(enabled=false)
	//public void modifyUserTest() {
		//System.out.println("user created");
	//}
	@Test(dependsOnMethods="createUserTest")
	public void deleteUserTest() {
		System.out.println("user created");
	}

}

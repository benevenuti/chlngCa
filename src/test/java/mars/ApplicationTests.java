package mars;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mars.business.Navigator;
import mars.model.Region;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Rule
	public TestName name= new TestName();
		
	private Region testRegion = new Region(0, 0, 4, 4);

	@Test
	public void contextLoads() {
	
	}
	
	@Test
	public void testRightRotate() {
		System.out.println(name.getMethodName());
		assertEquals(Navigator.navigate("MMRMMRMM", testRegion).toString(), "(2, 0, S)");	
	}
	
	@Test
	public void testLeftRotate() {
		System.out.println(name.getMethodName());
		assertEquals(Navigator.navigate("MML", testRegion).toString(), "(0, 2, W)");
	}
	
	@Test
	public void testLeftRotateTwice() {
		System.out.println(name.getMethodName());
		assertEquals(Navigator.navigate("MML", testRegion).toString(), "(0, 2, W)");
		assertEquals(Navigator.navigate("MML", testRegion).toString(), "(0, 2, W)");
	}
	
	@Test
	public void testClockwise() {
		System.out.println(name.getMethodName());
		assertEquals(Navigator.navigate("MMMMRMMMMRMMMMRMMMMR", testRegion).toString(), "(0, 0, N)");
	}
	
	@Test
	public void testCounterClockwise() {
		System.out.println(name.getMethodName());
		assertEquals(Navigator.navigate("RMMMMLMMMMLMMMMLMMMMLL", testRegion).toString(), "(0, 0, N)");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidCommand() {
		System.out.println(name.getMethodName());
		Navigator.navigate("AAA", testRegion);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPosition() {
		System.out.println(name.getMethodName());
		Navigator.navigate("MMMMMMMMMMMMMMMMMMMMMMMM", testRegion);
	}

}

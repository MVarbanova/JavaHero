package game.tests;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {
	
	String message = "Hello World";
	game.tests.MessageUtil msgUtil = new game.tests.MessageUtil(message);
	
	@Test
	public void testPrintMsg()
	{
		assertEquals(message,msgUtil.printMessage());
	}
}

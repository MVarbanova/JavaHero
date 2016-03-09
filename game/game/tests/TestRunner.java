package game.tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(TestJunit.class);
		
		for (Failure fail: result.getFailures())
		{
			System.out.println(fail.getMessage() + fail.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}

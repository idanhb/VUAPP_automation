package testCases;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
public class TestRun
{
	public static void main(String[] args) 
	{
		JUnitCore.main("testCases.Sanity_Login"); 
	}
}



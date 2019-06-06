package cleartrip.testcase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import cleartrip.util.BaseTest;

public class TestNGListenerClass extends BaseTest implements ITestListener {

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("test :"+arg0.getName()+" FAILED");
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("test :"+arg0.getName()+" SKIPPED");
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("test :"+arg0.getName()+" STARTED");
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("test :"+arg0.getName()+" PASSED");
		
	}

}

package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class mylistener implements ITestListener {
	public void onStart(ITestContext context) {
	   
		System.out.println("test started this is on start......");
		
		
		
	  }
	public void onTestStart(ITestResult result) {
	   System.out.println("This is on start method .......   ");
	  }
	public void onTestSuccess(ITestResult result) {
		System.out.println("TEst sucesss...");
		}
	  public void onTestFailure(ITestResult result) {
		   System.out.println("twest failed ......");
		  }
	 public void onTestSkipped(ITestResult result) {
		    System.out.println("TYEst skipped ---=--");
		  }
	public  void onFinish(ITestContext context) {
		    System.out.println("test finished with sucess..... ");
		  }

}

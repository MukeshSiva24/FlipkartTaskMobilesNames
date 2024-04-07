package FlipkartTestNGStep;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnal implements IRetryAnalyzer{
	
	int a=2;
	int b=3;

	@Override
	public boolean retry(ITestResult result) {
		if(a<b) {
			a++;
			System.out.print(result.getMethod());
			return true;
		}
		return false;
	}
	
	
	

}

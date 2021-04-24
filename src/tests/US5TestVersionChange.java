package tests;


import java.io.IOException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.VersionStrategyStable;
import controller.VersionStrategyVolatile;
import model.DocumentManager;
import model.VersionStrategyFactory;
import model.VersionsManager;
import model.VersionsStrategy;
import view.MainWindow;

public class US5TestVersionChange {

	private static MainWindow window;
	private static DocumentManager doc;
	private static VersionsManager managerV;
	
	@BeforeClass
	public static void init() {
		window = new MainWindow(null);
		managerV = new VersionsManager();
		try {
			doc = new DocumentManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testVtoS() {
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Volatile"));
		VersionsStrategy strategyBefore = VersionsManager.getStrategy(); 
		VersionStrategyStable stable = new VersionStrategyStable();
		stable.handle();
		VersionsStrategy strategyAfter = VersionsManager.getStrategy(); 
		
		if(strategyBefore.equals(strategyAfter)) {
			Assert.fail();
		}
	}
	
	@Test
	public void testStoV() {
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Stable"));
		VersionsStrategy strategyBefore = VersionsManager.getStrategy(); 
		VersionStrategyVolatile stable = new VersionStrategyVolatile();
		stable.handle();
		VersionsStrategy strategyAfter = VersionsManager.getStrategy(); 
		if(strategyBefore.equals(strategyAfter)) {
			Assert.fail();
		}
	}

}

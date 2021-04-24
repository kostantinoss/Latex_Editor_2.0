package tests;



import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import controller.*;
import model.DocumentManager;
import model.VersionStrategyFactory;
import model.VersionsManager;
import view.MainWindow;

public class US4TestVersionKeeping {
	
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
	public void testVolatile1() {
		
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Volatile"));
		ReportEvent report = new ReportEvent();
		report.handle("Report", "Author1", "Date1", "Copyright1", "Version1");
		String before = DocumentManager.getOnDisplayDocument().getContents();
		NewVersionEvent Version = new NewVersionEvent();
		Version.handle();
		MainWindow.display(before + "Hello");
		String after = DocumentManager.getOnDisplayDocument().getContents();		
		
		if(after.equals(VersionsManager.getPreviousVersion().getContents())) {
			Assert.fail();
		}	
	}	
	
	@Test
	public void testVolatile2() {
		
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Volatile"));
		ReportEvent report = new ReportEvent();
		report.handle("Report", "Author1", "Date1", "Copyright1", "Version1");
		String before = DocumentManager.getOnDisplayDocument().getContents();
		NewVersionEvent Version = new NewVersionEvent();
		Version.handle();
		Commands commands = new Commands();
		commands.choosenCommand("Add chapter");
		String after = MainWindow.getTextOnDisplay();
		
		if(after.equals(VersionsManager.getPreviousVersion().getContents())) {
			Assert.fail();
		}	
	}
	
	@Test
	public void testStable1() {
		
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Stable"));
		ReportEvent report = new ReportEvent();
		report.handle("Report", "Author1", "Date1", "Copyright1", "Version1");
		String before = DocumentManager.getOnDisplayDocument().getContents();
		NewVersionEvent Version = new NewVersionEvent();
		Version.handle();
		MainWindow.display(before + "Hello");
		String after = DocumentManager.getOnDisplayDocument().getContents();		
		
		if(after.equals(VersionsManager.getPreviousVersion().getContents())) {
			Assert.fail();
		}	
	}
	
	@Test
	public void testStable2() {
		
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Stable"));
		ReportEvent report = new ReportEvent();
		report.handle("Report", "Author1", "Date1", "Copyright1", "Version1");
		String before = DocumentManager.getOnDisplayDocument().getContents();
		NewVersionEvent Version = new NewVersionEvent();
		Version.handle();
		Commands commands = new Commands();
		commands.choosenCommand("Add chapter");
		String after = MainWindow.getTextOnDisplay();
		
		if(after.equals(VersionsManager.getPreviousVersion().getContents())) {
			Assert.fail();
		}	
	}

}

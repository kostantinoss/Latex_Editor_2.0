package tests;



import java.io.IOException;


import controller.NewVersionEvent;
import controller.ReportEvent;
import controller.RollbackEvent;
import controller.VersionControllEnabled;
import model.DocumentManager;
import model.VersionsManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import view.MainWindow;

public class US7TestRollback {

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
	public void test() {
		ReportEvent report = new ReportEvent();
		report.handle("Report", "Author1", "Date1", "Copyright1", "Version1");
		String before = DocumentManager.getOnDisplayDocument().getContents();
		
		VersionControllEnabled enableVersion = new VersionControllEnabled();
		enableVersion.handle();
		
		
		NewVersionEvent Version = new NewVersionEvent();
		Version.handle();
		MainWindow.display(before + "Hello");
		
		RollbackEvent rollback = new RollbackEvent();
		rollback.handle();
		
		String after = DocumentManager.getOnDisplayDocument().getContents();		
		
		Assert.assertEquals(before, after);
		
	}

}

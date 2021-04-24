package tests;

import java.io.File;
import java.io.IOException;

import controller.LoadEvent;
import controller.NewVersionEvent;
import controller.ReportEvent;
import controller.SaveEvent;
import controller.VersionControllEnabled;
import model.DocumentManager;
import model.VersionsManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import view.MainWindow;

public class US9TestLoad {

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
		
		VersionControllEnabled enableVersion = new VersionControllEnabled();
		enableVersion.handle();
		
		NewVersionEvent Version = new NewVersionEvent();
		Version.handle();
		
		String before = DocumentManager.getOnDisplayDocument().getContents();
		String path = System.getProperty("user.home")
				+ File.separator + "Documents" + File.separator + "demo.tex" ;
	
		SaveEvent save = new SaveEvent ();
		save.handle(path, before);	
		
		LoadEvent load = new LoadEvent ();
		load.handle(path);
		String after = DocumentManager.getOnDisplayDocument().getContents();
		
		Assert.assertEquals(before + '\n', after);
		
	}
}

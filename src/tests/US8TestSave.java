package tests;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.NewVersionEvent;
import controller.ReportEvent;
import controller.SaveEvent;
import controller.VersionControllEnabled;
import model.DocumentManager;
import model.VersionsManager;
import view.MainWindow;

public class US8TestSave {
	
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
		
		String after = "";
		FileReader fr;
		try {
			fr = new FileReader (path);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				if (line.startsWith("%")) {
					continue;	
				} else {
					after += line + '\n' ;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(before + '\n', after);
		
	}

}

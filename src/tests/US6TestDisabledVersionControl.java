package tests;


import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import controller.NewVersionEvent;
import controller.ReportEvent;
import controller.VersionControllDisabled;
import model.DocumentManager;
import model.VersionStrategyFactory;
import model.VersionsManager;
import view.MainWindow;

public class US6TestDisabledVersionControl {

	@Test
	public void test() {
		try {
			DocumentManager doc = new DocumentManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainWindow window = new MainWindow(null);
		VersionsManager managerV = new VersionsManager();
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Volatile"));
		
		int sizebefore = VersionsManager.getStrategy().getEntireHistory().size();
		VersionControllDisabled disable = new VersionControllDisabled();
		disable.handle();
		
		ReportEvent report = new ReportEvent();
		report.handle("Report", "Author1", "Date1", "Copyright1", "Version1");
		
		NewVersionEvent version = new NewVersionEvent();
		version.handle();
		int sizeafter = VersionsManager.getStrategy().getEntireHistory().size();
		
		Assert.assertFalse(VersionsManager.isEnable());
		Assert.assertEquals(sizebefore,sizeafter);
		
	}

}

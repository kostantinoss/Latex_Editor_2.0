package controller;

import model.DocumentManager;
import model.VersionsManager;

public class NewVersionEvent implements Event {

	@Override
	public void handle(String... args) {
		//System.out.println(DocumentManager.getOnDisplayDocument().getContents());
		if (VersionsManager.isEnable()) {
			VersionsManager.setCurrentVersion(DocumentManager.getOnDisplayDocument());
		}
	}
}

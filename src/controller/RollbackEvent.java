package controller;

import model.VersionsManager;

public class RollbackEvent implements Event {
	
	@Override
	public void handle(String... args) {
		VersionsManager.rollbackToPreviousVersion();
		
	}

}

package controller;

import model.VersionStrategyFactory;
import model.VersionsManager;

public class VersionControllEnabled implements Event {
	
	public VersionControllEnabled() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(String... args) {
		VersionsManager.enable();
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Volatile"));
		
	}

}

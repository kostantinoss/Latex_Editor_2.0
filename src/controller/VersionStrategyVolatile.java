package controller;

import model.VersionStrategyFactory;
import model.VersionsManager;
import model.VersionsStrategy;

public class VersionStrategyVolatile implements Event {

	public VersionStrategyVolatile() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(String... args) {
		VersionsStrategy current = VersionsManager.getStrategy();
		
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Volatile"));
		
		VersionsManager.getStrategy().setEntireHistory(current.getEntireHistory());
		
		
	}


}

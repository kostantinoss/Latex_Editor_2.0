package controller;

import model.VersionStrategyFactory;
import model.VersionsManager;
import model.VersionsStrategy;

public class VersionStrategyStable implements Event {

	@Override
	public void handle(String... args) {
		VersionsStrategy current = VersionsManager.getStrategy();
		
		VersionsManager.setStrategy(
				new VersionStrategyFactory().createStrategy("Stable"));
		
		VersionsManager.getStrategy().setEntireHistory(current.getEntireHistory());
	}

}

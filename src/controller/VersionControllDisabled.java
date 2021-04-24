package controller;

import model.VersionsManager;

public class VersionControllDisabled implements Event {

	@Override
	public void handle(String... args) {
		VersionsManager.disable();
	}

}

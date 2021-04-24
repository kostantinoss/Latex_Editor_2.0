package controller;

import java.io.IOException;

import model.DocumentManager;
import model.VersionsManager;
import view.MainWindow;

public class Init {

	public static void main(String[] args) throws IOException {
		VersionsManager versionsManager = new VersionsManager();
		DocumentManager model = new DocumentManager();
		EventHandler listener = new EventHandler();
		MainWindow window = new MainWindow(listener);
	}
}

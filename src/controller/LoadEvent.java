package controller;

import java.io.IOException;

import model.FileManager;
import view.MainWindow;

public class LoadEvent implements Event{

	private FileManager manager = new FileManager();
	
	@Override
	public void handle(String ...args) {
		try {
			MainWindow.display(manager.load(args[0]));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

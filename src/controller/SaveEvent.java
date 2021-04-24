package controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import model.FileManager;

public class SaveEvent implements Event{
	
	private FileManager manager = new FileManager();
	
	@Override
	public void handle(String ...args) {
		try {
			manager.save(args[0], args[1]);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

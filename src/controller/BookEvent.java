package controller;


import model.Document;
import model.DocumentManager;
import view.MainWindow;

public class BookEvent implements Event {
	
	@Override
	public void handle(String ...args) {
		Document doc = DocumentManager.getDocument(args[0], args[1], args[2], args[3], args[4]);
		MainWindow.display(doc.getContents());
		
	}

}

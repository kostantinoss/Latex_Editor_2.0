package tests;


import java.io.IOException;


import controller.BookEvent;
import model.Document;
import model.DocumentManager;
import org.junit.Assert;
import org.junit.Test;
import view.MainWindow;

public class US2TestEditing {

	@Test
	public void test() {
		try {
			DocumentManager manager = new DocumentManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainWindow window = new MainWindow(null);
		BookEvent book = new BookEvent();
		book.handle("Book", "Author1", "Date1", "Copyright1", "Version1");
		String contentsBefore = DocumentManager.getOnDisplayDocument().getContents();
		MainWindow.display("Hello");
		Document doc = DocumentManager.getOnDisplayDocument();
		doc.setContents(MainWindow.getTextOnDisplay());
		String contentsAfter = DocumentManager.getOnDisplayDocument().getContents();
		
		if(contentsAfter.equals(contentsBefore)) {
			Assert.fail();
		}
	}

}

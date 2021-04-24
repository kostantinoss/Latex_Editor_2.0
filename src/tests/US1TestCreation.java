package tests;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;

import controller.ArticleEvent;
import controller.BookEvent;
import controller.EmptyEvent;
import controller.LetterEvent;
import controller.ReportEvent;
import model.DocumentManager;
import view.MainWindow;

import static junit.framework.Assert.assertEquals;

public class US1TestCreation {

	@Test
	public void testHandle1() {
		try {
			DocumentManager manager = new DocumentManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainWindow window = new MainWindow(null);
		ReportEvent report = new ReportEvent();
		report.handle("Report", "Author1", "Date1", "Copyright1", "Version1");
		
		assertEquals(DocumentManager.getTemplateFromMap("Report").getContents(),
					DocumentManager.getOnDisplayDocument().getContents());
	}
	
	@Test
	public void testHandle2() {
		try {
			DocumentManager manager = new DocumentManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainWindow window = new MainWindow(null);
		LetterEvent letter = new LetterEvent();
		letter.handle("Letter", "Author1", "Date1", "Copyright1", "Version1");
		
		assertEquals(DocumentManager.getTemplateFromMap("Letter").getContents(),
					DocumentManager.getOnDisplayDocument().getContents());
	}
	
	@Test
	public void testHandle3() {
		try {
			DocumentManager manager = new DocumentManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainWindow window = new MainWindow(null);
		BookEvent book = new BookEvent();
		book.handle("Book", "Author1", "Date1", "Copyright1", "Version1");
		
		assertEquals(DocumentManager.getTemplateFromMap("Book").getContents(),
					DocumentManager.getOnDisplayDocument().getContents());
	}
	
	@Test
	public void testHandle4() {
		try {
			DocumentManager manager = new DocumentManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainWindow window = new MainWindow(null);
		ArticleEvent article = new ArticleEvent();
		article.handle("Article", "Author1", "Date1", "Copyright1", "Version1");
		
		assertEquals(DocumentManager.getTemplateFromMap("Article").getContents(),
					DocumentManager.getOnDisplayDocument().getContents());
	}
	
	@Test
	public void testHandle5() {
		try {
			DocumentManager manager = new DocumentManager();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MainWindow window = new MainWindow(null);
		EmptyEvent empty = new EmptyEvent();
		empty.handle("Empty", "Author1", "Date1", "Copyright1", "Version1");
		
		assertEquals(DocumentManager.getTemplateFromMap("Empty").getContents(),
					DocumentManager.getOnDisplayDocument().getContents());
	}
	
}

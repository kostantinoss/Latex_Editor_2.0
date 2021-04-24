package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import view.MainWindow;

public class DocumentManager {
	
	private static HashMap <String, Document> map = new HashMap <String, Document>();
	private static Document onDisplay;
	
	public DocumentManager() throws IOException {
		loadTemplates();
	}
	
	private void loadTemplates() throws IOException {
		
		Document empty = new Document();
		fillContent(getClass().getClassLoader().getResource("empty-template.tex").getPath() , empty);
		map.put("Empty", empty);
		
		Document report = new Document();
		fillContent(getClass().getClassLoader().getResource("report-template.tex").getPath(), report);
		map.put("Report", report);
		
		Document letter = new Document();
		fillContent(getClass().getClassLoader().getResource("letter-template.tex").getPath(), letter);
		map.put("Letter", letter);
		
		Document article = new Document();
		fillContent(getClass().getClassLoader().getResource("article-template.tex").getPath(), article);
		map.put("Article", article);
		
		Document book  = new Document();
		fillContent(getClass().getClassLoader().getResource("book-template.tex").getPath(), book);
		map.put("Book", book);
		
	}
	
	public static Document getDocument(String ID, String author, String date, String copyright,String versionID) {
		Document document = map.get(ID);
		document.setAuthor(author);
		document.setDate(date);
		document.setCopyright(copyright);
		document.setVersionID(versionID);
		onDisplay = document;
		
		return document.clone();
		
	}
	/*
	public static Document updateContent(Document doc, String author, String date){
		
		String content = doc.getContents();
		System.out.println("koukou");
		content.replace("\\author{Author1 \\and Author2 \\and ...}",  "\\author{" + author + "}");
		content.replace("\\date{\\today}", "\\date{" + date + "}");
		content.replace("\\signature{Sender's Name}", "\\signature{" + author + "}");
		
		Document neo = new Document();
		neo.setContents(content);
		
		return neo;
	} */
	
	private void fillContent(String path, Document doc) throws IOException {
		
		FileReader fr;
		
		try {
			fr = new FileReader (path);
			BufferedReader br = new BufferedReader(fr);
			
			String buffer = "";
			String line;
			while ((line = br.readLine()) != null) {
				buffer += line + '\n';
			}
			
			doc.setContents(buffer);
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Document getTemplateFromMap(String key) {
		return map.get(key);
	}
	
	public static Document getOnDisplayDocument() {
		onDisplay.setContents(MainWindow.getTextOnDisplay());
		return onDisplay;
	}
	
	public static void setOnDisplayDocument(Document newDocument) {
		onDisplay = newDocument;
	}

}

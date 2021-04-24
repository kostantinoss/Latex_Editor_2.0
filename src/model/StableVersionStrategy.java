package model;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StableVersionStrategy implements VersionsStrategy {

	private ArrayList<Document> versionHistory = new ArrayList<Document>() ;
	//private String path = "/home/LatexVersions";
	
	public void SetUpFile(String filename, Document newDocument) {
		String path = System.getProperty("user.home") + File.separator + "Documents";
		path += File.separator + "editorVersions";
		File customDir = new File(path);	
		try {		
			File stableDoc = new File(customDir.getPath() + File.separator + filename);
			stableDoc.createNewFile();
			PrintWriter writer = new PrintWriter(stableDoc.getPath(), "UTF-8");
			writer.println(newDocument.getContents());
			writer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void putVersion(Document newDocument) {
		versionHistory.add(newDocument.clone()) ;
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		SetUpFile(dateFormat.format(date) + ".tex", newDocument);	
	}

	@Override
	public Document getVersion() {
		if (versionHistory.size() == 0) {
			return null;
		}
		Document temp = versionHistory.get(versionHistory.size() -1) ;		
		versionHistory.remove(versionHistory.size() - 1);
	
		return temp;
	}

	@Override
	public void setEntireHistory(ArrayList<Document> versionList) {
		this.versionHistory = versionList;
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		for(Document d : versionHistory) {
			Date date = new Date();
			SetUpFile(dateFormat.format(date)+ ".tex", d);
		}
	}

	@Override
	public ArrayList<Document> getEntireHistory() {
		return this.versionHistory ;
	}

	@Override
	public void removeVersion() {
		this.versionHistory.remove(this.versionHistory.size() -1) ;

	}

}

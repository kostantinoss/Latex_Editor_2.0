package model;

import java.util.ArrayList;

public class VolatileVersionStrategy implements VersionsStrategy {
	
	private ArrayList<Document> versionHistory;
	
	public VolatileVersionStrategy() {
		this.versionHistory = new ArrayList<Document>() ;
	}
	
	@Override
	public void putVersion(Document newDocument) {
		versionHistory.add(newDocument.clone()) ;		
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

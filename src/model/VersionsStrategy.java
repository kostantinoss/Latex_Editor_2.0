package model;

import java.util.ArrayList;

public interface VersionsStrategy {
	void putVersion(Document document);
	Document getVersion();
	void setEntireHistory(ArrayList<Document> versionList);
	ArrayList<Document> getEntireHistory();
	void removeVersion();
	
}

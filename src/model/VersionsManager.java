package model;

import view.MainWindow;

public class VersionsManager {
	
	private static boolean enabled ;
	private static Document currentDocument ;
	private static VersionsStrategy strategy;
	
	public VersionsManager() {
		enabled = false;
	}
	
	public static boolean isEnable() {
		if (enabled == true) {
			return true;
		}else {
			return false;
		}
	}
	
	public static void enable() {
		enabled = true;
	}
	
	public static void disable() {
		enabled = false;	
	}
	
	public static void setStrategy(VersionsStrategy newStrategy) {
		strategy = newStrategy ;		
	}
	
	public static void setCurrentVersion(Document newDocument) {
		currentDocument = newDocument;
		strategy.putVersion(newDocument);
		//System.out.println(strategy);
	}
	
	public static Document getPreviousVersion() {
		return strategy.getVersion() ;
	}
	
	public static void rollbackToPreviousVersion(){
		currentDocument = strategy.getVersion();
		if (currentDocument != null) {
			DocumentManager.setOnDisplayDocument(currentDocument);
			MainWindow.display(currentDocument.getContents());
		}
	}
	
	public static VersionsStrategy getStrategy() {
		return strategy;
	}
}

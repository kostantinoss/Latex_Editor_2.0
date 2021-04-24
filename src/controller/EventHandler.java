package controller;

import java.util.ArrayList;
import java.util.HashMap;

public class EventHandler {
	
	private HashMap<String, Event> ActionHandlersMap;
	private ArrayList<String> commands;
		
	public EventHandler() {
		ActionHandlersMap 	= new HashMap<String, Event>();
		
		EventsFactory factory = new EventsFactory();
		initCommands();
		
		for (String i: commands) {
			ActionHandlersMap.put(i, factory.createCommand(i));
		}					
	}
	
	public void enact(String key, String Author, String Date, String Copyright, String VersionID) {
		//String keyword = key;
		Event event  = ActionHandlersMap.get(key);
		event.handle(key, Author, Date, Copyright, VersionID);
	}
	
	public void enact(String key, String path, String text) {
		//String keyword = key;
		Event event  = ActionHandlersMap.get(key);
		event.handle(path, text);
	}
	
	public void enact(String key) {
		//String keyword = key;
		Event event  = ActionHandlersMap.get(key);
		event.handle();
	}
	
	private void initCommands() {
		this.commands = new ArrayList<String>();
		commands.add("Report");
		commands.add("Letter");
		commands.add("Book");
		commands.add("Article");
		commands.add("Empty");
		commands.add("Enable");
		commands.add("Disable");
		commands.add("Stable");
		commands.add("Volatile");
		commands.add("Load");
		commands.add("Save");
		commands.add("newVersion");
		commands.add("Rollback");
	}

}

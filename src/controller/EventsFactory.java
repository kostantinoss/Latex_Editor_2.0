package controller;

public class EventsFactory {
	
	public Event createCommand(String type) {
		
		if (type.equals("Report")) {
			return new ReportEvent();
		} else if (type.equals("Letter")) {
			return new LetterEvent();
		} else if (type.equals("Book")) {
			return new BookEvent();
		} else if (type.equals("Article")) {
			return new ArticleEvent();
		} else if (type.equals("Empty")) {
			return new EmptyEvent();
		} else if (type.equals("Save")) {
			return new SaveEvent();
		} else if (type.equals("Load")) {
			return new LoadEvent();
		} else if (type.equals("Enable")) {
			return new VersionControllEnabled();
		} else if (type.equals("Disable")) {
			return new VersionControllDisabled();
		} else if (type.equals("Stable")) {
			return new VersionStrategyStable();
		} else if (type.equals("Volatile")) {
			 return new VersionStrategyVolatile();
		} else if (type.equals("newVersion")) {
			 return new NewVersionEvent();
		} else if (type.equals("Rollback")) {
			 return new RollbackEvent();
		}
		
		return null;
		
	}
}

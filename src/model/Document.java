package model;

public class Document {
	private String author;
	private String date;
	private String copyright;
	private String versionID;
	private String contents;
	
	public Document() {
		//default constructor
	}
	
	public Document(String author, String date, String copyright,String versionID, String contents) {
		this.author = author;
		this.date = date;
		this.copyright = copyright;
		this.versionID = versionID;
		this.contents = contents;
		
	}
	
	public void setContents(String data) {
		this.contents = data;
		
	}
	
	public String getAuthor() {
		return this.author;
	
	}
	
	public String getCopyright() {
		return this.copyright;
		
	}
	
	public String getVersion() {
		return this.versionID;
		
	}
	
	public String getDate() {
		return this.date;
		
	}
	
	public String getContents() {
		return this.contents;
		
	}
	
	public void save() {
		
	}
	
	public Document clone() {
		Document newDoc = new Document(this.author, this.date, this.copyright, this.versionID, this.contents);
		return newDoc;
		
	}

	public void setAuthor(String author2) {
		this.author = author2;
		
	}

	public void setDate(String date2) {
		this.date = date2;
		
	}

	public void setCopyright(String copyright2) {
		this.copyright = copyright2;
		
	}

	public void setVersionID(String versionID2) {
		this.versionID = versionID2;
		
	}

}

package tests;


import controller.Commands;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import view.MainWindow;

public class US3TestAddLatexCommand {
	
	private static MainWindow window;
	private static Commands commands;
	
	@BeforeClass
	public static void init() {
		window = new MainWindow(null);
		commands = new Commands();
	}
	
	@Test
	public void testChapter() {
		String before = MainWindow.getTextOnDisplay();
		before += "\n\\chapter{...}";
		commands.choosenCommand("Add chapter");
		String after = MainWindow.getTextOnDisplay();
		
		Assert.assertEquals(before, after);
		
	}
	
	@Test
	public void testSection() {
		String before = MainWindow.getTextOnDisplay();
		before += "\n\\section{}";
		commands.choosenCommand("Add section");
		String after = MainWindow.getTextOnDisplay();
		
		Assert.assertEquals(before, after);
		
	}
	
	@Test
	public void testSubSection() {
		String before = MainWindow.getTextOnDisplay();
		before += "\n\\subsection{}";
		commands.choosenCommand("Add subsection");
		String after = MainWindow.getTextOnDisplay();
		
		Assert.assertEquals(before, after);
		
	}
	
	@Test
	public void testSubSubSection() {
		String before = MainWindow.getTextOnDisplay();
		before +=  "\n\\subsubsection{}";
		commands.choosenCommand("Add subsubsection");
		String after = MainWindow.getTextOnDisplay();
		
		Assert.assertEquals(before, after);
		
	}
	
	@Test
	public void testEnumerationList() {
		String before = MainWindow.getTextOnDisplay();
		before += "\n\\begin{enumerate}\n"  + 
					"\\item ...\n" + 
					"\\item ...\n" + 
					"\\end{enumerate}";
		commands.choosenCommand("Add enumeration list");
		String after = MainWindow.getTextOnDisplay();

		Assert.assertEquals(before, after);
		
	}
	
	@Test
	public void testItemize() {
		String before = MainWindow.getTextOnDisplay();
		before +=  "\n\\begin{itemize} " +
					"\\item ...\n" + 
					"\\item ...\n" + 
					"\\end{itemize}";
		commands.choosenCommand("Add itemize");
		String after = MainWindow.getTextOnDisplay();

		Assert.assertEquals(before, after);
		
	}
	
	@Test
	public void testTable() {
		String before = MainWindow.getTextOnDisplay();
		before +=  "\n\\begin{table}\n" + 
					"\\caption{....}\\label{...}\n" + 
					"\\begin{tabular}{|c|c|c|}\n" + 
					"\\hline\n" + 
					"... &...&...\\\\\n" + 
					"... &...&...\\\\\n" + 
					"... &...&...\\\\\n" + 
					"\\hline\n" + 
					"\\end{tabular}\n" + 
					"\\end{table";
		commands.choosenCommand("Add a table");
		String after = MainWindow.getTextOnDisplay();

		Assert.assertEquals(before, after);
		
	}
	
	@Test
	public void testFigure() {
		String before = MainWindow.getTextOnDisplay();
		before +=  "\n\\begin{figure}\n" + 
					"\\includegraphics[width=...,height=...]{...}\n" + 
					"\\caption{....}\\label{...}\n" + 
					"\\end{figure}";
		commands.choosenCommand("Add figure");
		String after = MainWindow.getTextOnDisplay();

		Assert.assertEquals(before, after);
		
	}
}

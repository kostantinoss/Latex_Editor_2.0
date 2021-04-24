package controller;

import java.util.HashMap;

import view.MainWindow;

public class Commands {
	private HashMap<String,String> command = new HashMap<String,String>() ;
	
	public Commands () {
		this.command.put("Add chapter", "\n\\chapter{...}");
		this.command.put("Add section","\n\\section{}");
		this.command.put("Add subsection", "\n\\subsection{}");
		this.command.put("Add subsubsection", "\n\\subsubsection{}");
		this.command.put("Add enumeration list", "\n\\begin{enumerate}\n"  + 
												"\\item ...\n" + 
												"\\item ...\n" + 
												"\\end{enumerate}");
		this.command.put("Add itemize", "\n\\begin{itemize} " +
										"\\item ...\n" + 
										"\\item ...\n" + 
										"\\end{itemize}");
		this.command.put("Add a table", "\n\\begin{table}\n" + 
										"\\caption{....}\\label{...}\n" + 
										"\\begin{tabular}{|c|c|c|}\n" + 
										"\\hline\n" + 
										"... &...&...\\\\\n" + 
										"... &...&...\\\\\n" + 
										"... &...&...\\\\\n" + 
										"\\hline\n" + 
										"\\end{tabular}\n" + 
										"\\end{table");
		this.command.put("Add figure", "\n\\begin{figure}\n" + 
										"\\includegraphics[width=...,height=...]{...}\n" + 
										"\\caption{....}\\label{...}\n" + 
										"\\end{figure}");
	}
	
	public void choosenCommand(String key) {
		MainWindow.insertText(command.get(key));
			
	}
		
}

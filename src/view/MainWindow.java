package view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.JCheckBoxMenuItem;

import controller.Commands;
import controller.EventHandler;
import java.awt.Choice;
import javax.swing.JButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MainWindow {

	private JFrame frmLatexetodor;
	private static JEditorPane editorPane;
	private EventHandler EventsListener;
	private Commands command = new Commands();
	
	public MainWindow(EventHandler EventsListener) {
		this.EventsListener = EventsListener;
		initialize();
		frmLatexetodor.setVisible(true);
	}

	private void initialize() {
		frmLatexetodor = new JFrame();
		frmLatexetodor.setTitle("LateXeditor");
		frmLatexetodor.setResizable(false);
		frmLatexetodor.setBounds(100, 100, 700, 500);
		frmLatexetodor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLatexetodor.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 700, 21);
		frmLatexetodor.getContentPane().add(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		JMenu NewMenu = new JMenu("New");
		FileMenu.add(NewMenu);
		
		JMenu mnLatexCommands = new JMenu("LateX commands");
		mnLatexCommands.setEnabled(false);
		menuBar.add(mnLatexCommands);
		
		JMenuItem mntmAddChapter = new JMenuItem("Add chapter");
		mntmAddChapter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				command.choosenCommand("Add chapter");
			}
		});
		mnLatexCommands.add(mntmAddChapter);
		
		JMenuItem mntmAddSection = new JMenuItem("Add section");
		mntmAddChapter.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				command.choosenCommand("Add section");
			}
		});
		mnLatexCommands.add(mntmAddSection);
		
		JMenuItem mntmAddSubsection = new JMenuItem("Add subsection");
		mntmAddSubsection.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				command.choosenCommand("Add subsection");
			}
		});
		mnLatexCommands.add(mntmAddSubsection);
		
		JMenuItem mntmAddEnumerationList = new JMenuItem("Add enumeration list");
		mntmAddEnumerationList.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				command.choosenCommand("Add enumeration list");
			}
		});
		mnLatexCommands.add(mntmAddEnumerationList);
		
			JMenuItem mntmAddTable = new JMenuItem("Add a table");
			mntmAddTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					command.choosenCommand("Add a table");
				}
			});
			mnLatexCommands.add(mntmAddTable);
			
			JMenuItem mntmAddFigure = new JMenuItem("Add figure");
			mntmAddFigure.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					command.choosenCommand("Add figure");
				}
			});
			mnLatexCommands.add(mntmAddFigure);
		
		JMenu menuVersionTracking = new JMenu("Version Tracking");
		menuBar.add(menuVersionTracking);
		
		JMenu menuState = new JMenu("State");
		menuVersionTracking.add(menuState);
		
		JMenu mnStrategy = new JMenu("Versions Strategy");
		JCheckBoxMenuItem checkButtonVolatile = new JCheckBoxMenuItem("Volatile");
		JCheckBoxMenuItem checkButtonStable = new JCheckBoxMenuItem("Stable");		
		JCheckBoxMenuItem checkButtonEnabled = new JCheckBoxMenuItem("Enabled");
		JCheckBoxMenuItem checkButtonDisabled = new JCheckBoxMenuItem("Disabled");
		JButton btnNewVersion = new JButton("New Version");
		btnNewVersion.setEnabled(false);
		JButton btnRollback = new JButton("Rollback");
		btnRollback.setEnabled(false);
		
		checkButtonEnabled.addMouseListener(new MouseAdapter() {			
		@Override
		public void mousePressed(MouseEvent e) {
			if (checkButtonDisabled.isSelected() == true) {
				checkButtonDisabled.setSelected(false);
				mnStrategy.setEnabled(true);
				checkButtonVolatile.setSelected(true);
				checkButtonStable.setSelected(false);
				btnRollback.setEnabled(true);
				btnNewVersion.setEnabled(true);
				EventsListener.enact("Enable");
			} else if (checkButtonDisabled.isSelected() == false && checkButtonEnabled.isSelected() == true) {
				checkButtonDisabled.setSelected(true);
				mnStrategy.setEnabled(false);
				checkButtonVolatile.setSelected(false);
				checkButtonStable.setSelected(false);
				btnRollback.setEnabled(false);
				btnNewVersion.setEnabled(false);
				EventsListener.enact("Disable");
			} else if (checkButtonDisabled.isSelected() == false && checkButtonEnabled.isSelected() == false) {
				checkButtonDisabled.setSelected(false);
				mnStrategy.setEnabled(true);
				checkButtonVolatile.setSelected(true);
				checkButtonStable.setSelected(false);
				btnRollback.setEnabled(true);
				btnNewVersion.setEnabled(true); 
			}
		}
		
		});
		menuState.add(checkButtonEnabled);
		
		checkButtonDisabled.setSelected(true);
		checkButtonDisabled.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (checkButtonEnabled.isSelected() == true) {
					checkButtonEnabled.setSelected(false);
					mnStrategy.setEnabled(false);
					btnRollback.setEnabled(false);
					btnNewVersion.setEnabled(false);
					EventsListener.enact("Disable");
				} else if (checkButtonDisabled.isSelected() == true && checkButtonEnabled.isSelected() == false ) {
					checkButtonEnabled.setSelected(true);
					mnStrategy.setEnabled(true);
					checkButtonVolatile.setSelected(true);
					checkButtonStable.setSelected(false);
					btnRollback.setEnabled(true);
					btnNewVersion.setEnabled(true);
					EventsListener.enact("Enable");
				}
			}
		});
		menuState.add(checkButtonDisabled);
		
		mnStrategy.setEnabled(false);
		menuBar.add(mnStrategy);
		
		checkButtonVolatile.setSelected(true);
		checkButtonVolatile.addMouseListener(new MouseAdapter() {		
			@Override
			public void mousePressed(MouseEvent e) {
				if (checkButtonStable.isSelected() == true) {
					checkButtonStable.setSelected(false);
				}
			}			
		});
		mnStrategy.add(checkButtonVolatile);
		
		checkButtonStable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (checkButtonVolatile.isSelected() == true) {
					checkButtonVolatile.setSelected(false);
					EventsListener.enact("Stable");
				}
			}
		});
		mnStrategy.add(checkButtonStable);
		
		btnNewVersion.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (btnNewVersion.isEnabled()) {
					EventsListener.enact("newVersion");
				}
			}
		});
		menuBar.add(btnNewVersion);
		
		btnRollback.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (btnRollback.isEnabled()) {
					EventsListener.enact("Rollback");
				}
			}
		});
		menuBar.add(btnRollback);
		
		JMenuItem EmptyItem = new JMenuItem("Empty");
		EmptyItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				EventsListener.enact("Empty", " ", " ", " ", " ");
				mnLatexCommands.setEnabled(false);
			}
		});
		NewMenu.add(EmptyItem);
		
		JMenuItem ReportItem = new JMenuItem("Report");
		ReportItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mntmAddChapter.setEnabled(true);
				JFrame popup = new JFrame();
				String Author = JOptionPane.showInputDialog(frmLatexetodor,  "Enter Author name","Author",JOptionPane.INFORMATION_MESSAGE);
				String Date = JOptionPane.showInputDialog(frmLatexetodor, "Enter date","Date",JOptionPane.INFORMATION_MESSAGE);
				String Copyright = JOptionPane.showInputDialog(frmLatexetodor,  "Enter Copyrights","Copyright",JOptionPane.INFORMATION_MESSAGE);
				String VersionID = JOptionPane.showInputDialog(frmLatexetodor, "Enter VersionID","VersionID", JOptionPane.INFORMATION_MESSAGE);
				EventsListener.enact("Report", Author, Date, Copyright, VersionID);
				mnLatexCommands.setEnabled(true);
			}
		});
		NewMenu.add(ReportItem);
		
		JMenuItem BookItem = new JMenuItem("Book");
		BookItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mntmAddChapter.setEnabled(true);
				JFrame popup = new JFrame();
				String Author = JOptionPane.showInputDialog(frmLatexetodor,  "Enter Author name","Author",JOptionPane.INFORMATION_MESSAGE);
				String Date = JOptionPane.showInputDialog(frmLatexetodor, "Enter date","Date",JOptionPane.INFORMATION_MESSAGE);
				String Copyright = JOptionPane.showInputDialog(frmLatexetodor,  "Enter Copyrights","Copyright",JOptionPane.INFORMATION_MESSAGE);
				String VersionID = JOptionPane.showInputDialog(frmLatexetodor, "Enter VersionID","VersionID", JOptionPane.INFORMATION_MESSAGE);
				EventsListener.enact("Book", Author, Date, Copyright, VersionID);
				mnLatexCommands.setEnabled(true);
			}
		});
		NewMenu.add(BookItem);
		
		JMenuItem ArticleItem = new JMenuItem("Article");
		ArticleItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFrame popup = new JFrame();
				String Author = JOptionPane.showInputDialog(frmLatexetodor,  "Enter Author name","Author",JOptionPane.INFORMATION_MESSAGE);
				String Date = JOptionPane.showInputDialog(frmLatexetodor, "Enter date","Date",JOptionPane.INFORMATION_MESSAGE);
				String Copyright = JOptionPane.showInputDialog(frmLatexetodor,  "Enter Copyrights","Copyright",JOptionPane.INFORMATION_MESSAGE);
				String VersionID = JOptionPane.showInputDialog(frmLatexetodor, "Enter VersionID","VersionID", JOptionPane.INFORMATION_MESSAGE);
				EventsListener.enact("Article", Author, Date, Copyright, VersionID);
				mnLatexCommands.setEnabled(true);
				mntmAddChapter.setEnabled(false);
			}
		});
		NewMenu.add(ArticleItem);
		
		JMenuItem LetterItem = new JMenuItem("Letter");
		LetterItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFrame popup = new JFrame();
				String Author = JOptionPane.showInputDialog(frmLatexetodor,  "Enter Author name","Author",JOptionPane.INFORMATION_MESSAGE);
				String Date = JOptionPane.showInputDialog(frmLatexetodor, "Enter date","Date",JOptionPane.INFORMATION_MESSAGE);
				String Copyright = JOptionPane.showInputDialog(frmLatexetodor,  "Enter Copyrights","Copyright",JOptionPane.INFORMATION_MESSAGE);
				String VersionID = JOptionPane.showInputDialog(frmLatexetodor, "Enter VersionID","VersionID", JOptionPane.INFORMATION_MESSAGE);
				EventsListener.enact("Letter", Author, Date, Copyright, VersionID);
				mnLatexCommands.setEnabled(false);	
			}
		});
		NewMenu.add(LetterItem);
		
		JMenuItem SaveItem = new JMenuItem("Save");
		SaveItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();
			    int returnVal = chooser.showSaveDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	EventsListener.enact("Save", chooser.getSelectedFile().getPath(), editorPane.getText());
			    }
			}
		});
		FileMenu.add(SaveItem);
		
		JMenuItem LoadItem = new JMenuItem("Load");
		LoadItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JFileChooser chooser = new JFileChooser();
			    int returnVal = chooser.showOpenDialog(null);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	EventsListener.enact("Load", chooser.getSelectedFile().getPath(), null);
			    }
			}
		});
		FileMenu.add(LoadItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 22, 700, 441);
		frmLatexetodor.getContentPane().add(scrollPane);
		
		editorPane = new JEditorPane();
		editorPane.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				
			}
		});
		scrollPane.setViewportView(editorPane);
	}
	
	public static String getTextOnDisplay() {
		return editorPane.getText();
	}
	
	public static void display(String data) {
		editorPane.setText(data);
		editorPane.repaint();
	
	}
	public static void insertText(String condent)
	{
		try {
			editorPane.getDocument().insertString(editorPane.getDocument().getLength(), condent, null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
}








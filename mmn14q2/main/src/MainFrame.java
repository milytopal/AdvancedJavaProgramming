import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JButton;

@SuppressWarnings("serial")
// represents the visual aspect of the dictionary application
public class MainFrame extends JFrame implements ActionListener{

	private JPanel pnlEdit = new JPanel();
	private JPanel pnlFile = new JPanel();
	private JPanel pnlWrapper = new JPanel();

	private JTextArea txtDisplay = new JTextArea();
	private JButton btnEdit = new JButton("Edit");
	private JButton btnNew = new JButton("New");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnSearch = new JButton("Search");
	private JButton btnOpenFile = new JButton("Open File");
	private JButton btnSaveToFile = new JButton("Save To File");
	private JButton btnNewDictionary = new JButton("New Dictionary");
	private final JFileChooser fc = new JFileChooser();

	// the logical dictionary variable for containing the dictionary entries
	private Dictionary dictionary = new Dictionary(); 
	private File file; // for the dictionary file 



	// builds the visual display
	MainFrame(){
		super("WELCOME TO THE DICTIONARY APPLICATION");
		setLayout(new BorderLayout());
		buildDisplay(); // build the frame display items
		setSize(400,500);
		setVisible(true);
	}

	// builds the visual elements of the application
	// and adds action listeners
	private void buildDisplay(){
		// build visual display
		add(txtDisplay,BorderLayout.CENTER);
		pnlEdit.setLayout(new GridLayout(1,4,3,3));
		pnlEdit.add(btnNew);
		pnlEdit.add(btnEdit);
		pnlEdit.add(btnDelete);
		pnlEdit.add(btnSearch);
		pnlFile.setLayout(new GridLayout(1,3,3,3));
		pnlFile.add(btnNewDictionary);
		pnlFile.add(btnOpenFile);
		pnlFile.add(btnSaveToFile);
		pnlWrapper.setLayout(new GridLayout(2,1,5,5));
		pnlWrapper.add(pnlEdit);
		pnlWrapper.add(pnlFile);
		add(pnlWrapper,BorderLayout.SOUTH);

		// add action listeners to the buttons
		btnOpenFile.addActionListener(this);
		btnNewDictionary.addActionListener(this);
		btnSaveToFile.addActionListener(this);
		btnNew.addActionListener(this);
		btnEdit.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);

	}


	public void actionPerformed(ActionEvent e){

		// in case of opening a dictionary file
		// create a new dictionary and display it
		if (e.getSource() == btnOpenFile){
			int returnVal = fc.showOpenDialog(MainFrame.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {// if a file was chosen
				file = fc.getSelectedFile();
				try
				{
					dictionary = new Dictionary(file);
				}
				catch (FileNotFoundException i)
				{
					// if file does not exist catch the exception
					JOptionPane.showMessageDialog(null, "No such file!!!", "Warning" ,1,null);
				}
				txtDisplay.setText(dictionary.toString());
			}
		}
		// in case of creating a new dictionary make a new one and display it
		else if (e.getSource() == btnNewDictionary)
		{
			dictionary = new Dictionary();
			txtDisplay.setText(dictionary.toString());
		}
		// in case of saving the dictionary save it to the given destination
		else if (e.getSource() == btnSaveToFile)
		{
			int returnVal = fc.showSaveDialog(MainFrame.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) 
			{
				file = fc.getSelectedFile();
			}
		}
		// 
		else if (e.getSource() == btnNew)
		{
			String desc = "";
			String val = JOptionPane.showInputDialog(null, "Please enter a value:", "New Value", 1);
			if (val != null && !val.equals("") )
				desc = JOptionPane.showInputDialog(null, "Please enter a Description:", "New Value", 1);
			if (desc != null && !desc.equals("") )
			{
				dictionary.add(val, desc);
				txtDisplay.setText(dictionary.toString());

			}
		}
		else if (e.getSource() == btnDelete)
		{
			String val = JOptionPane.showInputDialog(null, "Please enter a value to delete:", "Delete Value", 1);
			if (val != null && !val.equals("") )
			{
				dictionary.remove(val);
				txtDisplay.setText(dictionary.toString());
			}
		}
		else if (e.getSource() == btnEdit)
		{
			String desc = "";
			String val = JOptionPane.showInputDialog(null, "Please enter a value to edit:", "Edit Value", 1);
			if (val != null && !val.equals("") && dictionary.search(val) != null )
				desc = JOptionPane.showInputDialog(null, "Please enter the new Description:", "Edit Value", 1);
			if (desc != null && !desc.equals("") )
			{
				dictionary.update(val, desc);
				txtDisplay.setText(dictionary.toString());
			}
		}
		else if (e.getSource() == btnSearch)
		{
			String val = JOptionPane.showInputDialog(null, "Please enter a value to search for:", "Search Value", 1);
			if (val != null && !val.equals("") )
			{
				if (dictionary.search(val) != null)
					JOptionPane.showMessageDialog(null, dictionary.search(val), val ,1,null);
				else
					JOptionPane.showMessageDialog(null, "No such value", val ,1,null);
			}
		}
	}
}

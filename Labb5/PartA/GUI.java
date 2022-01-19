package PartA;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

	private JTextField searchField, nameField, numberField;
	private JButton load, save, search, next, add, delete;
	private JPanel panelText, panelButton, panelButton1, panelButton2;
	private int i = 0;
	PhoneBook myPhoneBook = new PhoneBook();
	ArrayList<Person> searchResults;

	public GUI() {
		setTitle("Interactive phone book");

		Font theFont = new Font("SansSerif", Font.PLAIN, 20);
		load = new JButton("Load phonebook");
		load.setFont(theFont);
		load.addActionListener(this);
		save = new JButton("Save phonebook");
		save.setFont(theFont);
		save.addActionListener(this);
		search = new JButton("Search");
		search.setFont(theFont);
		search.addActionListener(this);
		next = new JButton("Next name");
		next.setFont(theFont);
		next.addActionListener(this);
		add = new JButton("Add person");
		add.setFont(theFont);
		add.addActionListener(this);
		delete = new JButton("Delete person");
		delete.setFont(theFont);
		delete.addActionListener(this);

		save.setEnabled(false);
		search.setEnabled(false);
		next.setEnabled(false);
		add.setEnabled(false);
		delete.setEnabled(false);
		load.setEnabled(true);

		panelButton1 = new JPanel(new GridLayout(3, 1));
		panelButton1.add(load);
		panelButton1.add(search);
		panelButton1.add(add);
		panelButton2 = new JPanel(new GridLayout(3, 1));
		panelButton2.add(save);
		panelButton2.add(next);
		panelButton2.add(delete);

		panelButton = new JPanel(new GridLayout(1, 2));
		panelButton.add(panelButton1);
		panelButton.add(panelButton2);

		searchField = new JTextField();
		searchField.setFont(theFont);
		searchField.addActionListener(this);
		nameField = new JTextField();
		nameField.setFont(theFont);
		nameField.addActionListener(this);
		nameField.setEditable(false);
		numberField = new JTextField();
		numberField.setFont(theFont);
		numberField.addActionListener(this);
		numberField.setEditable(false);

		panelText = new JPanel(new GridLayout(3, 1));
		panelText.add(searchField);
		panelText.add(nameField);
		panelText.add(numberField);

		Container c = getContentPane();
		c.setBackground(Color.WHITE);
		c.setLayout(new GridLayout(1, 2));
		c.add(panelButton);
		c.add(panelText);

		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		GUI theGUI = new GUI();

	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == load || e.getSource() == searchField) {
			String searchText = searchField.getText();
			System.out.println(searchText);
			searchField.setText("");

			String result = myPhoneBook.load(searchText);

			if (result.equals("Phone book loaded")) {

				save.setEnabled(true);
				search.setEnabled(true);
				add.setEnabled(true);
				delete.setEnabled(true);

			}

			nameField.setText(result);

		} else if (e.getSource() == save) {

			String filename = searchField.getText();
			searchField.setText("");

			if (filename.equals("")) {
				nameField.setText("Provide a file name");
			} else {

				nameField.setText(myPhoneBook.save(filename));

			}

			searchField.setText("");

		} else if (e.getSource() == search) {
			String arg = searchField.getText();
			searchField.setText("");

			if ((myPhoneBook.search(arg)).size() == 0) {
				nameField.setText("Provide a name");
				numberField.setText("");
			} else if ((myPhoneBook.search(arg)).size() == 1) {

				String person = (myPhoneBook.search(arg)).get(0).getFullName();
				int number = (myPhoneBook.search(arg)).get(0).getPhoneNumber();
				nameField.setText(person);
				numberField.setText(Integer.toString(number));

			} else if ((myPhoneBook.search(arg)).size() > 1) {

				next.setEnabled(true);
				searchResults = myPhoneBook.search(arg);

				nameField.setText(searchResults.get(0).getFullName());
				numberField.setText(Integer.toString(searchResults.get(0).getPhoneNumber()));

			}

		}
		if (e.getSource() == next) {
			i++;
			if (searchResults.size() > i) {
				nameField.setText(searchResults.get(i).getFullName());
				numberField.setText(Integer.toString(searchResults.get(i).getPhoneNumber()));
				if (i == (searchResults.size() - 1)) {
					i = 0;
					next.setEnabled(false);
				}
			}
		} else if (e.getSource() == delete) {

		}
	}

}

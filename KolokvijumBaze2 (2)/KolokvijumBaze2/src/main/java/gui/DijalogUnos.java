package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.IgracCrud;
import model.Igrac;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogUnos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfIme;
	private JTextField tfPrezime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogUnos dialog = new DijalogUnos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogUnos() {
		setTitle("Unos igraca");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIme = new JLabel("Ime");
			lblIme.setBounds(42, 40, 45, 13);
			contentPanel.add(lblIme);
		}
		{
			JLabel lblPrezime = new JLabel("Prezime");
			lblPrezime.setBounds(42, 135, 45, 13);
			contentPanel.add(lblPrezime);
		}
		{
			tfIme = new JTextField();
			tfIme.setBounds(184, 37, 96, 19);
			contentPanel.add(tfIme);
			tfIme.setColumns(10);
		}
		{
			tfPrezime = new JTextField();
			tfPrezime.setBounds(184, 132, 96, 19);
			contentPanel.add(tfPrezime);
			tfPrezime.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String ime = tfIme.getText();
						String prezime = tfPrezime.getText();
						
						Igrac i = new Igrac(ime, prezime);
						IgracCrud ic = new IgracCrud();
						ic.insertIgrac(i);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Zatvori");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}

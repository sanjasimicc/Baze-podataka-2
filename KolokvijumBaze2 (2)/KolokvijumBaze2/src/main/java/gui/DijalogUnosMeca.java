package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import crud.IgracCrud;
import crud.MecCrud;
import model.Igrac;
import model.Mec;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DijalogUnosMeca extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField tfDatum;
	private JTextField tfRezultat;
	private JTextField tfVreme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogUnosMeca dialog = new DijalogUnosMeca();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogUnosMeca() {
		setTitle("Unos meca");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblPrvi = new JLabel("Prvi igrac");
			lblPrvi.setBounds(27, 35, 45, 13);
			contentPanel.add(lblPrvi);
		}
		{
			JLabel lblDrugi = new JLabel("Drugi Igrac");
			lblDrugi.setBounds(27, 92, 45, 13);
			contentPanel.add(lblDrugi);
		}
		{
			JLabel lblDatum = new JLabel("Datum");
			lblDatum.setBounds(27, 156, 45, 13);
			contentPanel.add(lblDatum);
		}
		{
			JLabel lblVreme = new JLabel("Vreme");
			lblVreme.setBounds(234, 156, 45, 13);
			contentPanel.add(lblVreme);
		}
		{
			JLabel lblRezultat = new JLabel("Rezultat");
			lblRezultat.setBounds(27, 198, 45, 13);
			contentPanel.add(lblRezultat);
		}
		{
			tfDatum = new JTextField();
			tfDatum.setBounds(70, 153, 96, 19);
			contentPanel.add(tfDatum);
			tfDatum.setColumns(10);
		}
		{
			tfRezultat = new JTextField();
			tfRezultat.setBounds(70, 195, 96, 19);
			contentPanel.add(tfRezultat);
			tfRezultat.setColumns(10);
		}
		{
			tfVreme = new JTextField();
			tfVreme.setBounds(283, 153, 96, 19);
			contentPanel.add(tfVreme);
			tfVreme.setColumns(10);
		}
		
		JComboBox<Igrac> cbPrvi = new JComboBox<Igrac>();
		cbPrvi.setBounds(104, 31, 222, 30);
		contentPanel.add(cbPrvi);
		IgracCrud ic = new IgracCrud();
		List<Igrac> igraci = ic.listIgraci();
		for(Igrac i : igraci) {
			cbPrvi.addItem(i);
		}
		
	
		
		
		JComboBox<Igrac> cbDrugi = new JComboBox<Igrac>();
		cbDrugi.setBounds(104, 88, 222, 19);
		contentPanel.add(cbDrugi);
		IgracCrud ici = new IgracCrud();
		List<Igrac> igracii = ici.listIgraci();
		for(Igrac i : igracii) {
			cbPrvi.addItem(i);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Unesi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Igrac i1 = (Igrac) cbPrvi.getSelectedItem();
						Igrac i2 = (Igrac) cbDrugi.getSelectedItem();
						String datum = tfDatum.getText();
						String vreme = tfVreme.getText();
						String rezultat = tfRezultat.getText();
						
						Mec m = new Mec(datum, rezultat, vreme, i1, i2);
						MecCrud mc = new MecCrud();
						mc.insertMec(m);
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

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
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DijalogPrikaz extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	JComboBox<Igrac> cbIgraci;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogPrikaz dialog = new DijalogPrikaz();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogPrikaz() {
		setTitle("Prikaz meceva");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIzaberi = new JLabel("Izaberi igraca");
			lblIzaberi.setBounds(10, 25, 45, 13);
			contentPanel.add(lblIzaberi);
		}
		{
			cbIgraci = new JComboBox<Igrac>();
			cbIgraci.setBounds(93, 21, 29, 21);
			contentPanel.add(cbIgraci);
			IgracCrud ic = new IgracCrud();
			List<Igrac> igraci = ic.listIgraci();
			for(Igrac i : igraci) {
				cbIgraci.addItem(i);
			}
		}
		{
			JButton btnPrikazi = new JButton("Prikazi");
			btnPrikazi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IgracCrud ic = new IgracCrud();
					MecCrud mc = new MecCrud();
					Igrac i = (Igrac) cbIgraci.getSelectedItem();
					List<Mec> mecevi = mc.igraniMecevi(i);
					TableModelIgrac tmi = new TableModelIgrac(mecevi);
					table.setModel(tmi);

				}
			});
			btnPrikazi.setBounds(276, 21, 85, 21);
			contentPanel.add(btnPrikazi);
		}
		
		table = new JTable();
		table.setBounds(80, 90, 263, 132);
		contentPanel.add(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton btnZatvori = new JButton("Zatvori");
				btnZatvori.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btnZatvori.setActionCommand("Cancel");
				buttonPane.add(btnZatvori);
			}
		}
	}
}

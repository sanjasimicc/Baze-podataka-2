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
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class DijalogBrisanje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JComboBox<Igrac> cbIgraci;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogBrisanje dialog = new DijalogBrisanje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogBrisanje() {
		setTitle("Brisanje igraca");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblIgrac = new JLabel("Izaberi igraca");
			lblIgrac.setBounds(35, 49, 45, 13);
			contentPanel.add(lblIgrac);
		}
		{
			cbIgraci = new JComboBox<Igrac>();
			cbIgraci.setBounds(144, 49, 29, 21);
			contentPanel.add(cbIgraci);
			IgracCrud ic = new IgracCrud();
			List<Igrac> igraci = ic.listIgraci();
			for(Igrac i : igraci) {
				cbIgraci.addItem(i);
			}
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnBrisi = new JButton("Brisi");
				btnBrisi.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Igrac i = (Igrac) cbIgraci.getSelectedItem();
						IgracCrud ic = new IgracCrud();
						ic.deleteIgraca(i);
						
					}
				});
				btnBrisi.setActionCommand("OK");
				buttonPane.add(btnBrisi);
				getRootPane().setDefaultButton(btnBrisi);
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

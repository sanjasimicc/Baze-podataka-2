package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogGlavniProzor {

	private JFrame frmAplikacija;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DijalogGlavniProzor window = new DijalogGlavniProzor();
					window.frmAplikacija.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DijalogGlavniProzor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAplikacija = new JFrame();
		frmAplikacija.setTitle("Aplikacija");
		frmAplikacija.setBounds(100, 100, 450, 300);
		frmAplikacija.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAplikacija.getContentPane().setLayout(null);
		
		JButton btnUnos = new JButton("Unos novog igraca");
		btnUnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijalogUnos du = new DijalogUnos();
				du.setVisible(true);
				
			}
		});
		btnUnos.setBounds(101, 32, 85, 21);
		frmAplikacija.getContentPane().add(btnUnos);
		
		JButton btnUnosMec = new JButton("Unos novog meca");
		btnUnosMec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijalogUnosMeca dum = new DijalogUnosMeca();
				dum.setVisible(true);
			}
		});
		btnUnosMec.setBounds(101, 107, 85, 21);
		frmAplikacija.getContentPane().add(btnUnosMec);
		
		JButton btnBrisanje = new JButton("Obrisi igraca");
		btnBrisanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijalogBrisanje db = new DijalogBrisanje();
				db.setVisible(true);
			}
		});
		btnBrisanje.setBounds(101, 162, 85, 21);
		frmAplikacija.getContentPane().add(btnBrisanje);
		
		JButton btnPrikaz = new JButton("Prikaz svih meceva");
		btnPrikaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DijalogPrikaz dp = new DijalogPrikaz();
				dp.setVisible(true);
			}
		});
		btnPrikaz.setBounds(101, 215, 85, 21);
		frmAplikacija.getContentPane().add(btnPrikaz);
	}
}

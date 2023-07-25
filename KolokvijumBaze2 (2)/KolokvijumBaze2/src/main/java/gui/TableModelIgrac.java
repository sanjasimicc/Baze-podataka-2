package gui;
import model.Igrac;
import model.Mec;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TableModelIgrac extends AbstractTableModel{
	private List<Mec> mecevi = null;
	String[] naziviKolona = {"Igrac", "Datum", "Rezultat"};
	
	

	public TableModelIgrac(List<Mec> mecevi) {
		this.mecevi = mecevi;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return mecevi.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Mec m = mecevi.get(rowIndex);
		switch(columnIndex) {
		case 0: return m.getIgrac1();
		case 1: return m.getDatum();
		case 2: return m.getRezultat();
		}
		return null;
	}
	
	public String getColumnNames(int i) {
		return naziviKolona[i];
	}
	

}

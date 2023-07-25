package main;

import java.util.List;

import crud.IgracCrud;
import crud.MecCrud;
import model.Igrac;
import model.Mec;

public class GlavniProgram {

	public static void main(String[] args) {

		Igrac i1 = new Igrac("Marko", "Markovic");
		Igrac i2 =  new Igrac("Novak", "Djokovic");
		IgracCrud ic = new IgracCrud();
//		ic.insertIgrac(i);
		
		Igrac nadjen = ic.findIgraca(1);
		
//		List<Mec> lista = ic.igraniMecevi(i2);
//		for(Mec m : lista) {
//			System.out.println(m);
//		}
		
//		List<Igrac> lista2 = ic.listIgraci();
//		for(Igrac i : lista2) {
//			System.out.println(i);
//		}
		
		Mec m = new Mec("utorak", "1:0", "17h", i1 , i2);
		MecCrud mc = new MecCrud();
		mc.insertMec(m);
//       mc.poveziMecIIgraca(i2, m);
//		System.out.println("Svi mecevi koje je igrao " + nadjen);
//		List<Mec> meces = mc.igraniMecevi(nadjen);
//		for(Mec mm : meces) {
//			System.out.println(mm);
//		}
		
//		ic.deleteIgraca(nadjen);
		
	}

}

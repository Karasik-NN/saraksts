package saraksts;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class uzd1 {
static boolean jauEksiste(LinkedList<String> saraksts, String elements){
	for(int i=0; i<saraksts.size(); i++) {
		if(saraksts.get(i).equalsIgnoreCase(elements)) {
			JOptionPane.showMessageDialog(null, "Šads produkts jau ir pievienots sarakstam", "Kļuda",
					JOptionPane.WARNING_MESSAGE);
			return true;
		}
	}
	return false;
}
	public static void main(String[] args) {
String izvele, koPievienot, koAtrast, koNonemt,
arKoAizstat;
int kurPievienot, kurNonemt, kuruMainit;
LinkedList<String> saraksts = new LinkedList<>();
		
		do {
			do {
				izvele = JOptionPane.showInputDialog("1 - Pievienot produktu\n2 -  Produktu skaits \n"
						+ "3 - izvadīt produktu\n4 - Atrast produktu \n"
						+ "5 = Pievienot konkreta pozicija\n6 - Noņemt produktu"
						+ "\n7 - Noņemt pēc indeksa\n8 - Noņemt pirmo\n"
						+ "9 - Noņemt pedejo\n10 - Mainit produktu \n11 - Sakartot alfabetiski"
						+ "\n12 - Nodzest sarakstu \n0 - Apturēt ");
				if(izvele == null)
					izvele = "0";
			}while(!izvele.matches("\\d+"));
			
				switch(izvele) {
				case "1":
					do {
						koPievienot = 
								JOptionPane.showInputDialog("Kādu produktu pievienot");					
					}while((jauEksiste(saraksts, koPievienot) == true) || 
							!koPievienot.matches("^[\\p{L} ]+$"));
					
					saraksts.add(koPievienot.toLowerCase());
					JOptionPane.showMessageDialog(null, "Produkts pievienots sarakstam!", "Informacija",
							JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "2":
					JOptionPane.showMessageDialog(null, "Produktu skaits: "+saraksts.size(),"Informacija",
                            JOptionPane.INFORMATION_MESSAGE);
					break;
					
				case "3":
					if(saraksts.size()== 0)
						JOptionPane.showMessageDialog(null,
								"Nav saraksta produktu", "Informācija",
								JOptionPane.INFORMATION_MESSAGE);
					else {
						Iterator<String>izvade = saraksts.iterator();
						String str = "";
						while(izvade.hasNext()) {
							str +=izvade.next()+"\n";						
							}
						JOptionPane.showMessageDialog(null, str, "Produktu saraksts", JOptionPane.INFORMATION_MESSAGE);
						}
					break;
					
				case "4":
					do {
						koAtrast = JOptionPane.showInputDialog(null, "Kadu produktu meklet saraksta?", "Jautajums",
								JOptionPane.INFORMATION_MESSAGE);
					}while(!koAtrast.matches("^[\\p{L} ]+$"));
					
					JOptionPane.showMessageDialog(null, 
							((saraksts.indexOf(koAtrast))>-1)?
									"Produkts atrasts "+saraksts.indexOf(koAtrast)+". pozicija"
									:"Produkts netika atrasts saraksta!",
									"Informacija",
									JOptionPane.INFORMATION_MESSAGE);
					break;
				case"5":
					do {
						koPievienot =
								JOptionPane.showInputDialog("Kādu produktu pievienot");
						kurPievienot = Integer.parseInt(
								JOptionPane.showInputDialog("Kurā pozīcija pievienot?"));
								
					}while((jauEksiste(saraksts, koPievienot)== true)||!koPievienot.matches("^[\\p{L} ]+$"));
					saraksts.add(kurPievienot, koPievienot);
				case "6":
					do {
						koNonemt =
								JOptionPane.showInputDialog("Kādu produktu nonemt");
						
						if(saraksts.contains(koNonemt)) {
							kurNonemt = saraksts.indexOf(koNonemt);
							saraksts.remove(kurNonemt);
							JOptionPane.showMessageDialog(null, "Produkts ir nonemts!",
									"Informācija",JOptionPane.INFORMATION_MESSAGE);
							
						}
					}while((jauEksiste(saraksts,koNonemt )== true)||!koNonemt.matches("^[\\p{L} ]+$"));
					break;
				}
				
		}while(!izvele.equals("0"));
	}

}


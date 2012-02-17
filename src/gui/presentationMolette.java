package gui;
//package molette;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//import controleMoletteImpl;
//import iControleMolette;


public class presentationMolette extends JPanel implements ChangeListener,iPresentationMolette{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//on a mis controle molette mais le controle sera le VCO
	private iControleMolette controle;

	public iControleMolette getControle() {
		return controle;
	}

	public void setControle(iControleMolette controle) {
		this.controle = controle;
	}

	private DKnob ts=new DKnob();
	//on met un labael pour afficher les valeurs permises du slider
	JLabel jl;
	JLabel jla;
	SigneAffichage signeAff;
	//int entier=4;
	//String nomDeLamolette="att";

	public presentationMolette(/*controleMoletteImpl controle*/SigneAffichage signeAff, int entier,String nomDeLamolette){

		this.signeAff=signeAff;

		//on met le type de layout utilisé
		setLayout(new BorderLayout());
		setBackground(new Color(200,200,255));
		//on met le nom de la molette
		ts.setNomMolette(nomDeLamolette);
		//signeAff=SigneAffichage.negatif;
		
		//on précise si c'est en affichage négatif ou positif en fonction de son utilité
		//si b est le nombre, positif [0,b] et négatif [-b,b]
		ts.setChoxSigne(signeAff);

		//int vol = choisirAffichageValeur(SigneAffichage.negatif, ts);

		//on met le nombre qu'on voudrait afficher
		ts.setEntInter(entier);
		//on met le nombre de trait qu'on voudrait afficher
		//ts.setNombreDeTrait();
		choisirAffichageValeur(signeAff, ts);
		
		//ts.setBackground(C)
		
		ts.setOpaque(false);
		
//		/ts.setCursor()



		//on choisit de le mettre au nord du panel
		add(jl = new JLabel(ts.getNomMolette()+": "+ts.getEntInter()), BorderLayout.NORTH);

		ts.setValue((float)1.0);

		//on place le slider circulaire au milieu du panel
		add(ts, BorderLayout.CENTER);

		jla=jl;
		System.out.println(getCursor().toString());

		ts.addChangeListener( this
//								new ChangeListener() {
//				
//							@Override
//							public void stateChanged(ChangeEvent e) {
//				
//								int vol = choisirAffichageValeur(SigneAffichage.negatif, ts);
//								jla.setText(ts.getNomMolette()+": " + vol);
//								ts.setTempoValeurChangeListener(vol);
//								//controle.setValeurDeSortie(vol);
//								//System.out.println("la valeur : "+(int)ts.getTempoValeurChangeListener());
//				
//							}
//						}
				);
		
	}

/*	public static void main(String[]args){
		JFrame jf = new JFrame();
		jf.getContentPane().setLayout(new BorderLayout());
		
		jf.setSize(120,140);
		controleMoletteImpl cmi = new controleMoletteImpl();
		presentationMolette monAtt=new presentationMolette(SigneAffichage.negatif,5,"olivier");
		cmi.setPresentation(monAtt);
		
		jf.getContentPane().add(monAtt, BorderLayout.CENTER);		    
		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		
		//System.out.println("my value is:"+ cmi.getValeurDeSortie());
		jf.pack();
		jf.setVisible(true);

	}
*/

	@Override
	public void stateChanged(ChangeEvent e) {
		//DKnob ts2 = (DKnob) e.getSource();
		int vol = choisirAffichageValeur(signeAff, ts);
		jla.setText(ts.getNomMolette()+": " + vol);
		ts.setTempoValeurChangeListener(vol);
		//controle.setValeurDeSortie(vol);
	}

/**
 * To Choose the output value of DKnob 
 * 
 * **/	

	int choisirAffichageValeur(SigneAffichage sa, DKnob sld){
		int val;
		int pas=ts.getEntInter();
		if(sa.equals(SigneAffichage.negatif)){			
			val=(int)((pas*2) * sld.getValue())-pas;
			ts.setNombreDeTrait(pas*2);
		}else if(sa.equals(SigneAffichage.positif)){
			val=(int)((pas) * sld.getValue());
			ts.setNombreDeTrait(pas);
		}else{
			int Puissance=(int)(pas*sld.getValue());
			val=(int) Math.pow(2, Puissance);
			ts.setNombreDeTrait(pas);
		}
		return val;
	}

	public DKnob getTs() {
		return ts;
	}


	public void setTs(DKnob ts) {
		this.ts = ts;
	}


}

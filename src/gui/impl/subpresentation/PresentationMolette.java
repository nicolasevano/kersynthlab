package gui.impl.subpresentation;
//package molette;


import gui.IPresentationMolette;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PresentationMolette extends JPanel implements ChangeListener,IPresentationMolette{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DKnob ts=new DKnob();
	//on met un label pour afficher les valeurs permises du slider
	JLabel jl;
	JLabel jla;
	private SigneAffichage signeAff;

	public PresentationMolette( SigneAffichage signeAff, int entier,String nomDeLamolette ){

		this.setSigneAff(signeAff);

		//on met le type de layout utilis�
		setLayout(new BorderLayout());
		setBackground(new Color(200,200,255));
		//on met le nom de la molette
		ts.setNomMolette(nomDeLamolette);
		/**/
		ts.setSize(100, 100);
		//signeAff=SigneAffichage.negatif;
		
		//on pr�cise si c'est en affichage n�gatif ou positif en fonction de son utilit�
		//si b est le nombre, positif [0,b] et n�gatif [-b,b]
		ts.setChoxSigne(signeAff);

		//on met le nombre qu'on voudrait afficher
		ts.setEntInter(entier);
		//on met le nombre de trait qu'on voudrait afficher
		choisirAffichageValeur(signeAff, ts);
		
		ts.setOpaque(false);
		/**/
		setSize(120,120);
		/**/
		//on choisit de le mettre au nord du panel
		add(jl = new JLabel(ts.getNomMolette()+": "+( (signeAff == SigneAffichage.puissance)?(int)Math.pow(2, entier):entier) ), BorderLayout.NORTH);
		/**/
		jl.setSize(120,20);
		jl.setLocation(0,0);
		/**/
		ts.setValue((float)1.0);

		//on place le slider circulaire au milieu du panel
		//add(ts, BorderLayout.CENTER);
		add(ts);
		ts.setLocation(0,20);

		jla=jl;
		System.out.println(getCursor().toString());

		ts.addChangeListener( this );
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int vol = choisirAffichageValeur(getSigneAff(), ts);
		jla.setText(ts.getNomMolette()+": " + vol);
		ts.setTempoValeurChangeListener(vol);
	}

/**
 * To Choose the output value of DKnob 
 * 
 * **/	

	public int choisirAffichageValeur(SigneAffichage sa, DKnob sld){
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

	public void setSigneAff(SigneAffichage signeAff) {
		this.signeAff = signeAff;
	}

	public SigneAffichage getSigneAff() {
		return signeAff;
	}


}
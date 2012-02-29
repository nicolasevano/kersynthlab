package gui.impl.subpresentation;

import gui.IPresentationMolette;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PresentationMolette extends JPanel implements ChangeListener,IPresentationMolette{

	private static final long serialVersionUID = 1L;

	private DKnob ts;
	//on met un label pour afficher les valeurs permises du slider
	JLabel jl;
	JLabel jla;
	private SigneAffichage signeAff;
	private int numeroTrait;


	public PresentationMolette( SigneAffichage signeAff, int entier,String nomDeLamolette){

		ts = new DKnob();
		this.setSigneAff(signeAff);

		//on met le type de layout utilisé
		setLayout(new BorderLayout());
		setBackground(new Color(200,200,255));
		//on met le nom de la molette
		ts.setNomMolette(nomDeLamolette);
		ts.setSize(100, 100);
		
		//on prise si c'est en affichage n間atif ou positif en fonction de son utilit�
		//si b est le nombre, positif [0,b] et n間atif [-b,b]
		ts.setChoxSigne(signeAff);

		//on met le nombre qu'on voudrait afficher
		ts.setEntInter(entier);
		
		ts.setValue(0);
		
		//on met le nombre de trait qu'on voudrait afficher
		choisirAffichageValeur(signeAff, ts);
		
		ts.setOpaque(false);
		
		ts.validate();
		setSize(120,120);
		//on choisit de le mettre au nord du panel
		add(jl = new JLabel(ts.getNomMolette()+": "+( (signeAff == SigneAffichage.puissance)?(int)Math.pow(2, entier):entier) ), BorderLayout.NORTH);
		/**/
		jl.setSize(120,20);
		jl.setLocation(0,0);
		/**/
		ts.setValue((float)1.0);

		//on place le slider circulaire au milieu du panel
		add(ts);
		ts.setLocation(0,20);

		jla=jl;
		System.out.println(getCursor().toString());
		
		ts.setValeurAiguille(numeroTrait);
	    ts.setValue(-1);

		ts.addChangeListener( this );
		
	}
	
	/**
	 * Constructor of PresentationMolette
	 * 
	 * @param signeAff: there are three values (negatif, positif and puissance)
	 * @param entier: if signeAff is: - negatif, there are entier*2 "markers" in the displaying and values are between -entier to entier 
	 * 								  @- positif, there are entier "markers" in the displaying and values are between entier to entier 
	 * 								  - puissance,  there are entier "markers" in the displaying and values are between 2^0 to 2^entier
	 * @param nomDeLamolette: name of value displaying
	 * @param numeroTrait: place the default value of the number that indicated by numeroTrait (warning: this value is not negative)
	 * 
	 * */
	
	public PresentationMolette( SigneAffichage signeAff, int entier,String nomDeLamolette, int numeroTrait){

		ts = new DKnob();
		this.setSigneAff(signeAff);

		//on met le type de layout utilis�
		setLayout(new BorderLayout());
		setBackground(new Color(200,200,255));
		//on met le nom de la molette
		ts.setNomMolette(nomDeLamolette);
		/**/
		ts.setSize(100, 100);
		//signeAff=SigneAffichage.negatif;
		
		//on pr閏ise si c'est en affichage n間atif ou positif en fonction de son utilit�
		//si b est le nombre, positif [0,b] et n間atif [-b,b]
		ts.setChoxSigne(signeAff);

		//on met le nombre qu'on voudrait afficher
		ts.setEntInter(entier);
		
		ts.setValue(0);
		
		//on met le nombre de trait qu'on voudrait afficher
		choisirAffichageValeur(signeAff, ts);
		
		ts.setOpaque(false);
		
		ts.validate();
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
		
		ts.setValeurAiguille(numeroTrait);
		ts.addChangeListener( this );
		
		ts.validate();
		
	}

	
	public static void main(String[] args)
	{
	    JFrame win = new JFrame("DTest!");
	    win.getContentPane().setLayout(new BorderLayout());
	    win.setSize(120,140);
	    PresentationMolette viewMolette = new PresentationMolette(SigneAffichage.positif, 5, "toto",3);
	    viewMolette.getTs().setValue(-1);
	    win.getContentPane().add(viewMolette, BorderLayout.CENTER);
	    
	    win.addWindowListener(new WindowAdapter() {
	    	  public void windowClosing(WindowEvent we) {
	    	    System.exit(0);
	    	  }
	    	});
	    
	    win.setResizable(false);
	    win.show(true);
	    
	}
	
	
	@Override
	public void stateChanged(ChangeEvent e) {
		int vol = choisirAffichageValeur(getSigneAff(), ts);
		jla.setText(ts.getNomMolette()+": " + vol);
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
	
	public int getNumeroTrait() {
		return numeroTrait;
	}


	public void setNumeroTrait(int numeroTrait) {
		this.numeroTrait = numeroTrait;
	}


}

package gui;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Panel;

import javax.swing.JCheckBox;
import javax.swing.JFrame;



public class VCO extends JFrame {
	
	
	/**
	 * 29007655
	 */
	private static final long serialVersionUID = 1L;
	// Variables declaration                     
    private javax.swing.JLabel jLabel4;
    private Reglage parametre;
    private Onde forme;
	
	presentationOutPortImpl outPort;
	presentationInPortImpl inPort;
	
	
	
    // End of variables declaration  
	
	public VCO(){
		initComponents();
	}

	private void initComponents() {
		
        jLabel4 = new javax.swing.JLabel();
       
        //instanciation des composants
		
        parametre = new Reglage();
        forme = new Onde();

		inPort = new presentationInPortImpl();
		outPort = new presentationOutPortImpl();
	
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MODULE VCO");    

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("MODULE VCO");
        jLabel4.setBorder(new javax.swing.border.MatteBorder(null));
        
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        
        p.add(forme, BorderLayout.SOUTH);
        p.add(inPort, BorderLayout.WEST);
        p.add(outPort, BorderLayout.EAST);       
        p.add(parametre, BorderLayout.CENTER);
        p.add(jLabel4, BorderLayout.NORTH);
        setSize(800,400); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
        getContentPane().add(p);		
	}

	public static void main(String[] args){
		
		java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VCO().setVisible(true);
            }
        });
		
	}
}

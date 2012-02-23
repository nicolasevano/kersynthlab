package gui.impl;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class AboutBox extends JDialog{

	/**
	 * Add "about KerSynthSound" in the menu "About"
	 */
	private static final long serialVersionUID = 1L;
	
	public AboutBox(java.awt.Frame parent, boolean modal){
		super(parent, modal);
		initComponents();
	}

	/**
	 * Define these components in about box:
	 * 		JPanel jThanxPanel, jAffiliationsPanel
	 * 		JTabbedPane jTabbedPane
	 * 		JLabel jLabelLogo, jLabelInfo
	 */
	private void initComponents() {
		
		jTabbedPane = new javax.swing.JTabbedPane();
        jThanxPanel = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();
        jAffiliationsPanel = new javax.swing.JPanel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setName("About");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        
        
		jTabbedPane.setBackground(java.awt.Color.white);
        jTabbedPane.setName("");
        jThanxPanel.setLayout(new GridLayout());
		
		String str ="<html><body>KerSynthSound v1.1" +
				 "<br>Copyright 2012 Groupe KerSynthSound" +
				 "<br>Membres:" +
				 "<br>&nbsp;&nbsp;&nbsp;RAKOTOMALALA Alain" +
				 "<br>&nbsp;&nbsp;&nbsp;EVANO Nicolas" +
				 "<br>&nbsp;&nbsp;&nbsp;ZHAO Ying" +
				 "<br>&nbsp;&nbsp;&nbsp;AUNEAU Sylvie" +
				 "<br>&nbsp;&nbsp;&nbsp;TCHOUNGA Olivier" +
				 "</body></html> ";
        jLabelInfo = new JLabel(str);
        
    	icon = new ImageIcon ("images/logo.jpg");
        jLabelLogo = new JLabel(icon);
        jLabelLogo.setVisible (true) ;
    	
    	String strA = "<html> <body>Groupe KersynthSound" +
    				  "<br>E-mail: kersynthsound@gmail.com" +
    				  "</body> </html> ";
    	jLabelAffiliation = new JLabel(strA);
    	
        
        
        jThanxPanel.setName("About");
        jThanxPanel.setLayout(new java.awt.GridLayout(2, 1));
        jThanxPanel.add(jLabelLogo);
        jThanxPanel.add(jLabelInfo);
        
        jTabbedPane.addTab("About", jThanxPanel);
        
        jAffiliationsPanel.setName("Affiliations");
        jAffiliationsPanel.setLayout(new java.awt.GridLayout(1, 1));
        jAffiliationsPanel.add(jLabelAffiliation);
        jTabbedPane.addTab("Affiliations", jAffiliationsPanel);
        
        this.getContentPane().add(jTabbedPane, java.awt.BorderLayout.CENTER);
        
        this.pack();
        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new java.awt.Dimension(600, 390));
        this.setLocation((screenSize.width-450)/2,(screenSize.height-300)/2);
        this.setResizable(false);
	}
	
	/**
	 * Close AboutBox
	 */
	private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }
	
	/*public static void main(String args[]) {
        new AboutBox(new javax.swing.JFrame(), true).show();
    }*/
	
	private JPanel jThanxPanel;
	private JPanel jAffiliationsPanel;
    private ImageIcon icon;
    private JLabel jLabelLogo;
    private JLabel jLabelInfo;
    private JLabel jLabelAffiliation;
    private JTabbedPane jTabbedPane;
    
}

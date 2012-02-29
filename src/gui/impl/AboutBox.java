package gui.impl;

import java.awt.GridLayout;
import java.io.UnsupportedEncodingException;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import stringloader.IConfigurationLoader;


public class AboutBox extends JDialog{

	/**
	 * Add "about KerSynthSound" in the menu "About"
	 */
	private static final long serialVersionUID = 1L;
	
	public AboutBox(java.awt.Frame parent, boolean modal, IConfigurationLoader configuration) throws UnsupportedEncodingException{
		super(parent, modal);
		initComponents(configuration);
	}

	/**
	 * Define these components in about box:
	 * 		JPanel jThanxPanel, jAffiliationsPanel
	 * 		JTabbedPane jTabbedPane
	 * 		JLabel jLabelLogo, jLabelInfo
	 * @throws UnsupportedEncodingException 
	 */
	private void initComponents(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		String language = configuration.getLanguage();
		
		jTabbedPane = new javax.swing.JTabbedPane();
        jThanxPanel = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelInfo = new javax.swing.JLabel();
        jAffiliationsPanel = new javax.swing.JPanel();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        if(language == "Chinese")
        	setTitle(new String(configuration.getProperties().getProperty("about.title").getBytes("iso8859-1"), "utf-8"));
        else
        	setTitle(configuration.getProperties().getProperty("about.title"));
        setName("About");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        
        
		jTabbedPane.setBackground(java.awt.Color.white);
        jTabbedPane.setName("");
        jThanxPanel.setLayout(new GridLayout());
		
        if(language == "Chinese")
        {
        	String str ="<html><body>" + new String(configuration.getProperties().getProperty("about.info1").getBytes("iso8859-1"), "utf-8") +
   				 "<br>" + new String(configuration.getProperties().getProperty("about.info2").getBytes("iso8859-1"), "utf-8") +
   				 "<br>" + new String(configuration.getProperties().getProperty("about.info3").getBytes("iso8859-1"), "utf-8") +
   				 "<br>&nbsp;&nbsp;&nbsp;RAKOTOMALALA Alain" +
   				 "<br>&nbsp;&nbsp;&nbsp;EVANO Nicolas" +
   				 "<br>&nbsp;&nbsp;&nbsp;ZHAO Ying" +
   				 "<br>&nbsp;&nbsp;&nbsp;AUNEAU Sylvie" +
   				 "<br>&nbsp;&nbsp;&nbsp;TCHOUNGA Olivier" +
   				 "</body></html>";
        	jLabelInfo = new JLabel(str);
        }
        else
        {
        	String str ="<html><body>" + configuration.getProperties().getProperty("about.info1") +
   				 "<br>" + configuration.getProperties().getProperty("about.info2") +
   				 "<br>" + configuration.getProperties().getProperty("about.info3") +
   				 "<br>&nbsp;&nbsp;&nbsp;RAKOTOMALALA Alain" +
   				 "<br>&nbsp;&nbsp;&nbsp;EVANO Nicolas" +
   				 "<br>&nbsp;&nbsp;&nbsp;ZHAO Ying" +
   				 "<br>&nbsp;&nbsp;&nbsp;AUNEAU Sylvie" +
   				 "<br>&nbsp;&nbsp;&nbsp;TCHOUNGA Olivier" +
   				 "</body></html>";
        	jLabelInfo = new JLabel(str);
        }
       
       
         
    	icon = new ImageIcon (this.getClass().getResource("/images/logo.jpg"));
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
        if(language == "Chinese")
        	jTabbedPane.addTab(new String(configuration.getProperties().getProperty("about.panel.about").getBytes("iso8859-1"), "utf-8"), jThanxPanel);
        else
        	jTabbedPane.addTab(configuration.getProperties().getProperty("about.panel.about"), jThanxPanel);
        
        jAffiliationsPanel.setName("Affiliations");
        jAffiliationsPanel.setLayout(new java.awt.GridLayout(1, 1));
        jAffiliationsPanel.add(jLabelAffiliation);
        if(language == "Chinese")
        	jTabbedPane.addTab(new String(configuration.getProperties().getProperty("about.panel.affiliations").getBytes("iso8859-1"), "utf-8"), jAffiliationsPanel);
        else
        	jTabbedPane.addTab(configuration.getProperties().getProperty("about.panel.affiliations"), jAffiliationsPanel);
        
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
	
	private JPanel jThanxPanel;
	private JPanel jAffiliationsPanel;
    private ImageIcon icon;
    private JLabel jLabelLogo;
    private JLabel jLabelInfo;
    private JLabel jLabelAffiliation;
    private JTabbedPane jTabbedPane;
}

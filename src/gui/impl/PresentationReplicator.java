package gui.impl;

import java.awt.Color;
import java.io.UnsupportedEncodingException;

import javax.swing.JLabel;

import stringloader.IConfigurationLoader;

import kernel.Module;

import controler.CReplicator;
import gui.APresentationModule;
import gui.impl.subpresentation.PresentationInPortImpl;
import gui.impl.subpresentation.PresentationOutPortImpl;

public class PresentationReplicator extends APresentationModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CReplicator control;
	private PresentationInPortImpl inPort;
	private PresentationOutPortImpl outPort1;
	private PresentationOutPortImpl outPort2;
	private PresentationOutPortImpl outPort3;
	private JLabel labelReplicator;
	private JLabel jLabelIn;
	//private String nameRepliactor = "MODULE Replicator";

	public PresentationReplicator(IConfigurationLoader configuration) throws UnsupportedEncodingException {
		// TODO Auto-generated constructor stub
		String language = configuration.getLanguage();
		setLayout(null);
		setBackground(Color.gray);
		setSize( 140, 200 );
		
		labelReplicator = new JLabel();
		if(language == "Chinese")
			labelReplicator.setText(new String(configuration.getProperties().getProperty("module.Replicator.title").getBytes("iso8859-1"), "utf-8"));
        else
        	labelReplicator.setText(configuration.getProperties().getProperty("module.Replicator.title"));
		labelReplicator.setBorder(new javax.swing.border.MatteBorder(null));
		labelReplicator.setHorizontalAlignment( javax.swing.SwingConstants.CENTER );
		
		
		inPort = new PresentationInPortImpl();
		outPort1 = new PresentationOutPortImpl();
		outPort2 = new PresentationOutPortImpl();
		outPort3 = new PresentationOutPortImpl();
		
		jLabelIn = new JLabel();
        if(language == "Chinese")
        	jLabelIn.setText(new String(configuration.getProperties().getProperty("module.Replicator.in").getBytes("iso8859-1"), "utf-8"));
        else
        	jLabelIn.setText(configuration.getProperties().getProperty("module.Replicator.in"));
        jLabelIn.setSize(50,50);
        jLabelIn.setLocation(0, (getHeight()/2) - (inPort.getHeight()/2) - 35);
        jLabelIn.setForeground(Color.white);
        add(jLabelIn);
		
		
		add(labelReplicator);
		add(inPort);
		inPort.setLocation(0,(getHeight()/2) - (inPort.getHeight()/2));
		add( outPort1 );
		outPort1.setLocation( getWidth() - outPort1.getWidth(), 
				(getHeight()/6) - (outPort1.getHeight()/6));
		
//		System.out.println("Position outPort1: "+ ((getHeight()/6) - (outPort1.getHeight()/6)));
		add( outPort2 );
		outPort2.setLocation( getWidth() - outPort2.getWidth(), 
				( getHeight() / 2) - ( outPort2.getHeight() / 2 ) );
		
//		System.out.println("Position outPort2: "+(( getHeight() / 2) - ( outPort2.getHeight() / 2 )));
		add( outPort3 );
		outPort3.setLocation( getWidth() - outPort3.getWidth(), 
				 ((getHeight()/2) -  (outPort3.getHeight()/2))+51 );
//		System.out.println("position outPort3: "+((((getHeight()))) -  (((outPort3.getHeight())))));
		
		setTitlePosition();
		
	}
	
	private void setTitlePosition() {
		labelReplicator.setSize( 400, 30 );
        labelReplicator.setLocation( ( getWidth() / 2 ) - ( labelReplicator.getWidth() / 2 ), 0 );
        labelReplicator.setForeground(Color.white);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public CReplicator getControl() {
		return control;
	}

	public void setControl(CReplicator control) {
		this.control = control;
	}
	
	public PresentationInPortImpl getInPort() {
		return inPort;
	}

	public void setInPort(PresentationInPortImpl inPort) {
		this.inPort = inPort;
	}

	public PresentationOutPortImpl getOutPort1() {
		return outPort1;
	}

	public void setOutPort1(PresentationOutPortImpl outPort1) {
		this.outPort1 = outPort1;
	}

	public PresentationOutPortImpl getOutPort2() {
		return outPort2;
	}

	public void setOutPort2(PresentationOutPortImpl outPort2) {
		this.outPort2 = outPort2;
	}

	public PresentationOutPortImpl getOutPort3() {
		return outPort3;
	}
	
	public void setOutPort3(PresentationOutPortImpl outPort3) {
		this.outPort3 = outPort3;
	}

	@Override
	public void setControl(Module module) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PresentationOutPortImpl getOutPort() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOutPort(PresentationOutPortImpl outPort) {
		// TODO Auto-generated method stub
		
	}
	
	
	private IConfigurationLoader configuration;

}

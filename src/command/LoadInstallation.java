package command;

import gui.APresentationModule;
import gui.impl.PresentationModuleZone;
import gui.impl.subpresentation.PresentationWire;

import java.awt.Component;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;

import listener.WireListener;

import stringloader.IConfigurationLoader;

import controler.CADSR;
import controler.CInPort;
import controler.COUT;
import controler.COutPort;
import controler.CReplicator;
import controler.CVCA;
import controler.CVCF;
import controler.CVCO;
import controler.CWire;

/**
 * Load exist installations (montages)
 */

public class LoadInstallation extends Command {

	@Override
	public void execute(Point p) {
		// TODO Auto-generated method stub
		InputStream loadStream = null;
		InputStreamReader ipsr = null;
		BufferedReader br = null;
		String line;
		deleteOldModules();
		outports = new TreeMap<Integer,COutPort>();
		inports = new TreeMap<Integer,CInPort>();
		try {
			
			loadStream = new FileInputStream( toUseToLoad );
    		ipsr = new InputStreamReader( loadStream );
    		br = new BufferedReader( ipsr );	
    		while( ( line = br.readLine() ) != null ){
    			loadLine( line );
    		}
		} catch ( FileNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		APresentationModule.setCurrentPortId(counterPort);
	}
	
	/**
	 * Load each line of exist installations (montages)
	 * Each line contains a module or a wire
	 * @param line
	 */
	
	private void loadLine( String line ){
		try {
			if( line.startsWith( "VCO" ) ){
				CVCO cVco = new CVCO( configuration, line );
				outports.put(cVco.getPresentation().getOutPort().getControl().getId(),
							 cVco.getPresentation().getOutPort().getControl() );
				counterPort++;
				inports.put(cVco.getPresentation().getInPort().getControl().getId(),
						 cVco.getPresentation().getInPort().getControl() );
				counterPort++;
				cVcos.put(counterVCO, cVco);
				getHorloge().addModuleObserver( cVco );
				( (PresentationModuleZone) getPlan() ).add( cVco.getPresentation(),0 );
				counterVCO++;
			} else if( line.startsWith( "VCA" ) ){
				CVCA cVca = new CVCA( configuration, line );
				outports.put( cVca.getPresentation().getOutPort().getControl().getId(),
							  cVca.getPresentation().getOutPort().getControl() );
				counterPort++;
				inports.put( cVca.getPresentation().getInPort().getControl().getId(),
							 cVca.getPresentation().getInPort().getControl() );
				counterPort++;
				inports.put( cVca.getPresentation().getAm().getControl().getId(),
						     cVca.getPresentation().getAm().getControl() );
				counterPort++;
				cVcas.put(this.counterVcas, cVca);
				this.counterVcas++;
				getHorloge().addModuleObserver( cVca );
				( (PresentationModuleZone) getPlan() ).add( cVca.getPresentation(),0 );
			} else if( line.startsWith( "ADSR" ) ){
				CADSR cAdsr = new CADSR( configuration, line );
				outports.put(cAdsr.getPresentation().getOutPort().getControl().getId(),
							 cAdsr.getPresentation().getOutPort().getControl() );
				counterPort++;
				inports.put(cAdsr.getPresentation().getInPort().getControl().getId(),
							cAdsr.getPresentation().getInPort().getControl() );
				counterPort++;
				cAdsrs.put( this.counterADSR, cAdsr );
				this.counterADSR++;
				getHorloge().addModuleObserver( cAdsr );
				( (PresentationModuleZone) getPlan() ).add( cAdsr.getPresentation(),0 );
			} else if ( line.startsWith( "VCF" ) ){
				CVCF cVcf = new CVCF( configuration, line );
				outports.put(cVcf.getPresentation().getOutPort().getControl().getId(),
							 cVcf.getPresentation().getOutPort().getControl() );
				counterPort++;
				inports.put(cVcf.getPresentation().getInPort().getControl().getId(),
							cVcf.getPresentation().getInPort().getControl() );
				counterPort++;
				inports.put(cVcf.getPresentation().getFmPort().getControl().getId(),
							cVcf.getPresentation().getFmPort().getControl() );
				counterPort++;
				cVcfs.put( this.counterVCF, cVcf );
				this.counterVCF++;
				getHorloge().addModuleObserver( cVcf );
				( ( PresentationModuleZone ) getPlan() ).add( cVcf.getPresentation(), 0 );
			} else if ( line.startsWith( "Out" ) ){
				COUT cOut = new COUT( line );
				inports.put(cOut.getPresentation().getInPort().getControl().getId(),
							cOut.getPresentation().getInPort().getControl() );
				counterPort++;
				cOuts.put(this.counterCout, cOut);
				this.counterCout++;
				getHorloge().addModuleObserver( cOut );
				( ( PresentationModuleZone ) getPlan() ).add( cOut.getPresentation(), 0 );
			} else if ( line.startsWith( "Replicator" ) ){
				CReplicator cReplicator = new CReplicator( configuration,line );
				outports.put(cReplicator.getPresentation().getOutPort().getControl().getId(),
							 cReplicator.getPresentation().getOutPort().getControl() );
				counterPort++;
				inports.put(cReplicator.getPresentation().getInPort().getControl().getId(),
							cReplicator.getPresentation().getInPort().getControl() );
				counterPort++;
				cReplicators.put(this.counterReplicator, cReplicator);
				this.counterReplicator++;
				getHorloge().addModuleObserver( cReplicator );
				( ( PresentationModuleZone) getPlan() ).add( cReplicator.getPresentation(), 0 );
			} else if ( line.startsWith( "Wire" ) ){
				CWire cWire = new CWire( line );
				cWire.getPresentation().setOutPort(
						outports.get( cWire.getPresentation().getOutPortId() ).getPresentation()
						);
				cWire.getPresentation().setInPort( inports.get( cWire.getPresentation().getInportID() ).getPresentation() );
				cWire.setModule(outports.get( cWire.getPresentation().getOutPortId()).getModule() );
				cWire.attachPorts();
				attachWirePresentation( cWire );
				( ( PresentationModuleZone ) getPlan() ).add( cWire.getPresentation(), 0 );
				cWire.getPresentation().setVisible( true );
			}
		} catch ( UnsupportedEncodingException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		( ( PresentationModuleZone ) getPlan() ).validate();
		( ( PresentationModuleZone ) getPlan() ).repaint();
	}
	
	private void attachWirePresentation( CWire toAttach){
		for(int i = 0; i < cVcos.size();i++){
			if( cVcos.get( i ).getPresentation().getInPort().getControl().getId() == toAttach.getPresentation().getInportID() ){
				cVcos.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
			if( cVcos.get( i ).getPresentation().getOutPort().getControl().getId() == toAttach.getPresentation().getOutPortId() ){
				cVcos.get( i ).getPresentation().getWires().add(toAttach.getPresentation() );
			}
		}
		for(int i = 0; i < cAdsrs.size();i++){
			if( cAdsrs.get( i ).getPresentation().getInPort().getControl().getId() == toAttach.getPresentation().getInportID() ){
				cAdsrs.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
			if( cAdsrs.get( i ).getPresentation().getOutPort().getControl().getId() == toAttach.getPresentation().getOutPortId() ){
				cAdsrs.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
		}
		for(int i = 0; i < cVcas.size();i++){
			if( cVcas.get( i ).getPresentation().getInPort().getControl().getId() == toAttach.getPresentation().getInportID() ){
				cVcas.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
			if( cVcas.get( i ).getPresentation().getAm().getControl().getId() == toAttach.getPresentation().getInportID() ){
				cVcas.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
			if( cVcas.get( i ).getPresentation().getOutPort().getControl().getId() == toAttach.getPresentation().getOutPortId() ){
				cVcas.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
		}
		for(int i = 0; i < cVcfs.size();i++){
			if( cVcfs.get( i ).getPresentation().getInPort().getControl().getId() == toAttach.getPresentation().getInportID() ){
				cVcfs.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
			if( cVcfs.get( i ).getPresentation().getFmPort().getControl().getId() == toAttach.getPresentation().getInportID() ){
				cVcfs.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
			if( cVcfs.get( i ).getPresentation().getOutPort().getControl().getId() == toAttach.getPresentation().getOutPortId() ){
				cVcfs.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
		}
		for(int i = 0; i < cReplicators.size();i++){
			if( cReplicators.get( i ).getPresentation().getInPort().getControl().getId() == toAttach.getPresentation().getInportID() ){
				cReplicators.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
			if( cReplicators.get( i ).getPresentation().getOutPort().getControl().getId() == toAttach.getPresentation().getOutPortId() ){
				cReplicators.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
		}
		for(int i = 0; i < cOuts.size();i++){
			if( cOuts.get( i ).getPresentation().getInPort().getControl().getId() == toAttach.getPresentation().getInportID() ){
				cOuts.get( i ).getPresentation().getWires().add(toAttach.getPresentation());
			}
		}
		WireListener wireListener = new WireListener();
		wireListener.setCurrentPlan( ( PresentationModuleZone ) getPlan() );
		wireListener.setWire( toAttach.getPresentation() );
		toAttach.getPresentation().setWireListener( wireListener );
	}
	
	/**
	 * Delete modules which exist before
	 * Before we load the new installation (montage)
	 */
	
	private void deleteOldModules(){
		
		PresentationWire wire = null;
		int wiresSize;
		System.out.println( "Remove a module!" );
		Component [] components = ( ( PresentationModuleZone ) getPlan() ).getComponents();
		for(int i = 0; i < components.length; i++){
			if(components[i] instanceof APresentationModule){
				APresentationModule presentationToRemove = ( APresentationModule ) components[i];
				super.getHorloge().removeModuleObserver( presentationToRemove.getControl() );
				//TODO remove each wire at this moment
				wiresSize = presentationToRemove.getWires().size();
				for( int z = 0; z < wiresSize; z++ ){
					wire = presentationToRemove.getWires().get( 0 );
					wire.getControl().detachPorts();
					( ( APresentationModule ) wire.getOutPort().getParent() ).getWires().remove( wire );
					( ( APresentationModule ) wire.getInPort().getParent() ).getWires().remove( wire );
					( ( PresentationModuleZone ) getPlan() ).remove( wire );
					( ( PresentationModuleZone ) getPlan() ).validate();
					( ( PresentationModuleZone ) getPlan() ).repaint();
				}
				( ( PresentationModuleZone ) getPlan() ).remove(presentationToRemove);
				( ( PresentationModuleZone ) getPlan() ).validate();
				( ( PresentationModuleZone ) getPlan() ).repaint();
			}
		}
		
	}
	
	public File getToUseToLoad() {
		
		return toUseToLoad;
		
	}

	public void setToUseToLoad( File toUseToLoad ) {
		
		this.toUseToLoad = toUseToLoad;
		
	}
	
	public IConfigurationLoader getConfiguration() {
		return configuration;
	}

	public void setConfiguration(IConfigurationLoader configuration) {
		this.configuration = configuration;
	}
	
	private Map<Integer,COutPort> outports = new TreeMap<Integer,COutPort>();
	private Map<Integer,CInPort> inports = new TreeMap<Integer,CInPort>();
	private Map<Integer,CADSR> cAdsrs = new TreeMap<Integer,CADSR>();
	private int counterADSR = 0;
	private Map<Integer,CVCO> cVcos = new TreeMap<Integer,CVCO>();
	private int counterVCO = 0;
	private Map<Integer,CReplicator> cReplicators = new TreeMap<Integer,CReplicator>();
	private int counterReplicator = 0;
	private Map<Integer,CVCF> cVcfs = new TreeMap<Integer,CVCF>();
	private int counterVCF = 0;
	private Map<Integer,CVCA> cVcas = new TreeMap<Integer,CVCA>();
	private int counterVcas = 0;
	private Map<Integer,COUT> cOuts = new TreeMap<Integer,COUT>();
	private int counterCout = 0;
	private int counterPort = 0;
	
	private File toUseToLoad;
	
	private IConfigurationLoader configuration;

}

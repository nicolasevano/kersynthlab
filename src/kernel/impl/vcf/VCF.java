package kernel.impl.vcf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import kernel.HorlogeSubject;
import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;
import kernel.impl.HorlogeImpl;
import kernel.impl.InPortImpl;
import kernel.impl.Out;
import kernel.impl.OutPortImpl;
import kernel.impl.vco.VCO;
import kernel.impl.vco.VCO.WaveForm;

public class VCF implements Module {

	public VCF(){
		observers = new ArrayList<Observer>();
		inPorts = new TreeMap<String,InPort>();
		inPorts.put( "fm", new InPortImpl() );
		inPorts.put( "in", new InPortImpl() );
		outPorts = new TreeMap<String,OutPort>();
		outPorts.put( "out", new OutPortImpl() );
	}
	
	/**
	 * Notify each in port subscriber of this module.
	 */
	@Override
	public void masterNotify() {
		for( Observer observer:observers ){
			observer.update();
		}
	}

	/**
	 * Add a new in port subscriber to this VCF instance.
	 * @param toAdd new in port subscriber.
	 */
	@Override
	public void addObserver( Observer toAdd ) {
		// TODO Auto-generated method stub
		observers.add( toAdd );
		( ( InPortImpl )toAdd ).setModule( this );
	}

	/**
	 * Remove a subscriber to this VCF instance.
	 * @param toRemove in port subscriber to remove.
	 */
	@Override
	public void removeObserver(Observer toRemove) {
		// TODO Auto-generated method stub
		observers.remove( toRemove );
	}

	@Override
	public void moduleFunction() {
		// TODO Auto-generated method stub
		double cutoff = 0;
		if(!inPorts.get("fm").isEmpty())
			cutoff = 20. * Math.pow( 2, this.baseVCF ) + 
					 Math.pow(2, this.attVCF * ( ( this.inPorts.get( "fm" ).getValue() / 32768 ) * 5 ) );
		else
			cutoff = 20. * Math.pow( 2, this.baseVCF );
		double f = 2 * cutoff / HorlogeImpl.getSampleRate(); //[0 - 1]
		double k = 3.6 * f - 1.6 * f * f -1; //(Empirical tunning)
		double p = ( k+1 ) * 0.5;
		if(!inPorts.get("in").isEmpty()){
			//Loop
			//--Inverted feed back for corner peaking
			// no resonance
			x = ( this.inPorts.get("in").getValue() / 32768 ) * 5.0 ; /*- r*y4;*/

			//Four cascaded onepole filters (bilinear transform)
			//
				y1 =  x * p + oldx * p - k * y1;
				if (y1.isInfinite() || y1.isNaN()) {
					y1 = Double.valueOf( 0 );
				}
				y2 = y1 * p + oldy1 * p - k * y2;
				if (y2.isInfinite() || y2.isNaN()) {
					y2 = Double.valueOf( 0 );
				}
				y3 = y2 * p + oldy2 * p - k * y3;
				if (y3.isInfinite() || y3.isNaN()) {
					y3 = Double.valueOf( 0 );
				}
				y4 = y3 * p + oldy3 * p - k * y4;
				if (y4.isInfinite() || y4.isNaN() || y4 > 7.0) {
					y4 = Double.valueOf( 0 );
				}
				
			//Clipper band limited sigmoid
			y4 = y4 - ( Math.pow( y4.intValue(), 3 ) )/6;
			if (y4.isInfinite() || y4.isNaN()) {
				y4 = Double.valueOf( 0 );
			}
			oldx = x;
			oldy1 = y1;
			oldy2 = y2;
			oldy3 = y3;	
			outPorts.get( "out" ).setValue( (int)( (y4 / 5) * 32768 ) );
			masterNotify();
			( ( OutPortImpl ) outPorts.get( "out" ) ).removeHead();
		}
	}

	public static final void main( String...args ){
		VCO vco = new VCO();
		VCF vcf = new VCF();
		Out out = new Out();
		vco.addObserver( vcf.getInPorts().get( "in" ) );
		vcf.addObserver( out.getInPorts().get( "in" ) );
		vcf.setAttVCF( 8 );
		vcf.setBaseVCF( 6 );
		vco.setAtt( 1 );
		vco.setBase( 128 );
		vco.setPitch( 30 );
		vco.setWaveForm( WaveForm.SQUARE );
		HorlogeSubject timeBase = new HorlogeImpl();
		timeBase.addModuleObserver( vco );
		timeBase.addModuleObserver( vcf );
		timeBase.addModuleObserver( out );
		HorlogeImpl.setSampleRate( 44100 );
		( ( HorlogeImpl ) timeBase ).start();
		try {
			Thread.sleep( 60000 );
		} catch ( InterruptedException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		( ( HorlogeImpl ) timeBase ).stop();
		System.exit(0);
	}
	
	@Override
	public Map<String, InPort> getInPorts() {
		// TODO Auto-generated method stub
		return inPorts;
	}

	@Override
	public Map<String, OutPort> getOutPorts() {
		// TODO Auto-generated method stub
		return outPorts;
	}
	
	public int getAttVCF() {
		return attVCF;
	}

	public void setAttVCF(int attVCF) {
		this.attVCF = attVCF;
	}

	public int getBaseVCF() {
		return baseVCF;
	}

	public void setBaseVCF(int baseVCF) {
		this.baseVCF = baseVCF;
	}
	
	
	/**
	 * current vco att value
	 */
	private int attVCF;
	
	/**
	 * current base value
	 */
	private int baseVCF;
	
	/**
	 * Contains each pair name and in port of this VCA instance.
	 */
	private Map< String,InPort > inPorts;

	/**
	 * Contains each pair name and out port of this VCA instance.
	 */
	private Map< String,OutPort > outPorts;

	/**
	 * In port subcriber list on this VCA instance.
	 */
	private List<Observer> observers;

	
	private int sampleComputer = 1;
	
	/** moog vcf variable*/
	private Double y1 = Double.valueOf(0);
	private Double y2 = Double.valueOf(0);
	private Double y3 = Double.valueOf(0);
	private Double y4 = Double.valueOf(0);
	private Double x = Double.valueOf(0);
	private Double oldx = Double.valueOf(0);
	private Double oldy1 = Double.valueOf(0);
	private Double oldy2 = Double.valueOf(0);
	private Double oldy3 = Double.valueOf(0);

}

package kernel.impl.vcf;

import java.util.Map;

import kernel.InPort;
import kernel.Module;
import kernel.Observer;
import kernel.OutPort;

public class VCF implements Module {

	@Override
	public void masterNotify() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addObserver(Observer toAdd) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(Observer toRemove) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moduleFunction() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, InPort> getInPorts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, OutPort> getOutPorts() {
		// TODO Auto-generated method stub
		return null;
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

	

}

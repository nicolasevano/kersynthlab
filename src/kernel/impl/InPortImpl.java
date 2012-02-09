package kernel.impl;

import java.util.LinkedList;
import java.util.Queue;

import kernel.InPort;
import kernel.Module;
import kernel.Subject;
/**
 * InPort implementation
 * @author nicolas
 *
 */
public class InPortImpl implements InPort {

	/**
	 * Public constructor.
	 */
	public InPortImpl(){
		buffer = new  LinkedList< Integer >();
	}
	
	/**
	 * Return head value on in port buffer instance.
	 */
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return buffer.poll();
	}

	/**
	 * Add a value on the current in port buffer instance.
	 */
	@Override
	public void setValue( int value ) {
		// TODO Auto-generated method stub
		buffer.add( value );
	}
	
	/**
	 * IsEmpty function. 
	 * @return true if current in port instance buffer is empty.
	 */
	@Override
	public boolean isEmpty(){
		return buffer.isEmpty();
	}

	/**
	 * Update function set a value on the in port buffer by getting the one on the output buffer.
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.setValue( ( ( Module ) module ).getOutPorts().get( "out" ).getValue() );
	}
	
	/**
	 * SetModule set the current module subject producer output on the in port buffer.
	 * @param module module subject producer
	 */
	public void setModule(Subject module) {
		this.module = module;
	}
	
	/**
	 * In port current instance buffer.
	 */
	private Queue<Integer> buffer;
	
	/**
	 * Module subject producer. 
	 */
	private Subject module;
	
}

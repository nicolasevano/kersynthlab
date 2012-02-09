package kernel.impl;

import java.util.LinkedList;
import java.util.Queue;

import kernel.OutPort;

/**
 * OutPortImpl OutPort implementation.
 * @author nicolas
 *
 */
public class OutPortImpl implements OutPort{
	
	/**
	 * public constructor.
	 */
	public OutPortImpl(){
		buffer = new LinkedList<Integer>();
	}

	/**
	 * Return head value on current out port buffer.
	 */
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return buffer.element();
	}

	/**
	 * Add a value on current out port buffer.
	 */
	@Override
	public void setValue(int value) {
		// TODO Auto-generated method stub
		buffer.add( value );
	}
	
	/**
	 * Remove head value from the current output buffer.
	 */
	public void removeHead(){
		buffer.poll();
	}
	
	/**
	 * Clear current output buffer.
	 */
	public void clear(){
		buffer.clear();
	}
	
	/**
	 * Current out port buffer.
	 */
	private Queue<Integer> buffer;
	
}

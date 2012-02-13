package kernel.impl;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

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
		buffer = new LinkedBlockingQueue< Integer >();
	}

	/**
	 * Return head value on current out port buffer.
	 */
	@Override
	public synchronized int getValue() {
		// TODO Auto-generated method stub
		return buffer.element();
	}

	/**
	 * Add a value on current out port buffer.
	 */
	@Override
	public synchronized void setValue(int value) {
		//System.out.println("add a value in out:" + value);
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

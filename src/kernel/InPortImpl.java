package kernel;

import java.util.LinkedList;
import java.util.Queue;

public class InPortImpl implements InPort {

	public InPortImpl(){
		buffer = new  LinkedList< Integer >();
	}
	
	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return buffer.poll();
	}

	@Override
	public void setValue( int value ) {
		// TODO Auto-generated method stub
		buffer.add( value );
	}
	
	@Override
	public boolean isEmpty(){
		return buffer.isEmpty();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		this.setValue( ( ( Module ) module ).getOutPorts().get( "out" ).getValue() );
	}
	
	public void setModule(Subject module) {
		this.module = module;
	}
	
	private Queue<Integer> buffer;
	private Subject module;
	
}

package kernel;

import java.util.LinkedList;
import java.util.Queue;

public class OutPortImpl implements OutPort{
	
	public OutPortImpl(){
		buffer = new LinkedList<Integer>();
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return buffer.element();
	}

	@Override
	public void setValue(int value) {
		// TODO Auto-generated method stub
		buffer.add( value );
	}
	
	public void removeHead(){
		buffer.poll();
	}
	
	public void clear(){
		buffer.clear();
	}
	
	private Queue<Integer> buffer;
	
}

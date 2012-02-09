
package kernel;

public interface InPort extends Observer {
	void setValue(int value) ;

	int getValue() ;

	boolean isEmpty();

}

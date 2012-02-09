
package kernel;

interface InPort extends Observer {
	void setValue(int value) ;

	int getValue() ;

	boolean isEmpty();

}

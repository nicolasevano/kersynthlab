
package kernel;

interface Subject {
	void masterNotify() ;

	void addObserver(Observer toAdd) ;

	void removeObserver(Observer toRemove) ;

}

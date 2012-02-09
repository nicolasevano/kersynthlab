
package kernel;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class HorlogeImpl implements HorlogeSubject {

	public HorlogeImpl(){
		observers = new ArrayList<HorlogeObserver>();
		sampleRate = ( 10000 / 441 );
	}
	@Override
	public void addModuleObserver( HorlogeObserver toAdd ) {
		// TODO Auto-generated method stub
		observers.add( toAdd );
	}

	@Override
	public void removeModuleObserver( HorlogeObserver toRemove ) {
		// TODO Auto-generated method stub
		observers.remove( toRemove );
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		for(HorlogeObserver observer : observers){
			observer.moduleFunction();
		}
	}

	public void start(){
		timer = new Timer();
        timer.schedule (new TimerTask() {
            public void run(){
            	tick();
            }
        }, 1, sampleRate );
	}
	
	public void stop(){
		timer.cancel();
	}
	
	public int getSampleRate() {
		return sampleRate;
	}

	public void setSampleRate( int sampleRate ) {
		this.sampleRate = sampleRate;
	}
	
	/**
	 * sample period 22,7 us
	 */
	private int sampleRate;
	
	private Timer timer;
	
	private List<HorlogeObserver> observers;

}

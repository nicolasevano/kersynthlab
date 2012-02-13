
package kernel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import kernel.HorlogeObserver;
import kernel.HorlogeSubject;
/**
 * implementation clock implementation
 * @author nicolas
 *
 */
public class HorlogeImpl implements HorlogeSubject {

	/**
	 * Public constructor initiate each list
	 */
	public HorlogeImpl(){
		observers = new ArrayList<HorlogeObserver>();
		outs = new ArrayList<Out>();
		sampleRate = 44100;
		timerScheduler = Executors.newScheduledThreadPool( 1 );
	}
	
	/**
	 * Function addModuleObserver to current clock instance
	 * @param HorlogeObserver toAdd clock observer to add on the current clock instance
	 */
	@Override
	public void addModuleObserver( HorlogeObserver toAdd ) {
		// TODO Auto-generated method stub
		observers.add( toAdd );
	}

	/**
	 * Function removeModuleObserver remove a clock observer
	 * @param HorlogeObserver toRemove clock observer to remove on the current clock instance
	 */
	@Override
	public void removeModuleObserver( HorlogeObserver toRemove ) {
		// TODO Auto-generated method stub
		observers.remove( toRemove );
	}
	
	/**
	 * Function tick call each moduleFunction from clock observer on a thread 
	 * however not for out observer instance. 
	 */
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		for(final HorlogeObserver observer : observers){
			if(!(observer instanceof Out))
			( ( ScheduledExecutorService ) timerScheduler ).schedule( 
					new Callable<Integer>(){

						@Override
						public Integer call() throws Exception {
							// TODO Auto-generated method stub
							observer.moduleFunction();
							return 0;
						}

					},0,TimeUnit.MILLISECONDS);
		}
	}

	/**
	 * Start function launch clock synchronization of each clock module observer.
	 */
	public void start(){
		timer = new Timer();
        timer.schedule (new TimerTask() {
            public void run(){
            	tick();
            }
        }, 1, 2 );
        for(final HorlogeObserver observer : observers){
			if( observer instanceof Out){
				( ( Out ) observer).start();
				outs.add( ( ( Out ) observer ) );
			}
		}
        System.out.println( "Horloge started!" );
	}
	
	/**
	 * Stop function break clock synchronization of each module observer.
	 */
	public void stop(){
		for( Out out:outs ){
			out.stop();
		}
		outs.clear();
		try {
			Thread.sleep( 500 );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println( "Horloge stopped!" );
		timer.cancel();
	}
		
	public static int getSampleRate(){
		return HorlogeImpl.sampleRate;
	}
	
	
	public static void setSampleRate( int sampleRate ){
		HorlogeImpl.sampleRate = sampleRate;
	}
	
	/**
	 * @param sampleRate: sample rate production on sound card
	 */
	protected static int sampleRate;
	
	/**
	 * tick function scheduler
	 */
	private Timer timer;
	
	/**
	 * clock observer list
	 */
	private List<HorlogeObserver> observers;
	
	/**
	 * module function clock observer launcher 
	 */
	private ExecutorService timerScheduler;

	/**
	 * sound card list
	 */
	private List<Out> outs;
}

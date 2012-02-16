
package kernel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kernel.HorlogeObserver;
import kernel.HorlogeSubject;

/**
 * implementation clock implementation
 * @author nicolas
 *
 */
public class HorlogeImpl3 implements HorlogeSubject {

	/**
	 * Public constructor initiate each list
	 */
	public HorlogeImpl3(){
		observers = new ArrayList<HorlogeObserver>();
		outs = new ArrayList<Out3>();
		toCalls = new ArrayList<Callable>();
		sampleRate = 44100;
		timerScheduler = /*Executors.newScheduledThreadPool( 1 )*/Executors.newCachedThreadPool();
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
	public synchronized void tick() {
		// TODO Auto-generated method stub
		for(final Callable toCall : toCalls){
			//( ( ScheduledExecutorService ) timerScheduler ).submit(toCall);
			timerScheduler.submit( toCall );
			//( ( ScheduledExecutorService ) timerScheduler ).schedule( toCall,0,TimeUnit.MILLISECONDS);
		}
	}

	/**
	 * Start function launch clock synchronization of each clock module observer.
	 */
	public void start(){
		timer = new Timer();
		for(final HorlogeObserver observer : observers){
			if(!(observer instanceof Out3)){
				toCalls.add(new Callable<Integer>(){
					@Override
					public Integer call() throws Exception {
						// TODO Auto-generated method stub
						observer.moduleFunction();
						return 0;
					}
				});
			}
		}
		//timerScheduler.submit(new Callable(){
		//	@Override
		//	public Object call() throws Exception {
				// TODO Auto-generated method stub
		//		isRunning = true;
		//		while(isRunning){
		//			tick();
		//		}
		//		return null;
		//	}
		//});
		//Executors.newSingleThreadExecutor().submit(new Runnable(){

		//	@Override
		//	public void run() {
				// TODO Auto-generated method stub
		//		isRunning = true;
		//		while(isRunning){
		//			tick();
					//for(int i = 0; i < 200; i++){}
		//		}
		//	}
			
		//});
        timer.schedule (new TimerTask() {
            @Override
			public void run(){
            	//isRunning = true;
            	//while(isRunning){
            	tick();	
            	//}
            }
        }, 0,1);
        for(final HorlogeObserver observer : observers){
			if( observer instanceof Out3){
				( ( Out3 ) observer).start();
				outs.add( ( ( Out3 ) observer ) );
			}
		}
        System.out.println( "Horloge started!" );
	}
	
	/**
	 * Stop function break clock synchronization of each module observer.
	 */
	public void stop(){
		for( Out3 out:outs ){
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
		timerScheduler.shutdownNow();
		//timer.cancel();
		//isRunning = false;
		toCalls.clear();
	}
		
	public static int getSampleRate(){
		return HorlogeImpl3.sampleRate;
	}
	
	
	public static void setSampleRate( int sampleRate ){
		HorlogeImpl3.sampleRate = sampleRate;
	}
	
	/**
	 * @param sampleRate: sample rate production on sound card
	 */
	protected static int sampleRate;
	
	/**
	 * tick function scheduler
	 */
	private Timer timer;
	
	private boolean isRunning;
	
	/**
	 * clock observer list
	 */
	private List<HorlogeObserver> observers;
	
	private List<Callable> toCalls;
	/**
	 * module function clock observer launcher 
	 */
	private ExecutorService timerScheduler;

	/**
	 * sound card list
	 */
	private List<Out3> outs;
}

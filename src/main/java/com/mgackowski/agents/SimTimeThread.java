package com.mgackowski.agents;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * A simple timing mechanism; requires tick rate and a list of Timed objects (registered
 * observers). Fires an event (tick) as close to the tick rate as possible.
 * 
 * @author mgackowski
 * Extra credit: Eli Delventhal
 */
public class SimTimeThread extends Thread {
	
	private static long SECOND = 1000000000;
	
	private static Logger LOG = Logger.getLogger(SimTimeThread.class);
	private static float WAKE_TO_TICK_RATIO = 1; //increase to up precision but load CPU
	
	long updateFrequency;
	List<Timed> registeredProcesses;
	long nanosBetweenTicks;
	
	public SimTimeThread(long updateFrequency, List<Timed> registeredProcesses) {
		super("LOGIC");	// Thread name
		this.updateFrequency = updateFrequency;
		this.nanosBetweenTicks = (long) (SECOND / updateFrequency);
		this.registeredProcesses = registeredProcesses;
	}

	public double getUpdateFrequency() {
		return updateFrequency;
	}

	public void setUpdateFrequency(long updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public void run() {
		
		LOG.debug("nanosBetweenTicks=" + nanosBetweenTicks);
		
		double currentTime = System.nanoTime();
		double lastPlannedTickTime = currentTime;
		long millisBetweenWakes = (long) ((nanosBetweenTicks / 1000000) / WAKE_TO_TICK_RATIO);
		
		while(updateFrequency > 0) {
			currentTime = System.nanoTime();
			if (currentTime - lastPlannedTickTime >= nanosBetweenTicks) {
			
				tickAll();
				lastPlannedTickTime += nanosBetweenTicks;
				LOG.debug("Tick");
				
			}
			
            while (currentTime - lastPlannedTickTime <= nanosBetweenTicks)
            {
               try {
            	   Thread.sleep(millisBetweenWakes); 
            	   }
               catch(Exception e) {
            	   LOG.info("Inter-update sleep interrupted.");
               }
               currentTime = System.nanoTime();
            }
		}
	}
	
	private void tickAll() {
		for(Timed process : registeredProcesses) {
			process.tick();
		}
	}

}

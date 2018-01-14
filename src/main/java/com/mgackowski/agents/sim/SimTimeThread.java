package com.mgackowski.agents.sim;

import java.util.List;

import org.apache.log4j.Logger;

import com.mgackowski.agents.agent.processes.Timed;

/**
 * A simple timing mechanism; requires tick rate and a list of Timed objects (registered
 * observers). Fires an event (tick) as close to the tick rate as possible.
 * 
 * @author mgackowski
 * Extra credit: Eli Delventhal
 */
public class SimTimeThread extends Thread {
	
	private static Logger LOG = Logger.getLogger(SimTimeThread.class);
	
	private static float WAKE_TO_TICK_RATIO = 1; // increase to up precision but load CPU
	
	List<Timed> registeredProcesses;
	long targetUpdateFrequency;
	long targetMillisBetweenTicks;
	
	public SimTimeThread(long updateFrequency, List<Timed> registeredProcesses) {
		super("[logic]");	// thread name
		this.targetUpdateFrequency = updateFrequency;
		this.targetMillisBetweenTicks = (long) (1000 / updateFrequency);
		this.registeredProcesses = registeredProcesses;
	}

	public double getUpdateFrequency() {
		return targetUpdateFrequency;
	}

	public void setUpdateFrequency(long updateFrequency) {
		this.targetUpdateFrequency = updateFrequency;
	}

	public void run() {
		
		LOG.debug("targetMillisBetweenTicks=" + targetMillisBetweenTicks);
		
		double currentTime = System.currentTimeMillis();
		double lastPlannedTickTime = currentTime;
		long millisBetweenWakes = (long) (targetMillisBetweenTicks / WAKE_TO_TICK_RATIO);
		
		while(targetUpdateFrequency > 0) {
			currentTime = System.currentTimeMillis();
			if (currentTime - lastPlannedTickTime >= targetMillisBetweenTicks) {
			
				tickAll();
				lastPlannedTickTime += targetMillisBetweenTicks;
				
			}
			
            while (currentTime - lastPlannedTickTime <= targetMillisBetweenTicks)
            {
               try {
            	   Thread.sleep(millisBetweenWakes); 
            	   }
               catch(Exception e) {
            	   LOG.info("Inter-update sleep interrupted.");
               }
               currentTime = System.currentTimeMillis();
            }
		}
	}
	
	private void tickAll() {
		for(Timed process : registeredProcesses) {
			process.tick();
		}
		LOG.debug("Ticked " + registeredProcesses.size() + " processes");
	}

}

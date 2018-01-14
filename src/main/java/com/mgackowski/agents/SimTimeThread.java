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
	
	static Logger LOG = Logger.getLogger(SimTimeThread.class);
	
	double updateFrequency;
	List<Timed> registeredProcesses;
	double nanosBetweenTicks;
	
	public SimTimeThread(double updateFrequency, List<Timed> registeredProcesses) {
		super("SIM");
		this.updateFrequency = updateFrequency;
		this.nanosBetweenTicks = 1000000000 / updateFrequency;
		this.registeredProcesses = registeredProcesses;
	}

	public double getUpdateFrequency() {
		return updateFrequency;
	}

	public void setUpdateFrequency(double updateFrequency) {
		this.updateFrequency = updateFrequency;
	}

	public void run() {
		
		double currentTime = System.nanoTime();
		double lastPlannedTickTime = currentTime;
		
		while(updateFrequency > 0) {
			currentTime = System.nanoTime();
			if (currentTime - lastPlannedTickTime >= updateFrequency) {
			
				tickAll();
				lastPlannedTickTime += nanosBetweenTicks;
				LOG.debug("Tick");
				
			}
		}
	}
	
	private void tickAll() {
		for(Timed process : registeredProcesses) {
			process.tick();
		}
	}

}

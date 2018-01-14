package com.mgackowski.agents;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
	
	long tickTarget;
	
	List<Timed> timedProcesses = new ArrayList<Timed>();
	List<Agent> agents = new ArrayList<Agent>();
	
	public Simulation(long tickTarget) {
		this.tickTarget = tickTarget;
	}

	public void init() {
		
		Agent alice = new Agent("Alice");
		agents.add(alice);
		alice.init();
		timedProcesses.addAll(alice.getProcesses());
		
		Agent bob = new Agent("Bob");
		agents.add(bob);
		bob.init();
		timedProcesses.addAll(bob.getProcesses());
		
		System.out.println(timedProcesses);
	}
	
	public void simulate() {
		
		SimTimeThread time = new SimTimeThread(tickTarget, timedProcesses);
		time.start();
		
	}
	
	/*
	//temporary solution
	private void loop() {
		while(true){
			for (Timed process : timedProcesses) {
				process.tick();
			}
			
			//temp
			System.out.println(agents);
			
			try {
				Thread.sleep(tickTarget);
			} catch (InterruptedException e) {
				System.out.println("Main thread interrupted!");
				e.printStackTrace();
			}
		}
	}*/

}

package com.mgackowski.agents;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mgackowski.agents.AgentFactory.AgentPreset;

public class Simulation {
	
	private Logger LOG = Logger.getLogger(Simulation.class);
	
	long tickTarget;
	
	List<Timed> timedProcesses = new ArrayList<Timed>();
	List<Agent> agents = new ArrayList<Agent>();
	
	AgentFactory agentFactory = new AgentFactory();
	
	public Simulation(long tickTarget) {
		this.tickTarget = tickTarget;
	}

	public void init() {
		
		//Extract to AgentManager class
		
		Agent alice = agentFactory.getAgent(AgentPreset.DEFAULT, "Alice");
		agents.add(alice);
		alice.initProcesses();
		timedProcesses.addAll(alice.getProcesses());
		
		Agent bob = agentFactory.getAgent(AgentPreset.DEFAULT, "Bob");
		agents.add(bob);
		bob.initProcesses();
		timedProcesses.addAll(bob.getProcesses());
		
		LOG.info(timedProcesses);
	}
	
	public void simulate() {
		
		SimTimeThread time = new SimTimeThread(tickTarget, timedProcesses);
		time.start();
		LOG.info("Simulation started.");
		
	}

}

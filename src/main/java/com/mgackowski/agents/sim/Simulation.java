package com.mgackowski.agents.sim;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mgackowski.agents.agent.Agent;
import com.mgackowski.agents.agent.AgentManager;
import com.mgackowski.agents.agent.AgentFactory.AgentPreset;
import com.mgackowski.agents.agent.processes.Timed;

public class Simulation {
	
	private Logger LOG = Logger.getLogger(Simulation.class);
	
	long tickTarget;
	
	List<Timed> timedProcesses = new ArrayList<Timed>();
	AgentManager agentManager = new AgentManager(timedProcesses);
	
	List<Agent> agents = new ArrayList<Agent>();
	
	public Simulation(long tickTarget) {
		this.tickTarget = tickTarget;
	}

	public void init() {
		
		agentManager.createAgent(AgentPreset.DEFAULT, "Alice");
		agentManager.createAgent(AgentPreset.DEFAULT, "Bob");
		
	}
	
	public void simulate() {
		
		SimTimeThread time = new SimTimeThread(tickTarget, timedProcesses);
		time.start();
		LOG.info("Simulation started.");
		
	}

}

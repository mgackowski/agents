package com.mgackowski.agents.agent;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mgackowski.agents.agent.AgentFactory.AgentPreset;
import com.mgackowski.agents.agent.processes.Timed;

public class AgentManager {
	
	private static Logger LOG = Logger.getLogger(AgentManager.class);
	
	AgentFactory agentFactory = new AgentFactory();
	List<Agent> agents = new ArrayList<Agent>();
	List<Timed> processRegistry;
	
	public AgentManager(List<Timed> processRegistry) {
		this.processRegistry = processRegistry;
	}

	public Agent createAgent(AgentPreset preset, String name) {
		
		Agent newAgent = agentFactory.getAgent(preset, name);
		processRegistry.addAll(newAgent.getProcesses());
		newAgent.initProcesses();
		agents.add(newAgent);
		
		LOG.info("New agent created; Agent=" + newAgent);
		return newAgent;
		
	}
	
	public boolean destroyAgent(Agent agent) {
		
		agents.remove(agent);
		
		LOG.info("Agent removed; Agent=" + agent);
		return true;
		
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public List<Timed> getProcessRegistry() {
		return processRegistry;
	}

}

package com.mgackowski.agents.agent;

import java.util.ArrayList;
import java.util.List;

import com.mgackowski.agents.agent.needs.Needs;
import com.mgackowski.agents.agent.processes.Deterioration;
import com.mgackowski.agents.agent.processes.Timed;
import com.mgackowski.agents.agent.traits.Traits;

public class Agent {
	
	
	private String name;
	
	private List<Timed> processes = new ArrayList<Timed>();
	private Needs needs;
	private Traits traits;
	
	public Agent(String name, List<Timed> processes, Needs needs, Traits traits) {
		this.name = name;
		this.processes = processes;
		this.needs = needs;
		this.traits = traits;
	}

	public void initProcesses() {
		processes.add(new Deterioration(needs, traits));
	}

	public String getName() {
		return name;
	}

	public List<Timed> getProcesses() {
		return processes;
	}

	public Needs getNeeds() {
		return needs;
	}

	@Override
	public String toString() {
		return "Agent [name=" + name + ", processes=" + processes + ", needs=" + needs + "]";
	}

}

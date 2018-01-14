package com.mgackowski.agents;

import java.util.ArrayList;
import java.util.List;

public class Agent {
	
	
	private String name;
	
	private List<Timed> processes = new ArrayList<Timed>();
	private Needs needs;
	
	public Agent(String name, List<Timed> processes, Needs needs) {
		this.name = name;
		this.processes = processes;
		this.needs = needs;
	}

	public void initProcesses() {
		processes.add(new Deterioration(needs));
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

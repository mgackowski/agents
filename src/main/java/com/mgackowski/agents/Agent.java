package com.mgackowski.agents;

import java.util.ArrayList;
import java.util.List;

public class Agent {
	//defer most of this to factories
	
	private String name;
	
	private List<Timed> processes = new ArrayList<Timed>();
	private Needs needs = new Needs();
	
	public Agent(String name) {
		this.name = name;
	}

	public void init() {
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

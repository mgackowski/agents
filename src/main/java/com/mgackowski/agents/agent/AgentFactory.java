package com.mgackowski.agents.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mgackowski.agents.agent.needs.NeedName;
import com.mgackowski.agents.agent.needs.Needs;
import com.mgackowski.agents.agent.processes.Deterioration;
import com.mgackowski.agents.agent.processes.Timed;

public class AgentFactory {
	
	public enum AgentPreset {
		DEFAULT
	}
	
	public Agent getAgent(AgentPreset preset, String name) {
		
		Map<NeedName, Float> needMap = new HashMap<NeedName, Float>();
		List<Timed> processes = new ArrayList<Timed>();
		Needs needs;
		
		switch(preset) {
			case DEFAULT:
				needMap.put(NeedName.FOOD, 100f);
				needMap.put(NeedName.ENERGY, 100f);
				needs = new Needs(needMap);
				processes.add(new Deterioration(needs));
				break;
			default:
				break;
		}
		return new Agent(name, processes, new Needs(needMap));
	}

}

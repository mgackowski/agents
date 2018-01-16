package com.mgackowski.agents.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mgackowski.agents.agent.needs.NeedName;
import com.mgackowski.agents.agent.needs.Needs;
import com.mgackowski.agents.agent.processes.Deterioration;
import com.mgackowski.agents.agent.processes.Timed;
import com.mgackowski.agents.agent.traits.Traits;

public class AgentFactory {
	
	public enum AgentPreset {
		DEFAULT
	}
	
	public Agent getAgent(AgentPreset preset, String name) {
		
		Map<NeedName, Float> needMap = new HashMap<NeedName, Float>();
		Needs needs = new Needs(needMap);
		
		Map<NeedName, Float> deteriorationMap = new HashMap<NeedName, Float>();
		Traits traits = new Traits.TraitsBuilder().deteriorationRate(deteriorationMap).build();
		
		List<Timed> processes = new ArrayList<Timed>();
		
		switch(preset) {
			case DEFAULT:
				
				needMap.put(NeedName.FOOD, 100f);
				needMap.put(NeedName.ENERGY, 100f);
				
				deteriorationMap.put(NeedName.FOOD, -0.05f);
				deteriorationMap.put(NeedName.ENERGY, -0.01f);
				
				processes.add(new Deterioration(needs, traits));
				
				break;
				
			default:
				break;
		}
		return new Agent(name, processes, needs, traits);
	}

}

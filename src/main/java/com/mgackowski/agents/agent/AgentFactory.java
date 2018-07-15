package com.mgackowski.agents.agent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mgackowski.agents.agent.needs.NeedLevels;
import com.mgackowski.agents.agent.processes.Deterioration;
import com.mgackowski.agents.agent.processes.Timed;
import com.mgackowski.agents.agent.traits.Traits;
import com.mgackowski.agents.needs.Need;

public class AgentFactory {
	
	public enum AgentPreset {
		DEFAULT
	}
	
	public Agent getAgent(AgentPreset preset, String name) {
		
		Map<Need, Float> needMap = new HashMap<Need, Float>();
		NeedLevels needs = new NeedLevels(needMap);
		
		Map<Need, Float> deteriorationMap = new HashMap<Need, Float>();
		Traits traits = new Traits.TraitsBuilder().deteriorationRate(deteriorationMap).build();
		
		List<Timed> processes = new ArrayList<Timed>();
		
		switch(preset) {
			case DEFAULT:
				
				needMap.put(Need.FOOD, 100f);
				needMap.put(Need.ENERGY, 100f);
				
				deteriorationMap.put(Need.FOOD, -0.05f);
				deteriorationMap.put(Need.ENERGY, -0.01f);
				
				processes.add(new Deterioration(needs, traits));
				
				break;
				
			default:
				break;
		}
		return new Agent(name, processes, needs, traits);
	}

}

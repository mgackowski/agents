package com.mgackowski.agents;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AgentFactory {
	
	public enum AgentPreset {
		DEFAULT
	}
	
	public Agent getAgent(AgentPreset preset, String name) {
		
		Map<NeedName, Float> needMap = new HashMap<NeedName, Float>();
		
		switch(preset) {
			case DEFAULT:
				needMap.put(NeedName.FOOD, 100f);
				needMap.put(NeedName.ENERGY, 100f); 
				break;
			default:
				break;
		}
		return new Agent(name, new ArrayList<Timed>(), new Needs(needMap));
	}

}

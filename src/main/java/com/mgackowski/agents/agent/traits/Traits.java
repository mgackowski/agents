package com.mgackowski.agents.agent.traits;

import java.util.HashMap;
import java.util.Map;

import com.mgackowski.agents.agent.needs.NeedName;

public class Traits {
	
	//TODO: Use this instead of hardwired value in Deterioration class
	Map<NeedName, Float> deteriorationRate = new HashMap<NeedName, Float>();

	public Traits(Map<NeedName, Float> deteriorationRate) {
		this.deteriorationRate = deteriorationRate;
	}

	public Map<NeedName, Float> getDeteriorationRate() {
		return deteriorationRate;
	}

}

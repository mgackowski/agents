package com.mgackowski.agents;

import java.util.Map;

public class Deterioration implements Timed {
	
	private Needs needs;
	private float deteriorationRate = -0.01f;
	
	public Deterioration(Needs needs) {
		this.needs = needs;
	}

	public boolean tick() {
		
		Map<NeedName, Float> needMap = needs.getNeedMap();
		for (NeedName need : needMap.keySet()) {
			needs.change(need, deteriorationRate);
		}
		return true;
	}

}

package com.mgackowski.agents;

import java.util.HashMap;
import java.util.Map;

public class Needs {
	
	private Map<NeedName, Float> needMap = new HashMap<NeedName, Float>();
	
	public Needs() {
		//temporarily pre-set here
		needMap.put(NeedName.FOOD, 100f);
		needMap.put(NeedName.ENERGY, 100f);
	}

	public Map<NeedName, Float> getNeedMap() {
		return needMap;
	}
	
	float change(NeedName need, Float difference) {
		float newValue = needMap.get(need) + difference;
		needMap.put(need, newValue);
		return newValue;
	}

	@Override
	public String toString() {
		return "Needs [needMap=" + needMap + "]";
	}

}

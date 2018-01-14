package com.mgackowski.agents.agent.needs;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class Needs {
	
	Logger LOG = Logger.getLogger(Needs.class);
	
	private Map<NeedName, Float> needMap = new HashMap<NeedName, Float>();
	
	public Needs(Map<NeedName, Float> needMap) {
		this.needMap = needMap;
	}

	public Map<NeedName, Float> getNeedMap() {
		return needMap;
	}
	
	public float change(NeedName need, Float difference) {
		float newValue = needMap.get(need) + difference;
		needMap.put(need, newValue);
		LOG.debug("Need " + need.name() + " changed to " + newValue);
		return newValue;
	}

	@Override
	public String toString() {
		return "Needs [needMap=" + needMap + "]";
	}

}

package com.mgackowski.agents.agent.needs;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mgackowski.agents.needs.Need;

/**
 * Need levels of an individual agent.
 * 
 * @author mgackowski
 *
 */
public class NeedLevels {
	
	Logger LOG = Logger.getLogger(NeedLevels.class);
	
	private Map<Need, Float> fulfillment = new HashMap<>();
	
	public NeedLevels(Map<Need, Float> needMap) {
		this.fulfillment = needMap;
	}

	public Map<Need, Float> getNeedMap() {
		return fulfillment;
	}
	
	public float change(Need need, Float difference) {
		
		float newValue = fulfillment.get(need) + difference;
		fulfillment.put(need, newValue);
		LOG.debug("Need " + need + " changed to " + newValue);
		return newValue;
	}

	@Override
	public String toString() {
		return "NeedLevels [fulfillment=" + fulfillment + "]";
	}

}

package com.mgackowski.agents.needs;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.mgackowski.agents.scoring.DummyScoringFunction;

/**
 * A registry of all Need objects.
 * @author mgackowski
 */
public class Needs {
	
	private static Logger LOG = Logger.getLogger(Needs.class);
	
	private static final Map<String, Need> registeredNeeds = new HashMap<>();
	
	{
		// Pre-baked needs; expand on mechanism as needs grow
		registeredNeeds.put("TEST", new Need("test", new DummyScoringFunction()));
		registeredNeeds.put("FOOD", new Need("food", new DummyScoringFunction()));
		registeredNeeds.put("REST", new Need("rest", new DummyScoringFunction()));	
	}
	
	public static Need get(String needName) {
		return registeredNeeds.get(needName);
	}
	
	public static boolean registerNew(String key, Need newNeed) {
		
		if(registeredNeeds.containsKey(key)) {
			LOG.error("Need " + key + " already registered");
			return false;
		}
		registeredNeeds.put(key, newNeed);
		LOG.info("Registered new need " + key + "=" + newNeed);
		return true;
		
	}

}

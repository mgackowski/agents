package com.mgackowski.agents.common;

import java.util.HashMap;
import java.util.Map;

import com.mgackowski.agents.needs.Need;
import com.mgackowski.agents.needs.Needs;

public class DefaultNeedGroup implements NeedGroup {
	
	@Override
	public Map<String, Need> getMap() {
		
		Map<String, Need> defaults = new HashMap<>();
		defaults.put("FOOD", Needs.get("FOOD"));
		defaults.put("REST", Needs.get("REST"));
		
		return defaults;
	}

}
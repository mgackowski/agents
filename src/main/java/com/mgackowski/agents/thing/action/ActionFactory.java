package com.mgackowski.agents.thing.action;

import java.util.HashMap;
import java.util.Map;

import com.mgackowski.agents.needs.Need;
import com.mgackowski.agents.needs.Needs;

public class ActionFactory {
	
	public enum ActionName {
		EAT,
		SLEEP
	}
	
	public Action getAction(ActionName actionName) {
		
		Map<Need, Consequence> promises = new HashMap<Need, Consequence>();
		Map<Need, Consequence> consequences = new HashMap<Need, Consequence>();
		String verb = "";
		
		//TODO: Read from files instead of having enums/switches
		switch (actionName) {
			case EAT :
				promises.put(Needs.get("FOOD"), new Consequence(Needs.get("FOOD"), 40f, 0.1f));
				consequences.put(Needs.get("FOOD"), new Consequence(Needs.get("FOOD"), 40f, 0.1f));
				break;
			case SLEEP :
				promises.put(Need.ENERGY, new Consequence(Need.ENERGY, 80f, 0.04f));
				promises.put(Need.ENERGY, new Consequence(Need.ENERGY, 80f, 0.04f));
				break;
		}
		
		return new Action(verb, promises, consequences);
		
	}

}

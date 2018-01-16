package com.mgackowski.agents.thing.action;

import java.util.HashMap;
import java.util.Map;

import com.mgackowski.agents.agent.needs.NeedName;

public class ActionFactory {
	
	public enum ActionName {
		EAT,
		SLEEP
	}
	
	public Action getAction(ActionName actionName) {
		
		Map<NeedName, Consequence> promises = new HashMap<NeedName, Consequence>();
		Map<NeedName, Consequence> consequences = new HashMap<NeedName, Consequence>();
		String verb = "";
		
		//TODO: Read from files instead of having enums/switches
		switch (actionName) {
			case EAT :
				promises.put(NeedName.FOOD, new Consequence(NeedName.FOOD, 40f, 0.1f));
				consequences.put(NeedName.FOOD, new Consequence(NeedName.FOOD, 40f, 0.1f));
				break;
			case SLEEP :
				promises.put(NeedName.ENERGY, new Consequence(NeedName.ENERGY, 80f, 0.04f));
				promises.put(NeedName.ENERGY, new Consequence(NeedName.ENERGY, 80f, 0.04f));
				break;
		}
		
		return new Action(verb, promises, consequences);
		
	}

}

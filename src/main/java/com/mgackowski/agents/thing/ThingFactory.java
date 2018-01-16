package com.mgackowski.agents.thing;

import java.util.ArrayList;
import java.util.List;

import com.mgackowski.agents.thing.action.Action;
import com.mgackowski.agents.thing.action.ActionFactory;
import com.mgackowski.agents.thing.action.ActionFactory.ActionName;

public class ThingFactory {
	
	public enum ThingName {
		FRIDGE,
		BED
	}
	
	public Thing getThing(ThingName thingName) {
		
		// TODO: This is not manageable for a large lsit of objects/actions
		// Read those from files
		
		String noun = "";
		ActionFactory actionFactory = new ActionFactory();
		List<Action> actionList = new ArrayList<Action>();
		
		switch(thingName) {
			case FRIDGE :
				noun = "fridge";
				actionList.add(actionFactory.getAction(ActionName.EAT));
				break;
			case BED :
				noun = "bed";
				actionList.add(actionFactory.getAction(ActionName.EAT));
				break;
		}
		
		return new Thing.ThingBuilder().name(noun).actions(actionList).build();
		
	}

}

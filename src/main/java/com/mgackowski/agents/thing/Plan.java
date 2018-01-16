package com.mgackowski.agents.thing;

import com.mgackowski.agents.thing.action.Action;

public class Plan {
	
	private Thing thing;
	private Action action;
	
	public Plan(Thing thing, Action action) {
		this.thing = thing;
		this.action = action;
	}

	public Thing getThing() {
		return thing;
	}

	public Action getAction() {
		return action;
	}

}
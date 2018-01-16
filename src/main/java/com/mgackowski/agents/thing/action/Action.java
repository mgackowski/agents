package com.mgackowski.agents.thing.action;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.mgackowski.agents.agent.needs.NeedName;

public class Action {
	
	private String verb;
	
	Map<NeedName, Consequence> promises;
	Map<NeedName, Consequence> consequences;
	
	List<Predicate> conditions; // TBA
	
	public Action(String verb, Map<NeedName, Consequence> promises, Map<NeedName, Consequence> consequences) {
		this.verb = verb;
		this.promises = promises;
		this.consequences = consequences;
	}

	public String getVerb() {
		return verb;
	}

	public Map<NeedName, Consequence> getPromises() {
		return promises;
	}

	public Map<NeedName, Consequence> getConsequences() {
		return consequences;
	}
	

}

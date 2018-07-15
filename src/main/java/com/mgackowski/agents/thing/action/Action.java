package com.mgackowski.agents.thing.action;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.mgackowski.agents.needs.Need;

public class Action {
	
	private String verb;
	
	Map<Need, Consequence> promises;
	Map<Need, Consequence> consequences;
	
	List<Predicate> conditions; // TBA
	
	public Action(String verb, Map<Need, Consequence> promises, Map<Need, Consequence> consequences) {
		this.verb = verb;
		this.promises = promises;
		this.consequences = consequences;
	}

	public String getVerb() {
		return verb;
	}

	public Map<Need, Consequence> getPromises() {
		return promises;
	}

	public Map<Need, Consequence> getConsequences() {
		return consequences;
	}
	

}

package com.mgackowski.agents.needs;

import com.mgackowski.agents.scoring.ScoringFunction;

public class Need {
	
	private final String name;
	private final ScoringFunction urgency;
	
	protected Need(String name, ScoringFunction urgency) {
		this.name = name;
		this.urgency = urgency;
	}

	public final String getName() {
		return name;
	}

	public final ScoringFunction getUrgency() {
		return urgency;
	}
	

}

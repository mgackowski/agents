package com.mgackowski.agents.thing.action;

import com.mgackowski.agents.agent.needs.NeedName;

public class Consequence {
	
	NeedName needName;
	float changeAmount;
	float changeRate;
	
	public Consequence(NeedName needName, float changeAmount, float changeRate) {
		this.needName = needName;
		this.changeAmount = changeAmount;
		this.changeRate = changeRate;
	}

	public NeedName getNeedName() {
		return needName;
	}

	public float getChangeAmount() {
		return changeAmount;
	}

	public float getChangeRate() {
		return changeRate;
	}
	
}

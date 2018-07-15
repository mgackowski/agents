package com.mgackowski.agents.thing.action;

import com.mgackowski.agents.needs.Need;

public class Consequence {
	
	Need needName;
	float changeAmount;
	float changeRate;
	
	public Consequence(Need needName, float changeAmount, float changeRate) {
		this.needName = needName;
		this.changeAmount = changeAmount;
		this.changeRate = changeRate;
	}

	public Need getNeedName() {
		return needName;
	}

	public float getChangeAmount() {
		return changeAmount;
	}

	public float getChangeRate() {
		return changeRate;
	}
	
}

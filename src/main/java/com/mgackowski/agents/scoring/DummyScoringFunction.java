package com.mgackowski.agents.scoring;

public class DummyScoringFunction implements ScoringFunction {

	@Override
	public float score(float currentValue, float promisedChange) {
		return 0;
	}

}

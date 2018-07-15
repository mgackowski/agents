package com.mgackowski.agents.scoring;

/**
 * Score the attractiveness of a change.
 * 
 * @author mgackowski
 *
 */
@FunctionalInterface
public interface ScoringFunction {
	
	float score(float currentValue, float promisedChange);

}
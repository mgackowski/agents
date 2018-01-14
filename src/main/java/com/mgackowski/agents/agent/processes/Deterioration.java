package com.mgackowski.agents.agent.processes;

import java.util.Map;

import com.mgackowski.agents.agent.needs.NeedName;
import com.mgackowski.agents.agent.needs.Needs;

/**
 * Time-based deterioration of Needs creates incentive for Agents to pursue actions.
 * @author mgackowski
 *
 */
public class Deterioration implements Timed {
	
	private Needs needs;
	private float deteriorationRate = -0.01f;
	
	public Deterioration(Needs needs) {
		this.needs = needs;
	}

	public boolean tick() {
		
		Map<NeedName, Float> needMap = needs.getNeedMap();
		for (NeedName need : needMap.keySet()) {
			needs.change(need, deteriorationRate);
		}
		return true;
	}

	@Override
	public String toString() {
		return "Deterioration [needs=" + needs + ", deteriorationRate=" + deteriorationRate + "]";
	}

}

package com.mgackowski.agents.agent.processes;

import java.util.Map;

import com.mgackowski.agents.agent.needs.NeedName;
import com.mgackowski.agents.agent.needs.Needs;
import com.mgackowski.agents.agent.traits.Traits;

/**
 * Time-based deterioration of Needs creates incentive for Agents to pursue actions.
 * @author mgackowski
 *
 */
public class Deterioration implements Timed {
	
	private Needs needs;
	private Traits traits;
	
	public Deterioration(Needs needs, Traits traits) {
		this.needs = needs;
		this.traits = traits;
	}

	public boolean tick() {
		
		Map<NeedName, Float> needMap = needs.getNeedMap();
		Map<NeedName, Float> deteriorationMap = traits.getDeteriorationRate();
		
		for (NeedName need : needMap.keySet()) {
			needs.change(need, deteriorationMap.get(need));
		}
		return true;
	}

	@Override
	public String toString() {
		return "Deterioration [needs=" + needs + ", traits=" + traits + "]";
	}

}

package com.mgackowski.agents.agent.processes;

import java.util.Map;

import com.mgackowski.agents.agent.needs.NeedLevels;
import com.mgackowski.agents.agent.traits.Traits;
import com.mgackowski.agents.needs.Need;

/**
 * Time-based deterioration of NeedLevels creates incentive for Agents to pursue actions.
 * @author mgackowski
 *
 */
public class Deterioration implements Timed {
	
	private NeedLevels needs;
	private Traits traits;
	
	public Deterioration(NeedLevels needs, Traits traits) {
		this.needs = needs;
		this.traits = traits;
	}

	public boolean tick() {
		
		Map<Need, Float> needMap = needs.getNeedMap();
		Map<Need, Float> deteriorationMap = traits.getDeteriorationRate();
		
		for (Need need : needMap.keySet()) {
			needs.change(need, deteriorationMap.get(need));
		}
		return true;
	}

	@Override
	public String toString() {
		return "Deterioration [needs=" + needs + ", traits=" + traits + "]";
	}

}

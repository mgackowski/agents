package com.mgackowski.agents.agent.traits;

import java.util.HashMap;
import java.util.Map;

import com.mgackowski.agents.needs.Need;

public class Traits {
	
	Map<Need, Float> deteriorationRate = new HashMap<Need, Float>();

	public Traits(TraitsBuilder builder) {
		this.deteriorationRate = builder.deteriorationRate;
	}

	public Map<Need, Float> getDeteriorationRate() {
		return deteriorationRate;
	}
	
	public static class TraitsBuilder {
		private Map<Need, Float> deteriorationRate;
		
		public TraitsBuilder() {
			//required traits
		}
		
		public TraitsBuilder deteriorationRate(Map<Need, Float> deteriorationRate) {
			this.deteriorationRate = deteriorationRate;
			return this;
		}
		
		public Traits build() {
			return new Traits(this);
		}
	}

}

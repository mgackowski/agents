package com.mgackowski.agents.agent.traits;

import java.util.HashMap;
import java.util.Map;

import com.mgackowski.agents.agent.needs.NeedName;

public class Traits {
	
	Map<NeedName, Float> deteriorationRate = new HashMap<NeedName, Float>();

	public Traits(TraitsBuilder builder) {
		this.deteriorationRate = builder.deteriorationRate;
	}

	public Map<NeedName, Float> getDeteriorationRate() {
		return deteriorationRate;
	}
	
	public static class TraitsBuilder {
		private Map<NeedName, Float> deteriorationRate;
		
		public TraitsBuilder() {
			//required traits
		}
		
		public TraitsBuilder deteriorationRate(Map<NeedName, Float> deteriorationRate) {
			this.deteriorationRate = deteriorationRate;
			return this;
		}
		
		public Traits build() {
			return new Traits(this);
		}
	}

}

package com.mgackowski.agents.thing;

import java.util.List;

import com.mgackowski.agents.thing.action.Action;

public class Thing {
	
	private String name;
	private List<Action> actions;
	
	private Thing(ThingBuilder builder) {
		this.name = builder.name;
		this.actions = builder.actions;
	}
	
	public String getName() {
		return name;
	}

	public List<Action> getActions() {
		return actions;
	}

	public static class ThingBuilder {
		
		private String name;
		private List<Action> actions;
		
		public ThingBuilder() {};
		
		public ThingBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public ThingBuilder actions(List<Action> actions) {
			this.actions = actions;
			return this;
		}
		
		public Thing build() {
			return new Thing(this);
		}
		
	}

}

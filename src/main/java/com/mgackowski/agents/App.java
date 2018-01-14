package com.mgackowski.agents;

public class App 
{
    public static void main( String[] args )
    {
    	Simulation sim = new Simulation(2);
        sim.init();
        sim.simulate();
    }
    
}

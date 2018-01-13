package com.mgackowski.agents;

public class App 
{
    public static void main( String[] args )
    {
    	Simulation sim = new Simulation(200);
        sim.init();
        sim.simulate();
    }
    
}

package com.fenoxo.coc.zadenikt_java_port.actors;

public class ActorRathazul extends Actor {
	protected Boolean grownThorns = false;

	public Boolean hasGrownThorns() { return grownThorns; }
	public void growThorns() { this.grownThorns = true; }
}

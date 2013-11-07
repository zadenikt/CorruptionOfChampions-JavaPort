package com.fenoxo.coc.zadenikt_java_port.characteristics;

public class Tail {
	private Type type;
	private double venom;
	
	public Tail(Type type, double venom) {
		this.type = type;
		this.venom = venom;
	}
	
	public Type getType() { return this.type; }
	public double getVenom() { return this.venom; }
	public double rechargeVenom() { return this.venom += this.type.rechargeAmount; }
	public double depleteVenom(double amount) { return this.venom -= amount; }
	public void setVenom(double venom) { this.venom = venom; }
	
	public enum Type { // TODO Recharge amounts
		NONE,
		HORSE,
		DOG,
		DEMONIC,
		COW,
		SPIDER,
		BEE,
		SHARK,
		CAT,
		LIZARD,
		RABBIT,
		HARPY,
		KANGAROO,
		FOX(true, 0.0), // For counting tails :/
		DRAGON;
		
		public final boolean hasVenom;
		public final double rechargeAmount;
		
		private Type() { this(false, 0.0); }
		private Type(boolean hasVenom, double rechargeAmount) {
			this.hasVenom = hasVenom;
			this.rechargeAmount = (hasVenom ? rechargeAmount : 0.0);
		}
	}
}

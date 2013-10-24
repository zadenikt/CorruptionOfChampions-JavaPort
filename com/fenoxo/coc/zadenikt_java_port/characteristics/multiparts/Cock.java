package com.fenoxo.coc.zadenikt_java_port.characteristics.multiparts;

/** NOTES:
 * thickness is now diameter.
 * grow and thicken are now growLength and growDiameter.
 * grow with a negative value can use shrink with a positive one instead.
 * grow and shrink use a slightly different implementation than the original.
**/

public class Cock {
	protected Type type;
	protected double length, diameter;
	
	public Cock() { this(Type.NORMAL, 4.5, 1); }
	public Cock(Type type) { this(type, 4.5, 1); }
	public Cock(double length, double circumference) { this(Type.NORMAL, 4.5, 1); }
	public Cock(Type type, double length, double diameter) {
		this.type = type;
		this.length = length;
		this.diameter = diameter;
	}

	public Type getType() { return this.type; }
	public double getLength() { return this.length; }
	public double getDiameter() { return this.diameter; }
	public double getThickness() { return this.getDiameter(); }
	public double getWidth() { return this.getDiameter(); }
	
	public double getArea() {
		return this.getLength() * this.getDiameter();
		//Isn't this cross-sectional area? Volume is:
		//return this.getLength() * ((this.getDiameter() / 2) ** 2) * Math.PI;
		//Surface Area is:
		//return (2 * ((this.getDiameter() / 2) ** 2)) + (this.getDiameter() * this.getLength() * Math.PI);
	}
	public double growLength(double amount) {
		int modifier = 1;
		if(amount > 0.0) {
			if(this.getLength() > ((this.getType() == Type.HORSE) ? 17 : 10)) modifier *= 2;
			if(this.getLength() > ((this.getType() == Type.HORSE) ? 40 : 24)) modifier *= 2;
		} else if(amount < 0.0) {
			if(this.getType() != Type.HORSE && this.getLength() < 5) modifier *= 2;
			if(this.getType() == Type.HORSE && this.getLength() < 10) modifier *= 3;
			else if(this.getLength() < 10) modifier *= 2;
			if(this.getType() == Type.HORSE && this.getLength() < 4) modifier *= 3;
			else if(this.getLength() < 4) modifier *= 2;
			if(this.getType() == Type.HORSE && this.getLength() < 6) modifier *= 3;
			else if(this.getLength() < 6) modifier *= 2;
		} else {
			return 0;
		}
		return (this.length += (amount / modifier));
	}
	public double shrinkLength(double amount) { return growLength(-amount); }
	public double growDiameter(double amount) {
		int modifier = 1;
		if(amount > 0.0) {
			if(this.getDiameter() > 1.0 && this.getLength() < 12) modifier *= 4;
			if(this.getDiameter() > 1.5 && this.getLength() < 18) modifier *= 5;
			if(this.getDiameter() > 2.0 && this.getLength() < 24) modifier *= 5;
			if(this.getDiameter() > 3.0 && this.getLength() < 30) modifier *= 5;
			if(this.getDiameter() > (this.getLength() * 0.15)) modifier *= 3;
			if(this.getDiameter() > (this.getLength() * 0.20)) modifier *= 3;
			if(this.getDiameter() > (this.getLength() * 0.30)) modifier *= 5;
			if(this.getDiameter() > 4.0) modifier *= 2;
			if(this.getDiameter() > 5.0) modifier *= 2;
			if(this.getDiameter() > 6.0) modifier *= 2;
			if(this.getDiameter() > 7.0) modifier *= 2;
		} else if(amount < 0.0) {
			if(this.getDiameter() <= 1.0) modifier *= 2;
			if(this.getDiameter() < 2.0 && this.getLength() < 10) modifier *= 2;
			if(this.getDiameter() < 3.0 && this.getLength() < 18) modifier *= 2;
			if(this.getDiameter() < 4.0 && this.getLength() < 24) modifier *= 2;
			if((this.diameter + (amount / modifier)) < 0.5) return (this.diameter = 0.5);
		} else {
			return 0;
		}
		return (this.diameter += (amount / modifier));
	}
	public double shrinkDiameter(double amount) { return growDiameter(-amount); }
	
	public enum Type {
		NORMAL,
		HORSE,
		DOG,
		DEMON,
		TENTACLE,
		CAT,
		LIZARD,
		ANEMONE,
		KANGAROO,
		DRAGON;
	}
}

package com.fenoxo.coc.zadenikt_java_port.characteristics;

/**
 * NOTES: thickness is now diameter.
 * grow and thicken are now growLength an growDiameter.
 * grow with a negative value can use shrink with a positive one instead.
 * grow and shrink use a slightly different implementation than the original.
 **/

public class Cock {
  private static final int DEFAULT_DIAMETER = 1;
  private static final double DEFAULT_LENGTH = 4.5;
  protected Type type;
  protected double length, diameter;

  public Cock() {
    this(Type.NORMAL, DEFAULT_LENGTH, DEFAULT_DIAMETER);
  }

  public Cock(Type type) {
    this(type, DEFAULT_LENGTH, DEFAULT_DIAMETER);
  }

  public Cock(double length, double diameter) {
    this(Type.NORMAL, length, diameter);
  }

  public Cock(Type type, double length, double diameter) {
    this.type = type;
    this.length = length;
    this.diameter = diameter;
  }

  public Type getType() {
    return this.type;
  }

  public double getLength() {
    return this.length;
  }

  public double getDiameter() {
    return this.diameter;
  }

  public double getThickness() {
    return this.getDiameter();
  }

  public double getWidth() {
    return this.getDiameter();
  }

  public double getArea() {
    return this.getLength() * this.getDiameter();
    // Isn't this cross-sectional area? Volume is:
    // return this.getLength() * ((this.getDiameter() / 2) ** 2) * Math.PI;
    // Surface Area is:
    // return (2 * ((this.getDiameter() / 2) ** 2)) + (this.getDiameter() *
    // this.getLength() * Math.PI);
  }

  public double growLength(double amount) {
    int modifier = 1;
    if (amount == 0.0) {
      return 0.0;
    }
    if (amount > 0.0) {
      if (this.getLength() > ((this.isHorse()) ? 17 : 10)) {
        modifier *= 2;
      }
      if (this.getLength() > ((this.isHorse()) ? 40 : 24)) {
        modifier *= 2;
      }
    } else if (amount < 0.0) {
      if (!this.isHorse() && this.getLength() < 5) {
        modifier *= 2;
      }
      if (this.getLength() < 10) {
        modifier *= this.isHorse() ? 3 : 2;
      }
      if (this.getLength() < 6) {
        modifier *= this.isHorse() ? 3 : 2;
      }
      if (this.getLength() < 4) {
        modifier *= this.isHorse() ? 3 : 2;
      }
    }
    return (this.length += (amount / modifier));
  }

  public double shrinkLength(double amount) {
    return growLength(-amount);
  }

  public double growDiameter(double amount) {
    int modifier = 1;
    if (amount == 0.0) {
      return 0.0;
    }
    if (amount > 0.0) {
      if (this.getDiameter() > 1.0 && this.getLength() < 12) {
        modifier *= 4;
      }
      if (this.getDiameter() > 1.5 && this.getLength() < 18) {
        modifier *= 5;
      }
      if (this.getDiameter() > 2.0 && this.getLength() < 24) {
        modifier *= 5;
      }
      if (this.getDiameter() > 3.0 && this.getLength() < 30) {
        modifier *= 5;
      }
      if (this.getDiameter() > (this.getLength() * 0.15)) {
        modifier *= 3;
      }
      if (this.getDiameter() > (this.getLength() * 0.20)) {
        modifier *= 3;
      }
      if (this.getDiameter() > (this.getLength() * 0.30)) {
        modifier *= 5;
      }
      if (this.getDiameter() > 4.0) {
        modifier *= 2;
      }
      if (this.getDiameter() > 5.0) {
        modifier *= 2;
      }
      if (this.getDiameter() > 6.0) {
        modifier *= 2;
      }
      if (this.getDiameter() > 7.0) {
        modifier *= 2;
      }
    } else if (amount < 0.0) {
      if (this.getDiameter() <= 1.0) {
        modifier *= 2;
      }
      if (this.getDiameter() < 2.0 && this.getLength() < 10) {
        modifier *= 2;
      }
      if (this.getDiameter() < 3.0 && this.getLength() < 18) {
        modifier *= 2;
      }
      if (this.getDiameter() < 4.0 && this.getLength() < 24) {
        modifier *= 2;
      }
      if ((this.diameter + (amount / modifier)) < 0.5) {
        return (this.diameter = 0.5);
      }
    }
    return (this.diameter += (amount / modifier));
  }

  public double shrinkDiameter(double amount) {
    return growDiameter(-amount);
  }

  public boolean isNormal() {
    return this.getType() == Type.NORMAL;
  }

  public boolean isHorse() {
    return this.getType() == Type.HORSE;
  }

  public boolean isDog() {
    return this.getType() == Type.DOG;
  }

  public boolean isDemon() {
    return this.getType() == Type.DEMON;
  }

  public boolean isTentacle() {
    return this.getType() == Type.TENTACLE;
  }

  public boolean isCat() {
    return this.getType() == Type.CAT;
  }

  public boolean isLizard() {
    return this.getType() == Type.LIZARD;
  }

  public boolean isAnemone() {
    return this.getType() == Type.ANEMONE;
  }

  public boolean isKangaroo() {
    return this.getType() == Type.KANGAROO;
  }

  public boolean isDragon() {
    return this.getType() == Type.DRAGON;
  }

  
  public enum Type {
    NORMAL, HORSE, DOG, DEMON, TENTACLE, CAT, LIZARD, ANEMONE, KANGAROO, DRAGON;
  }
}

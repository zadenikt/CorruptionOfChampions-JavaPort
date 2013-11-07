package com.fenoxo.coc.zadenikt_java_port.characteristics;

public class Skin {
    protected Tone tone;
    protected Type type;
    
    public Skin() {
        this(Tone.LIGHT);
    }
    public Skin(Tone tone) {
        this(tone, Type.NORMAL);
    }
    public Skin(Tone tone, Type type) {
        this.tone = tone;
        this.type = type;
    }
    
    public void setType(Type type) { this.type = type; }
    public Type getType() { return type; }
    public void setTone(Tone tone) { this.tone = tone; }
    public Tone getTone() { return tone; }
    
    public enum Tone { // TODO Add more.
        LIGHT,
        OLIVE,
        DARK,
        EBONY,
        ALBINO,
        PALE_YELLOW,
        GRAYISH_BLUE,
        GREEN,
        DARK_GREEN;
    }
    public enum Type {
        NORMAL,
        FUR,
        SCALES,
        GOO;
    }
}

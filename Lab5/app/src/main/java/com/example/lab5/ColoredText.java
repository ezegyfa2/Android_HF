package com.example.lab5;

public class ColoredText {
    private String text;
    private int color;

    public ColoredText(String text, int color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public int getColor() {
        return color;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return text;
    }
}

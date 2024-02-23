package com.example.himymcharacters;

public class HIMYMCharacter {
    private String name;
    private String description;
    private int imageResourceId;

    // Constructor
    public HIMYMCharacter(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}

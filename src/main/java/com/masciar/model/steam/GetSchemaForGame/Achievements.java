package com.masciar.model.steam.GetSchemaForGame;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Achievements {
    private String name;
    @JsonProperty("defaultvalue")
    private int defaultValue;
    private String displayName;
    private int hidden;
    private String description;
    private String icon;
    private String icongray;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcongray() {
        return icongray;
    }

    public void setIcongray(String icongray) {
        this.icongray = icongray;
    }
}

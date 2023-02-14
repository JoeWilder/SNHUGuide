package com.example.snhuchat;

import org.jgrapht.graph.DefaultWeightedEdge;

public class WeightedDescriptiveEdge extends DefaultWeightedEdge {

    private String description;

    public WeightedDescriptiveEdge() {
        this.description = "";
    }

    WeightedDescriptiveEdge(String description) {
        this.description = description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

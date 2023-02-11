package com.example.snhuchat;

import android.content.Context;
import android.content.res.AssetManager;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CampusMap {
    private final Context context;
    private final Graph<String, WeightedDescriptiveEdge> snhuGraph; // Graph of SNHU campus

    public CampusMap(Context context) {
        this.context = context;
        snhuGraph = new SimpleWeightedGraph<>(WeightedDescriptiveEdge.class);
        createGraphFromCSV();
    }


    // Get all the nodes and edges from snhuMap.csv and put them into a simple weighted graph
    private void createGraphFromCSV() {
        try {
            InputStream is = context.getAssets().open("snhuMap.csv");
            InputStreamReader streamReader = new InputStreamReader(is);
            CSVReader reader = new CSVReader(streamReader);
            String[] nextLine;
            reader.readNext(); // Skip first line of the CSV
            while ((nextLine = reader.readNext()) != null) {
                String node1 = nextLine[1];
                String node2 = nextLine[2];
                String distance = nextLine[3];
                String description = nextLine[4];

                // Add node1 if it is not in the graph
                if (!snhuGraph.containsVertex(node1)) {
                    snhuGraph.addVertex(node1.toLowerCase());
                }

                // Add node2 if it is not in the graph
                if (!snhuGraph.containsVertex(node2)) {
                    snhuGraph.addVertex(node2.toLowerCase());
                }

                // Add a weighted descriptive edge connecting both of the nodes
                try {
                    WeightedDescriptiveEdge edge = snhuGraph.addEdge(node1.toLowerCase(), node2.toLowerCase());
                    snhuGraph.setEdgeWeight(edge, Double.parseDouble(distance));
                    edge.setDescription(description);
                } catch(NumberFormatException e) {
                    throw new IllegalArgumentException("Could not parse double: " + distance);
                } catch(NullPointerException e) {
                    throw new IllegalArgumentException("Null distance: " + distance);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found: " + e.getMessage());
        } catch (IOException | CsvValidationException e) {
            throw new IllegalArgumentException("Error reading file: " + e.getMessage());
        }
    }


    // Find the shortest path between two nodes
    public List<String> shortestPath(String node1, String node2) {
        if (!snhuGraph.containsVertex(node1)) {
            System.out.println("The following node does not exist: " + node1);
            return null;
        }
        if (!snhuGraph.containsVertex(node2)) {
            System.out.println("The following node does not exist: " + node2);
            return null;
        }
        return DijkstraShortestPath.findPathBetween(snhuGraph, node1.toLowerCase(), node2.toLowerCase()).getVertexList();
    }


    // Print the graph of SNHU campus
    public Graph<String,WeightedDescriptiveEdge> getGraph() {
        return snhuGraph;
    }
}





package com.example.snhuchat;

import java.util.*;

public class LanguageDirections {

    public List<String> givenArray;
    public Dictionary<String, String> edgeDictionary;

    public LanguageDirections(List<String> originalArray) // Add functionality to get list from other function
    {
        givenArray = originalArray;
        edgeDictionary = new Hashtable<String, String>();
        edgeDictionary.put("studentcenter, int24", "Head southeast out of the Student Center");
        edgeDictionary.put("int24, greenspace", "Head east across the Green Space");
        edgeDictionary.put("greenspace, int32", "Head southwest away from the Green Space");
        edgeDictionary.put("int32, dininghall", "Head east into the Dining Hall");
        // Add rest of dictionary (~400 entries)
    }

    public String getPath()
    {
        String path = "";
        String entry = "";
        for (int i = 0; i < givenArray.size(); i++)
        {
            if (i != givenArray.size() - 1) {
                entry = givenArray.get(i) + ", " + givenArray.get(i + 1);
                path += edgeDictionary.get(entry);
                path += "\n";
            }
            entry = "";
        }
        return path;
    }
}

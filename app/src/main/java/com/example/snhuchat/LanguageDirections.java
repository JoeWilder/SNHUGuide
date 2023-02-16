package com.example.snhuchat;

import java.util.*;

public class LanguageDirections {

    public List<String> testArray;
    public Dictionary<String, String> edgeDictionary;

    public LanguageDirections() // Add functionality to get list from other function
    {
        testArray = Arrays.asList("studentcenter", "int24", "greenspace", "int32", "dininghall");
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
        for (int i = 0; i < testArray.size(); i++)
        {
            if (i != testArray.size() - 1) {
                entry = testArray.get(i) + ", " + testArray.get(i + 1);
                path += edgeDictionary.get(entry);
                path += "\n";
            }
            entry = "";
        }
        return path;
    }
}

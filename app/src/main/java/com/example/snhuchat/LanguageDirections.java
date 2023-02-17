package com.example.snhuchat;

import java.util.*;

public class LanguageDirections {

    public List<String> givenArray;
    public Dictionary<String, String> edgeDictionary;

    public LanguageDirections(List<String> originalArray) // Add functionality to get list from other function
    {
        givenArray = originalArray;
        edgeDictionary = new Hashtable<String, String>();
        edgeDictionary.put("lot13, int1", "Head east out of Parking Lot 13");
        edgeDictionary.put("int1, lot12", "Head southwest towards Parking Lot 12");
        edgeDictionary.put("lot12, lot11", "Head southwest towards Parking Lot 11");
        edgeDictionary.put("lot10, lot11", "Head southwest towards Parking Lot 11");
        edgeDictionary.put("int2, lot10", "Head southwest towards Parking Lot 10");
        edgeDictionary.put("int2, int1", "Head west");
        edgeDictionary.put("int2, int3", "Head east");
        edgeDictionary.put("int3, int4", "Head east");
        edgeDictionary.put("int3, int5", "Head southwest");
        edgeDictionary.put("int5, int6", "Head southwest until you turn south and then continue");
        edgeDictionary.put("int6, lot6", "Head southeast towards Parking Lot 6");
        edgeDictionary.put("lot6, newcastle", "Head into Newcastle");
        edgeDictionary.put("newcastle, lot8", "Head from Newcastle towards Parking Lot 8");
        edgeDictionary.put("lot8, int6", "Head southwest from Parking Lot 8");
        edgeDictionary.put("lot9, int7", "Head southwest away from Parking Lot 9");
        edgeDictionary.put("int7, lot8", "Head southwest towards Parking Lot 8");
        edgeDictionary.put("int4, lot9", "Head southwest towards Parking Lot 9");
        edgeDictionary.put("int6, lot5", "Head south away from Parking Lot 5");
        edgeDictionary.put("int17, lot4", "Head southeast then turn right and continue into Parking Lot 4");
        edgeDictionary.put("lot5, int17", "Head southeast then turn left and continue");
        edgeDictionary.put("int17, int18", "Head east towards Parking Lot 3");
        edgeDictionary.put("int18, lot3", "Head across the street towards Parking Lot 3");
        edgeDictionary.put("int18, athleticcomplex", "Head northwest towards the Athletic Complex");
        edgeDictionary.put("int8, athleticcomplex", "Head southeast towards the Athletic Complex");
        edgeDictionary.put("int8, lot6", "Head northwest towards Parking Lot 6");
        edgeDictionary.put("int8, int9", "Head northeast along Larkin Field");
        edgeDictionary.put("int9, newcastle", "Head northwest towards Newcastle");
        edgeDictionary.put("int8, int18", "Head northwest along the Athletic Complex");
        edgeDictionary.put("int9, lot7", "Head northeast");
        edgeDictionary.put("lot7, int10", "Head northeast");
        edgeDictionary.put("int10, int7", "Head northwest");
        edgeDictionary.put("int10, int11", "Head northeast");
        edgeDictionary.put("int11, lot9", "Head northwest towards Lot 9 then turn right and continue");
        edgeDictionary.put("int11, int7", "Head northwest towards Lot 9 then turn left and continue");
        edgeDictionary.put("int11, int12", "Head northeast");
        edgeDictionary.put("int12, int13", "Head northeast around Kingston");
        edgeDictionary.put("int12, lot9", "Head northwest towards Parking Lot 9");
        edgeDictionary.put("int13, washington", "Head north into Washington");
        edgeDictionary.put("washington, lot15", "Head north into Lot 15");
        edgeDictionary.put("int4, lot15", "Head northeast then turn right and continue towards Lot 15");
        edgeDictionary.put("lot15, int14", "Head southeast away from Parking Lot 15");
        edgeDictionary.put("int13, int14", "Head east then turn around Washington building");
        edgeDictionary.put("int15, int13", "Head north towards Washington");
        edgeDictionary.put("int15, int16", "Head southwest");
        edgeDictionary.put("int16, int11", "Head west");
        edgeDictionary.put("int15, kingston", "Head west towards Kingston");
        edgeDictionary.put("int16, kingston", "Head north towards Kingston");
        edgeDictionary.put("int12, kingston", "Head east towards Kingston");
        edgeDictionary.put("int18, larkinfield", "Walk north towards the center of Larkin Field");
        edgeDictionary.put("int8, larkinfield", "Walk east towards the center of Larkin Field");
        edgeDictionary.put("larkinfield, int19", "Walk west away from the center of Larkin Field");
        edgeDictionary.put("int19, int10", "Head northwest");
        edgeDictionary.put("int22, int19", "Head northwest");
        edgeDictionary.put("int19, int20", "Head northeast across the back of the Student Center");
        edgeDictionary.put("int20, int21", "Head northeast across the back of the Green Center");
        edgeDictionary.put("int25, int20", "Head northwest in-between the Student Center and Green Center");
        edgeDictionary.put("int21, int26", "Head southeast around the Green Center");
        edgeDictionary.put("lot3, int22", "Head northeast from Parking Lot 3");
        edgeDictionary.put("int22, int23", "Head northeast until you're just northwest of Robert Frost");
        edgeDictionary.put("int23, int24", "Head northeast until you're in front of the Student Center");
        edgeDictionary.put("int24, int25", "Head northeast until you're just northwest of the center of the Green Space");
        edgeDictionary.put("int25, int26", "Head northeast until you're on the edge of the Green Space");
        edgeDictionary.put("int20, int16", "Head northwest towards the front of Kingston");
        edgeDictionary.put("int21, int15", "Head northwest");
        edgeDictionary.put("int23, studentcenter", "Head north into the Student Center");
        edgeDictionary.put("int24, studentcenter", "Head northwest into the Student Center");
        edgeDictionary.put("int25, greencenter", "Head north into the Green Center");
        edgeDictionary.put("int26, greencenter", "Head west into the Student Center");
        edgeDictionary.put("int26, int75", "Head northeast towards the Hospitality front parking lot");
        edgeDictionary.put("int75, hospitality", "Head east into the Hospitality building");
        edgeDictionary.put("int75, int74", "Head north towards the SETA building");
        edgeDictionary.put("int74, seta", "Head north into the SETA building");
        edgeDictionary.put("int26, int74", "Head northeast");
        edgeDictionary.put("int15, seta", "Head east then turn left and continue into SETA");
        edgeDictionary.put("int21, seta", "Head northeast into SETA");
        edgeDictionary.put("int74, int27", "Head northeast along the edge of SETA");
        edgeDictionary.put("int27, lot16", "Head southeast into Parking Lot 16");
        edgeDictionary.put("int27, int28", "Head northeast along the edge of SETA");
        edgeDictionary.put("int28, int14", "Head northwest along the edge of SETA");
        edgeDictionary.put("int28, int29", "Head northeast");
        edgeDictionary.put("int29, lot17", "Head northwest towards Parking Lot 17");
        edgeDictionary.put("int29, int30", "Head northeast down the long path connected to Webster");
        edgeDictionary.put("int30, lot18", "Head northwest towards Parking Lot 18");
        edgeDictionary.put("lot18, lot19", "Head northwest then turn left and continue towards Parking Lot 19");
        edgeDictionary.put("lot19, int36", "Head northeast and continue on the road until you've gone completely around Webster");
        edgeDictionary.put("int36, madison", "Head southeast towards Madison");
        edgeDictionary.put("int36, int35", "Head southwest");
        edgeDictionary.put("int35, int34", "Head southwest");
        edgeDictionary.put("int34, int71", "Head southwest");
        edgeDictionary.put("int71, int33", "Head southwest toward the crosswalk in the center of campus");
        edgeDictionary.put("int33, int32", "Head west around Webster");
        edgeDictionary.put("int35, int30", "Head northwest into Webster");
        edgeDictionary.put("int35, webster", "In the Webster parking lot");
                edgeDictionary.put("int35, lot18", "Head east towards Lot 18");
        edgeDictionary.put("webster, lot18", "Head northwest across the street towards SETA");
        edgeDictionary.put("int71, int28", "Head northwest towards the Green Space");
        edgeDictionary.put("int32, greenspace", "Head west across the Green Space");
        edgeDictionary.put("greenspace, int24", "Head northwest across the Green Space");
        edgeDictionary.put("greenspace, int25", "Head north across the Green Space");
        edgeDictionary.put("greenspace, int26", "Head southwest and walk along the path towards Robert Frost");
        edgeDictionary.put("int32, frost", "Head southeast into Robert Frost");
        edgeDictionary.put("int23, frost", "Head southeast into Robert Frost");
        edgeDictionary.put("int72, frost", "Head northeast into Robert Frost");
        edgeDictionary.put("int72, int22", "Head northwest along the side of Robert Frost");
        edgeDictionary.put("int72, belknap", "Head southwest into Belknap");
        edgeDictionary.put("int31, belknap", "Head northeast along Parking Lot 3 until you reach Belknap");
        edgeDictionary.put("int31, int72", "Head northeast then turn left around Belknap Hall");
        edgeDictionary.put("int31, int18", "Head northwest along Parking Lot 3");
        edgeDictionary.put("int33, acc", "Head east into the ACC building");
        edgeDictionary.put("int33, lot23", "Head southeast into Parking Lot 23");
        edgeDictionary.put("int33, lot22", "Head southeast into Parking Lot 22");
        edgeDictionary.put("lot22, int41", "Head southwest away from Parking Lot 22");
        edgeDictionary.put("int32, dininghall", "Head east into the Dining Hall");
        edgeDictionary.put("int32, int41", "Head southeast in-between the Library and Dining Hall");
        edgeDictionary.put("int32, int38", "Head southeast towards the curved path leading to the Library");
        edgeDictionary.put("int38, library", "Head south into the Library");
        edgeDictionary.put("publicsafety, library", "Head northeast down the street then turn right and head into the Library");
        edgeDictionary.put("publicsafety, int32", "Head northeast down the street away from Public Safety");
        edgeDictionary.put("ford, publicsafety", "Head from the front of the Ford house to Public Safety");
        edgeDictionary.put("int31, ford", "Head northeast towards the Ford house");
        edgeDictionary.put("int41, int68", "Head northeast behind the back of the Library");
        edgeDictionary.put("int68, int40", "Head west towards Gustafson");
        edgeDictionary.put("int40, gustafson", "Head northwest into Gustafson");
        edgeDictionary.put("int31, int37", "Head southeast along Parking Lot 2");
        edgeDictionary.put("int37, int39", "Head southeast along Parking Lot 2");
        edgeDictionary.put("int39, int42", "Head east away from Parking Lot 2");
        edgeDictionary.put("int42, int40", "Head northwest towards Gustafson");
        edgeDictionary.put("int37, lot2", "Head south into Parking Lot 2");
        edgeDictionary.put("int39, lot2", "Head south into Parking Lot 2");
        edgeDictionary.put("lot2, arboreum", "Head into the Arboreum");
        edgeDictionary.put("int42, int43", "Head east along Parking Lot 1");
        edgeDictionary.put("int43, int44", "Head east along Parking Lot 1");
        edgeDictionary.put("int44, int52", "Head east along Parking Lot 1");
        edgeDictionary.put("int52, int61", "Head southeast along the road between Parking Lot 32 and 33");
        edgeDictionary.put("int61, int62", "Head east");
        edgeDictionary.put("lot32, int62", "Head east away from Parking Lot 32");
        edgeDictionary.put("lot1, lot32", "Head east into Parking Lot 32");
        edgeDictionary.put("int43, lot1", "Head southeast into Parking Lot 1");
        edgeDictionary.put("lot32, int52", "Head northwest towards the road entrance between Lot 1 and 32");
        edgeDictionary.put("lot1, int52", "Head east towards the road entrance between Lot 1 and 32");
        edgeDictionary.put("int52, lot33", "Head northeast into Parking Lot 33");
        edgeDictionary.put("int42, operationscenter", "Head southeast towards the Operations Center");
        edgeDictionary.put("int43, int68", "Head northwest");
        edgeDictionary.put("int44, int45", "Head north towards Monadnock");
        edgeDictionary.put("int45, int46", "Head north around Monadnock");
        edgeDictionary.put("int46, int47", "Head north");
        edgeDictionary.put("int47, int41", "Head northwest towards the Dining Hall");
        edgeDictionary.put("int45, monadnock", "Head east into Monadnock");
        edgeDictionary.put("int46, monadnock", "Head southeast into Monadnock");
        edgeDictionary.put("monadnock, int73", "Head northeast from Monadnock into the forest");
        edgeDictionary.put("int47, int73", "Head east into the forest");
        edgeDictionary.put("lot22, int73", "Head southeast into the forest from Lot 22");
        edgeDictionary.put("int73, int48", "Head northeast out of the forest");
        edgeDictionary.put("int71, int51", "Head southeast off of the main road on campus");
        edgeDictionary.put("int51, int70", "Head southeast towards an intersection");
        edgeDictionary.put("int70, int58", "Head southeast away from an intersection");
        edgeDictionary.put("int58, int57", "Head south along Parking Lot 30");
        edgeDictionary.put("int57, int63", "Head southwest until you hit a fork in the road");
        edgeDictionary.put("int63, int62", "Head west off the main road");
        edgeDictionary.put("int63, int53", "Head west towards the outer edges of Tuckerman");
        edgeDictionary.put("int53, int54", "Head northwest towards the outer edges of Tuckerman");
        edgeDictionary.put("int53, int55", "Head northeast towards Parking Lot 31");
        edgeDictionary.put("int54, lot31", "Head west towards Parking Lot 31");
        edgeDictionary.put("int55, lot31", "Head west away from the outer edges of Tuckerman");
        edgeDictionary.put("int55, int56", "Head northwest then turn right around Tuckerman");
        edgeDictionary.put("int54, int69", "Head west along Tuckerman");
        edgeDictionary.put("int56, int69", "Head northwest away from Tuckerman");
        edgeDictionary.put("int69, int48", "Head northwest into Tuckerman");
        edgeDictionary.put("lot31, tuckerman", "Head southwest out of Parking Lot 25");
        edgeDictionary.put("lot25, int48", "Head west towards Windson");
        edgeDictionary.put("int58, windson", "Head northwest away from Windson");
        edgeDictionary.put("windson, int49", "Head northwest away from the main road");
        edgeDictionary.put("int70, int50", "Head south along Hampton");
        edgeDictionary.put("int50, int49", "Head northwest into Hampton");
        edgeDictionary.put("int49, hampton", "Head south into Parking Lot 25");
        edgeDictionary.put("int49, lot25", "Head east into Parking Lot 20");
        edgeDictionary.put("int34, lot20", "Head southeast towards Penmen Field");
        edgeDictionary.put("int34, penmenfield", "Head from Lot 20 to southeast towards Penmen Field");
        edgeDictionary.put("lot20, penmenfield", "Head southwest then turn left and continue towards Parking Lot 24");
        edgeDictionary.put("penmenfield, lot24", "Head southeast towards Lot 26");
        edgeDictionary.put("lot24, lot26", "Head southeast away from Parking Lot 26");
        edgeDictionary.put("lot26, int60", "Head south along the green space");
        edgeDictionary.put("int60, int59", "Head east towards Lincoln");
        edgeDictionary.put("int60, lincoln", "Head southeast towards Conway");
        edgeDictionary.put("int59, conway", "Head from Lincoln to Conway");
        edgeDictionary.put("lincoln, conway", "Head east towards Lot 27");
        edgeDictionary.put("lincoln, lot27", "Head southeast towards Lot 27");
        edgeDictionary.put("conway, lot27", "Head east then turn right and continue");
        edgeDictionary.put("int58, int59", "Head southeast into Parking Lot 30");
        edgeDictionary.put("int57, lot30", "Head northeast into Parking Lot 30");
        edgeDictionary.put("int63, lot30", "Head southeast off of the main road on campus");
        edgeDictionary.put("int62, int64", "Head east into Parking Lot 37");
        edgeDictionary.put("int64, lot37", "Head southeast");
        edgeDictionary.put("int64, int65", "Head northeast off the main road and continue towards Ouellette Stadium");
        edgeDictionary.put("int65, ouellettestadium", "Head northeast off the main road");
        edgeDictionary.put("int65, lot38", "Head northeast off the main road and continue towards Parking Lot 38");
        edgeDictionary.put("int65, int66", "Head south");
        edgeDictionary.put("int66, setaannex", "Head east off the road into the SETA Annex");
        edgeDictionary.put("int66, int67", "Head south past the SETA Annex");
        edgeDictionary.put("int67, lot39", "Head southeast into Parking Lot 39");
        edgeDictionary.put("int67, lot40", "Head south towards Parking Lot 40");
        edgeDictionary.put("int23, wellnesscenter", "Head north into the Wellness Center");
        edgeDictionary.put("int24, wellnesscenter", "Head northwest into the Wellness Center");
        edgeDictionary.put("int1, lot13", "Head east out of west towards Parking Lot 13");
        edgeDictionary.put("lot12, int1", "Head northeast out of Parking Lot 12");
        edgeDictionary.put("lot11, lot12", "Head northeast towards Parking Lot 12");
        edgeDictionary.put("lot11, lot10", "Head northeast towards Parking Lot 13");
        edgeDictionary.put("lot10, int2", "Head northeast out of Parking Lot 10");
        edgeDictionary.put("int1, int2", "Head east");
        edgeDictionary.put("int3, int2", "Head west");
        edgeDictionary.put("int4, int3", "Head west");
        edgeDictionary.put("int5, int3", "Head northeast");
        edgeDictionary.put("int6, int5", "Head north until you turn northeast and then continue");
        edgeDictionary.put("lot6, int6", "Head northwest out of Parking Lot 6");
        edgeDictionary.put("newcastle, lot6", "Head out of Newcastle");
        edgeDictionary.put("lot8, newcastle", "Head towards Newcastle from Parking Lot 8");
        edgeDictionary.put("int6, lot8", "Head northeast towards Parking Lot 8");
        edgeDictionary.put("int7, lot9", "Head northeast towards Parking Lot 9");
        edgeDictionary.put("lot8, int7", "Head northeast away from Parking Lot 8");
        edgeDictionary.put("lot9, int4", "Head northeast away from Parking Lot 9");
        edgeDictionary.put("lot5, int6", "Head north away from Parking Lot 5");
        edgeDictionary.put("lot4, int17", "Head northwest then turn left and continue away from Parking Lot 4");
        edgeDictionary.put("int17, lot5", "Head northwest then turn right and continue");
        edgeDictionary.put("int18, int17", "Head west away from Parking Lot 3");
        edgeDictionary.put("lot3, int18", "Head across the street away from Parking Lot 3");
        edgeDictionary.put("athleticcomplex, int18", "Head southeast away from the Athletic Complex");
        edgeDictionary.put("athleticcomplex, int8", "Head northwest away from the Athletic Complex");
        edgeDictionary.put("lot6, int8", "Head southeast away from Parking Lot 6");
        edgeDictionary.put("int9, int8", "Head southwest along Larkin Field");
        edgeDictionary.put("newcastle, int9", "Head southeast away from Newcastle");
        edgeDictionary.put("int18, int8", "Head southeast along the Athletic Complex");
        edgeDictionary.put("lot7, int9", "Head southwest");
        edgeDictionary.put("int10, lot7", "Head southwest");
        edgeDictionary.put("int7, int10", "Head southeast");
        edgeDictionary.put("int11, int10", "Head southwest");
        edgeDictionary.put("lot9, int11", "Head southwest away from Lot 9 then turn left and continue");
        edgeDictionary.put("int7, int11", "Head northeast slightly towards Lot 9 then turn left and continue");
        edgeDictionary.put("int12, int11", "Head southwest");
        edgeDictionary.put("int13, int12", "Head southwest around Kingston");
        edgeDictionary.put("lot9, int12", "Head southeast away from Parking Lot 9");
        edgeDictionary.put("washington, int13", "Head south out of Washington");
        edgeDictionary.put("lot15, washington", "Head south into Washington");
        edgeDictionary.put("lot15, int4", "Head west then turn left and continue away from Lot 15");
        edgeDictionary.put("int14, lot15", "Head northwest towards Parking Lot 15");
        edgeDictionary.put("int14, int13", "Head south then turn around Washington building");
        edgeDictionary.put("int13, int15", "Head south");
        edgeDictionary.put("int16, int15", "Head northeast");
        edgeDictionary.put("int11, int16", "Head east");
        edgeDictionary.put("kingston, int15", "Head east away from Kingston");
        edgeDictionary.put("kingston, int16", "Head south away from Kingston");
        edgeDictionary.put("kingston, int12", "Head west away from Kingston");
        edgeDictionary.put("larkinfield, int18", "Walk south away from the center of Larkin Field");
        edgeDictionary.put("larkinfield, int8", "Walk west away from the center of Larkin Field");
        edgeDictionary.put("int19, larkinfield", "Walk east towards the center of Larkin Field");
        edgeDictionary.put("int10, int19", "Head southeast");
        edgeDictionary.put("int19, int22", "Head southeast");
        edgeDictionary.put("int20, int19", "Head southwest across the back of the Student Center");
        edgeDictionary.put("int21, int20", "Head southwest across the back of the Green Center");
        edgeDictionary.put("int20, int25", "Head southeast in-between the Student Center and Green Center");
        edgeDictionary.put("int26, int21", "Head northwest around the Green Center");
        edgeDictionary.put("int22, lot3", "Head southwest away from Parking Lot 3");
        edgeDictionary.put("int23, int22", "Head southwest until you're just northwest of Robert Frost");
        edgeDictionary.put("int24, int23", "Head southwest until you're in front of the Student Center");
        edgeDictionary.put("int25, int24", "Head southwest until you're just northwest of the center of the Green Space");
        edgeDictionary.put("int26, int25", "Head southwest until you're on the edge of the Green Space");
        edgeDictionary.put("int16, int20", "Head southeast away from Kingston");
        edgeDictionary.put("int15, int21", "Head southeast");
        edgeDictionary.put("studentcenter, int23", "Head south out of the Student Center");
        edgeDictionary.put("studentcenter, int24", "Head southeast out of the Student Center");
        edgeDictionary.put("greencenter, int25", "Head south out of the Green Center");
        edgeDictionary.put("greencenter, int26", "Head east out of the Student Center");
        edgeDictionary.put("int75, int26", "Head southwest away from the Hospitality front parking lot");
        edgeDictionary.put("hospitality, int75", "Head west out of the Hospitality building");
        edgeDictionary.put("int74, int75", "Head south away from the SETA building");
        edgeDictionary.put("seta, int74", "Head south out of the SETA building");
        edgeDictionary.put("int74, int26", "Head southwest");
        edgeDictionary.put("seta, int15", "Head southwest then continue away from SETA");
        edgeDictionary.put("seta, int21", "Head southwest away from SETA");
        edgeDictionary.put("int27, int74", "Head southwest along the edge of SETA");
        edgeDictionary.put("lot16, int27", "Head northwest away from Parking Lot 16");
        edgeDictionary.put("int28, int27", "Head southwest along the edge of SETA");
        edgeDictionary.put("int14, int28", "Head southeast along the edge of SETA");
        edgeDictionary.put("int29, int28", "Head southwest");
        edgeDictionary.put("lot17, int29", "Head southeast away from Parking Lot 17");
        edgeDictionary.put("int30, int29", "Head southwest down the long path connected to Webster");
        edgeDictionary.put("lot18, int30", "Head southeast towards Parking Lot 18");
        edgeDictionary.put("lot19, lot18", "Head east then turn right and continue towards Parking Lot 18");
        edgeDictionary.put("int36, lot19", "Head north then turn left and continue towards Parking Lot 19");
        edgeDictionary.put("madison, int36", "Head northwest away from Madison");
        edgeDictionary.put("int35, int36", "Head northeast");
        edgeDictionary.put("int34, int35", "Head northeast");
        edgeDictionary.put("int71, int34", "Head northeast");
        edgeDictionary.put("int33, int71", "Head northeast");
        edgeDictionary.put("int32, int33", "Head northeast away from the crosswalk in the center of campus");
        edgeDictionary.put("int30, int35", "Head east around Webster");
        edgeDictionary.put("webster, int35", "Head southeast out of Webster");
        edgeDictionary.put("lot18, int35", "Head northeast then turn right to go around Webster");
        edgeDictionary.put("lot18, webster", "Head west into Webster");
        edgeDictionary.put("int28, int71", "Head southeast across the street away from SETA");
        edgeDictionary.put("greenspace, int32", "Head southwest away from the Green Space");
        edgeDictionary.put("int24, greenspace", "Head east across the Green Space");
        edgeDictionary.put("int25, greenspace", "Head southeast across the Green Space");
        edgeDictionary.put("int26, greenspace", "Head south across the Green Space");
        edgeDictionary.put("frost, int32", "Head southeast and walk along the path away from Robert Frost");
        edgeDictionary.put("frost, int23", "Head northwest away from Robert Frost");
        edgeDictionary.put("frost, int72", "Head southwest away from Robert Frost");
        edgeDictionary.put("int22, int72", "Head southeast along the side of Robert Frost");
        edgeDictionary.put("belknap, int72", "Head northeast out of Belknap");
        edgeDictionary.put("belknap, int31", "Head south along Parking Lot 3 out of Belknap");
        edgeDictionary.put("int72, int31", "Head southeast then turn right around Belknap Hall");
        edgeDictionary.put("int18, int31", "Head southeast along Parking Lot 3");
        edgeDictionary.put("acc, int33", "Head west out of the ACC building");
        edgeDictionary.put("lot23, int33", "Head northwest out of Parking Lot 23");
        edgeDictionary.put("lot22, int33", "Head northwest out of Parking Lot 22");
        edgeDictionary.put("int41, lot22", "Head northeast towards Parking Lot 22");
        edgeDictionary.put("dininghall, int32", "Head west away from the Dining Hall");
        edgeDictionary.put("int41, int32", "Head northwest in-between the Library and Dining Hall");
        edgeDictionary.put("int38, int32", "Head northwest away from the curved path leading to the Library");
        edgeDictionary.put("library, int38", "Head north away from the Library");
        edgeDictionary.put("library, publicsafety", "Head northwest out of the Library and turn left towards the Public Safety house");
        edgeDictionary.put("int32, publicsafety", "Head southwest down the street towards Public Safety");
        edgeDictionary.put("publicsafety, ford", "Head from the front of the Public Safety house to Ford");
        edgeDictionary.put("ford, int31", "Head southwest away from the Ford house");
        edgeDictionary.put("int68, int41", "Head southwest behind the back of the Library");
        edgeDictionary.put("int40, int68", "Head east away from Gustafson");
        edgeDictionary.put("gustafson, int40", "Head southeast out of Gustafson");
        edgeDictionary.put("int37, int31", "Head northwest along Parking Lot 2");
        edgeDictionary.put("int39, int37", "Head northwest along Parking Lot 2");
        edgeDictionary.put("int42, int39", "Head west towards Parking Lot 2");
        edgeDictionary.put("int40, int42", "Head southeast away from Gustafson");
        edgeDictionary.put("lot2, int37", "Head north away from Parking Lot 2");
        edgeDictionary.put("lot2, int39", "Head north away from Parking Lot 2");
        edgeDictionary.put("arboreum, lot2", "Head out of the Arboreum");
        edgeDictionary.put("int43, int42", "Head west along Parking Lot 1");
        edgeDictionary.put("int44, int43", "Head west along Parking Lot 1");
        edgeDictionary.put("int52, int44", "Head west along Parking Lot 1");
        edgeDictionary.put("int61, int52", "Head northwest along the road between Parking Lot 32 and 33");
        edgeDictionary.put("int62, int61", "Head west");
        edgeDictionary.put("int62, lot32", "Head west into Parking Lot 32");
        edgeDictionary.put("lot32, lot1", "Head west into Parking Lot 1");
        edgeDictionary.put("lot1, int43", "Head northwest away from Parking Lot 1");
        edgeDictionary.put("int52, lot32", "Head southeast away from the road entrance between Lot 1 and 32");
        edgeDictionary.put("int52, lot1", "Head west away from the road entrance between Lot 1 and 32");
        edgeDictionary.put("lot33, int52", "Head southwest away from Parking Lot 33");
        edgeDictionary.put("operationscenter, int42", "Head northwest away from the Operations Center");
        edgeDictionary.put("int68, int43", "Head southeast");
        edgeDictionary.put("int45, int44", "Head south away from Monadnock");
        edgeDictionary.put("int46, int45", "Head south around Monadnock");
        edgeDictionary.put("int47, int46", "Head south");
        edgeDictionary.put("int41, int47", "Head southeast towards the Dining Hall");
        edgeDictionary.put("monadnock, int45", "Head west away from Monadnock");
        edgeDictionary.put("monadnock, int46", "Head northwest away from Monadnock");
        edgeDictionary.put("int73, monadnock", "Head southwest from the forest into Monadnock");
        edgeDictionary.put("int73, int47", "Head west away from the forest");
        edgeDictionary.put("int73, lot22", "Head northwest into Lot 22 from the forest");
        edgeDictionary.put("int48, int73", "Head southwest into the forest");
        edgeDictionary.put("int51, int71", "Head northwest into the main road on campus");
        edgeDictionary.put("int70, int51", "Head northwest");
        edgeDictionary.put("int58, int70", "Head northwest away from an intersection");
        edgeDictionary.put("int57, int58", "Head northwest towards an intersection");
        edgeDictionary.put("int63, int57", "Head north along Parking Lot 30");
        edgeDictionary.put("int62, int63", "Head northeast away from a fork in the road");
        edgeDictionary.put("int53, int63", "Head east towards the main road");
        edgeDictionary.put("int54, int53", "Head east away from the outer edges of Tuckerman");
        edgeDictionary.put("int55, int53", "Head southeast away from the outer edges of Tuckerman");
        edgeDictionary.put("lot31, int54", "Head southwest away from Parking Lot 31");
        edgeDictionary.put("lot31, int55", "Head east away from Parking Lot 31");
        edgeDictionary.put("int56, int55", "Head east toward the outer edges of Tuckerman");
        edgeDictionary.put("int69, int54", "Head southwest then turn left around Tuckerman");
        edgeDictionary.put("int69, int56", "Head east along Tuckerman");
        edgeDictionary.put("int48, int69", "Head southeast towards Tuckerman");
        edgeDictionary.put("tuckerman, lot31", "Head southeast into Lot 31");
        edgeDictionary.put("int48, lot25", "Head northeast into Parking Lot 25");
        edgeDictionary.put("windson, int58", "Head east away from Windson");
        edgeDictionary.put("int49, windson", "Head southeast towards Windson");
        edgeDictionary.put("int50, int70", "Head southeast towards the main road");
        edgeDictionary.put("int49, int50", "Head north along Hampton");
        edgeDictionary.put("hampton, int49", "Head southeast out of Hampton");
        edgeDictionary.put("lot25, int49", "Head north away from Parking Lot 25");
        edgeDictionary.put("lot20, int34", "Head west out of Parking Lot 20");
        edgeDictionary.put("penmenfield, int34", "Head northwest away from Penmen Field");
        edgeDictionary.put("penmenfield, lot20", "Head northwest towards Lot 20 away from Penmen Field");
        edgeDictionary.put("lot24, penmenfield", "Head northwest then turn right and continue towards Penmen Field");
        edgeDictionary.put("lot26, lot24", "Head northwest towards Lot 24");
        edgeDictionary.put("int60, lot26", "Head northwest towards Parking Lot 26");
        edgeDictionary.put("int59, int60", "Head north along the green space");
        edgeDictionary.put("lincoln, int60", "Head west away from Lincoln");
        edgeDictionary.put("conway, int59", "Head northwest away from Conway");
        edgeDictionary.put("conway, lincoln", "Head from Conway to Lincoln");
        edgeDictionary.put("lot27, lincoln", "Head west");
        edgeDictionary.put("lot27, conway", "Head northwest towards Conway");
        edgeDictionary.put("int59, int58", "Head northwest then turn left and continue");
        edgeDictionary.put("lot30, int57", "Head northwest away from Parking Lot 30");
        edgeDictionary.put("lot30, int63", "Head southwest away from Parking Lot 30");
        edgeDictionary.put("int64, int62", "Head northwest into the main road on campus");
        edgeDictionary.put("lot37, int64", "Head west out of Parking Lot 37");
        edgeDictionary.put("int65, int64", "Head northwest");
        edgeDictionary.put("ouellettestadium, int65", "Head southwest away from Ouellette Stadium");
        edgeDictionary.put("lot38, int65", "Head southwest away from Parking Lot 38");
        edgeDictionary.put("int66, int65", "Head north");
        edgeDictionary.put("setaannex, int66", "Head west away from the SETA Annex onto the road");
        edgeDictionary.put("int67, int66", "Head north past the SETA Annex");
        edgeDictionary.put("lot39, int67", "Head northwest out of Parking Lot 39");
        edgeDictionary.put("lot40, int67", "Head north away from Parking Lot 40");
        edgeDictionary.put("wellnesscenter, int23", "Head south out of the Wellness Center");
        edgeDictionary.put("wellnesscenter, int24", "Head southeast out of the Wellness Center");
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

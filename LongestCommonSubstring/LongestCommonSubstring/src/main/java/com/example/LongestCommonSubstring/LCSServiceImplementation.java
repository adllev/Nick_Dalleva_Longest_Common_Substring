package com.example.LongestCommonSubstring;

import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LCSServiceImplementation implements LCSService {                   //Implements LCS Service Interface

    @Override
    public List<LCS> getLCS(String[] arrayOfStrings){                           //Accepts an array of strings. Returns a list of LCS Objects
        Arrays.sort(arrayOfStrings, Comparator.comparingInt(String::length));  //Sort All Strings from shortest length to longest to get word with fewest roots first
        List<String> allSubstrings = new ArrayList<String>();                   //Initialize ArrayList of all possible substrings
        List<String> longestCommonSubstrings = new ArrayList<String>();         //Initialize ArrayList for Longest Common Substrings Found
        int numStrings = arrayOfStrings.length;                                 //Get the number of total strings provided

        for (int i = 0; i < arrayOfStrings[0].length(); i++) {                  //first "for" loop breaks the first and smallest word in the array into all possible roots
            for (int j = i+1; j <= arrayOfStrings[0].length(); j++) {
                allSubstrings.add(arrayOfStrings[0].substring(i,j));            //All possible roots stored in allSubstrings variable
            }
        }

        for(int n = 1; n < numStrings; n++){                                    //second "for" loop to iterate through each string remaining
            int numSubstrings = allSubstrings.size();                           //Store the current number of substrings
            for(int s = 0; s < numSubstrings; s++){                                 //"for" loop to see if substring within allSubstrings is "contained" in the current string. Word is removed if it is not in common
                if(!arrayOfStrings[n].contains(allSubstrings.get(s))){
                    allSubstrings.remove(s);                                        //remove substring that doesnt match
                    s = s - 1;                                                      //update count due to reduction in number of elements in the substring ArrayList. Avoids skipping elements and out of bounds errors
                    numSubstrings = numSubstrings - 1;                              //update number of substrings remaining
                }
            }
        }
        if(allSubstrings.size()!=0){
            allSubstrings.sort(Comparator.comparingInt(String::length).reversed());    //Now that we have ALL common substrings we need to sort them from largest to smallest
            int lcsLength = allSubstrings.get(0).length();                              //get length of longest substring found
            for(String ss : allSubstrings){                                             //"for" loop to add all substrings of that length to the final list of longestCommonSubstrings
                if(ss.length()==lcsLength){
                    longestCommonSubstrings.add(ss);                                    //adds longest substrings to longestCommonSubstrings
                }
            }
            Collections.sort(longestCommonSubstrings);                                  //Sorts alphabetically
            List<LCS> LCSListFinal = new ArrayList<>();                                 //Initialize list of LCS objects
            for(String substring : longestCommonSubstrings){                            // add all longest common substrings to LCS Object list
                LCS lcs = new LCS();
                lcs.setValue(substring);
                LCSListFinal.add(lcs);
            }
            return LCSListFinal;                 //return final list of LCS

        } else {
            return new ArrayList<>();
        }
    };
}
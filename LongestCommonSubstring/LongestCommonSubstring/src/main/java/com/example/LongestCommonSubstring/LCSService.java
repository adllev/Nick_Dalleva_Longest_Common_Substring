package com.example.LongestCommonSubstring;

import java.util.List;

public interface LCSService {                               //Interface for LCSService
    public List<LCS> getLCS(String[] arrayOfStrings);       //getLCS function acceps an array of strings. Returns list of LCS objects
}

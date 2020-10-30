package com.example.LongestCommonSubstring;

import java.util.HashSet;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

@RestController                 //Data returned by method will be added to response body
@RequestMapping("/")            //edits url mapping
public class LCSController {        //LCS controller to handle requests and responses

    @Autowired                      //Dependency injection for LCSService
    LCSService lcsService;

    @RequestMapping(value = "lcs", method = RequestMethod.POST, produces="application/json") //dictate post method and content-type of response
    @ResponseBody
    public ResponseEntity<String> longestCommonSubstring(HttpEntity<String> httpEntity) throws IllegalArgumentException { //longestcommonsubstring returns response entity containing a json string
        HashSet<String> setOfStrings = new HashSet<String>();       //Initialize HashSet to store all strings
        try{                                                        //"try" wrapper to catch exceptions. Badly formatted inputs
            ObjectMapper objectMapper = new ObjectMapper();           //Jackson Mapper to get json into Java object
            JsonNode jsonNode = objectMapper.readTree(httpEntity.getBody()).get("setOfStrings");

            for(JsonNode j : jsonNode){                                                                     //"for" loop checks for duplicate entries
                if (setOfStrings.add(j.get("value").toString().replace("\"", ""))){
                    setOfStrings.add(j.get("value").toString().replace("\"", ""));
                } else{
                    ErrorResponse errorResponse = new ErrorResponse();
                    errorResponse.setStatus(400);
                    errorResponse.setMessage("All Strings Must be Unique");
                    return new ResponseEntity<String>(new Gson().toJson(errorResponse), HttpStatus.BAD_REQUEST);       //Responds with Error and proper http status message
                }
            }

            if(setOfStrings.size() ==0 ){                   //If no strings return error status and inform user they must enter strings
                ErrorResponse errorResponse = new ErrorResponse();
                errorResponse.setStatus(400);
                errorResponse.setMessage("Set of Strings Must Not Be Empty");
                return new ResponseEntity<String>(new Gson().toJson(errorResponse), HttpStatus.BAD_REQUEST);
            }

        } catch (Exception e) {                   //Catch all formatting exceptions
            ErrorResponse errorResponse = new ErrorResponse();
            errorResponse.setStatus(400);
            errorResponse.setMessage("Format Not Acceptable");
            return new ResponseEntity<String>(new Gson().toJson(errorResponse), HttpStatus.BAD_REQUEST);
        }
        LCSWrapper lcsWrapper = new LCSWrapper();       //initialize LCSWrapper object
        lcsWrapper.setLcs(lcsService.getLCS(setOfStrings.toArray(new String[setOfStrings.size()]))); //Run lcsService.getLCS() algorithm on the Array of strings provided. Insert returned data into LCSWrapper object
        lcsWrapper.setLcs(lcsService.getLCS(setOfStrings.toArray(new String[setOfStrings.size()]))); //Run lcsService.getLCS() algorithm on the Array of strings provided. Insert returned data into LCSWrapper object
        return new ResponseEntity<String>(new Gson().toJson(lcsWrapper), HttpStatus.OK);        //Return json response of LCSWrapper object using gson to convert POJO into JSON. Respond HTTP OK message
    };
}

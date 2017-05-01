package com.example.Strings;

import java.util.ArrayList;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Pretty print a json object using proper indentation.

Every inner brace should increase one indentation to the following lines.
Every close brace should decrease one indentation to the same line and the following lines.
The indents can be increased with an additional ‘\t’
Example 1:

Input : {A:"B",C:{D:"E",F:{G:"H",I:"J"}}}
Output :
{
    A:"B",
    C:
    {
        D:"E",
        F:
        {
            G:"H",
            I:"J"
        }
    }
}
Example 2:

Input : ["foo", {"bar":["baz",null,1.0,2]}]
Output :
[
    "foo",
    {
        "bar":
        [
            "baz",
            null,
            1.0,
            2
        ]
    }
]
[] and {} are only acceptable braces in this case.

Assume for this problem that space characters can be done away with.

Your solution should return a list of strings, where each entry corresponds to a single line. The strings should not have “\n” character in them.
 */

public class PrettyJson {
    public ArrayList<String> prettyJSON(String a) {
        ArrayList<String> result = new ArrayList<>();
        int indentation = 0;
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < a.length(); i++){
            char c = a.charAt(i);
            if(c == ' ')
                continue;
            else if(c == '[' || c == '{'){
                temp.append(c);
                StringBuilder builder = new StringBuilder();
                for(int j = indentation; j > 0; j--)
                    builder.append("\t");
                builder.append(temp.toString());
                result.add(builder.toString());
                temp.setLength(0);
                indentation++;
            } else if(c == ']' || c == '}'){
                if(i < a.length()-1 && a.charAt(i+1) == ','){
                    indentation--;
                    temp.append(c);
                    temp.append(a.charAt(++i));
                    StringBuilder builder = new StringBuilder();

                    for(int j = indentation; j > 0; j--)
                        builder.append("\t");
                    builder.append(temp.toString());
                    result.add(builder.toString());
                    temp.setLength(0);
                }else{
                    temp.append(c);
                    indentation--;
                    StringBuilder builder = new StringBuilder();

                    for(int j = indentation; j > 0; j--)
                        builder.append("\t");
                    builder.append(temp.toString());
                    result.add(builder.toString());
                    temp.setLength(0);
                }
            }else if(c == ':' && (a.charAt(i+1) == '{' || a.charAt(i+1) == '[')){
                temp.append(c) ;
                StringBuilder builder = new StringBuilder();
                for(int j = indentation; j > 0; j--)
                    builder.append("\t");
                builder.append(temp.toString());
                result.add(builder.toString());
                temp.setLength(0);
            }else if(c == ':' && (a.charAt(i+1) != '{' || a.charAt(i+1) != '['))
                temp.append(c);
            else if(c == ',' || c == ':' || a.charAt(i+1) == '}' || a.charAt(i+1) == ']'|| a.charAt(i+1) == '{' || a.charAt(i+1) == '['){
                temp.append(c);
                StringBuilder builder = new StringBuilder();
                for(int j = indentation; j > 0; j--)
                    builder.append("\t");
                builder.append(temp.toString());
                result.add(builder.toString());
                temp.setLength(0);
            }
            else{
                temp.append(c);
            }
        }
        // for(int i = 0; i < result.size(); i++)
        //     System.out.println(result.get(i));
        return result;
    }
}

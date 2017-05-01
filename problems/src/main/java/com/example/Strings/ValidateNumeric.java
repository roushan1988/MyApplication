package com.example.Strings;

/**
 * Created by shwetatrivedi1 on 2/8/17.
 */
/*
Validate if a given string is numeric.

Examples:

"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 */
public class ValidateNumeric {
    boolean valid(String s){
        int i=0;
        boolean e =false; // check if 'e' exists
        boolean dot=false; // check if '.' exists
        boolean dig =false;

        while (i< s.length()-1){
            if (i==0){ // a number can start with +, -, .
                if (s.charAt(i)<'0' || s.charAt(i)>'9'){ // if is 0-9 continue
                    if (s.charAt(i)=='+' || s.charAt(i)=='-' || s.charAt(i)=='.'){
                        if (s.length()==1){return false;} // only +, - , . is not a number
                        if (s.charAt(i)=='.'){dot=true;}
                    }
                    else {return false;}
                }else{dig=true;}
                i++;
            }
            if (i>0){
                switch (s.charAt(i)){
                    case 'e': // e cannot follow +,- , .
                        if ( !e && s.charAt(i-1)!='+' && s.charAt(i-1)!='-' && dig && i!=s.length()-1) {
                            e = true;
                        }else{
                            return false;
                        }
                        break;
                    case 'E': // e cannot follow +,- , .
                        if (!e && s.charAt(i-1)!='+' && s.charAt(i-1)!='-' && dig && i!=s.length()-1) {
                            e = true;
                        }else{
                            return false;
                        }
                        break;
                    case '+': // + can only occur before e
                        if (s.charAt(i-1)=='e' || s.charAt(i-1)=='E'){}else{return false;}
                        break;
                    case '-': // - can only occur before e
                        if (s.charAt(i-1)=='e' || s.charAt(i-1)=='E'){}else{return false;}
                        break;
                    case '.': // . can only occur once and cannot occure after e
                        if (!dot && !e){dot=true;}else{return false;}
                        break;
                    default:  // only 0-9 can be valid numbers
                        if (s.charAt(i)<'0'||s.charAt(i)>'9'){return false;}
                        else{dig = true;}
                        break;
                }
                i++;continue;
            }
        }

        //last dig can only be 0-9, or ., when it is . there is no . and e before
        if (s.charAt(s.length()-1)>='0' && s.charAt(s.length()-1)<='9')
            return true;
        if (s.charAt(s.length()-1)=='.' && !dot && !e && s.charAt(s.length()-2)>='0' && s.charAt(s.length()-2)<='9')
            return true;
        return false;
    }
    boolean isNumber(String s) {
        String s1 = s.trim(); //delete spaces in the front and end, don't delete the spaces in middle.
        if (s1.length()==0){return false;} // if null string, return false;
        return valid(s1);
    }
}

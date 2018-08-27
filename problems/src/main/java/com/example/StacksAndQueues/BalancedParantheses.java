package com.example.StacksAndQueues;

import java.util.Stack;

public class BalancedParantheses {
    public int isValid(String A) {
        /* Declare an empty character stack */
        Stack<Character> st=new Stack<>();

       /* Traverse the given expression to
          check matching parenthesis */
        for(int i=0;i<A.length();i++)
        {

          /*If the exp[i] is a starting
            parenthesis then push it*/
            if (A.charAt(i) == '{' || A.charAt(i) == '(' || A.charAt(i) == '[')
                st.push(A.charAt(i));

          /* If exp[i] is an ending parenthesis
             then pop from stack and check if the
             popped parenthesis is a matching pair*/
            if (A.charAt(i) == '}' || A.charAt(i) == ')' || A.charAt(i) == ']')
            {

              /* If we see an ending parenthesis without
                 a pair then return false*/
                if (st.isEmpty())
                {
                    return 0;
                }

             /* Pop the top element from stack, if
                it is not a pair parenthesis of character
                then there is a mismatch. This happens for
                expressions like {(}) */
                else if ( !isMatchingPair(st.pop(), A.charAt(i)) )
                {
                    return 0;
                }
            }

        }

       /* If there is something left in expression
          then there is a starting parenthesis without
          a closing parenthesis */

        if (st.isEmpty())
            return 1; /*balanced*/
        else
        {   /*not balanced*/
            return 0;
        }
    }

    /* Returns true if character1 and character2
       are matching left and right Parenthesis */
    static boolean isMatchingPair(char character1, char character2)
    {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }
}

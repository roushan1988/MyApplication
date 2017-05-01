package com.example.Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shwetatrivedi1 on 2/9/17.
 */
/*
You are given the following :

A positive number N
Heights : A list of heights of N persons standing in a queue
Infronts : A list of numbers corresponding to each person (P) that gives the number of persons who are taller than P
and standing in front of P
You need to return list of actual order of persons’s height

Consider that heights will be unique

Example

Input :
Heights: 5 3 2 6 1 4
InFronts: 0 1 2 0 3 2
Output :
actual order is: 5 3 2 1 6 4
So, you can see that for the person with height 5, there is no one taller than him who is in front of him,
and hence Infronts has 0 for him.

For person with height 3, there is 1 person ( Height : 5 ) in front of him who is taller than him.

You can do similar inference for other people in the list.
 */
public class OrderOfHeights {
    static class Person implements Comparator<Person> {
        int height;
        int infront;
        public Person(){}
        public Person(int height, int infront){
            this.height = height;
            this.infront = infront;
        }
        public int compare(Person p1, Person p2){
            return p1.height - p2.height;
        }
    }

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        ArrayList<Integer> result = new ArrayList<>();
        if(heights == null || infronts == null || heights.size() != infronts.size())
            return result;

        int n = heights.size();
        Person[] persons = new Person[n];
        for(int i = 0; i< n; i++)
            persons[i] = new Person(heights.get(i), infronts.get(i));

        Arrays.sort(persons, new Person());

        Person[] temp = new Person[n];
        for(Person p : persons){
            int count = 0;
            for(int i = 0; i < n; i++){
                if(count == p.infront){ //no. of empty slots seen till now can hold ppl of greater height
                    while(temp[i] != null && i < n-1)
                        i++;
                    temp[i] = p;
                    break;
                }
                if(temp[i] == null){ //a filled temp[i] will have a smaller height person that is not to be counted,
                    count++; // only an empty slot can have place for a person of taller height
                }
            }
        }
        for(int i = 0; i < n; i++)
            result.add(temp[i].height);
        return result;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author vmatheis
 */
public class PredicateMain {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        list.add(0);
        list.add(-4);
        list.add(6);
        list.add(5);
        list.add(-6);
        list.add(7);
        list.add(1);
        //list.add(null);
        list.add(-4);
        list.add(8);
        stringList.add("hello");
        stringList.add("i'm");
        stringList.add("doing");
        stringList.add("homework");
        
        predicate(list, stringList);
    }

    public static void predicate(List<Integer> list, List<String> stringList) {
        final Predicate<Integer> isEven = e -> (e % 2 == 0 && e != 0 );
        final Predicate<Integer> isPositive = e -> e > 0;
        final Predicate<Integer> isNull = e -> e == 0;
        //final Predicate<Integer> wertIsNull = e -> e == null;
        final Predicate<String> isShortWord = e -> e.length() < 4;

        try {
            list.stream().filter(isEven.and(isPositive)).forEach(s -> System.out.println(s + " is even and positive"));
            System.out.println("------------------------");
            list.stream().filter(isEven.negate().and(isPositive)).forEach(s -> System.out.println(s + " is positive and odd"));
            System.out.println("------------------------");
            list.stream().filter(isNull).forEach(s -> System.out.println(s + " is zero"));
            System.out.println("------------------------");
            //list.stream().filter(wertIsNull).forEach(s -> System.out.println(s + " is null"));
            stringList.stream().filter(isShortWord).forEach(s -> System.out.println("*" + s + "* has less than 4 letters"));

        } catch (NullPointerException e) { 
            System.out.println("null is null");
        }
    }
}

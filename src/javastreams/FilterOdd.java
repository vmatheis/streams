/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author vmatheis
 */
public class FilterOdd {
    static final int result = IntStream.of(1,2,3,4,5,6,7,8,9,10).filter(w -> w%2 != 0).map(x -> x*x).sum();
    public static void main(String[] args) {
        System.out.println(result);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

/**
 *
 * @author vmatheis
 */
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Streams {
    int[] numbers;
    String[] string = new String[10];

    public Streams(int[] numbers) {
        this.numbers = numbers;
        for (int i = 0; i < 1000; i++) {
            this.numbers[i] = ((int) ((Math.random()*100)+1));
        }
        byte[] b = new byte[10];
        for (String s : string) {
            new Random().nextBytes(b);
            s = new String(b, Charset.forName("UTF-8"));
        }
    }

    public double average(int[] numbers) {
        return Arrays.stream(numbers).asDoubleStream().average().getAsDouble();
    }

    public List<String> upperCase(String[] strings) {
        //implement this
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        //implement this
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        //implement this
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        //implement this
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        //implement this
    }

    public List<String> toNameList(List<Weapon> weapons) {
        //implement this
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        //implement this
    }

    public int sumUpValues(List<Weapon> weapons) {
        //implement this
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        //implement this
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        //implement this
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        //implement this
    }
}

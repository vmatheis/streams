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
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    int[] numbers = new int[1000];
    String[] string = new String[10];
    List<Weapon> weapon = new ArrayList<>();

    public Streams() {
    }

    public double average(int[] numbers) {
        return Arrays.stream(numbers).asDoubleStream().average().getAsDouble();
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.asList(strings).stream().map(w -> w.toUpperCase()).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        try {
            return weapons.stream().min(Comparator.comparing(Weapon::getDamage)).get();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        try {
            return weapons.stream().max(Comparator.comparing(Weapon::getMinStrength)).get();
        } catch (NoSuchElementException ex) {
            return null;
        }
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(w -> w.getDamageType() == DamageType.MISSILE).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        try {
            return weapons.stream().max(new Comparator<Weapon>() {
                @Override
                public int compare(Weapon o1, Weapon o2) {
                    return o1.getName().length() - o2.getName().length();
                }
            })
                    .get();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(w -> w.getName()).collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream().mapToInt(w -> w.getSpeed()).toArray();
    }

    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream().mapToInt(w -> w.getValue()).sum();
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return weapons.stream().mapToInt(w -> w.hashCode()).sum();
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().map(w -> w).collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        //weapons.stream().map(w -> w.setValue(((int) w.getValue() * 1.1)));
    }

}

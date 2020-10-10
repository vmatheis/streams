/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static javastreams.JavaStreams.weapon;

/**
 *
 * @author vmatheis
 */
public class MainStreams {

    public static void main(String[] args) throws IOException {
        initialize();
    }

    public static void initialize() throws IOException {
        Streams s = new Streams();
        for (int i = 0; i < s.number.length; i++) {
            s.number[i] = ((int) ((Math.random() * 100) + 1));
        }

        byte[] b = new byte[10];
        for (int i = 0; i < s.string.length; i++) {
            new Random().nextBytes(b);
            s.string[i] = new String(b, Charset.forName("UTF-8"));
        }

        s.weapon = Files.lines(new File("weapons.csv").toPath()).skip(1)
                .map(x -> x.split(";"))
                .map(w -> new Weapon(
                w[0],
                CombatType.valueOf(w[1]),
                DamageType.valueOf(w[2]),
                Integer.parseInt(w[3]),
                Integer.parseInt(w[4]),
                Integer.parseInt(w[5]),
                Integer.parseInt(w[6])
        )).collect(Collectors.toList());

        System.out.println("average");
        System.out.println(s.average(s.number));
        System.out.println("upperCase");
        System.out.println(s.upperCase(s.string));
        System.out.println("lowestDamage");
        System.out.println(s.findWeaponWithLowestDamage(s.weapon));
        System.out.println("highestStrength");
        System.out.println(s.findWeaponWithHighestStrength(s.weapon));
        System.out.println("damageTyp.Missile");
        System.out.println(s.collectMissileWeapons(s.weapon));
        System.out.println("longestName");
        System.out.println(s.findWeaponWithLongestName(s.weapon));
        System.out.println("listNames");
        System.out.println(s.toNameList(s.weapon));
        System.out.println("speeds");
        System.out.println(s.toSpeedArray(s.weapon));
        System.out.println("sumValues");
        System.out.println(s.sumUpValues(s.weapon));
        System.out.println("sumHashCodes");
        System.out.println(s.sumUpHashCodes(s.weapon));
        System.out.println("noDuplicates");
        System.out.println(s.removeDuplicates(s.weapon));
        System.out.println("value+10%");
        s.increaseValuesByTenPercent(s.weapon);
    }
}

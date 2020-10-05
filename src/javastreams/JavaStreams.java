/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javastreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author vmatheis
 */
public class JavaStreams {

    static Comparator<Weapon> c;

    public static List<Weapon> main(String[] args) throws IOException {
        List<Weapon> weapon = new ArrayList<>();

        weapon = Files.lines(new File("weapons.csv").toPath()).skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                s[0],
                CombatType.valueOf(s[1]),
                DamageType.valueOf(s[2]),
                Integer.parseInt(s[3]),
                Integer.parseInt(s[4]),
                Integer.parseInt(s[5]),
                Integer.parseInt(s[6])
        ))
                .collect(Collectors.toList());
        weapon.sort(c);
        return weapon;
    }

    public static void initialize() {
        c = ((o1, o2) -> Integer.compare(o1.getDamage(), o2.getDamage()));
    }
}

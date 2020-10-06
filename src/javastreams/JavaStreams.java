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

    static Comparator<Weapon> damage;
    static Comparator<Weapon> bigc;
    static List<Weapon> weapon = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        initialize();
        readFile();
        printList();
        printListAsTable();
    }

    public static void readFile() throws IOException {
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
        weapon.sort(bigc);
    }

    public static void initialize() {
        damage = ((o1, o2) -> Integer.compare(o1.getDamage(), o2.getDamage()));
        bigc = ((o1, o2) -> {
            if (o1.getCombatType().compareTo(o2.getCombatType()) == 0) {
                if (Integer.compare(o1.getDamage(), o2.getDamage()) == 0) {
                    return o1.getName().compareTo(o2.getName());
                } else {
                    return Integer.compare(o1.getDamage(), o2.getDamage());
                }
            } else {
                return o1.getCombatType().compareTo(o2.getCombatType());
            }
        });
    }

    public static void printList() {
        Printable printable = p -> System.out.println(p.getName() + " [" + p.getDamageType() + " = " + p.getDamage() + "]");
        weapon.forEach(w -> printable.print(w));
    }

    public static void printListAsTable() {
        System.out.println("-----------------------------------------------------------------");

        Printable tablePrint = (w) -> {
            System.out.printf("%-20s", " | " + w.getName());
            System.out.printf("%-9s", " | " + w.getCombatType());
            System.out.printf("%-11s ", " | " + w.getDamageType());
            System.out.printf("%-6s", " | " + w.getDamage());
            System.out.printf("%-3s", " | " + w.getSpeed());
            System.out.printf("%-6s", " | " + w.getMinStrength());
            System.out.printf("%-7s %n", " | " + w.getValue());
            System.out.println("+---------------------------------------------------------------+");
        };
        weapon.forEach(w -> tablePrint.print(w));
        System.out.println("-----------------------------------------------------------------");

    }

}

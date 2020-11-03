package com.example.eshopweb;

import com.example.eshopweb.entity.Item;

import java.util.*;

public class Lambda_Example {

    public static void main(String[] args) {

        // gulas :-)
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item(2, "Paprika", 50),
                new Item(3, "Knedlik", 20),
                new Item(4, "Cibule", 30),
                new Item(5, "Cesnek", 20),
                new Item(6, "Kmin", 10),
                new Item(7, "Mleta paprika", 10),
                new Item(8, "Rajcata", 50),
                new Item(1, "Hovezi maso", 500)
        ));

        // Do Java 8:

//        Collections.sort(items, new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                int x = Double.compare(o2.getPrice(), o1.getPrice());
//                if(x == 0) {
//                    x = o1.getName().compareTo(o2.getName());
//                }
//                return x;
//            }
//        });

        // Od Java 8:
        // Kazdy interface, ktery ma PRAVE JEDNU ABSTRAKTNI METODU
        // je tzv. funkcionalni interface a je mozne ho alternativne zapsat jako lambda vyraz

        // THIS IS LAMBDA!!!
//        Collections.sort(items, (Item o1, Item o2) -> {
//                int x = Double.compare(o2.getPrice(), o1.getPrice());
//                if(x == 0) {
//                    x = o1.getName().compareTo(o2.getName());
//                }
//                return x;
//            });

        // THIS IS LAMBDA!!!
//        Collections.sort(items, (o1, o2) -> {
//            int x = Double.compare(o2.getPrice(), o1.getPrice());
//            if(x == 0) {
//                x = o1.getName().compareTo(o2.getName());
//            }
//            return x;
//        });

        items.sort(Comparator.comparing(Item::getPrice).reversed().thenComparing(Item::getName));

        // THIS IS LAMBDA!!!
        // jednodussi varianta
//        Collections.sort(items, (o1, o2) -> {
//            return Double.compare(o2.getPrice(), o1.getPrice());
//        });
//
//        // THIS IS LAMBDA!!!
//        // jednoradkovy lambda vyraz
//        Collections.sort(items, (o1, o2) -> Double.compare(o2.getPrice(), o1.getPrice()));
//
//        // jeste lepe:
//        items.sort(Comparator.comparing(Item::getPrice).reversed());


        // :: je "method reference"
        // nejjednodussi lambda vyraz je mozne alternativne zapsat pres method reference
        items.forEach(System.out::println);


    }

}

@FunctionalInterface
interface I {
    void test(); // JEDINA ABSTRAKTNI METODA
    default void test2() {

    }
    static void test3() {

    }
}
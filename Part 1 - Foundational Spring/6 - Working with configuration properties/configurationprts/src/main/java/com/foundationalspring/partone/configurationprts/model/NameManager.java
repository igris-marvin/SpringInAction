package com.foundationalspring.partone.configurationprts.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.foundationalspring.partone.configurationprts.dao.NameManagerDAO;

@Component
public class NameManager implements NameManagerDAO<String> {

    @Override
    public List<String> generateNames() {
        List<String> names = new ArrayList<>();

        addNames(names);

        return names;
    }
    @Override
    public List<String> pageableFilter(List<String> n, Integer p) {

        List<String> names = n.subList(0, p);

        return names;

    }

    @Override
    public void displayNames(List<String> n) {

        for (String x : n) {
            System.out.println(x);
        }

    }

    private void addNames(List<String> names) {
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Eve");
        names.add("Frank");
        names.add("Grace");
        names.add("Hannah");
        names.add("Ivy");
        names.add("Jack");
        names.add("Kathy");
        names.add("Leo");
        names.add("Mona");
        names.add("Nina");
        names.add("Oscar");
        names.add("Paul");
        names.add("Quincy");
        names.add("Rachel");
        names.add("Sam");
        names.add("Tina");
        names.add("Uma");
        names.add("Victor");
        names.add("Wendy");
        names.add("Xander");
        names.add("Yara");
        names.add("Zane");
        names.add("Aaron");
        names.add("Bella");
        names.add("Cody");
        names.add("Diana");
        names.add("Ethan");
        names.add("Fiona");
        names.add("George");
        names.add("Holly");
        names.add("Ian");
        names.add("Jill");
        names.add("Kevin");
        names.add("Luna");
        names.add("Mason");
        names.add("Nora");
        names.add("Owen");
        names.add("Piper");
        names.add("Quinn");
        names.add("Riley");
        names.add("Sophia");
        names.add("Tom");
        names.add("Ursula");
        names.add("Vince");
        names.add("Willow");
        names.add("Josh");
    }
}

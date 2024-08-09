package com.foundationalspring.partone.configurationprts.model;

import java.util.List;

public class NameThread implements Runnable {

    private int size = 10;
    
    private NameManager mng;

    public NameThread(NameManager mng) {
        this.mng = mng;
    }

    @Override
    public void run() {
        List<String> names = mng.generateNames();

        names = mng.pageableFilter(names, size);

        System.out.println("Size: " + names.size());
    }
    
}

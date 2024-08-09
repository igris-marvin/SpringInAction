package com.foundationalspring.partone.configurationprts.dao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface NameManagerDAO<T> {
    List<T> generateNames();
    List<T> pageableFilter(List<T> n, Integer p);
    void displayNames(List<T> n);
}

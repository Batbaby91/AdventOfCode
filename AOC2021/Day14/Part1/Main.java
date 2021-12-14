package AOC2021.Day14.Part1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static HashMap<ArrayList<Character>, ArrayList<Character>> readRules(HashMap<ArrayList<Character>, ArrayList<Character>> rules, String filename ) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line =  reader.nextLine();
        if(line.contains("->")) {
          char[] splitLine = line.toCharArray();
          ArrayList<Character> before = new ArrayList<Character>();
          ArrayList<Character> after = new ArrayList<Character>();
          before.add(splitLine[0]);
          before.add(splitLine[1]);
          after.add(splitLine[0]);
          after.add(splitLine[6]);

          rules.put(before, after);
        }
      }
      reader.close();
    } 
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    return rules;
  }

  public static ArrayList<Character> readTemplate(ArrayList<Character> template, String filename ) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      for(char c : reader.nextLine().toCharArray()) {
        template.add(c);
      }
      reader.close();
    } 
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    return template;
  }

  public static void main(String[] args) {
    HashMap<ArrayList<Character>, ArrayList<Character>> rules = new HashMap<ArrayList<Character>, ArrayList<Character>>();
    ArrayList<Character> template = new ArrayList<Character>();
    ArrayList<Character> newTemplate = new ArrayList<Character>();
    String filename = "AOC2021\\Day14\\Part1\\input.txt";
    HashMap<Character, Integer> charTally = new HashMap<Character, Integer>();

    rules = readRules(rules, filename);
    template = readTemplate(template, filename);

    for(int counter=0; counter<10; counter++) {

      for(int x=1; x<template.size(); x++) {
        ArrayList<Character> pair = new ArrayList<Character>();
        pair.add(template.get(x-1));
        pair.add(template.get(x));
        ArrayList<Character> newEntry = rules.get(pair);

        for(Character c: newEntry) {
          newTemplate.add(c);
        }

        if(x == template.size()-1) {
          newTemplate.add(template.get(x));
        }
      }

      template.clear();
      template.addAll(newTemplate);
      newTemplate.clear();
    }

    for(Character c : template) {
      if(charTally.containsKey(c)) {
        charTally.replace(c, (charTally.get(c) + 1));
      }
      else {
        charTally.put(c, 1);
      }
    }

    ArrayList<Integer> frequencies = new ArrayList<Integer>(charTally.values());
    Collections.sort(frequencies);

    System.out.println((frequencies.get(frequencies.size()-1) - frequencies.get(0)));
  }
}

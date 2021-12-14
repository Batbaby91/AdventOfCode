package AOC2021.Day14.Part2;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

  public static HashMap<String, Pair> readRules(HashMap<String, Pair> rules, String filename ) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      while (reader.hasNextLine()) {
        String line =  reader.nextLine();
        if(line.contains("->")) {
          char[] splitLine = line.toCharArray();
          char[] original = { splitLine[0], splitLine[1] };
          char addition = splitLine[6];
          Pair pair = new Pair(original, addition);

          rules.put(new String(original), pair);
        }
      }
      reader.close();
    } 
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    return rules;
  }

  public static char[] readTemplate(String filename ) {
    try {
      File input = new File(filename);
      Scanner reader = new Scanner(input);

      char[] template = reader.nextLine().toCharArray();

      reader.close();

      return template;
    } 
    catch (Exception e) { System.out.println(e.getMessage()); }
    
    return null;
  }

  public static void main(String[] args) {
    String filename = "AOC2021\\Day14\\Part2\\input.txt";
    HashMap<String, Pair> rules = new HashMap<String, Pair>();
    char[] template = readTemplate(filename);

    HashMap<Pair, Long> pairCount = new HashMap<Pair, Long>();
    HashMap<Pair, Long> workingPairCount = new HashMap<Pair, Long>();
    HashMap<Character, Long> charCount = new HashMap<Character, Long>();

    rules = readRules(rules, filename);

    for(Pair pair : rules.values()) {
      pairCount.put(pair, 0l);
    }

    for(int x=1; x<template.length; x++) {
      char[] sub = {template[x-1], template[x]};
      String index = new String(sub);
      Pair pair = rules.get(index);

      pairCount.replace(pair, (pairCount.get(pair)+1));
    }

    for(int counter=0; counter<40; counter++) {
      workingPairCount.putAll(pairCount);
      for(Pair pair : pairCount.keySet()) {
        workingPairCount.replace(pair, workingPairCount.get(pair)-pairCount.get(pair));
        Pair newPair1 = rules.get(pair.getNew1());
        Pair newPair2 = rules.get(pair.getNew2());
        workingPairCount.replace(newPair1, workingPairCount.get(newPair1)+ pairCount.get(pair));
        workingPairCount.replace(newPair2, workingPairCount.get(newPair2)+ pairCount.get(pair));
      }
      pairCount.clear();
      pairCount.putAll(workingPairCount);
      workingPairCount.clear();
    }

    for(String index : rules.keySet()) {
      long indexCount = pairCount.get(rules.get(index));
      if(charCount.containsKey(index.toCharArray()[0])) {
        charCount.replace(index.toCharArray()[0], (charCount.get(index.toCharArray()[0]) + indexCount));
      }
      else {
        charCount.put(index.toCharArray()[0], indexCount);
      }
    }

    Character end = template[template.length-1];
    charCount.replace(end, (charCount.get(end) + 1));

    ArrayList<Long> frequencies = new ArrayList<Long>(charCount.values());
    Collections.sort(frequencies);

    System.out.println((frequencies.get(frequencies.size()-1) - frequencies.get(0)));
  }
}

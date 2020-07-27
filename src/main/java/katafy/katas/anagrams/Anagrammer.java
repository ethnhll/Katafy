package katafy.katas.anagrams;

import java.util.Set;

public interface Anagrammer {
    Anagrammer add(String word);
    Set<String> anagrams(String word);
    Set<String> words();
}

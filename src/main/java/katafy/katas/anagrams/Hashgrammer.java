package katafy.katas.anagrams;

import katafy.Generated;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Hashgrammer implements Anagrammer {

    private final Map<String, Set<String>> sortedWordsToAnagrams;

    private static String sortLetters(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public Hashgrammer() {
        this.sortedWordsToAnagrams = new HashMap<>();
    }

    public Hashgrammer(Set<String> words) {
        this.sortedWordsToAnagrams = new HashMap<>();
        for (String word : words) {
            String sortedWord = sortLetters(word);
            Set<String> anagrams = this.sortedWordsToAnagrams.computeIfAbsent(sortedWord, k -> new HashSet<>());
            anagrams.add(word);
            this.sortedWordsToAnagrams.put(sortedWord, anagrams);
        }
    }

    @Override
    public Anagrammer add(String word) {
        String sortedWord = sortLetters(word);
        Set<String> anagrams = this.sortedWordsToAnagrams.computeIfAbsent(sortedWord, k -> new HashSet<>());
        anagrams.add(word);
        this.sortedWordsToAnagrams.put(sortedWord, anagrams);

        return this;
    }

    @Override
    public Set<String> anagrams(String word) {
        return this.sortedWordsToAnagrams.getOrDefault(sortLetters(word), Collections.emptySet());
    }

    @Override
    public Set<String> words() {
        return this.sortedWordsToAnagrams.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    @Generated("IntelliJ")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashgrammer that = (Hashgrammer) o;

        return Objects.equals(this.sortedWordsToAnagrams, that.sortedWordsToAnagrams);
    }

    @Generated("IntelliJ")
    @Override
    public int hashCode() {
        return this.sortedWordsToAnagrams != null ? this.sortedWordsToAnagrams.hashCode() : 0;
    }
}

package katafy.katas.anagrams;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class HashgrammerTest {

    private static final int NUM_WORDS = 100;
    private static final String TEST_WORD = "test";

    private Anagrammer anagrammerUnderTest;

    @BeforeEach
    void initialize() {
        this.anagrammerUnderTest = new Hashgrammer();
    }

    @Nested
    @DisplayName("getting the set of words")
    class Words {
        @Test
        @DisplayName("when the Hashgrammer is empty")
        void shouldReturnAnEmptySet() {
            assertThat(anagrammerUnderTest.words()).isEmpty();
        }

        @Test
        @DisplayName("when the Hashgrammer has one word")
        void shouldReturnTheSameWord() {
            anagrammerUnderTest = new Hashgrammer(Collections.singleton(TEST_WORD));
            assertThat(anagrammerUnderTest.words()).containsExactly(TEST_WORD);
        }

        @Test
        @DisplayName("when the Hashgrammer has several words")
        void shouldReturnTheSameWords() {
            // Create a set of "words"
            Set<String> words = generateWords();
            anagrammerUnderTest = new Hashgrammer(words);
            assertThat(anagrammerUnderTest.words()).containsExactlyInAnyOrderElementsOf(words);
        }
    }

    @Nested
    @DisplayName("adding words to the Hashgrammer")
    class Add {
        @Test
        @DisplayName("when the Hashgrammer is empty")
        void shouldReturnTheAddedWord() {
            Anagrammer actualAnagrammer = anagrammerUnderTest.add(TEST_WORD);
            Anagrammer expectedAnagrammer = new Hashgrammer(Collections.singleton(TEST_WORD));
            assertThat(actualAnagrammer).isEqualTo(expectedAnagrammer);
        }

        @Test
        @DisplayName("when the Hashgrammer has a word already")
        void shouldReturnTheOldWordAndTheNewWord() {
            Set<String> words = generateWords();
            Set<String> expectedWords = new HashSet<>(words);
            expectedWords.add(TEST_WORD);

            anagrammerUnderTest = new Hashgrammer(words);
            Anagrammer actualAnagrammer = anagrammerUnderTest.add(TEST_WORD);
            Anagrammer expectedAnagrammer = new Hashgrammer(expectedWords);
            assertThat(actualAnagrammer).isEqualTo(expectedAnagrammer);
        }
    }

    @Nested
    @DisplayName("getting anagrams for a word")
    class Anagrams {

        @Test
        @DisplayName("when the Hashgrammer is empty")
        void shouldReturnAnEmptySet() {
            assertThat(anagrammerUnderTest.anagrams("")).isEmpty();
        }

        @Test
        @DisplayName("when the Hashgrammer already has words, but none of them are anagrams")
        void shouldAlsoReturnAnEmptySet() {
            anagrammerUnderTest = new Hashgrammer(Collections.singleton(TEST_WORD));
            assertThat(anagrammerUnderTest.anagrams("")).isEmpty();
        }

        @Test
        @DisplayName("when the Hashgrammer already has a word, and the word argument matches that word")
        void shouldReturnTheWord() {
            anagrammerUnderTest = new Hashgrammer(Collections.singleton(TEST_WORD));
            assertThat(anagrammerUnderTest.anagrams(TEST_WORD)).containsExactly(TEST_WORD);
        }

        @Test
        @DisplayName("when the Hashgrammer has words, and they are anagrams of each other")
        void shouldReturnTheWords() {
            Set<String> expectedAnagrams = new HashSet<>(
                    Arrays.asList(
                            TEST_WORD,
                            new StringBuilder(TEST_WORD).reverse().toString()
                    )
            );
            anagrammerUnderTest = new Hashgrammer(expectedAnagrams);
            Set<String> actualAnagrams = anagrammerUnderTest.anagrams(TEST_WORD);
            assertThat(actualAnagrams).containsExactlyInAnyOrderElementsOf(expectedAnagrams);
        }
    }
    private Set<String> generateWords() {
        return IntStream.range(0, HashgrammerTest.NUM_WORDS)
                .mapToObj(String::valueOf)
                .collect(Collectors.toSet());
    }
}

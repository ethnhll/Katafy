package katafy.katas.vanity.phone;

import java.util.Map;
import java.util.Set;


/**
 * An object which generates dictionary words from phone numbers using a "keypad" character set that maps numbers to
 * letters. For example, in the United States, a typical phone's keypad maps the number 2 to the letters {@code {'A',
 * 'B', 'C'}}.
 * <p>
 * "Vanity numbers" do not have mixed alpha-numeric character sets, as vanity number are just made up of letters.
 */
public interface NumberVanitizer {
    /**
     * Returns the Set of all dictionary words available to {@code this} for generating vanity phone numbers.
     *
     * @return the Set of all dictionary words available
     */
    Set<String> words();

    /**
     * Returns the mapping of single digit "keypad" numbers to letters.
     *
     * @return a Map with single digit numbers as keys (numbers are {@code Character}s for convenience) and a Set of
     * Characters as values.
     */
    Map<Character, Set<Character>> keypadMapping();

    /**
     * Generates a set of "vanity numbers" from the given {@code phoneNumber}. The vanity numbers are dictionary words.
     *
     * @param phoneNumber the phone number from which vanity numbers are generated
     * @return a set of all possible "vanity numbers" that can be generated by a given phone number
     */
    Set<String> vanitize(String phoneNumber);

    /**
     * Reconstructs a phone number from a given word/"vanity number".
     *
     * @param vanityNumber a word that may or may not have a corresponding phone number that the {@code vanityNumber}
     * could have been generated from.
     * @return the phone number (as a String) that would have generated the {@code vanityNumber}
     */
    String devanitize(String vanityNumber);
}

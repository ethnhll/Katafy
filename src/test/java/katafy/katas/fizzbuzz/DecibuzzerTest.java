package katafy.katas.fizzbuzz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class DecibuzzerTest {

    private static final int PRIME = 13;

    private FizzBuzzer fizzBuzzerUnderTest;

    @BeforeEach
    void initialize() {
        this.fizzBuzzerUnderTest = new DeciBuzzer();
    }

    @Test
    @DisplayName("fizzBuzz: when an empty string is passed")
    void shouldReturnAnEmptyString() {
        assertThat(fizzBuzzerUnderTest.fizzBuzz("")).isEmpty();
    }

    @Test
    @DisplayName("fizzBuzz: when a number divisible by 3")
    void shouldReturnFizz() {
        assertThat(fizzBuzzerUnderTest.fizzBuzz(Integer.toString(PRIME * 3))).isEqualTo("fizz");
    }

    @Test
    @DisplayName("fizzBuzz: when a number divisible by 5")
    void shouldReturnBuzz(){
        assertThat(fizzBuzzerUnderTest.fizzBuzz(Integer.toString(PRIME * 5))).isEqualTo("buzz");
    }

    @Test
    @DisplayName("fizzBuzz: when a number divisible by 3 and 5")
    void shouldReturnFizzBuzz(){
        assertThat(fizzBuzzerUnderTest.fizzBuzz(Integer.toString(PRIME * 15))).isEqualTo("fizzbuzz");
    }

    @Test
    @DisplayName("fizzBuzz: when a number is not divisible by 3 or 5")
    void shouldReturnNumber(){
        assertThat(fizzBuzzerUnderTest.fizzBuzz(Integer.toString(PRIME))).isEqualTo(Integer.toString(PRIME));
    }

    @Test
    @DisplayName("fizzBuzz: when a number is larger than MAX_INT")
    void shouldReturnOutput() {
        String hugeNumber = BigDecimal.valueOf(Integer.MAX_VALUE).multiply(BigDecimal.valueOf(3L)).toString();
        assertThat(fizzBuzzerUnderTest.fizzBuzz(hugeNumber)).isEqualTo("fizz");
    }
    @Test
    @DisplayName("fizzBuzz: when a number is actually a word")
    void shouldReturnOutput() {
        assertThat(fizzBuzzerUnderTest.fizzBuzz("word")).isEqualTo("");
    }
}

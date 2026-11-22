package be.smals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SolutionTest {

    @ParameterizedTest(name = "SSIN: {0} -> expected: {1}")
    @CsvSource({
            "93051822361, true",
            "02031003152, true",
            "12345678900, false",
            "12345, false",
            "123456789012, false",
            "930518223AA, false",
            "'', false",
            "'           ', false"
    })
    void shouldValidateSsin(String ssin, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.validator(ssin);
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenSsinIsNull() {
        Solution solution = new Solution();
        assertThrows(
                NullPointerException.class,
                () -> solution.validator(null));
    }
}

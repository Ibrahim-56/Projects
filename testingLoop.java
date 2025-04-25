package sdr;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class testingLoop {
    @Test
    void test() {
        loop l = new loop();
        assertEquals(2, l.countLetters("  hh"));
    }
}

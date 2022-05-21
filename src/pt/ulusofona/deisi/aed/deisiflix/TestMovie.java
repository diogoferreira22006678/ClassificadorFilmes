package pt.ulusofona.deisi.aed.deisiflix;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestMovie {

    @Test
    public void testFilme1() {
        Filme filme = new Filme(603,"The Matrix","30-03-1999",234,10.4);
        String expectativa = "603 | The Matrix | 1999-03-30 | 234 | 10.4";
        assertEquals(expectativa, filme.toString());
    }

    @Test
    public void testFilme2() {
        Filme filme = new Filme(10428,"Hackers","14-09-1995",534,12.4);
        String expectativa = "10428 | Hackers | 1995-09-14 | 534 | 12.4";
        assertEquals(expectativa, filme.toString());
    }
}
package implementations;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TheMatrixTest {

    @Test
    public void testZeroTestOne() {
        char[][] matrix = {
                {'a', 'a', 'a'},
                {'a', 'a', 'a'},
                {'a', 'b', 'a'},
                {'a', 'b', 'a'},
                {'a', 'b', 'a'}
        };
        char fillChar = 'x';
        int startRow = 0;
        int startCol = 0;

        TheMatrix theMatrix = new TheMatrix(matrix, fillChar, startRow, startCol);

        theMatrix.solve();

        String str = theMatrix.toOutputString();
        assertEquals(
                "xxx\r\n" +
                        "xxx\r\n" +
                        "xbx\r\n" +
                        "xbx\r\n" +
                        "xbx", str);
    }

    @Test
    public void testZeroTestTwo() {
        char[][] matrix = {
                {'a', 'a', 'a',},
                {'a', 'a', 'a',},
                {'a', 'b', 'a',},
                {'a', 'b', 'a',},
                {'a', 'b', 'a',}

        };
        char fillChar = 'x';
        int startRow = 2;
        int startCol = 1;

        TheMatrix theMatrix = new TheMatrix(matrix, fillChar, startRow, startCol);

        theMatrix.solve();

        String str = theMatrix.toOutputString();
        assertEquals(
                "aaa\r\n" +
                        "aaa\r\n" +
                        "axa\r\n" +
                        "axa\r\n" +
                        "axa", str);
    }

    @Test
    public void testZeroTestThree() {
        char[][] matrix = {
                {'o', 'o', '1', '1', 'o', 'o'},
                {'o', '1', 'o', 'o', '1', 'o'},
                {'1', 'o', 'o', 'o', 'o', '1'},
                {'o', '1', 'o', 'o', '1', 'o'},
                {'o', 'o', '1', '1', 'o', 'o'}
        };
        char fillChar = '3';
        int startRow = 2;
        int startCol = 1;

        TheMatrix theMatrix = new TheMatrix(matrix, fillChar, startRow, startCol);

        theMatrix.solve();

        String str = theMatrix.toOutputString();
        assertEquals(
                "oo11oo\r\n" +
                        "o1331o\r\n" +
                        "133331\r\n" +
                        "o1331o\r\n" +
                        "oo11oo", str);
    }

    @Test
    public void testZeroTestFour() {
        char[][] matrix = {
                {'o', 'o', 'o', 'o', 'o', 'o'},
                {'o', 'o', 'o', '1', 'o', 'o'},
                {'o', 'o', '1', 'o', '1', '1'},
                {'o', '1', '1', 'w', '1', 'o'},
                {'1', 'o', 'o', 'o', 'o', 'o'}
        };
        char fillChar = 'z';
        int startRow = 4;
        int startCol = 1;

        TheMatrix theMatrix = new TheMatrix(matrix, fillChar, startRow, startCol);

        theMatrix.solve();

        String str = theMatrix.toOutputString();
        assertEquals(
                "oooooo\r\n" +
                        "ooo1oo\r\n" +
                        "oo1o11\r\n" +
                        "o11w1z\r\n" +
                        "1zzzzz", str);
    }

    @Test
    public void testZeroTestFive() {
        char[][] matrix = {
                {'o', '1', 'o', 'o', '1', 'o'},
                {'o', '1', 'o', 'o', '1', 'o'},
                {'o', '1', '1', '1', '1', 'o'},
                {'o', '1', 'o', 'w', '1', 'o'},
                {'o', 'o', 'o', 'o', 'o', 'o'}
        };
        char fillChar = 'z';
        int startRow = 4;
        int startCol = 0;

        TheMatrix theMatrix = new TheMatrix(matrix, fillChar, startRow, startCol);

        theMatrix.solve();

        String str = theMatrix.toOutputString();
        assertEquals(
                "z1oo1z\r\n" +
                        "z1oo1z\r\n" +
                        "z1111z\r\n" +
                        "z1zw1z\r\n" +
                        "zzzzzz", str);
    }
}
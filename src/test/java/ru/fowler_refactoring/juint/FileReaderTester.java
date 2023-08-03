package ru.fowler_refactoring.juint;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileReaderTester extends TestCase {

    FileReader _input;

    public FileReaderTester(String name) {
        super(name);
    }

    protected void setUp() {
        try {
            _input = new FileReader("src/test/resources/data.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error open file");
        }
    }

    protected void tearDown() {
        try {
            _input.close();
        } catch (IOException e) {
            throw new RuntimeException("Error close file");
        }
    }

    public void testRead() throws IOException {
        char ch = '&';
        for (int i = 0; i < 4; i++) {
            ch = (char) _input.read();
        }
        assert ('d' == ch);
    }

    public void testReadAtEnd() throws IOException {
        int ch = -1234;

        for (int i = 0; i < 181; i++) {
            ch = _input.read();
        }

        assertEquals("чтение за границей", -1, ch, _input.read());
    }

    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(new FileReaderTester("testRead"));
        suite.addTest(new FileReaderTester("testReadAtEnd"));
        return suite;
    }

    public static void main(String[] args) {
        // junit.textui.TestRunner.run(suite());
        junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
    }

}

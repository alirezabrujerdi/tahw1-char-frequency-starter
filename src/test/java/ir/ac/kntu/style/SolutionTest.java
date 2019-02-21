/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.kntu.style;

import ir.ac.kntu.CharFrequency;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 15 points
 * @author mhrimaz
 */
public class SolutionTest {
    static {
        System.err.println("$$$GRADER$$$ | { type:\"MSG\" , key:\"TOTAL\" , value:20, priority:1  }  | $$$GRADER$$$");
    }
    public boolean test(String inputString, String outputString) {

        InputStream in = null;
        PrintStream printStream = null;
        try {
            File input = new File("input.txt");
            File output = new File("output.txt");
            in = new FileInputStream(input);
            printStream = new PrintStream(output);
            try (PrintWriter w = new PrintWriter(input);) {
                w.println(inputString);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try (BufferedReader reader = new BufferedReader(new FileReader(output))) {
                System.setIn(in);
                System.setOut(printStream);
                CharFrequency.main(new String[]{});
                String collect = reader.lines().collect(java.util.stream.Collectors.joining("\n"));
                return collect.equals(outputString);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                in.close();
                printStream.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    @Test
    public void test1() {

        assertTrue(test("aa bb c AA",
                "a : 4\nb : 2\nc : 1"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:4 , reason:\"Test Passed.\" } | $$$GRADER$$$" );
    }

    @Test
    public void test2() {

        assertTrue(test("aaaa bb c",
                "a : 4\nb : 2\nc : 1"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:4 , reason:\"Test Passed.\" } | $$$GRADER$$$" );
    }

    @Test
    public void test3() {

        assertTrue(test("aAaA@bb ca",
                "a : 5\nb : 2\nc : 1"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:4 , reason:\"Test Passed.\" } | $$$GRADER$$$" );
    }
  
    
        @Test
    public void test4() {

        assertTrue(test("aaaa ###    bb c",
                "a : 4\nb : 2\nc : 1"));
        System.err.println("$$$GRADER$$$ | { type:\"SCORE\" , amount:3 , reason:\"Test Passed.\" } | $$$GRADER$$$" );
    }
}

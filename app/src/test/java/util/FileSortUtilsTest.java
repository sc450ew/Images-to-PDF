package util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import swati4star.createpdf.util.FileSortUtils;

import static org.junit.Assert.assertArrayEquals;

@RunWith(JUnit4.class)
public class FileSortUtilsTest {

    ArrayList<File> files;
    ArrayList<File> original;
    File first, second, third, fourth, fifth;

    @Before
    public void setUp() throws Exception {
        PrintWriter writer = null;
        files = new ArrayList<>();
        original = new ArrayList<>();

        first = new File("first.pdf");
        writer = new PrintWriter(first);
        writer.print("111111111111111");
        writer.close();

        second = new File("second.pdf");
        writer = new PrintWriter(second);
        writer.print("2585  665");
        writer.close();

        third = new File("third.pdf");
        writer = new PrintWriter(third);
        writer.print("11543215564");
        writer.close();

        fourth = new File("fourth.pdf");
        writer = new PrintWriter(fourth);
        writer.print("5968");
        writer.close();

        fifth = new File("fifth.pdf");
        writer = new PrintWriter(fifth);
        writer.print("1");
        writer.close();

        files.addAll(Arrays.asList(first, second, third, fourth, fifth));
        original.addAll(Arrays.asList(first, second, third, fourth, fifth));
    }

    @After
    public void tearDown() {
        first.delete();
        second.delete();
        third.delete();
        fourth.delete();
        fifth.delete();
    }

    @Test
    public void test_performSortOperation_by_name() {
        assertArrayEquals(original.toArray(), files.toArray());
        FileSortUtils.performSortOperation(FileSortUtils.NAME_INDEX, files);

        File[] expected = {fifth, first, fourth, second, third};
        assertArrayEquals(files.toArray(), expected);
    }

   // @Test
   // public void test_completeSortOperation_by_date() {
        //assertArrayEquals(original.toArray(), files.toArray());
       // FileSortUtils.performSortOperation(FileSortUtils.DATE_INDEX, files);
       // assertArrayEquals(files.toArray(), original.toArray());
   // }

    @Test
    public void test_completeSortOperation_by_grow_order() {
        assertArrayEquals(original.toArray(), files.toArray());
        FileSortUtils.performSortOperation(FileSortUtils.SIZE_INCREASING_ORDER_INDEX, files);
        File[] expected = {fifth, fourth, second, third, first};
        assertArrayEquals(files.toArray(), expected);
    }

    @Test
    public void test_completeSortOperation_by_drop_order() {
        assertArrayEquals(original.toArray(), files.toArray());
        FileSortUtils.performSortOperation(FileSortUtils.SIZE_DECREASING_ORDER_INDEX, files);
        File[] expected = {first , third, second, fourth, fifth};
        assertArrayEquals(files.toArray(), expected);
    }

}
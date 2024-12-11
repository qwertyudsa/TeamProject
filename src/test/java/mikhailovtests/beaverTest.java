package mikhailovtests;

import allclasses.mihailov.beaver;
import org.junit.Assert;
import org.junit.Test;


public class beaverTest {
    @Test
    public void PrintNameTest(){
        beaver beaver = new beaver();
        String expected = beaver.PrintName();
        Assert.assertEquals(expected, beaver.PrintName());
    }

    @Test
    public void PrintAgeTest(){
        beaver beaver = new beaver();
        String expected = beaver.PrintAge();
        Assert.assertEquals(expected, beaver.PrintAge());
    }
}

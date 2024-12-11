package mikhailovtests;

import allclasses.mihailov.Beaver;
import org.junit.Assert;
import org.junit.Test;


public class BeaverTest {
    @Test
    public void PrintNameTest(){
        Beaver beaver = new Beaver();
        String expected = beaver.PrintName();
        Assert.assertEquals(expected, beaver.PrintName());
    }

    @Test
    public void PrintAgeTest(){
        Beaver beaver = new Beaver();
        String expected = beaver.PrintAge();
        Assert.assertEquals(expected, beaver.PrintAge());
    }
}

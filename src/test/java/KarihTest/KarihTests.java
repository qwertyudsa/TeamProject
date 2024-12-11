package KarihTest;
import allclasses.Karih.Cat;
import org.junit.Assert;
import org.junit.Test;
public class KarihTests {
    @Test
    public void Meow3Times()
    {
        Cat cat1 = new Cat(10, "Charlotte");

        Assert.assertEquals("Meow Meow Meow", cat1.Meow(3));
    }
    @Test
    public void Meow0Times(){
        Cat cat1 = new Cat(10, "Charlotte");

        Assert.assertEquals("", cat1.Meow(0));
    }
    @Test
    public void GetCatAge(){
        Cat cat1 = new Cat(10, "Charlotte");

        Assert.assertEquals(10, cat1.age);
    }
    @Test
    public void GetCatName(){
        Cat cat1 = new Cat(10, "Charlotte");

        Assert.assertEquals("Charlotte", cat1.name);
    }
}

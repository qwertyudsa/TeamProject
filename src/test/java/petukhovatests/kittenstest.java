package petukhovatests;

import allclasses.petukhova.kittens;
import org.junit.Assert;
import org.junit.Test;

public class kittenstest {
    @Test
    public bool testGetcorrectStringReturnTrue(){
        kittens kitten = new kittens();
        Assert.assertEquals(kitten.PrintInfo(), "This is: Kitten's mom \n This is: Kitten's dad \n And: This is a kitten");
    }
}

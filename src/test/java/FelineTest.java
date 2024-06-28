import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void testGetFamily() throws Exception {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithArg() throws Exception {
        int count = 2;
        assertEquals(count, feline.getKittens(count));
    }

    @Test
    public void testGetKittensWithoutArg() throws Exception {
        assertEquals(1, feline.getKittens());
    }
}

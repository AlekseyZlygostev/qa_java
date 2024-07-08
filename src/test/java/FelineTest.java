import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

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
        feline.getFamily();
        Mockito.verify(feline).getFamily();
    }

    @Test
    public void testGetKittensWithArg() throws Exception {
        int count = 2;
        feline.getKittens(count);
        Mockito.verify(feline).getKittens(count);
    }

    @Test
    public void testGetKittensWithoutArg() throws Exception {
        feline.getKittens();
        Mockito.verify(feline).getKittens(1);
    }
}

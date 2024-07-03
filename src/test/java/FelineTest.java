import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    public void testGetFamily() throws Exception {
        Mockito.when(feline.getFamily()).thenReturn("Кошачьи");
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensWithArg() throws Exception {
        int count = 2;
        Mockito.when(feline.getKittens(count)).thenReturn(count);
        assertEquals(count, feline.getKittens(count));
    }

    @Test
    public void testGetKittensWithoutArg() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, feline.getKittens());
    }
}

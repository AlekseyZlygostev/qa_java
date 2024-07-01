import com.example.Aleks;
import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AleksTest {

    @Mock
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Aleks aleks = new Aleks(feline);
        aleks.getKittens();
        Mockito.verify(feline).getKittens(0);
    }

    @Test
    public void testGetFriends() throws Exception {
        Aleks aleks = new Aleks(feline);
        assertEquals(List.of("Марти", "Глория", "Мелман"), aleks.getFriends());
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        Aleks aleks = new Aleks(feline);
        assertEquals("Нью-Йоркский зоопарк", aleks.getPlaceOfLiving());
    }
}

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    private final String sex;
    private final boolean hasMane;

    public LionTest(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {"Самец", true}, {"Самка", false}, {"Оно", false},
        };
    }


    @Test
    public void testDoesHaveMane() {

        boolean haveMane = false;

        try {
            Lion lion = new Lion(sex);
            haveMane = lion.doesHaveMane();
        } catch (Exception exception) {
            haveMane = false;
        }
        assertEquals(hasMane, haveMane);
    }

    @Spy
    Feline feline;

    @Test
    public void testGetKittens(){
        Lion lion = new Lion(feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
}

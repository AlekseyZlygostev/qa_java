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
public class LionTestParam {

    private final String sex;
    private final boolean hasMane;

    public LionTestParam(String sex, boolean hasMane){
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSumData() {
        return new Object[][] {
                {"Самка", false}, {"Самец", true}, {"Оно", false},
        };
    }

    @Mock
    Feline feline;

    @Test
    public void testDoesHaveMane() {

        boolean haveMane = false;

        try {
            Lion lion = new Lion(sex, feline);
            haveMane = lion.doesHaveMane();
        } catch (Exception exception) {
            haveMane = false;
        }
        //System.out.println(sex);
        assertEquals(hasMane, haveMane);
    }

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

}

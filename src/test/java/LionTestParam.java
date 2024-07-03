import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

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
                {"Самец", true}, {"Самка", false}, {"Оно", false},
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
        assertEquals(hasMane, haveMane);
    }

}

package connection;

import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.mockito.Matchers;

import static org.junit.Assert.*;

/**
 * Created by maciek on 04.02.17.
 */
public class MpkDataGetterTest {

    @Test
    public void test() throws Exception {

        MpkDataGetter mpkDataGetter = new MpkDataGetter();
        String str = mpkDataGetter.getResponse("23710");
        assertFalse(str == null);
        System.out.println(str);
    }
}
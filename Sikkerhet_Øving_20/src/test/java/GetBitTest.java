import org.junit.Test;
import util.MathUtil;

import static org.junit.Assert.assertEquals;

/**
 * Created by faiter on 11/8/17.
 */
public class GetBitTest {

    @Test
    public void test_get_bit(){

        int nr = 0b1011_0111;

        assertEquals(1, MathUtil.getBit(nr,0));
        assertEquals(0, MathUtil.getBit(nr,1));
        assertEquals(1, MathUtil.getBit(nr,2));
        assertEquals(1, MathUtil.getBit(nr,3));
        assertEquals(0, MathUtil.getBit(nr,4));
        assertEquals(1, MathUtil.getBit(nr,5));
        assertEquals(1, MathUtil.getBit(nr,6));
        assertEquals(1, MathUtil.getBit(nr,7));


    }
}

import org.junit.Test;

public class MyTest {

    @Test
    public void test(){
        System.out.println("" + Long.toHexString(Long.MAX_VALUE));
        System.out.println("" + Long.toHexString(Long.MIN_VALUE));
        System.out.println("" + Long.toHexString(Math.abs(Long.MIN_VALUE)));
    }
}

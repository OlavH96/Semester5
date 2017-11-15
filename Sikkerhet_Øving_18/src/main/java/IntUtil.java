/**
 * Created by faiter on 11/1/17.
 */
public class IntUtil {

    public static String toBinaryString(int i, int length){

        String str = Integer.toBinaryString(i);

        while (str.length() != length){
            str = "0"+str;
        }
        return str;
    }

    public static void main(String[] args) {

        int i = 0b000_0101;

        System.out.println(toBinaryString(i, 8));

    }
}

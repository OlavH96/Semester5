import static java.lang.Integer.toBinaryString;

/**
 * Created by faiter on 10/30/17.
 */
public class Hasher {

    public static int squareHash(int nr, int length){

        int square = nr*nr;
        String squareString = String.valueOf(square);

        //System.out.println(square);

        int middle = squareString.length()/2;

        int range = length/2;

        //if (length % 2 == 0){ // even

            return Integer.parseInt(squareString.substring(middle-range, middle+range));
        //}
        // odd
        //return Integer.parseInt(squareString.substring(middle-range, middle+range+1));

    }

    public static int squareHashBinary(int nr, int length){

        //System.out.println("nr:\t\t\t"+Integer.toBinaryString(nr));

        int square = (nr*nr) % (int)Math.pow(2,8);

        String squareString = toBinaryString(square);

        System.out.println("Squared:\t"+squareString);

        int middle = squareString.length()/2;

        int range = length/2;
        String s = squareString.substring(middle - range, middle + range);
        //System.out.println("substring: "+s);
        int i = Integer.parseInt(s, 2);
        //System.out.println("Hash:\t\t"+Integer.toBinaryString(i));
        return i;
    }

    public static void main(String[] args) {

        /*int nr = 12345;

        System.out.println(squareHash(nr, 3));

        System.out.println(squareHash(345, 2));
        int i = squareHashBinary(0b1010_0110, 4);
        System.out.println(i);
        System.out.println(toBinaryString(i));


        System.out.println("0"+toBinaryString(squareHashBinary(0b11001110, 4)));
*/
        // oppg5

        int h1 = squareHashBinary(0b1010_0110, 4);
        System.out.println(toBinaryString(h1));
        int concat = HMAC.concat(0b1100, 0b1001, 4);
        System.out.println(toBinaryString(concat));
        int ans = squareHashBinary(concat, 4);

        System.out.println("Answer: 0"+toBinaryString(ans));


    }
}
/**
 * Created by faiter on 9/13/17.
 */
public class ROTTester {

    public static String RotN(String message, int rot){

        StringBuilder out = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {

            System.out.println(message.charAt(i) +" - "+(char)(message.charAt(i)+rot));

            out.append((char) (message.charAt(i) + rot));

        }
        return out.toString();

    }

    public static void main(String[] args) {

        String encrypted = "judwxohuhuCghuhCkduCixqqhwCphoglqjhqD";

        int jallategn = 3;

        int rot = 'a'-'A'-jallategn+23;
        System.out.println((char)('a'-1));
        System.out.println(rot);

        System.out.println(RotN(encrypted, -35));

        /*for (int i = 0; i < 30; i++) {

            System.out.println("ROT "+i+": "+RotN(encrypted, i));

        }*/

    }
}

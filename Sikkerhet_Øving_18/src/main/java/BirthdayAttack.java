/**
 * Created by faiter on 10/30/17.
 */
public class BirthdayAttack {

    public static void main(String[] args) {

        int nr = 3456;

        int hash = Hasher.squareHash(nr, 3);

        int attempt = 1111;
        int attemptNr = 0;

        while (Hasher.squareHash(attempt, 3) != hash){

            do{
                attempt = (int) (Math.random()*9999);
            }
            while (String.valueOf(attempt).length() > 4);

            attemptNr += 1;

        }

        System.out.println("Successful collision: "+attempt);
        System.out.println("Attempts: "+attemptNr);

        System.out.println(nr+": "+hash+" - "+attempt+": "+Hasher.squareHash(attempt, 3));

    }
}

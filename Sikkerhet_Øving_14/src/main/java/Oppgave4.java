import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by faiter on 10/18/17.
 */
public class Oppgave4 {

    public static void main(String[] args) {

        SubstitutionCipher cypher = new SubstitutionCipher();
        //cypher.setReverseCypher();
        String numbers = "04 05 15 01 04 26 01 26 26 01 15 14 13 14 01 06 13 14 01 15 06 13 14 01 15 26 01 26 26 01 15 06 13 14 01 15 14 13 14 01 15 20 13 15 00 13 04 23 12 15 10 20 01 04 10 20 01 14 01 27 15 20 20 01 09 27 01 04 14 24 22 09 18 13 15 27 13 15 24 04";

        String[] split = numbers.split("\\s");

        List<Letter> letters = Arrays
                .stream(split)
                .map(s -> Letter.fromInt(Integer.parseInt(s)))
                .collect(Collectors.toList());

        System.out.println(Letter.toStringList(letters));

        //cypher.add(Letter.B, Letter.E); // Most common
        //Når
        cypher.add(Letter.E, Letter.N);
        cypher.add(Letter.F, Letter.Å);
        cypher.add(Letter.P, Letter.R);

        //En
        cypher.add(Letter.B, Letter.E);
        cypher.add(Letter.E, Letter.N);

        //Pepper
        cypher.add(Letter.Æ, Letter.P);

        //Kake
        cypher.add(Letter.O, Letter.K);
        cypher.add(Letter.N, Letter.A);

        //Baker
        cypher.add(Letter.G, Letter.B);

        //Tar han
        cypher.add(Letter.U, Letter.T);
        cypher.add(Letter.A, Letter.H);

        //Først
        cypher.add(Letter.X, Letter.F);
        cypher.add(Letter.M, Letter.Ø);
        cypher.add(Letter.K, Letter.S);

        //Og
        cypher.add(Letter.Ø, Letter.G);

        // en kilo
        cypher.add(Letter.J, Letter.O);
        cypher.add(Letter.Y, Letter.I);
        cypher.add(Letter.W, Letter.L);

        //Margarin
        cypher.add(Letter.S, Letter.M);


















        System.out.println(cypher.solve(letters));
        cypher.printTable();

    }
}

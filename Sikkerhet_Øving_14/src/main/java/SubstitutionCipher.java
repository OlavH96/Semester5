import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by faiter on 10/18/17.
 */
public class SubstitutionCipher {

    private Map<Letter, Letter> substitutionMap = new HashMap<>();

    public SubstitutionCipher() {

        Letter start = Letter.A;
        for (int i = 0; i < Letter.values().length; i++) {

            add(start, start);

            start = start.next();

        }

    }

    public void add(Letter from, Letter to){
        substitutionMap.put(from, to);
    }
    public Letter get(Letter from){
        return substitutionMap.get(from);
    }
    public String solve(List<Letter> letters){

        StringBuilder out = new StringBuilder();

        letters.forEach(letter -> {

            out.append(get(letter));

        });
        return out.toString();
    }

    public void setReverseCypher(){

        Letter start = Letter.A;
        Letter end = Letter.Å;

        for (int i = 0; i < Letter.values().length; i++) {

            add(start, end);

            start = start.next();
            end = end.prev();

        }
    }

    public void rotate(){



    }
    public void printTable(){

        substitutionMap.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).forEach(e -> {

            System.out.println("[ "+e.getKey()+" | "+e.getValue()+" ]");

        });

    }

}

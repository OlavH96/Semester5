import java.util.List;

/**
 * Created by faiter on 10/18/17.
 */
public enum Letter {

    A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,Æ,Ø,Å;

    public static Letter fromInt(int nr){

        return values()[nr];
    }

    public Letter next(){

        int index = ordinal();

        return values()[index == values().length-1 ? 0 : index+1];
    }
    public Letter prev(){
        int index = ordinal();

        return values()[index == 0 ? values().length-1 : index-1];
    }
    public static String toStringList(List<Letter> letters){

        StringBuilder out = new StringBuilder();

        letters.forEach(letter -> {

            out.append(letter);
        });
        return out.toString();

    }
}

package elGamal;

/**
 * Created by faiter on 11/10/17.
 */
public class Message {

    private int aPowK, xBPowK;

    public Message(int aPowK, int xBPowK) {

        this.aPowK = aPowK;
        this.xBPowK = xBPowK;
    }

    public int getaPowK() {

        return aPowK;
    }

    public int getxBPowK() {

        return xBPowK;
    }

    @Override
    public String toString() {

        return "Message{" + "aPowK=" + aPowK + ", xBPowK=" + xBPowK + '}';
    }
}

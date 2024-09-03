package blockchainJava;

public class Transaction{

    private int origin;
    private int destiny;
    private float value;

    public Transaction(int origin, int destiny, float value){
        this.origin = origin;
        this.destiny = destiny;
        this.value = value;
    }

    public int getOrigin(){
        return origin;
    }

    public int getDestiny(){
        return destiny;
    }

    public float getValue(){
        return value;
    }

    @Override
    public String toString(){
        return origin + "," + destiny + "," + value;
    }
}
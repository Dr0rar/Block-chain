package blockchainJava;
import blockchainJava.Block;
import blockchainJava.Transaction;
public class Block{
    private String hash;
    private Transaction transactions;

    public Block( Transaction transactions,String hash ){
        this.transactions = transactions;
        this.hash = hash;
    }

    public String getHash(){
        return hash ;
    }

    public Transaction getTransactions(){
        return transactions;
    }

    public String toString() {
        return transactions.toString() + "," + hash;
    }

}

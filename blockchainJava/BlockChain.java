package blockchainJava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import blockchainJava.Block;
import blockchainJava.Transaction;
/*Blockchain:
    Block:
        Hash of previous Block + transaction
 */

public class BlockChain {

    private  List<Block> blockchain = new ArrayList<>();;
    private final String filename;

    public BlockChain(String filename){
        this.filename = filename; 
    }

    public void addGen(){
        Transaction t = new Transaction(-1, -1, -1);
        blockchain.add(new Block(t, "0x0"));
    }

    public void addBlock(int origin,int  destiny,float value){
        Block prevblock = blockchain.get(blockchain.size() -1);
        Transaction nt = new Transaction(origin, destiny, value);
        Block nb = new Block(nt, calculateHash(nt, prevblock.getHash()));
        blockchain.add(nb);
    }

    public boolean isThereSomething(){
        try{
         BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = "";
            int i = 0;
            while((line = reader.readLine()) != null){
                i++;
            }
            if(i == 0){
                return false;
            }
        }catch(Exception e){
            System.out.println("Erro ao carregar o ficheiro: " + e);
        }
        return true;
    }

    public void loadFromFile(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = "";
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                int origin = Integer.parseInt(parts[0]);
                int destiny = Integer.parseInt(parts[1]);
                float value = Float.parseFloat(parts[2]);
                String hash = parts[3];
                Transaction nt = new Transaction(origin, destiny, value);
                blockchain.add(new Block(nt, hash));
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar o ficheiro: " + e);
        }
    }

    public void saveToFile(String filename){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            for (Block b : blockchain){
                writer.write(b.toString());
                writer.newLine();
            }
            writer.close();
        }catch(Exception e){
            System.out.println("Erro ao guardar o ficheiro: " + e);
        }
    }

    public String calculateHash(Transaction transactions, String previousHash){
        try {
            String data = transactions.toString() + previousHash;
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(data.getBytes());
            byte[] hash = md.digest();
            String bytesTohex = prettyString(hash);
            return bytesTohex;
        } catch (Exception e) {
            return null;
        }
    }

    private static String prettyString(byte[] h){
        String hexString = "";
        for(byte b : h){
            hexString += String.format("%02x", b);}
        return hexString;
    }

    public int VerifyBlockChain(){
        if(blockchain.isEmpty()){
            return 0;
        }
        for(int i = 1; i < blockchain.size(); i++){
            String currhash = blockchain.get(i).getHash();
            Transaction currtrans = blockchain.get(i).getTransactions();
            String prevhash = blockchain.get(i-1).getHash();
            if(!currhash.equals(calculateHash(currtrans, prevhash))){
                return -1;
            }
        }
        return 1;

    }
}

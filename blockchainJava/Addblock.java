package blockchainJava;

import java.util.Scanner;

public class Addblock{

   public static void main(String[] args) {
    if (args.length != 4) {
        System.out.println("Uso: addblock <origin> <destiny> <value> <filename>");
        System.exit(-1);
    }

    int origin = Integer.parseInt(args[0]);
    int destiny = Integer.parseInt(args[1]);
    float value = Float.parseFloat(args[2]);
    String filename = args[3];
    BlockChain blockchain = new BlockChain(filename);
    if(blockchain.isThereSomething()){
        blockchain.loadFromFile();
        blockchain.addBlock(origin,destiny,value);
    }
    else{
        blockchain.addGen();
        blockchain.addBlock(origin,destiny,value);
    }
    blockchain.saveToFile(filename);
   }

}

package blockchainJava;

public class VerifyBlockChain {
    public static void main(String[] args) {

        if(args.length != 1){
            System.out.println("verifychain <filename>");
            System.exit(-1);
        }

        String filename = args[0];
        BlockChain bc = new BlockChain(filename);
        bc.loadFromFile();
        int verify = bc.VerifyBlockChain();
        if(verify == 0){
            System.out.println("Block Chain is empty.");
        }
        if(verify == 1){
            System.out.println("Block Chain Verified. No curruption detected.");
        }
        if(verify == -1){
            System.out.println("Block Chain currupted." );
        }
    }
}

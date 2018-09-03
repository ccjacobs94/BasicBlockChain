package blockChain.Containers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Block {
    private byte[] prevHash;  //The hash of the previous block in the chain
    private String[] transactions;  //The transactions of this block
    private String timeStamp;

    private byte[] blockHash;  //The hash of this current block

    /**
     * Creates a new Block Object with the transactions and previous hash provided
     * @param prevHash The hash of the element before this in the blockChain
     * @param transactions The transactions of this block
     */
    public Block(byte[] prevHash, String[] transactions){
        this.prevHash = prevHash;
        this.transactions = transactions;
        this.timeStamp = String.valueOf(System.currentTimeMillis());

        Object[] contents = {hash(transactions.toString() + timeStamp), prevHash};
        this.blockHash = hash(contents.toString());
    }


    public byte[] getPrevHash() {
        return prevHash;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public byte[] getBlockHash() {
        return this.blockHash;

    }

    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * Hashes the string given into a SHA256  Byte Array
     * @param input The string to be hashed
     * @return The SHA-256 byte array
     */
    private byte[] hash(String input){
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] out = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return out;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}

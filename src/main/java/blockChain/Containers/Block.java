package blockChain.Containers;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Block {
    private byte[] prevHash;
    private String[] transactions;

    private byte[] blockHash;

    public Block(byte[] prevHash, String[] transactions){
        this.prevHash = prevHash;
        this.transactions = transactions;

        Object[] contents = {hash(transactions.toString()), prevHash};
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

    private byte[] hash(String input){
        MessageDigest digest = null;
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

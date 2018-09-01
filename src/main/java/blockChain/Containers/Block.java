package blockChain.Containers;

import java.util.Arrays;

public class Block {
    private int prevHash;
    private String[] transactions;

    private int blockHash;

    public Block(int prevHash, String[] transactions){
        this.prevHash = prevHash;
        this.transactions = transactions;

        Object[] contents = {Arrays.hashCode(transactions), prevHash};
        this.blockHash = Arrays.hashCode(contents);
    }

    public int getPrevHash() {
        return prevHash;
    }

    public String[] getTransactions() {
        return transactions;
    }

    public int getBlockHash() {
        return this.blockHash;

    }
}

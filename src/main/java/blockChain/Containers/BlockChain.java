package blockChain.Containers;

import java.util.LinkedList;

public class BlockChain {
    private LinkedList<Block> blockChain;

    /**
     * creates a new BlockChain object with the initial transaction specified
     * @param initialTransaction The first transaction in the chain
     */
    public BlockChain(String[] initialTransaction){
        blockChain = new LinkedList<>();
        blockChain.add(new Block(0, initialTransaction));
    }

    /**
     * creates a new BlockChain Object with a default initial transaction
     */
    public BlockChain(){
        blockChain = new LinkedList<>();
        String[] initial_transaction = {"Chris started the chanin"};
        blockChain.add(new Block(0, initial_transaction));
    }

    /**
     * Returns the list of block objects
     * @return The BlockChain List Object
     */
    public LinkedList<Block> getBlockChain() {
        return blockChain;
    }

    /**
     * adds a new block to the chain
     * @param newBlock
     */
    public void addBlock(Block newBlock){
        blockChain.add(newBlock);
    }

    /**
     * adds a transaction to the blockChain
     * @param transaction
     */
    public void addTransaction(String[] transaction){
        int lastHash = blockChain.getLast().getBlockHash();
        Block newBlock = new Block(lastHash, transaction);

        addBlock(newBlock);
    }
}

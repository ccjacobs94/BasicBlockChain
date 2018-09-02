package blockChain.Containers;

import java.util.LinkedList;

public class BlockChain {

    private LinkedList<Block> blockChain; //The block chain being worked on

    /**
     * creates a new BlockChain object with the initial transaction specified
     * @param initialTransaction The first transaction in the chain
     */
    public BlockChain(String[] initialTransaction){
        blockChain = new LinkedList<>();
        byte[] initial_hash = {'1'};
        blockChain.add(new Block(initial_hash, initialTransaction));
    }

    /**
     * creates a new BlockChain Object with a default initial transaction
     */
    public BlockChain(){
        blockChain = new LinkedList<>();
        String[] initial_transaction = {"Chris started the chain"};
        byte[] initial_hash = {'1'};
        blockChain.add(new Block(initial_hash, initial_transaction));
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
     * @param newBlock The new block object to be added
     */
    public void addBlock(Block newBlock){
        blockChain.add(newBlock);
    }

    /**
     * adds a transaction to the blockChain
     * @param transaction The transactions of the new block
     */
    public void addTransaction(String[] transaction){
        byte[] lastHash = blockChain.getLast().getBlockHash();
        Block newBlock = new Block(lastHash, transaction);

        addBlock(newBlock);
    }
}

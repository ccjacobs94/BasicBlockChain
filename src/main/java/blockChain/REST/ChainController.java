package blockChain.REST;

import blockChain.Containers.Block;
import blockChain.Containers.BlockChain;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChainController {

    private BlockChain blockChain = new BlockChain();

    /**
     * adds a transaction to the underlying BlockChain
     * @param transaction The transaction to be added
     */
    @RequestMapping(value = "/addTransaction", method = RequestMethod.POST)
    public List<Block> addTransaction(@RequestBody() String[] transaction){
        blockChain.addTransaction(transaction);
        return blockChain.getBlockChain();
    }

}

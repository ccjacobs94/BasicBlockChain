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
    public Boolean addTransaction(@RequestBody() String[] transaction){
        try {
            blockChain.addTransaction(transaction);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/ledger", method = RequestMethod.GET)
    public List<Block> getLedger(){
        return blockChain.getBlockChain();
    }

    @RequestMapping(value = "/IP", method = RequestMethod.GET)
    public String getIPAddresses(){
        return "One Moment Please";
    }

}

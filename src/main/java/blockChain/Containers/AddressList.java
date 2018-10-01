package blockChain.Containers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AddressList {
    List<String> addresses = new ArrayList<>();

    /**
     * Checks if all addresses in the list are valid
     * If they are then the response list of IP addresses is added to the list of IP addresses
     */
    public void refreshList(){
        for (int i = 0; i < addresses.size(); i++){
            String address = addresses.get(i);
            ArrayList<String> addressResponse = checkAddress(address);
            if (addressResponse != null){
                addResponse(addressResponse);
            }
        }


    }

    /**
     * checks if the address given is still active on the network
     * @param address the address being checked
     * @return The list of IP addresses returned from the request
     */
    private ArrayList<String> checkAddress(String address) {
        String request = address + ":8080/IP";
        try {
            URL url = new URL(request);
            ArrayList<String> response = (ArrayList<String>)url.getContent();
            return response;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("IP address expired " + request);
        }
        return null;
    }

    /**
     * goes through all of the addresses of a response and adds the non duplicates
     * @param response The list returned in a request
     */
    private void addResponse(ArrayList<String> response) {
        for (String s : response) {
            this.add(s);
        }
    }

    /**
     * adds a new address to the list of addresses as long as it is not a duplicate
     * @param address the address being added
     */
    private void add(String address){
        if (this.contains(address)){
            addresses.add(address);
        }
    }

    /**
     * checks if the list contains the address being added
     * @param address
     * @return
     */
    private boolean contains(String address) {
        for(String s : addresses){
            if (s.equals(address)){
                return true;
            }
        }
        return false;
    }

    public List<String> getAddresses() {
        return addresses;
    }
}

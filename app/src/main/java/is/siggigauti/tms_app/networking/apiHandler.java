package is.siggigauti.tms_app.networking;

import org.json.JSONException;
import org.json.JSONObject;


//A class that handles interconnections and data.
public class apiHandler {
    CustomTrust customTrustConnection = new CustomTrust();
    public boolean verifyUserKey(String userKey){
        //Not implemented.
        //Takes the userKey, sends a get request to the API for the user key
        //If the API returns with something, we check if its the same as user key
        //If same then return true (he exists) o.w. return false.
        return true;
    }

    public JSONObject getStoreByKennitala(int kt) throws JSONException {
        //Not implemented.
        //Takes the kt and sends a post request to the API with the kt.
        //API returns a json object in the body if the store with this kt exists
        JSONObject json = new JSONObject();
        json.put("storeName","Krónan");
        json.put("location","Árbær");
        json.put("kt","2020123399");
        json.put("no_of_terms","3");

        //Add info here before return (take from body)
        return json;
    }

    public boolean verifyTermSwitch(int oldHW, int newHW){
        //Not implemented
        //Use customTrustConenction.post(URL, JSON); to post to the server.
        //The function returns a string with the data returned, as well as headers e.t.c.
        //Takes old and new HW id. Constructs a post requests to the API.
        //API runs the SP on the DB and returns truthy or falsy
        //grab result and sends true or false depending on if the procedure successful.
        return true;
    }
}

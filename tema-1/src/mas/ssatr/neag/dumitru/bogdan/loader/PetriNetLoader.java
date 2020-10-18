package mas.ssatr.neag.dumitru.bogdan.loader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


/**
 * author: Bogdan
 */
public class PetriNetLoader {

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void readPetriNet(){

        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) object;

            JSONArray locationArray = (JSONArray)jsonObject.get("Locatii");
            if(locationArray == null) {
                System.out.println("Location array is null");
            }else if(locationArray.isEmpty()){
                System.out.println("location array is empty");
            }else{

            }


            JSONArray transitionArray = (JSONArray) jsonObject.get("Tranzitii");
            if(transitionArray == null){
                System.out.println("Transition array is null");
            }else if(transitionArray.isEmpty()){
                System.out.println("Transition array is empty");
            }else {

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}

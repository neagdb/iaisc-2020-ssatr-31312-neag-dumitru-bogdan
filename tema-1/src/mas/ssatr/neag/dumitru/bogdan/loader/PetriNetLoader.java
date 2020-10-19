package mas.ssatr.neag.dumitru.bogdan.loader;

import mas.ssatr.neag.dumitru.bogdan.model.Location;
import mas.ssatr.neag.dumitru.bogdan.model.ObjectualModel;
import mas.ssatr.neag.dumitru.bogdan.model.Transition;
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
    private ObjectualModel objectualModel = new ObjectualModel();
    public PetriNetLoader(String fileName) {
        this.fileName = fileName;
    }

    public PetriNetLoader() {

    }

    public ObjectualModel getObjectualModel() {
        return objectualModel;
    }

    public void readPetriNet() throws IOException, ParseException {

        JSONParser parser = new JSONParser();
        Object object = parser.parse(new FileReader(fileName));
        JSONObject jsonObject = (JSONObject) object;
        JSONArray locationArray = (JSONArray) jsonObject.get("Locatii");
        readLocation(jsonObject, locationArray);
        JSONArray transitionArray = (JSONArray) jsonObject.get("Tranzitii");
        readTransition(jsonObject, transitionArray);


    }

    private void readTransition(JSONObject jsonObject, JSONArray transitionArray) {
        if (jsonObject == null) {
            System.out.println("JSON is null!");
        } else if (transitionArray == null) {
            System.out.println("Transition Array is null!");
        } else if (transitionArray.isEmpty()) {
            System.out.println("Transition Array is empty!");
        } else {
            System.out.println("\nTransitions:");
            for (Object o : transitionArray) {
                jsonObject = (JSONObject) o;
                objectualModel.addTranistion(new Transition().setTransition(jsonObject));
                System.out.println(jsonObject);

            }
        }
    }

    private void readLocation(JSONObject jsonObject, JSONArray locationArray) {

        if(jsonObject == null){
            System.out.println("JSON is null!");
        }else if(locationArray == null){
            System.out.println("Location Array is null!");

        }else if(locationArray.isEmpty()){
            System.out.println("Location Array is empty!");
        }else {
            System.out.println("Locations:");
            for (Object o : locationArray) {
                jsonObject = (JSONObject) o;
                objectualModel.addLocation(new Location().setLocation(jsonObject));
                System.out.println(jsonObject);
            }
        }

    }

}

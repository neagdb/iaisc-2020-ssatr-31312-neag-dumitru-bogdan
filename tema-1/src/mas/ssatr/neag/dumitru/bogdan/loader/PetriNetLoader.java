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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


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

    public void readPetriNet() {

        JSONParser parser = new JSONParser();
        ObjectualModel objectualModel = new ObjectualModel();
        try {
            Object object = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) object;

            JSONArray locationArray = (JSONArray) jsonObject.get("Locatii");
            if (locationArray == null) {
                System.out.println("Location array is null");
            } else if (locationArray.isEmpty()) {
                System.out.println("location array is empty");
            } else {
                Iterator<JSONObject> iterator = locationArray.iterator();
                while (iterator.hasNext()) {
                    jsonObject = iterator.next();
                    objectualModel.addLocation(setLocation(jsonObject));
                    System.out.println(jsonObject);
                }
            }


            JSONArray transitionArray = (JSONArray) jsonObject.get("Tranzitii");
            if (transitionArray == null) {
                System.out.println("Transition array is null");
            } else if (transitionArray.isEmpty()) {
                System.out.println("Transition array is empty");
            } else {
                Iterator<JSONObject> iterator = transitionArray.iterator();
                while (iterator.hasNext()) {
                    jsonObject = iterator.next();
                    objectualModel.addTranistion(setTransition(jsonObject));
                    System.out.println(jsonObject);

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    private Location setLocation(JSONObject jsonObject) {
        Location l = new Location();
        return l;
    }

    public Transition setTransition(JSONObject jsonObject) {
        Transition t = new Transition();
        t.setId(jsonObject.get("id").toString());
        t.setMinT(Integer.valueOf(jsonObject.get("minT").toString()));
        t.setMaxT(Integer.valueOf(jsonObject.get("maxT").toString()));

        JSONArray inputArray = (JSONArray) jsonObject.get("in");
        List<String> inputList = new ArrayList<String>();
        Iterator<String> iterator = inputArray.iterator();
        while (iterator.hasNext()) {
            inputList.add(iterator.next());
        }
        t.setInputLocation(inputList);

        JSONArray outputArray = (JSONArray) jsonObject.get("out");
        List<String> outputList = new ArrayList<String>();
        iterator = outputArray.iterator();
        while (iterator.hasNext()) {
            outputList.add(iterator.next());
        }
        t.setOutputLocation(outputList);

        return t;
    }


}

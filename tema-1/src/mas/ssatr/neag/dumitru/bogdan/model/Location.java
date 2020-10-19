package mas.ssatr.neag.dumitru.bogdan.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author: Bogdan
 */
public class Location {

    private String id;
    private int jeton;
    private List<String>inputTransition;
    private List<String> outputTransition;

    public Location(String id, int jeton, List<String> inputTransition, List<String> outputTransition) {
        this.id = id;
        this.jeton = jeton;
        this.inputTransition = inputTransition;
        this.outputTransition = outputTransition;
    }

    public Location() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getJeton() {
        return jeton;
    }

    public void setJeton(int jeton) {
        this.jeton = jeton;
    }

    public List<String> getInputTransition() {
        return inputTransition;
    }

    public void setInputTransition(List<String> inputTransition) {
        this.inputTransition = inputTransition;
    }

    public List<String> getOutputTransition() {
        return outputTransition;
    }

    public void setOutputTransition(List<String> outputTransition) {
        this.outputTransition = outputTransition;
    }

    public Location setLocation(JSONObject jsonObject){
        Location location = new Location();
        location.setId(jsonObject.get("id").toString());
        location.setJeton(Integer.parseInt(jsonObject.get("jeton").toString()));

        JSONArray inputArray = (JSONArray)jsonObject.get("in");
        List<String> inputTransition = new ArrayList<String>();
        Iterator<String> iterator = inputArray.iterator();
        while (iterator.hasNext()){
            inputTransition.add(iterator.next());
        }
        location.setInputTransition(inputTransition);

        JSONArray outputArray = (JSONArray)jsonObject.get("out");
        List<String> outputTransition = new ArrayList<String>();
        iterator = outputArray.iterator();
        while (iterator.hasNext()){
            outputTransition.add(iterator.next());
        }
        location.setOutputTransition(outputTransition);

        return location;
    }
}

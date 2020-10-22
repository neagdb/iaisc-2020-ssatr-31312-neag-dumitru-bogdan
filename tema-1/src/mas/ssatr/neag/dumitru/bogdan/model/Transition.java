package mas.ssatr.neag.dumitru.bogdan.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * author: Bogdan
 */
public class Transition {

    private String id;
    private int minT;
    private int maxT;
    private List<String> inputLocation;
    private List<String> outputLocation;
    private int duration;
    private int jetonInTrans;

    public Transition() {
    }

    public Transition(String id, int minT, int maxT, List<String> inputLocation, List<String> outputLocation, int duration) {
        this.id = id;
        this.minT = minT;
        this.maxT = maxT;
        this.inputLocation = inputLocation;
        this.outputLocation = outputLocation;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMinT() {
        return minT;
    }

    public void setMinT(int minT) {
        this.minT = minT;
    }

    public int getMaxT() {
        return maxT;
    }

    public void setMaxT(int maxT) {
        this.maxT = maxT;
    }

    public List<String> getInputLocation() {
        return inputLocation;
    }

    public void setInputLocation(List<String> inputLocation) {
        this.inputLocation = inputLocation;
    }

    public List<String> getOutputLocation() {
        return outputLocation;
    }

    public void setOutputLocation(List<String> outputLocation) {
        this.outputLocation = outputLocation;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration() {
        this.duration = (int) ((Math.random() * (maxT - minT)) + minT);
        System.out.println("Transition with id:" + id + " has " + duration + "T.U. duration");
    }

    public Transition setTransition(JSONObject jsonObject) {
        Transition transition = new Transition();
        transition.setId(jsonObject.get("id").toString());
        transition.setMinT(Integer.parseInt(jsonObject.get("minT").toString()));
        transition.setMaxT(Integer.parseInt(jsonObject.get("maxT").toString()));

        JSONArray inputArray = (JSONArray) jsonObject.get("in");
        List<String> inputLocation = new ArrayList<String>();
        Iterator<String> iterator = inputArray.iterator();
        while (iterator.hasNext()) {
            inputLocation.add(iterator.next());
        }
        transition.setInputLocation(inputLocation);

        JSONArray outputArray = (JSONArray) jsonObject.get("out");
        List<String> outputLocation = new ArrayList<String>();
        iterator = outputArray.iterator();
        while (iterator.hasNext()) {
            outputLocation.add(iterator.next());
        }
        transition.setOutputLocation(outputLocation);

        return transition;
    }


    public int getJetonInTrans() {
        return jetonInTrans;
    }

    public void incJetonInTrans() {
        jetonInTrans++;
    }

    public void decJetonInTrans() {
        jetonInTrans--;
    }

    public void decDuration() {
        duration--;
    }
}

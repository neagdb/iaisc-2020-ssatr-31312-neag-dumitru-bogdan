package mas.ssatr.neag.dumitru.bogdan.model;

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
}

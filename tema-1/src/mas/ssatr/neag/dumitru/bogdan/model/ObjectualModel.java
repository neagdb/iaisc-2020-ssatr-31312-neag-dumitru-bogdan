package mas.ssatr.neag.dumitru.bogdan.model;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Bogdan
 */
public class ObjectualModel {

    private String id;
    private List<String> input = new ArrayList<String>();
    private List<String> output = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getInput() {
        return input;
    }

    public void setInput(List<String> input) {
        this.input = input;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }
}

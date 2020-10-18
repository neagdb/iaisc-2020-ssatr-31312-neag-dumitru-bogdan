package mas.ssatr.neag.dumitru.bogdan.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * author: Bogdan
 */
public class ObjectualModel {

    private List<Location> locations;
    private List<Transition> transitions;

    public void addLocation(Location l) {
        locations.add(l);
    }

    public void addTranistion(Transition t) {
        transitions.add(t);
    }

    public List<Location> getLocations() {
        return locations;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

}

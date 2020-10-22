package mas.ssatr.neag.dumitru.bogdan.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * author: Bogdan
 */
public class ObjectualModel {

    private List<Location> locations = new ArrayList<>();
    private List<Transition> transitions = new ArrayList<>();
    private List<Integer> maxTimes = new ArrayList<>();

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

    public Location findLocation(String id) {
        for (Location location : locations) {
            if (location.getId().equals(id)) {
                return location;
            }

        }
        return null;
    }

    public List<Integer> getMaxTimes() {
        for (Transition transition : transitions) {
            maxTimes.add(transition.getMaxT());
        }
        return maxTimes;
    }

}

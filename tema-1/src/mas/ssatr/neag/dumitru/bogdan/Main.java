package mas.ssatr.neag.dumitru.bogdan;

import mas.ssatr.neag.dumitru.bogdan.loader.PetriNetLoader;
import mas.ssatr.neag.dumitru.bogdan.model.ObjectualModel;
import mas.ssatr.neag.dumitru.bogdan.simulation.SimulationEngine;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        PetriNetLoader petriNetLoader = new PetriNetLoader("src/mas/ssatr/neag/dumitru/bogdan/input/retea-petri.json");
        petriNetLoader.readPetriNet();
        ObjectualModel objectualModel = petriNetLoader.getObjectualModel();
        SimulationEngine simulationEngine = new SimulationEngine(objectualModel);
        simulationEngine.setOutputFile("src/mas/ssatr/neag/dumitru/bogdan/output/simulation-result.txt");
        simulationEngine.evaluate();
    }
}

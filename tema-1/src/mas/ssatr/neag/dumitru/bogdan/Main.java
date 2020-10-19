package mas.ssatr.neag.dumitru.bogdan;

import mas.ssatr.neag.dumitru.bogdan.loader.PetriNetLoader;
import mas.ssatr.neag.dumitru.bogdan.model.Location;
import mas.ssatr.neag.dumitru.bogdan.model.ObjectualModel;
import mas.ssatr.neag.dumitru.bogdan.simulation.SimulationEngine;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        PetriNetLoader petriNetLoader = new PetriNetLoader("src/mas/ssatr/neag/dumitru/bogdan/input/retea-petri.json");
        petriNetLoader.readPetriNet();
        ObjectualModel objectualModel = petriNetLoader.getObjectualModel();
        SimulationEngine simulationEngine = new SimulationEngine(objectualModel);
        simulationEngine.seOutputFile("src/mas/ssatr/neag/dumitru/bogdan/output/simulation-result.txt");
        simulationEngine.evaluate();
    }
}

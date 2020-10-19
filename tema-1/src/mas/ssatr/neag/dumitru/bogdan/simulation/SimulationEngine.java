package mas.ssatr.neag.dumitru.bogdan.simulation;

import mas.ssatr.neag.dumitru.bogdan.loader.PetriNetLoader;
import mas.ssatr.neag.dumitru.bogdan.model.Location;
import mas.ssatr.neag.dumitru.bogdan.model.ObjectualModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: Bogdan
 */
public class SimulationEngine {
    private FileWriter fileWriter;
    private boolean isAlive = true;
    private ObjectualModel objectualModel;

    public SimulationEngine(ObjectualModel objectualModel) {
        this.objectualModel = objectualModel;
    }

    public void seOutputFile(String file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public void evaluate() throws IOException {
        while (isAlive) {
            writeMark();
            fire();
        }
        fileWriter.flush();
        fileWriter.close();
    }

    private void fire() {
        isAlive = false;
    }

    private void writeMark() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String currentDate = formatter.format(date);

        fileWriter.write("Time: " + currentDate + " ");
        System.out.print("Time: " + currentDate + " ");
        for (Location location : objectualModel.getLocations()) {
            fileWriter.write(location.getId() + " -> " + location.getJeton() + " ");
            System.out.print(location.getId() + " -> " + location.getJeton() + " ");
        }
        fileWriter.write("\n");
        System.out.println();



    }


}

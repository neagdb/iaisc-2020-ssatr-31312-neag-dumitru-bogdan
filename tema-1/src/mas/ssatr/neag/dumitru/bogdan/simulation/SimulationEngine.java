package mas.ssatr.neag.dumitru.bogdan.simulation;

import mas.ssatr.neag.dumitru.bogdan.model.Location;
import mas.ssatr.neag.dumitru.bogdan.model.ObjectualModel;
import mas.ssatr.neag.dumitru.bogdan.model.Transition;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * author: Bogdan
 */
public class SimulationEngine {
    private FileWriter fileWriter;
    private boolean isAlive = true;
    private ObjectualModel objectualModel;
    private List<String> initialMark;
    private List<String> currentMark;
    private List<Integer> maxTimes;
    private int worstCaseTime = 0;
    private int currentTime = 0;


    public SimulationEngine(ObjectualModel objectualModel) {
        this.objectualModel = objectualModel;
    }

    public void setOutputFile(String file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public void evaluate() throws IOException {

        initialMark = getMark();
        maxTimes = objectualModel.getMaxTimes();
        worstCaseTime = getMaxTimeOverall(maxTimes);

        while (isAlive) {
            writeMark();
            fire();
            if (checkMark(initialMark, currentMark) || checkWorstCase(worstCaseTime, currentTime)) {
                isAlive = false;
            }

        }
        fileWriter.flush();
        fileWriter.close();
    }


    private List<String> getMark() {
        List<String> returnMatk = new ArrayList<>();
        List<String> mark = new ArrayList<>();
        for (Location location : objectualModel.getLocations()) {
            mark.add(location.getId() + "->" + location.getJeton());

        }
        returnMatk.add(mark.toString());
        return returnMatk;

    }

    private void writeMark() throws IOException {
        currentTime++;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String currentDate = formatter.format(date);

        fileWriter.write("Time:" + currentDate + " [");
        System.out.print("Time: " + currentDate + " [");
        for (Location location : objectualModel.getLocations()) {
            fileWriter.write(location.getId() + "->" + location.getJeton() + " ");
            System.out.print(location.getId() + "->" + location.getJeton()+ " ");
        }
        fileWriter.write("]\n");
        System.out.print("]\n");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fire() {

        for (int i = 0; i < objectualModel.getTransitions().size(); i++) {
            Transition transition = objectualModel.getTransitions().get(i);
            if (transition.getDuration() > 0) {
                transition.decDuration();
            }
            if (transition.getJetonInTrans() == 0) {
                if (isFireable(transition)) {
                    getTokenFromInput(transition);
                }
            }
        }
        for (int i = 0; i < objectualModel.getTransitions().size(); i++) {
            Transition transition = objectualModel.getTransitions().get(i);
            setTokenToOutput(transition);
        }
        currentMark = getMark();
    }

    private void getTokenFromInput(Transition transition) {

        for (int i = 0; i < transition.getInputLocation().size(); i++) {
            Location location = objectualModel.findLocation(transition.getInputLocation().get(i));
            if (location.getJeton() != 0)
                location.decJeton();

        }
        transition.incJetonInTrans();
        transition.setDuration();
    }

    private void setTokenToOutput(Transition transition) {
        if (transition.getDuration() == 0) {
            if (transition.getJetonInTrans() != 0) {
                transition.decJetonInTrans();
                for (int i = 0; i < transition.getOutputLocation().size(); i++) {
                    Location location = objectualModel.findLocation(transition.getOutputLocation().get(i));
                    location.incJeton();
                }
            }
        }
    }

    private boolean isFireable(Transition transition) {
        if (transition.getInputLocation().size() == 0)
            return false;
        for (int i = 0; i < transition.getInputLocation().size(); i++) {
            Location location = objectualModel.findLocation(transition.getInputLocation().get(i));
            if (location.getJeton() == 0)
                return false;
        }
        return true;
    }

    private int getMaxTimeOverall(List<Integer> maxTimes) {

        for (Integer maxTime : maxTimes) {
            worstCaseTime += maxTime;
        }
        return worstCaseTime;
    }

    private boolean checkMark(List<String> initialMark, List<String> currentMark) {
        return initialMark.equals(currentMark);
    }
    private boolean checkWorstCase(int worstCaseTime, int currentTime){
        return (worstCaseTime < currentTime);
    }
}

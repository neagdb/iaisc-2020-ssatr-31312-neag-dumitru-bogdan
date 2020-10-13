package mas.ssatr.neag.dumitru.bogdan.model;

import java.util.Random;

/**
 * author: Bogdan
 */
public class Transition extends ObjectualModel{

    private int minT;
    private int maxT;
    private int delay;
    private int temopToken;

    public Transition(){
        delay = 0;
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

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        if(minT == 0 && maxT == 0){
            System.out.println(this.getId() + "has no delay!");
        }else {
            Random r = new Random();
            delay = r.nextInt((maxT - minT) + 1) + minT;
            System.out.println(this.getId() + " delay set to: " + delay);
        }
    }

    public int getTemopToken() {
        return temopToken;
    }

    public void setTemopToken(int temopToken) {
        this.temopToken = temopToken;
    }

    public void addTempToken(){
        temopToken++;
    }
}

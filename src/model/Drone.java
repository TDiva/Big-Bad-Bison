package model;

/**
 * @author Vlad Abramov
 * @since 2/11/2016
 */
public class Drone {

    private int maxPayload;
    private int curLoad;

    public Drone() {
    }

    public Drone(int maxPayload) {
        this.maxPayload = maxPayload;
    }

    public Drone(int maxPayload, int curLoad) {
        this.maxPayload = maxPayload;
        this.curLoad = curLoad;
    }

    public int getMaxPayload() {
        return maxPayload;
    }

    public void setMaxPayload(int maxPayload) {
        this.maxPayload = maxPayload;
    }

    public int getCurLoad() {
        return curLoad;
    }

    public void setCurLoad(int curLoad) {
        this.curLoad = curLoad;
    }
}

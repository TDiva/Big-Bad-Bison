import java.util.ArrayList;
import java.util.List;

/**
 * Created by TDiva on 2/11/16.
 */
public abstract class AbstractSolver implements Solver {

    private List<Drone> drones;
    private List<Order> orders;
    private List<Warehouse> warehouses;

    private int r;
    private int c;

    public AbstractSolver(List<Drone> drones, List<Order> orders, List<Warehouse> warehouses, int r, int c) {
        this.drones = drones;
        this.orders = orders;
        this.warehouses = warehouses;
        this.r = r;
        this.c = c;
    }

    public AbstractSolver(int r, int c) {
        this.r = r;
        this.c = c;
        drones = new ArrayList<>();
        warehouses = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public void addDrone(Drone d) {
        drones.add(d);
    }

    public void addOrder(Order o) {
        orders.add(o);
    }

    public void addWarehouse(Warehouse w) {
        warehouses.add(w);
    }

}

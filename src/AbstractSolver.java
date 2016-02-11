import java.util.ArrayList;
import java.util.List;

/**
 * Created by TDiva on 2/11/16.
 */
public abstract class AbstractSolver implements Solver {

    protected List<Drone> drones;
    protected List<Order> orders;
    protected List<Warehouse> warehouses;

    protected int r;
    protected int c;
    protected int maxWeight;

    public AbstractSolver(List<Drone> drones, List<Order> orders, List<Warehouse> warehouses, int r, int c, int m) {
        this.drones = drones;
        this.orders = orders;
        this.warehouses = warehouses;
        this.r = r;
        this.c = c;
        this.maxWeight = m;
    }

    public AbstractSolver(int r, int c, int m) {
        this.r = r;
        this.c = c;
        this.maxWeight = m;
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

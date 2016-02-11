import java.util.List;

/**
 * Created by TDiva on 2/11/16.
 */
public class StupidSolver extends AbstractSolver {
    public StupidSolver(List<Drone> drones, List<Order> orders, List<Warehouse> warehouses, int r, int c) {
        super(drones, orders, warehouses, r, c);
    }

    public StupidSolver(int r, int c) {
        super(r, c);
    }

    @Override
    public Result run() {

        Warehouse stPoint = warehouses.get(0);

        for (Order o: orders) {
            if (stPoint.getProducts().keySet().containsAll(o.getProducts().keySet())) {

            }
        }


        return new Result();
    }
}

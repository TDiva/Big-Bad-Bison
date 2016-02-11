import model.AbstractSolver;
import model.Drone;
import model.Order;
import model.Warehouse;

import java.util.List;

/**
 * Created by TDiva on 2/11/16.
 */
public class ShortPathSolver extends AbstractSolver {

    public ShortPathSolver(int r, int c) {
        super(r, c);
    }

    public ShortPathSolver(List<Drone> drones, List<Order> orders, List<Warehouse> warehouses, int r, int c) {
        super(drones, orders, warehouses, r, c);
    }

    @Override
    public Result run() {

        return new Result();
    }
}

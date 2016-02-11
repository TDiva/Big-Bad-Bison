package solver;

import model.Drone;
import model.Order;
import model.Result;
import model.Warehouse;

import java.util.List;

/**
 * Created by TDiva on 2/11/16.
 */
public class ShortPathSolver extends AbstractSolver {


    public ShortPathSolver(List<Drone> drones, List<Order> orders, List<Warehouse> warehouses, Integer r, Integer c, Integer m) {
        super(drones, orders, warehouses, r, c, m);
    }

    public ShortPathSolver(int r, int c, int m) {
        super(r, c, m);
    }

    @Override
    public Result run() {

        return new Result();
    }
}

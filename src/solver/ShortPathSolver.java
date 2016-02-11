package solver;

import model.*;

import java.util.List;

/**
 * Created by TDiva on 2/11/16.
 */
public class ShortPathSolver extends AbstractSolver {

    public ShortPathSolver(List<Drone> drones, List<Product> products, List<Order> orders, List<Warehouse> warehouses, Integer r, Integer c, Integer m) {
        super(drones, products, orders, warehouses, r, c, m);
    }

    public ShortPathSolver(int r, int c, int m) {
        super(r, c, m);
    }

    @Override
    public Result run() {

        return new Result();
    }
}

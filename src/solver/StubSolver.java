package solver;

import model.*;

import java.util.List;

/**
 * @author Vlad Abramov
 * @since 2/11/2016
 */
public class StubSolver extends AbstractSolver {


    public StubSolver(List<Drone> drones, List<Product> products, List<Order> orders, List<Warehouse> warehouses, Integer r, Integer c, Integer m) {
        super(drones, products, orders, warehouses, r, c, m);
    }

    public StubSolver(int r, int c, int m) {
        super(r, c, m);
    }

    @Override
    public Result run() {
        return null;
    }
}

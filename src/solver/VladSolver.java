package solver;

import model.Drone;
import model.Order;
import model.Result;
import model.Warehouse;

import java.util.List;

/**
 * @author Vlad Abramov
 * @since 2/11/2016
 */
public class VladSolver extends AbstractSolver {

    public VladSolver(List<Drone> drones, List<Order> orders, List<Warehouse> warehouses, Integer r, Integer c, Integer m) {
        super(drones, orders, warehouses, r, c, m);
    }

    public VladSolver(int r, int c, int m) {
        super(r, c, m);
    }

    @Override
    public Result run() {
        return null;
    }
}

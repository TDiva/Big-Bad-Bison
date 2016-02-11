package solver;

import model.*;

import java.util.List;

/**
 * Created by TDiva on 2/11/16.
 */
public class StupidSolver extends AbstractSolver {


    public StupidSolver(List<Drone> drones, List<Product> products, List<Order> orders, List<Warehouse> warehouses, Integer r, Integer c, Integer m) {
        super(drones, products, orders, warehouses, r, c, m);
    }

    public StupidSolver(int r, int c, int m) {
        super(r, c, m);
    }

    @Override
    public Result run() {

        Warehouse stPoint = warehouses.get(0);

        for (Order o: orders) {
            if (stPoint.hasAllItems(o.getProducts())) {
                
            }
        }


        return new Result();
    }
}

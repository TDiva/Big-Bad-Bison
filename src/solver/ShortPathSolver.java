package solver;

import javafx.util.Pair;
import model.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by TDiva on 2/11/16.
 */
public class ShortPathSolver extends AbstractSolver {

    public ShortPathSolver(AbstractSolver a) {
        super(a.drones, a.products, a.orders, a.warehouses, a.r, a.c, a.maxWeight);
    }

    public ShortPathSolver(List<Drone> drones, List<Product> products, List<Order> orders, List<Warehouse> warehouses, Integer r, Integer c, Integer m) {
        super(drones, products, orders, warehouses, r, c, m);
    }

    public ShortPathSolver(int r, int c, int m) {
        super(r, c, m);
    }

    @Override
    public Result run() {
        Result result = new Result();
        int minDist = Integer.MAX_VALUE;
        Map<Integer, Pair<Order, Warehouse>> turns = new HashMap<>();
        Pair<Order, Warehouse> temp;

        Warehouse first = getZero();
        Collections.sort(warehouses, (o1, o2) -> o1.wayTo(first.getxPos(), first.getyPos()) - o2.wayTo(first.getxPos(), first.getyPos()));

        for (Order o : orders) {
            Warehouse nearest = null;
            int distance = 0;
            for (Warehouse w : warehouses) {
                if (w.hasAllItems(o.getProducts())) {
                    distance = distanceBetweenWarehouseAndOrder(w, o);
                    if (distance <= minDist) {
                        minDist = distance;
                        nearest = w;
                    }
                }
            }

        }
        return new Result();
    }

    private int distanceBetweenWarehouseAndOrder(Warehouse w, Order o) {
        return (int) Math.ceil(Math.sqrt(Math.abs(o.getxDeliverPos() - w.getxPos()) ^ 2 + Math.abs(o.getyDeliverPos() - w.getyPos()) ^ 2));
    }

    private Warehouse getZero() {
        for (Warehouse w : warehouses)
            if (w.getId() == 0)
                return w;
        return null;
    }
}

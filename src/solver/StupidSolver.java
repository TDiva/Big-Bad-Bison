package solver;

import model.*;

import java.util.*;

/**
 * Created by TDiva on 2/11/16.
 */
public class StupidSolver extends AbstractSolver {

    public StupidSolver(AbstractSolver a) {
        super(a.drones, a.products, a.orders, a.warehouses, a.r, a.c, a.maxWeight);
    }

    public StupidSolver(List<Drone> drones, List<Product> products, List<Order> orders, List<Warehouse> warehouses, Integer r, Integer c, Integer m) {
        super(drones, products, orders, warehouses, r, c, m);
    }

    public StupidSolver(int r, int c, int m) {
        super(r, c, m);
    }

    @Override
    public Result run() {
        Result result = new Result();
        Queue<Drone> available = new LinkedList<>(drones);
        Queue<Warehouse> ws = new LinkedList<>(warehouses);
        while (!available.isEmpty() && !orders.isEmpty()) {
            Warehouse stPoint = ws.poll();
            for (Order o : orders) {
                if (stPoint.hasAllItems(o.getProducts())) {
                    Map<Product, Integer> forDrone = new HashMap<>();
                    int weight = 0;
                    for (Product p : o.getProducts().keySet()) {
                        for (int i = 0; i < o.getProducts().get(p); i++) {
                            if (weight + p.getWeight() > maxWeight) {
                                send(available.poll(), result, stPoint, o, forDrone);
                                forDrone.clear();
                                weight = 0;
                            }
                            weight += p.getWeight();
                            forDrone.put(p, (forDrone.containsKey(p) ? forDrone.get(p) : 0) + 1);
                        }
                    }
                    send(available.poll(), result, stPoint, o, forDrone);
                    orders.remove(o);
                }
            }
        }

        return result;
    }

    public void send(Drone d, Result r, Warehouse w, Order o, Map<Product, Integer> pr) {
        for (Product p: pr.keySet()) {
            r.load(d, w, p, pr.get(p));
        }
        for (Product p : pr.keySet()) {
            r.deliver(d, o, p, pr.get(p));
        }
    }
}

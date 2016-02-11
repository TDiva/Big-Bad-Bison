package solver;

import model.*;

import java.util.*;

/**
 * Created by TDiva on 2/11/16.
 */
public class StupidSolverV2 extends AbstractSolver {

    public StupidSolverV2(AbstractSolver a) {
        super(a.drones, a.products, a.orders, a.warehouses, a.r, a.c, a.maxWeight);
    }

    public StupidSolverV2(List<Drone> drones, List<Product> products, List<Order> orders, List<Warehouse> warehouses, Integer r, Integer c, Integer m) {
        super(drones, products, orders, warehouses, r, c, m);
    }

    public StupidSolverV2(int r, int c, int m) {
        super(r, c, m);
    }

    @Override
    public Result run() {
        Result result = new Result();
        Queue<Drone> available = new LinkedList<>(drones);
        Warehouse first = warehouses.get(0);
        Collections.sort(warehouses, (o1, o2) -> o1.wayTo(first.getxPos(), first.getyPos()) - o2.wayTo(first.getxPos(), first.getyPos()));
        Queue<Warehouse> ws = new LinkedList<>(warehouses);
        int orderCnt = orders.size();
        while (!available.isEmpty() && !ws.isEmpty() &&  orderCnt > 0) {
            Warehouse stPoint = ws.poll();
            Drone drone = available.poll();
            Collections.sort(orders, (o1, o2) -> {
                if (o1.isDone() && o2.isDone()) return 0;
                if (o1.isDone()) return Integer.MAX_VALUE;
                if (o2.isDone()) return Integer.MIN_VALUE;
                else return o1.wayTo(stPoint.getxPos(), stPoint.getyPos()) - o2.wayTo(stPoint.getxPos(), stPoint.getyPos());
            });
            for (Order o : orders) {
                if (!o.isDone() &&
                        ((first == stPoint && first.hasAllItems(o.getProducts())) ||
                                (first != stPoint  && Warehouse.hasAllItems2(o.getProducts(), stPoint, first)))) {
                    Map<Product, Integer> forDrone = new HashMap<>();
                    int weight = 0;
                    Map<Product, Integer> list1 = first.getListofAvailable(o.getProducts());
                    Map<Product, Integer> list2 = restOf(o.getProducts(), list1);
                    for (Product p : list1.keySet()) {
                        for (int i = 0; i < list1.get(p); i++) {
                            if (weight + p.getWeight() > maxWeight) {
                                send(drone, result, first, o, forDrone);
                                first.ejectProducts(forDrone);
                                available.add(drone);
                                drone = available.poll();
                                forDrone.clear();
                                weight = 0;
                            }
                            weight += p.getWeight();
                            forDrone.put(p, (forDrone.containsKey(p) ? forDrone.get(p) : 0) + 1);
                        }
                    }
                    send(drone, result, first, o, forDrone);
                    first.ejectProducts(forDrone);
                    available.add(drone);
                    drone = available.poll();

                    forDrone.clear();
                    weight = 0;
                    for (Product p : list2.keySet()) {
                        for (int i = 0; i < list2.get(p); i++) {
                            if (weight + p.getWeight() > maxWeight) {
                                send(drone, result, stPoint, o, forDrone);
                                stPoint.ejectProducts(forDrone);
                                available.add(drone);
                                drone = available.poll();
                                forDrone.clear();
                                weight = 0;
                            }
                            weight += p.getWeight();
                            forDrone.put(p, (forDrone.containsKey(p) ? forDrone.get(p) : 0) + 1);
                        }
                    }
                    send(drone, result, stPoint, o, forDrone);
                    stPoint.ejectProducts(forDrone);
                    available.add(drone);
                    drone = available.poll();

                    o.setDone();
                    orderCnt--;
                }
            }
        }

        return result;
    }

    public static Map<Product, Integer> restOf(Map<Product, Integer> all, Map<Product, Integer> done) {
        Map<Product, Integer> rest = new HashMap<>(all);
        for (Product p: done.keySet()) {
            rest.put(p, rest.get(p) - done.get(p));
        }
        return rest;
    }

    public void send(Drone d, Result r, Warehouse w, Order o, Map<Product, Integer> pr) {
        for (Product p: pr.keySet()) {
            r.load(d, w, p, pr.get(p));
        }
        for (Product p : pr.keySet()) {
            r.deliver(d, o, p, pr.get(p));
        }
    }

    public void load(Drone d, Result r, Warehouse w, Order o, Map<Product, Integer> pr) {
        for (Product p: pr.keySet()) {
            r.load(d, w, p, pr.get(p));
        }
    }

    public void deliver(Drone d, Result r, Warehouse w, Order o, Map<Product, Integer> pr) {
        for (Product p : pr.keySet()) {
            r.deliver(d, o, p, pr.get(p));
        }
    }
}

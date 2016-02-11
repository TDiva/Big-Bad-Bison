package solver;

import javafx.util.Pair;
import model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        int distance = 0;
        int min_distance_to_order = Integer.MAX_VALUE;
        Map<Integer,Pair<Order,Warehouse>> turns = new HashMap<>();
        Pair<Order,Warehouse> temp;


        for(Order o: orders){
            Pair<Integer,Integer> minDinstanceWarhouse;
            for(Warehouse w : warehouses){
                distance = (int) Math.ceil(Math.sqrt(Math.abs(o.getxDeliverPos()-w.getxPos())^2 + Math.abs(o.getyDeliverPos()-w.getyPos())^2));
                if(distance < min_distance_to_order){
                    min_distance_to_order = distance;
                    minDinstanceWarhouse = new Pair<>(distance,w.getId());
                }
                temp = new Pair<>(o,w);
                turns.put(min_distance_to_order,temp);

            }
        }
        return new Result();
    }
}

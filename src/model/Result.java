package model;

import main.InOutService;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * Created by TDiva on 2/11/16.
 */
public class Result implements Comparable<Result>{

    private enum OperaionType {
        LOAD("L"),
        UNLOAD("U"),
        DELIVER("D"),
        WAIT("W");

        private String code;

        OperaionType(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    private class Operation {
        private Drone drone;
        private OperaionType type;
        private Number[] params;

        public Operation(Drone d, OperaionType type, Number... params) {
            this.drone = d;
            this.type = type;
            this.params = params;
        }

        @Override
        public String toString() {
            return drone.getId() + " " + type.getCode() + " " + Arrays.stream(params)
                    .map(n -> String.valueOf(n))
                    .collect(joining(" "));
        }
    }

    private List<Operation> operationList;

    public void load(Drone drone, Warehouse warehouse, Product product, Integer amount) {
        operationList.add(new Operation(drone, OperaionType.LOAD, warehouse.getId(), product.getTypeCode(), amount));
    }

    public void deliver(Drone drone, Order order, Product product, Integer amount) {
        operationList.add(new Operation(drone, OperaionType.DELIVER, order.getId(), product.getTypeCode(), amount));
    }

    public void save(InOutService inOutService) {

    }

    // MAX is the best
    @Override
    public int compareTo(Result o) {
        return 0;
    }
}

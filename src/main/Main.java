package main;

import model.*;
import solver.AbstractSolver;
import model.Result;
import solver.Solver;
import solver.VladSolver;

import java.lang.reflect.Constructor;
import java.util.*;

public class Main {

    // Fill solvers
    private static List<Solver> solvers = Arrays.asList();

    public static void main(String[] args) {
        try {
            String busyDay = "busy_day";
            String motherOfAllWarehouses = "mother_of_all_warehouses";
            String redundancy = "redundancy";

            InOutService inOut = new InOutService(busyDay);

            AbstractSolver abstractSolver = parseInput(inOut, VladSolver.class);

            List<Result> res = new ArrayList<>();
            solvers.forEach( s -> res.add(s.run()));

            Result best = Collections.max(res);
            if (best != null)
                best.save(inOut);

            inOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static <T extends AbstractSolver> T parseInput(InOutService inOut, Class<T> clazz) throws Exception {
        StringTokenizer st = new StringTokenizer(inOut.readLine());
        int rows = Integer.parseInt(st.nextToken());
        int columns = Integer.parseInt(st.nextToken());
        int dronesCount = Integer.parseInt(st.nextToken());
        List<Drone> drones = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Warehouse> warehouses = new ArrayList<>();
        for (int i = 0; i < dronesCount; ++i)
            drones.add(new Drone());
        // List<model.Drone> drones, List<model.Order> orders, List<model.Warehouse> warehouses, int r, int c
        Constructor<T> constructor = clazz.getDeclaredConstructor(List.class, List.class, List.class, Integer.class, Integer.class);
        return constructor.newInstance(drones, orders, warehouses, rows, columns);
    }

}
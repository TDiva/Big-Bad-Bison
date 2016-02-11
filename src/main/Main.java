package main;

import model.*;
import solver.AbstractSolver;
import solver.Solver;
import solver.StubSolver;
import solver.StupidSolver;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int TURNS = 0;

    // Fill solvers
    private static List<Solver> solvers = Arrays.asList();

    public static void main(String[] args) {
        try {
            String busyDay = "busy_day";
            String motherOfAllWarehouses = "mother_of_all_warehouses";
            String redundancy = "redundancy";

            InOutService inOut = new InOutService(busyDay);

            AbstractSolver abstractSolver = parseInput(inOut, StubSolver.class);

            StupidSolver tanya = new StupidSolver(abstractSolver);

            Result r = tanya.run();
            r.save(inOut);

//            List<Result> res = new ArrayList<>();
//            solvers.forEach( s -> res.add(s.run()));
//
//            Result best = Collections.max(res);
//            if (best != null)
//                best.save(inOut);

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
        TURNS = Integer.parseInt(st.nextToken());
        int maxPayload = Integer.parseInt(st.nextToken());
        List<Drone> drones = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        List<Warehouse> warehouses = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        // drones
        for (int i = 0; i < dronesCount; ++i)
            drones.add(new Drone(i, maxPayload));
        // products
        st = new StringTokenizer(inOut.readLine());
        int productCount = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(inOut.readLine());
        for (int i = 0; i < productCount; ++i)
            products.add(new Product(i, Integer.parseInt(st.nextToken())));

        // warehouses
        st = new StringTokenizer(inOut.readLine());
        int warehouseCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < warehouseCount; ++i) {
            st = new StringTokenizer(inOut.readLine());
            Warehouse w = new Warehouse(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(inOut.readLine());
            for (Product p : products) {
                int c = Integer.parseInt(st.nextToken());
                if (c != 0 )
                    w.addProduct(p, c);
            }
            warehouses.add(w);
        }

        // orders
        st = new StringTokenizer(inOut.readLine());
        int ordersCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < ordersCount; ++i) {
            st = new StringTokenizer(inOut.readLine());
            Order o = new Order(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(inOut.readLine());
            int itemsCount = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(inOut.readLine());
            for (int j = 0; j < itemsCount; ++j) {
                int id = Integer.parseInt(st.nextToken());
                Product p = getProduct(products, id);
                o.addProduct(p);
            }
            orders.add(o);
        }

        Constructor<T> constructor = clazz.getDeclaredConstructor(List.class, List.class, List.class, List.class, Integer.class, Integer.class, Integer.class);
        return constructor.newInstance(drones, products, orders, warehouses, rows, columns, maxPayload);
    }

    private static Product getProduct(List<Product> products, int id) {
        for (Product p : products)
            if (p.getTypeCode() == id)
                return p;
        return null;
    }

}

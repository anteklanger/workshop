package pl.coderslab.team2.dao;

import pl.coderslab.team2.entity.Vehicle;
import pl.coderslab.team2.services.DbService;

import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleDao {

    public static int saveToDb(Vehicle vehicle) {

        int result = 0;

        String query = "insert into vehicles values(null, ?, ?, ?, ?, ?, ?);";

        List<String> params = new ArrayList<>();
        params.add(vehicle.getBrand());
        params.add(vehicle.getModel());
        params.add(vehicle.getLicencePlate());
        params.add(String.valueOf(vehicle.getProductionYear()));
        params.add(String.valueOf(vehicle.getNextTechnicalReview()));
        params.add(String.valueOf(vehicle.getClientID()));

        try {
            result = DbService.insertIntoDatabase(query, params);
            System.out.println("saved to database");
        } catch (SQLException e) {

            System.out.println("saving to database failed");
            e.printStackTrace();
        }
        return result;
    }

    public static int updateVechicleDataInDb(Vehicle vehicle) {

        int result = 0;

        String query = "update vehicles set " +
                "brand = ?, " +
                "model = ?, " +
                "licencePlate = ?, " +
                "productionYear = ?," +
                "nextTechnicalReview = ?" +
                "where clientID = ?;";

        List<String> params = new ArrayList<>();
        params.add(vehicle.getBrand());
        params.add(vehicle.getModel());
        params.add(vehicle.getLicencePlate());
        params.add(String.valueOf(vehicle.getProductionYear()));
        params.add(String.valueOf(vehicle.getNextTechnicalReview()));
        params.add(String.valueOf(vehicle.getClientID()));
        try {
            result = DbService.executeQuery(query, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<Vehicle> loadAll() {
        String query = "select * from vehicles;";
        List<Vehicle> vehicles = new ArrayList<>();
        List<String[]> allVehicles = new ArrayList<>();
        try {
            allVehicles = DbService.getData(query, null);
        } catch (SQLException e) {

            e.printStackTrace();
        }

        for (String[] vehicleList : allVehicles
                ) {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleID(Integer.parseInt(vehicleList[0]));
            vehicle.setBrand(vehicleList[1]);
            vehicle.setModel(vehicleList[2]);
            vehicle.setLicencePlate(vehicleList[3]);
            vehicle.setProductionYear(Integer.parseInt(vehicleList[4]));
            vehicle.setNextTechnicalReview(vehicleList[5]);
            vehicle.setClientID(Integer.parseInt(vehicleList[6]));
            vehicles.add(vehicle);
        }
        return vehicles;
    }


    public static Vehicle findById(int id) {
        String query = "select * from vehicles where vehicleID = ?";

        List<String> params = new ArrayList<>();
        params.add(String.valueOf(id));

        List<String[]> vehicleListFromDb = new ArrayList<>();
        try {
            vehicleListFromDb = DbService.getData(query, params);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        String[] vehicleList = vehicleListFromDb.get(0);
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleID(Integer.parseInt(vehicleList[0]));
        vehicle.setBrand(vehicleList[1]);
        vehicle.setModel(vehicleList[2]);
        vehicle.setLicencePlate(vehicleList[3]);
        vehicle.setProductionYear(Integer.parseInt(vehicleList[4]));
        vehicle.setNextTechnicalReview(vehicleList[5]);
        vehicle.setClientID(Integer.parseInt(vehicleList[6]));
        return vehicle;
    }

    public static int delete(int id) {
        String query = "delete from vehicles where vehicleID = ?";
        List<String> params = new ArrayList<>();
        int result = 0;
        params.add(String.valueOf(id));
        try {
            result = DbService.executeQuery(query, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}

package dao_test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import com.shani.vehicle.beans.Log;
import com.shani.vehicle.beans.Vehicle;
import com.shani.vehicle.beans.VehicleFilters;
import com.shani.vehicle.dao.VehicleDAO;
import com.shani.vehicle.enums.EuroEmissionsStandard;
import com.shani.vehicle.enums.FuelType;
import com.shani.vehicle.enums.GearboxType;
import com.shani.vehicle.logic.LogController;
import com.shani.vehicle.utils.DateUtils;

public class TestSome {

	public static void main(String[] args) {

		VehicleDAO vehicleDAO = new VehicleDAO();

		// Vehicle vehicle3 = new Vehicle();
		// vehicle3.setLicenseNumber(44444);
		// vehicle3.setModel("93 djdb");
		// vehicle3.setYear("03");
		// vehicle3.setEuroEmissionsStandard(EuroEmissionsStandard.Euro6);
		// vehicle3.setFuelType(FuelType.GASOLINE95);
		// vehicle3.setGearbox(GearboxType.AUTOMATIC);
		// long id = vehicleDAO.createVehicle(vehicle3);
		// System.out.println("(:" + id);

		// Vehicle vehicle1 = new Vehicle();
		// vehicle1.setVehicleId(8);
		// vehicle1.setLicenseNumber(874);
		// vehicle1.setModel("gal 2014 hjk");
		// vehicle1.setYear("2000");
		// vehicle1.setEuroEmissionsStandard(EuroEmissionsStandard.Euro6);
		// vehicle1.setFuelType(FuelType.GASOLINE95);
		// vehicle1.setGearbox(GearboxType.AUTOMATIC);
		//
		// Vehicle vehicle2 = new Vehicle();
		// vehicle2.setVehicleId(4);
		// vehicle2.setLicenseNumber(3297256);
		// vehicle2.setModel("ud 837423");
		// vehicle2.setYear("18");
		// vehicle2.setEuroEmissionsStandard(EuroEmissionsStandard.Euro6);
		// vehicle2.setFuelType(FuelType.GASOLINE95);
		// vehicle2.setGearbox(GearboxType.AUTOMATIC);
		//
		// Vehicle vehicle3 = new Vehicle();
		// vehicle3.setVehicleId(9);
		// vehicle3.setLicenseNumber(12986);
		// vehicle3.setModel("987 oaa 43");
		// vehicle3.setYear("2003");
		// vehicle3.setDisplacment(3800);
		// vehicle3.setEuroEmissionsStandard(EuroEmissionsStandard.Euro6);
		// vehicle3.setFuelType(FuelType.GASOLINE95);
		// vehicle3.setGearbox(GearboxType.AUTOMATIC);
		//
		// HashSet<Vehicle> vehicles = new HashSet<>();
		// vehicles.add(vehicle1);
		// vehicles.add(vehicle2);
		// vehicles.add(vehicle3);
		// vehicleDAO.updateManyVehicles(vehicles);
		// System.out.println("it works!");

		// int[] ids = new int[2];
		// ids[0] = 1;
		// ids[1] = 7;
		// vehicleDAO.deleteManyVehicles(ids);
		// System.out.println("work!");

		// long id = 10;
		// System.out.println(vehicleDAO.getVehicle(id));
		// System.out.println("many");
		// System.out.println(vehicleDAO.getAllVehicles());

		// String k = "";
		// System.out.println(k.isEmpty());
		// System.out.println(k.length());
		// System.out.println(k.toString());
		// String l = null;
		// System.out.println(l.isEmpty());
		// System.out.println(l.length());
		// System.out.println(l.toString());

		// String day = "DAY";
		//
		// QueryFactory queryFactory = new QueryFactory();
		//
		// String query = queryFactory.getQuery(day);
		//
		// System.out.println(query);
		//
		//
		//
		//

		// all filters have default values sent from client-side
		// for int/float/long -> -1
		// for String -> ""
		// for Enum -> null
		// VehicleFilters filters = new VehicleFilters();
		// filters.setVehicleId(-1);
		// filters.setLicenseNumber(-1);
		// filters.setModel("7");
		// filters.setFromYear("2000");
		// filters.setUpToYear("3000");
		// filters.setFromPower(-1);
		// filters.setUpToPower(-1);
		// filters.setFromTopSpeed(-1);
		// filters.setUpToTopSpeed(-1);
		// filters.setFromCo2Emissions(-1);
		// filters.setUpToCo2Emissions(-1);
		// filters.setEuroEmissionsStandard(EuroEmissionsStandard.Euro6);
		// filters.setFromFuelConsumption(-1);
		// filters.setUpToFuelConsumption(-1);
		// filters.setFuelType(null);
		// filters.setFromDisplacment(-1);
		// filters.setUpToDisplacment(-1);
		// filters.setGearbox(null);
		// List<Vehicle>vehicles = vehicleDAO.getAllVehiclesByFilters(filters);
		// for (Vehicle vehicle : vehicles) {
		// System.out.println(vehicle);
		// }

		// LogController logController = new LogController();
		// List<Log> logs = logController.getAllLogs();
		// System.out.println(logs);

		Date date = DateUtils.getCurrentTime();
		System.out.println(date);
		long time = date.getTime();
		System.out.println(time);

		// java.sql.Date dateSQL = DateUtils.getCurrentDay();
		// System.out.println(dateSQL);

		LocalDateTime t = LocalDateTime.now();
		System.out.println(t);
		Date d = getDate(t);
		System.out.println(d);

	}

	static Date getDate(LocalDateTime dateToConvert) {
		return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
	}
}

package cz.unicorn.tga.tractor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.unicorn.tga.tractor.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;


public interface CarDAO extends JpaRepository<Car,Long> {
    @Query(value = "SELECT car.id, car.cars_type, car.vin, car.nickname, car.date_of_acquisition, car.state_type, " +
            "len.id as len_id, cl.name, cl.surname FROM car " +
            "LEFT JOIN lending len ON car.id = len.car AND (len.date_to >= GETDATE() AND len.date_from <= GETDATE())" +
            "LEFT JOIN car_client cl ON len.car_client = cl.id " +
            "ORDER BY car.cars_type, car.state_type ASC", nativeQuery = true)
    List<Object[]> findCarsClients();

}

package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.model.enumeration.CarsType;
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

    @Query("SELECT c FROM Car c " +
            "WHERE c.type= :typeCar " +
            " and c.carState = 'IN_GARAGE' " +
            " AND not exists (select len.id from Lending len where c.id=len.car  " +
            "AND (len.dateFrom BETWEEN :dateFrom AND :dateTo " +
            "OR len.dateTo BETWEEN :dateFrom AND :dateTo " +
            "OR :dateFrom BETWEEN len.dateFrom AND len.dateTo " +
            "OR :dateTo BETWEEN len.dateFrom AND len.dateTo)" +
            " )")

    List<Car> findAvailableCars(@Param("dateFrom") Date dateFrom,
                                     @Param("dateTo") Date dateTo,
                                     @Param("typeCar") CarsType type);

}

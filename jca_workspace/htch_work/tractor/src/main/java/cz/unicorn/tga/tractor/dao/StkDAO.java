package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.entity.Lending;
import cz.unicorn.tga.tractor.entity.Client;
import cz.unicorn.tga.tractor.model.enumeration.CarState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StkDAO extends JpaRepository<Stk,Long> {
//    select s.car, car.cars_type, car.vin, max(s.check_date), car.nickname  from car_stk s JOIN car ON s.car = car.id
//    WHERE (car.state_type not like 'NEW' or car.state_type not like 'DISABLED')  and s.check_date <= PARSEDATETIME('23.08.2017','dd.MM.yyyy')
//    GROUP BY s.car
//    ORDER BY s.car;

//    select  *  from car_stk s JOIN car ON s.car = car.id
//    WHERE (car.state_type not like 'NEW' or car.state_type not like 'DISABLED')  and s.check_date <= PARSEDATETIME('23.08.2017','dd.MM.yyyy')
//    GROUP BY s.car, s.id
//    ORDER BY max(s.check_date) DESC;


    @Query("select s from Stk s JOIN s.car as car " +
            "WHERE car.carState not in (:ignoreStates) and s.dateOfCheck <= :lastDateOfCheck " +
            "GROUP BY s.car, s.id " +
            "ORDER BY s.car, max(s.dateOfCheck) ASC")
    List<Stk> findStkForView(@Param("ignoreStates") CarState[] ignoreStates, @Param("lastDateOfCheck") Date lastDateOfCheck);


    @Query(value = "SELECT car.id, car.cars_type, car.vin, s.check_date, car.nickname, len.id as len_id, len.date_to, cl.name, cl.surname FROM car " +
            "LEFT JOIN car_stk s ON car.id = s.car " +
            "LEFT JOIN lending len ON car.id = len.car AND (len.date_to >= :lastDateOfCheck AND len.date_from <= :lastDateOfCheck)" +
            "LEFT JOIN car_client cl ON len.car_client = cl.id " +
            "WHERE " +
            "car.state_type not in (:ignoreStates) " +
            "AND s.check_date IN (SELECT max(st.check_date) FROM car_stk st WHERE st.car = car.id AND st.is_pass = 'Y') " +
            "AND s.check_date  <= :lastDateOfCheck", nativeQuery = true)
    List<Object[]> findObj(@Param("ignoreStates") CarState[] ignoreStates, @Param("lastDateOfCheck") Date lastDateOfCheck);

    List<Stk> findStkByCar_CarStateIsNotInAndDateOfCheckBeforeOrderByDateOfCheckDesc( CarState[] ignoreStates, Date lastDateOfCheck);

}

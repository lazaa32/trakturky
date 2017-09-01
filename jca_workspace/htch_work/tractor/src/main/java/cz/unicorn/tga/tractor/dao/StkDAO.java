package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.StkOverviewDTO;
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



    @Query(value = "select * " +
            " from car_stk s JOIN car ON s.car = car.id " +
            "WHERE car.state_type not in (:ignoreStates) and s.check_date <= :lastDateOfCheck " +
            "GROUP BY s.car, s.id " +
            "ORDER BY max(s.check_date) ASC", nativeQuery = true)
    List<Stk> findStkForView(@Param("ignoreStates") CarState[] ignoreStates, @Param("lastDateOfCheck") Date lastDateOfCheck);

    List<Stk> findStkByCar_CarStateIsNotInAndDateOfCheckBeforeOrderByDateOfCheckDesc( CarState[] ignoreStates, Date lastDateOfCheck);

}

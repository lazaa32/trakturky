package cz.unicorn.tga.tractor.dao;

import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.enumeration.CarState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface StkDAO extends JpaRepository<Stk,Long> {

    @Query(value = "SELECT car.id, car.cars_type, car.vin, s.check_date, car.nickname, len.id as len_id, len.date_to, cl.name, cl.surname FROM car " +
            "LEFT JOIN car_stk s ON car.id = s.car " +
            "LEFT JOIN lending len ON car.id = len.car AND (len.date_to >= GETDATE() AND len.date_from <= GETDATE())" +
            "LEFT JOIN car_client cl ON len.car_client = cl.id " +
            "WHERE " +
            "car.state_type not in (:ignoreStates) " +
            "AND s.check_date IN (SELECT max(st.check_date) FROM car_stk st WHERE st.car = car.id AND st.is_pass = 'Y') " +
            "AND s.check_date  <= :lastDateOfCheck ORDER BY s.check_date ASC", nativeQuery = true)
    List<Object[]> findObj(@Param("ignoreStates") CarState[] ignoreStates, @Param("lastDateOfCheck") Date lastDateOfCheck);
}

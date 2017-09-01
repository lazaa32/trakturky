package cz.unicorn.tga.tractor.entity;

import cz.unicorn.tga.tractor.model.enumeration.CarState;
import cz.unicorn.tga.tractor.model.enumeration.CarsType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "car_stk")
@Data
public class Stk {

    @Id
    @SequenceGenerator(name = "STK_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STK_ID_GENERATOR")
    private Long id;

    @Column(name = "car")
    private Long car;

    @Column(name = "check_date")
    private Date dateOfCheck;

    @Column(name = "is_pass")
    private String isPass;


}

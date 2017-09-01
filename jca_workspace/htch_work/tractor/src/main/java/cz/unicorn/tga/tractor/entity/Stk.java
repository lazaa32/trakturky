package cz.unicorn.tga.tractor.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "car_stk")
@Data
public class Stk {

    @Id
    @SequenceGenerator(name = "STK_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STK_ID_GENERATOR")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car")
    private Car car;

    @Column(name = "check_date")
    private Date dateOfCheck;

    @Column(name = "is_pass")
    private Boolean isPass;


}

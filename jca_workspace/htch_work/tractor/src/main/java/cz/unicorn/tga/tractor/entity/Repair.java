package cz.unicorn.tga.tractor.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "car_repair")
@Data
public class Repair {

    @Id
    @SequenceGenerator(name = "REPAIR_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPAIR_ID_GENERATOR")
    private Long id;

    private Long car;
    private Date date;
    private BigDecimal price;

    @Column(name = "repair_resolution")
    private String repairResolution;
}

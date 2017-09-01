/**
 *
 */
package cz.unicorn.tga.tractor.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

/**
 * @author DZCJS9F
 *
 */
@Entity
@Data
public class Lending {

    @Id
    @SequenceGenerator(name = "LENDING_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LENDING_ID_GENERATOR")
    private Long id;

    private Long car;

    private String vin;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    private BigDecimal price;

    @Column(name = "car_client")
    private Long client;

    private BigDecimal lattitude;

    private BigDecimal longitude;
}

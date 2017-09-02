/**
 *
 */
package cz.unicorn.tga.tractor.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

/**
 * @author DZCJS9F
 *
 */
@Entity
@Table(name = "lending")
@Data
public class Lending {

    @Id
    @SequenceGenerator(name = "LENDING_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LENDING_ID_GENERATOR")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car")
    private Car car;

    @Column(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    private Date dateTo;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "car_client")
    private Client client;

    private BigDecimal lattitude;

    private BigDecimal longitude;
}

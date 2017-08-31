/**
 * 
 */
package cz.unicorn.tga.tractor.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import cz.unicorn.tga.tractor.model.enumeration.CarState;
import cz.unicorn.tga.tractor.model.enumeration.CarsType;
import lombok.Data;

/**
 * @author DZCJS9F
 *
 */
@Entity
@Data
public class Car {

	@Id
	@SequenceGenerator(name = "CAR_ID_GENERATOR", sequenceName = "HIBERNATE_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_ID_GENERATOR")
	private Long id;

	@Column(name = "cars_type")
	@Enumerated(EnumType.STRING)
	private CarsType type;

	private String vin;

	@Column(name = "state_type")
	@Enumerated(EnumType.STRING)
	private CarState carState;

	@Column(name = "date_of_acquisition")
	private Date dateOfAcquisition;

	@Column(name = "last_control")
	private Date dateOfLastTechnicalCheck;

	private BigDecimal price;


}

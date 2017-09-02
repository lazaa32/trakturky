/**
 * 
 */
package cz.unicorn.tga.tractor.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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

	private String nickname;

	@OneToMany(mappedBy = "car")
	private List<Stk> stks;

	@OneToMany(mappedBy = "car")
	private List<Lending> lends;


}

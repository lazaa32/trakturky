/**
 * 
 */
package cz.unicorn.tga.tractor.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author User
 *
 */
@Data

public class FreeCar {

	private Date dateFrom;
	private Date dateTo;
	private String type;

}

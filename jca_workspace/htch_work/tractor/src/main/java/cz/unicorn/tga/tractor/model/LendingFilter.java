/**
 *
 */
package cz.unicorn.tga.tractor.model;

import java.math.BigDecimal;
import java.util.Date;

import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Client;
import lombok.*;

/**
 * @author User
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LendingFilter {

    private Long id;
    private Car car;
    private Date acquiredFromFrom;
    private Date acquiredFromTo;
    private Date acquiredToFrom;
    private Date acquiredToTo;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private Client client;

}

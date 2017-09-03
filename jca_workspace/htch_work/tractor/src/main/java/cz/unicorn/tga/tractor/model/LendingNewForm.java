/**
 *
 */
package cz.unicorn.tga.tractor.model;

import java.math.BigDecimal;
import java.util.Date;

import cz.unicorn.tga.tractor.entity.Client;
import lombok.Data;

/**
 * @author DZCJS9F
 *
 */

@Data
public class LendingNewForm {

    private Client client;
    private String vin;
    private BigDecimal price;

    private Date testDatum;

}

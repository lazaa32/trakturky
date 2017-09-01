/**
 *
 */
package cz.unicorn.tga.tractor.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

/**
 * @author User
 *
 */
@Data
@ToString
public class StkOverviewDTO implements Serializable {

    private Long id;
    private String type;
    private String vin;
    private Date dateOfLastTechnicalCheck;
    private String nickname;

}

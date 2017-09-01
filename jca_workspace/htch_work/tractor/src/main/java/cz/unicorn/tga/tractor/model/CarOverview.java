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
public class CarOverview implements Serializable {

    private Long id;
    private String type;
    private String vin;
    private String carState;
    private Date dateOfAcquisition;
    private String nickname;
    private String client;

}
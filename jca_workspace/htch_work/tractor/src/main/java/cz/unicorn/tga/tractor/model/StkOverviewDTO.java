/**
 *
 */
package cz.unicorn.tga.tractor.model;

import java.io.Serializable;
import java.util.Date;

import lombok.*;

/**
 * @author User
 *
 */
@Data
@ToString
public class StkOverviewDTO implements Serializable {

    private Long idCar;
    private String type;
    private String vin;
    private Date dateOfLastTechnicalCheck;
    private String nickname;
    private Long idLending;
    private String client;
    private Date dateOfReturn;
}

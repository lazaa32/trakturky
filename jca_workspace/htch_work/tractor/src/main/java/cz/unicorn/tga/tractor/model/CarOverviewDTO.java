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
public class CarOverviewDTO implements Serializable {

    private Long idCar;
    private String type;
    private String vin;
    private String nickname;
    private Date dateOfRegistration;
    private String state;
    private Long idLending;
    private String client;
}

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
public class StkOvDTO implements Serializable {

    private Long id;
    private String cars_type;
    private String vin;
    private Date check_date;
    private String nickname;
    private Long len_id;
    private Date date_to;
    private String name;
    private String surname;

}

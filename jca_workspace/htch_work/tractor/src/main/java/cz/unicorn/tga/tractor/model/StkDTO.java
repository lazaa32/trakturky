/**
 *
 */
package cz.unicorn.tga.tractor.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import cz.unicorn.tga.tractor.entity.Car;
import lombok.*;

import javax.persistence.*;

/**
 * @author User
 *
 */
@Data
@ToString
public class StkDTO implements Serializable {
    private Long id;
    private Long car;
    private Date dateOfCheck;
    private String isPass;

}

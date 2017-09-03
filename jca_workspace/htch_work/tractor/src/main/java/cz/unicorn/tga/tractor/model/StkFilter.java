/**
 *
 */
package cz.unicorn.tga.tractor.model;

import java.util.Date;

import cz.unicorn.tga.tractor.entity.Car;
import lombok.*;

/**
 * @author User
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StkFilter {

    private Long id;
    private Car car;
    private Date dateOfCheck;
    private boolean isPass;
}
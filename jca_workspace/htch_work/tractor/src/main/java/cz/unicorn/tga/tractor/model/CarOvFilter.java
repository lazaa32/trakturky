/**
 *
 */
package cz.unicorn.tga.tractor.model;

import java.util.Date;

import lombok.*;

/**
 * @author User
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarOvFilter {

    private Long id;
    private String type;
    private String vin;
    private String state;
    private Date acquiredFrom;
    private Date acquiredTo;
    private String nickname;
    private String client;

}

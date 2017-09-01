package cz.unicorn.tga.tractor.model;

import lombok.Data;
import lombok.ToString;
import org.aspectj.lang.annotation.DeclareAnnotation;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class LendingDTO {
    private Long id;
    private Long car;
    private String vin;
    private Date dateFrom;
    private Date dateTo;
    private BigDecimal price;
    private Long client;
    private BigDecimal lattitude;
    private BigDecimal longitude;
}

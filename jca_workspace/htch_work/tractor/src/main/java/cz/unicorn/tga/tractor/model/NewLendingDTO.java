package cz.unicorn.tga.tractor.model;

import lombok.Data;
import lombok.ToString;
import org.aspectj.lang.annotation.DeclareAnnotation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class NewLendingDTO implements Serializable {
    private Long id;
    private Long car;
    private Date dateFrom;
    private Date dateTo;
    private BigDecimal price;
    private Long client;
    private BigDecimal lattitude;
    private BigDecimal longitude;
}

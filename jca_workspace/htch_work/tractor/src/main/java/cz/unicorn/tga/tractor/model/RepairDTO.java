package cz.unicorn.tga.tractor.model;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class RepairDTO {
    private Long id;
    private Long car;
    private Date date;
    private BigDecimal price;
    private String repairResolution;
}

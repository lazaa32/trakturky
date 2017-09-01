package cz.unicorn.tga.tractor.model;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String ico;
    private Date registrationDate;
    private String email;
    private String ceilPhone;
}

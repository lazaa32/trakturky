package cz.unicorn.tga.tractor.model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
public class ClientDTO implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String ico;
    private Date registrationDate;
    private String email;
    private String cellPhone;
}

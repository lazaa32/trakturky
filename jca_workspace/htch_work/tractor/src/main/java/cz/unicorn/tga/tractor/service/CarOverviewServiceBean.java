package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.CarDAO;
import cz.unicorn.tga.tractor.model.CarOverviewDTO;
import cz.unicorn.tga.tractor.model.enumeration.CarState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class CarOverviewServiceBean implements CarOverviewService {
    private final CarDAO carDAO;

    @Autowired
    public CarOverviewServiceBean(CarDAO carDAO) {
        this.carDAO = carDAO;
    }



    private CarOverviewDTO convertObj2CarOv(Object[] car) {
        if ( car == null ) {
            return null;
        }


        CarOverviewDTO carOverviewDTO = new CarOverviewDTO();

        try {
            carOverviewDTO.setIdCar(car[0] != null ? Long.parseLong(String.valueOf(car[0])) : null);
            carOverviewDTO.setType(car[1] != null ? (String) car[1] : null);
            carOverviewDTO.setVin(car[2] != null ? (String) car[2] : null);
            carOverviewDTO.setNickname(car[3] != null ? (String) car[3] : null);
            carOverviewDTO.setDateOfRegistration(car[4] != null ? (Date) car[4] : null);
            carOverviewDTO.setState((car[5] != null ? (String) car[5] : null));
            carOverviewDTO.setIdLending(car[6] != null ? Long.parseLong(String.valueOf(car[6])) : null);
            if (car[8] != null) {
                carOverviewDTO.setClient((String) car[7] + " " + (String) car[8]);
            } else {
                carOverviewDTO.setClient((String) car[7]);
            }
        }
        catch (ConverterNotFoundException e){
            e.printStackTrace();
        }

        return carOverviewDTO;
    }

    private List<CarOverviewDTO> convertObj2CarOv(List<Object[]> cars) {
        if ( cars == null ) {
            return null;
        }

        List<CarOverviewDTO> list = new ArrayList<CarOverviewDTO>( cars.size() );
        for ( Object[] car : cars ) {
            list.add( convertObj2CarOv( car ) );
        }

        return list;
    }



    /** {@inheritDoc} */
    @Override
    public List<CarOverviewDTO> getOverview() {
//        String string = "November 5, 2012";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
//        LocalDate date = LocalDate.parse(string, formatter);

        return convertObj2CarOv(carDAO.findCarsClients());
    }

}

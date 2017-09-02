package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.CarDAO;
import cz.unicorn.tga.tractor.dao.StkDAO;
import cz.unicorn.tga.tractor.dao.StkFilterDAOImpl;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.StkOvDTO;
import cz.unicorn.tga.tractor.model.StkOverviewDTO;
import cz.unicorn.tga.tractor.model.enumeration.CarState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConverterNotFoundException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class StkOverviewServiceBean implements StkOverviewService {
    private final StkDAO stkDAO;
//    private final StkDAO stkDAO;
    private final CarDAO carDAO;

    @Autowired
    public StkOverviewServiceBean(StkDAO stkDAO, CarDAO carDAO) {
        this.stkDAO = stkDAO;
        this.carDAO = carDAO;
    }



    private StkOverviewDTO convert2StkOv(Stk stk) {
        if ( stk == null ) {
            return null;
        }

        StkOverviewDTO stkOverviewDTO = new StkOverviewDTO();
        Car car = carDAO.findOne(stk.getCar().getId());

        stkOverviewDTO.setIdCar( car.getId() );
        if ( car.getType() != null ) { stkOverviewDTO.setType(car.getType().name());}
        stkOverviewDTO.setVin(car.getVin());
        stkOverviewDTO.setNickname( car.getNickname() );
        stkOverviewDTO.setDateOfLastTechnicalCheck( stk.getDateOfCheck() );

        return stkOverviewDTO;
    }

    private List<StkOverviewDTO> convert2StkOv(List<Stk> stks) {
        if ( stks == null ) {
            return null;
        }

        List<StkOverviewDTO> list = new ArrayList<StkOverviewDTO>( stks.size() );
        for ( Stk stk : stks ) {
            list.add( convert2StkOv( stk ) );
        }

        return list;
    }

    private StkOverviewDTO convertObj2StkOv(Object[] stk) {
        if ( stk == null ) {
            return null;
        }


        for(int i=0; i<stk.length;i++){
            if (stk[i] != null) System.out.println(stk[i].getClass());
        }

        StkOverviewDTO stkOverviewDTO = new StkOverviewDTO();

        try {
            stkOverviewDTO.setIdCar(stk[0] != null ? Long.parseLong(String.valueOf(stk[0])) : null);
            stkOverviewDTO.setType(stk[1] != null ? (String) stk[1] : null);
            stkOverviewDTO.setVin(stk[2] != null ? (String) stk[2] : null);
            stkOverviewDTO.setDateOfLastTechnicalCheck(stk[3] != null ? (Date) stk[3] : null);
            stkOverviewDTO.setNickname(stk[4] != null ? (String) stk[4] : null);
            stkOverviewDTO.setIdLending(stk[5] != null ? Long.parseLong(String.valueOf(stk[0])) : null);
            stkOverviewDTO.setDateOfReturn(stk[6] != null ? (Date) stk[6] : null);
            if (stk[8] != null) {
                stkOverviewDTO.setClient((String) stk[7] + " " + (String) stk[8]);
            } else {
                stkOverviewDTO.setClient((String) stk[7]);
            }
        }
        catch (ConverterNotFoundException e){
            e.printStackTrace();
        }

        return stkOverviewDTO;
    }

    private List<StkOverviewDTO> convertObj2StkOv(List<Object[]> stks) {
        if ( stks == null ) {
            return null;
        }

        List<StkOverviewDTO> list = new ArrayList<StkOverviewDTO>( stks.size() );
        for ( Object[] stk : stks ) {
            list.add( convertObj2StkOv( stk ) );
        }

        return list;
    }



    /** {@inheritDoc} */
    @Override
    public List<StkOverviewDTO> getOverview() {
        String string = "November 5, 2015";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(string, formatter);

        return convertObj2StkOv(stkDAO.findObj(new CarState[]{CarState.DISABLED, CarState.NEW},
                Date.from(date.minusMonths(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));
//        return convert2StkOv(stkDAO.findStkForView(new CarState[]{CarState.DISABLED, CarState.NEW},
//                Date.from(LocalDate.now().minusMonths(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));



    }

}

package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.dao.CarDAO;
import cz.unicorn.tga.tractor.dao.StkDAO;
import cz.unicorn.tga.tractor.dao.StkFilterDAOImpl;
import cz.unicorn.tga.tractor.entity.Car;
import cz.unicorn.tga.tractor.entity.Stk;
import cz.unicorn.tga.tractor.model.StkOverviewDTO;
import cz.unicorn.tga.tractor.model.enumeration.CarState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        stkOverviewDTO.setId( car.getId() );
        if ( car.getType() != null ) { stkOverviewDTO.setType(car.getType().name());}
        stkOverviewDTO.setVin(car.getVin());
        stkOverviewDTO.setNickname( car.getCarState().name() );
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


    /** {@inheritDoc} */
    @Override
    public List<StkOverviewDTO> getOverview() {
//        return convert2StkOv(stkDAO.findAll());

//        return convert2StkOv(stkDAO.findStkForView(new CarState[]{CarState.DISABLED, CarState.NEW},
//                Date.from(LocalDate.now().minusMonths(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));

        return convert2StkOv(stkDAO.findStkForView(new CarState[]{CarState.DISABLED, CarState.NEW},
                Date.from(LocalDate.now().minusMonths(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));

//        return convert2StkOv(stkDAO.findStkByCar_CarStateIsNotInAndDateOfCheckBeforeOrderByDateOfCheckDesc(new CarState[]{CarState.DISABLED, CarState.NEW},
//                Date.from(LocalDate.now().minusMonths(10).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant())));


    }

}

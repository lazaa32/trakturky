package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.model.CarOverviewDTO;

import java.util.List;

public interface CarOverviewService {
    List<CarOverviewDTO> getOverview();
}

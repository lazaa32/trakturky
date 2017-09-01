package cz.unicorn.tga.tractor.service;

import cz.unicorn.tga.tractor.model.StkOverviewDTO;

import java.util.List;

public interface StkOverviewService {
    List<StkOverviewDTO> getOverview();
}

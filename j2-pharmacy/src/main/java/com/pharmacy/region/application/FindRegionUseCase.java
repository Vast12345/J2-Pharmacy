package com.pharmacy.region.application;

import java.util.Optional;

import com.pharmacy.region.domain.entity.Region;
import com.pharmacy.region.domain.service.RegionService;

public class FindRegionUseCase {
    private final RegionService regionService;

    public FindRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public Optional<Region> execute(String id) {
        return regionService.findRegion(id);
    }
}

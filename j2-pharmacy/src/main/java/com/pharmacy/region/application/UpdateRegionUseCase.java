package com.pharmacy.region.application;

import java.util.Optional;

import com.pharmacy.region.domain.entity.Region;
import com.pharmacy.region.domain.service.RegionService;

public class UpdateRegionUseCase {
    private final RegionService regionService;

    public UpdateRegionUseCase(RegionService regionService) {
        this.regionService = regionService;
    }

    public Optional<Region> execute(String id, String name, String code) {
        return regionService.updateRegion(id, name, code);
    }
}

package com.pharmacy.region.domain.service;

import java.util.Optional;

import com.pharmacy.region.domain.entity.Region;

public interface RegionService {
    void createRegion(Region region);
    Optional<Region> findRegion(String id);
    Optional<Region> updateRegion(String id, String name, String code);
    void deleteRegion(String id);
}

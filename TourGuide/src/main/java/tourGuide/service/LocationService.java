package tourGuide.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LocationService {

    private final GpsUtil gpsUtil;
    private final Logger logger = LoggerFactory.getLogger(LocationService.class);

    @Autowired
    public LocationService(GpsUtil gpsUtil) {
        this.gpsUtil = gpsUtil;
    }

    public VisitedLocation getUserLocation(UUID userId) {
        return gpsUtil.getUserLocation(userId);
    }

    public List<Attraction> getAttractions() {
        return gpsUtil.getAttractions();
    }

//    public List<UUID> getAttractionIds() {
//        List<UUID> attractionIds = new ArrayList<>();
//        for (Attraction attraction : gpsUtil.getAttractions()) {
//            attractionIds.add(attraction.attractionId);
//        }
//        return attractionIds;
//    }

}

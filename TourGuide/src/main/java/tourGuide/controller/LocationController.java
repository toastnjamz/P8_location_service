package tourGuide.controller;

import gpsUtil.location.VisitedLocation;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tourGuide.domain.AttractionListWrapper;
import tourGuide.service.LocationService;

import java.util.UUID;

@RestController
@Api(description="Location microservice for TourGuide")
public class LocationController {

    @Autowired
    private LocationService locationService;
    private final Logger logger = LoggerFactory.getLogger(LocationController.class);

    /**
     * Gets a user's last visited location
     * @param userId
     * @return visited location
     */
    @RequestMapping("/user-location")
    public VisitedLocation getUserLocation(@RequestParam String userId) {
        VisitedLocation visitedLocation = locationService.getUserLocation(UUID.fromString(userId));
        logger.debug("Request made to getUserLocation");
        return visitedLocation;
    }

    /**
     * Gets a list of all attractions
     * @return list of all attractions
     */
    @RequestMapping("/attractions")
    public AttractionListWrapper getAttractions() {
        AttractionListWrapper attractionListWrapper = new AttractionListWrapper();
        attractionListWrapper.setAttractionList(locationService.getAttractions());
        logger.debug("Request made to getAttractions");
        return attractionListWrapper;
    }

}

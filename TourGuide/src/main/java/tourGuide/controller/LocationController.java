package tourGuide.controller;

import com.jsoniter.output.JsonStream;
import gpsUtil.location.VisitedLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tourGuide.service.LocationService;

import java.util.UUID;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;
    private final Logger logger = LoggerFactory.getLogger(LocationController.class);


    @RequestMapping("/user-location")
    public String getUserLocation(@RequestParam String userID) {
        VisitedLocation visitedLocation = locationService.getUserLocation(UUID.fromString(userID));
        logger.debug("Request made to getUserLocation");
        return JsonStream.serialize(visitedLocation.location);
    }

    @RequestMapping("/attractions")
    public String getAttractions() {
        logger.debug("Request made to getAttractions");
        return JsonStream.serialize(locationService.getAttractions());
    }

}

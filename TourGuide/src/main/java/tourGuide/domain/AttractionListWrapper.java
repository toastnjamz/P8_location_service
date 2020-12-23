package tourGuide.domain;

import gpsUtil.location.Attraction;

import java.util.List;

public class AttractionListWrapper {

    private List<Attraction> attractionList;

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    public void setAttractionList(List<Attraction> attractionList) {
        this.attractionList = attractionList;
    }
}

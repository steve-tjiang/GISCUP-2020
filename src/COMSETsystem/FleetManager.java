package COMSETsystem;

import java.util.Set;

public abstract class FleetManager {

    protected CityMap map;

    protected TrafficPattern trafficPattern;

    public enum MapState {
        ROAD_TRAVEL_TIME_CHANGED,
    }

    public enum ResourceState {
        AVAILABLE,
        PICKED_UP,
        DROPPED_OFF,
        EXPIRED
    }

    public abstract void onAgentIntroduced(long agentId, LocationOnRoad currentLoc, long time);

    public abstract void onMapStateChanged(Road road, MapState state);

    public abstract AgentAction onResourceAvailabilityChange(Resource resource, ResourceState state,
                                                             LocationOnRoad currentLoc, long time);

    public abstract Intersection onReachIntersection(long agentId, long time, LocationOnRoad currentLoc);

    public abstract Intersection onReachIntersectionWithResource(long agentId, long time, LocationOnRoad currentLoc,
                                                                 Resource resource);

    public abstract boolean isResourceWaitingPickup(Resource resource);

    public FleetManager(CityMap map) {
        this.map = map;
    }

    public void setTrafficPattern(TrafficPattern trafficPattern) {
        this.trafficPattern = trafficPattern;
    }
}

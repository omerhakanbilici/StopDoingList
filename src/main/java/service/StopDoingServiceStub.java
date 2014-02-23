package service;

import model.StopDoingItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by omerhakanbilici on 23.02.2014.
 * StopDoingList
 */

@Component("StopDoingService")
public class StopDoingServiceStub implements StopDoingService {

    private List<StopDoingItem> stopDoingItems = new ArrayList<>();

    private static StopDoingServiceStub instance;

    private StopDoingServiceStub(){
        StopDoingItem sdi1 = new StopDoingItem();
        sdi1.setItem("Smoking");
        sdi1.setId("1");
        sdi1.setStopped(true);

        StopDoingItem sdi2 = new StopDoingItem();
        sdi2.setItem("Alcohol");
        sdi2.setId("2");
        sdi2.setStopped(false);

        stopDoingItems.add(sdi1);
        stopDoingItems.add(sdi2);
    }

    public static StopDoingService getInstance(){
        if(instance==null)
            instance = new StopDoingServiceStub();
        return instance;
    }

    @Override
    public List<StopDoingItem> list() {
        return stopDoingItems;
    }

    @Override
    public StopDoingItem get(String id) {
        StopDoingItem sdi = null;
        for (StopDoingItem s : stopDoingItems) {
            if(s.getId().equals(id))
                sdi = s;
        }
        return sdi;
    }

    @Override
    public void remove(String id) {
        stopDoingItems.remove(get(id));
    }

    @Override
    public void save(StopDoingItem s) {
        s.setId(UUID.randomUUID().toString());
        stopDoingItems.add(s);

    }
}

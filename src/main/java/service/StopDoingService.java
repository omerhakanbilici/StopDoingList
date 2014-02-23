package service;

import model.StopDoingItem;

import java.util.List;

/**
 * Created by omerhakanbilici on 23.02.2014.
 * StopDoingList
 */

public interface StopDoingService {

    public List<StopDoingItem> list();

    public StopDoingItem get(String id);

    public void remove(String id);

    public void save(StopDoingItem p);
}

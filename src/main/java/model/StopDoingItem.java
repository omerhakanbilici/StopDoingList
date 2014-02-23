package model;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by omerhakanbilici on 23.02.2014.
 * StopDoingList
 */

@XmlRootElement
public class StopDoingItem implements Serializable {
    private static final long serialVersionUID = 5371701758945728825L;

    private String id;
    private String item;
    private Boolean stopped;

    public StopDoingItem() {
    }

    public StopDoingItem(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Boolean getStopped() {
        return stopped;
    }

    public void setStopped(Boolean stopped) {
        this.stopped = stopped;
    }
}

package com.wlewicki.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by wlewicki on 3/28/2017.
 */

@Entity
@Table(name="releaseItem")
public class ReleaseItem implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;

    protected ReleaseItem() {}

    public ReleaseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("ReleaseItem[id=%d, name='%s']",
                id, name);
    }

}

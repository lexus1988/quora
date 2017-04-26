package com.wlewicki.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by wlewicki on 3/22/2017.
 */

    @Entity
    @Table(name="project")
    public class Project implements Serializable {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long id;
        private String name;
        private String description;

        @OneToMany(cascade = CascadeType.ALL)
        private List<ReleaseItem> releaseItems;

        protected Project() {}


    public Project(String name, String description) {
            this.name = name;

            this.description = description;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ReleaseItem> getReleaseItems() {
        return releaseItems;
    }

    public void setReleaseItems(List<ReleaseItem> releaseItems) {
        this.releaseItems = releaseItems;
    }

    @Override
        public String toString() {
            return String.format("Project[id=%d, name='%s', description='%s']",
                    id, name, description);
        }

    }


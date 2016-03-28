package com.learning.daggertwo.casterio.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by wahibulhaq on 28/03/16.
 */
public class Country extends RealmObject {

    @PrimaryKey
    private String uuid;
    private String name;
    private Integer populationCount;

    public Integer getPopulationCount() {
        return populationCount;
    }

    public void setPopulationCount(Integer populationCount) {
        this.populationCount = populationCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}

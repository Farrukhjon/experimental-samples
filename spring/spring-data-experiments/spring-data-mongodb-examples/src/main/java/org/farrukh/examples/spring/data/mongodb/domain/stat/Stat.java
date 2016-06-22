package org.farrukh.examples.spring.data.mongodb.domain.stat;

public class Stat {

    private String id;

    private String gender;

    private long count;

    private long maleCount;

    private long femaleCount;

    public long getFemaleCount() {
        return femaleCount;
    }

    public void setFemaleCount(final long femaleCount) {
        this.femaleCount = femaleCount;
    }

    public long getMaleCount() {
        return maleCount;
    }

    public void setMaleCount(final long maleCount) {
        this.maleCount = maleCount;
    }

    public long getCount() {
        return count;
    }

    public void setCount(final long count) {
        this.count = count;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}

package org.farrukh.examples.spring.data.mongodb.domain.stat;

public class GenderStat {

    private String id;

    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(final long count) {
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }
}

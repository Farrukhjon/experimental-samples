package org.farrukh.examples.mongodb.restaurants;

import com.mongodb.client.FindIterable;
import org.bson.Document;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RestaurantsServiceImpl implements RestaurantsService {

    private DataSource dataSource;

    public RestaurantsServiceImpl() {
        this.dataSource = new DataSource();
    }

    @Override
    public List getAll() {
        FindIterable<Document> iterable = dataSource.getCollection()
                                                    .find();
        return Stream.of(iterable)
                     .collect(Collectors.toList());
    }
}

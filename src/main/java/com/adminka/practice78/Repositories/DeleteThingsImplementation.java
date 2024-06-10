package com.adminka.practice78.Repositories;


import com.mongodb.client.MongoClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Component
public class DeleteThingsImplementation implements DeleteThings{

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void deleteByProductId(Integer id) {
        Query query = new Query(where("product_id").is(id));
        mongoTemplate.remove(query, "products");
    }
}

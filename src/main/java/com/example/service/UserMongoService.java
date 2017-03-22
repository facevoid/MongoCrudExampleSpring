package com.example.service;

import com.example.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Shaurav on 3/18/2017.
 */
@Component
public class UserMongoService {
    @Autowired
    private MongoOperations mongoOperations;
    List<User> findByDistance(User user,int distance){
        Point point = new Point(user.getLocation().getLongitude(),user.getLocation().getLatitude());
        Distance radius = new Distance(distance, Metrics.KILOMETERS);
        Circle area = new Circle(point,radius);
        Query query = new Query();
        query.addCriteria(Criteria.where("user.location").withinSphere(area));
        return mongoOperations.find(query,User.class);
    }
}

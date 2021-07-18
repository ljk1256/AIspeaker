package com.eatingtoday.eatingtoday;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import javax.websocket.RemoteEndpoint;
import java.util.List;

public interface ResturantRepository extends MongoRepository<Resturant, String> {

    List<Resturant> findByLocaldata(String localdata);
}

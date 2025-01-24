package com.example.joblisting.Repository;

import com.example.joblisting.model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class SearchRepositoryimpl implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<Post> FindByText(String text) {
        final List<Post> posts = new ArrayList<Post>();
        MongoDatabase database = mongoClient.getDatabase("JobPortal");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 3L)));

        result.forEach(doc->posts.add(mongoConverter.read(Post.class,doc)));

        return posts;
    }
}

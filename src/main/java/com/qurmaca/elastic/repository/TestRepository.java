package com.qurmaca.elastic.repository;

import com.qurmaca.elastic.entity.Test;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends ElasticsearchRepository<Test,String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    public List<Test> findByCustomQuery(String id);
}

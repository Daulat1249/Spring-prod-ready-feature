package com.codingshuttleModule4.prod_features.repositories;

import com.codingshuttleModule4.prod_features.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}

package com.greenfox.trialexam.repositories;

import com.greenfox.trialexam.models.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlModel, Long> {

    Boolean existsAliaserByAlias(String alias);
    String getUrlModelByAlias(String alias);
    Optional<UrlModel> findByAlias(String alias);
}

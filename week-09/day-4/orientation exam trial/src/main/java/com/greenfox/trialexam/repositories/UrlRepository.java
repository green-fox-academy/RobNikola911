package com.greenfox.trialexam.repositories;

import com.greenfox.trialexam.models.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UrlRepository extends JpaRepository<UrlModel, Long> {

}

package com.greenfox.trialexam.services;

import com.greenfox.trialexam.models.UrlModel;

import java.util.List;

public interface UrlService {

    public List<UrlModel> findAll();
    void createAlias(UrlModel urlModel);
    boolean isUrlPresent(String URL);
    UrlModel getUrlByName(String URL);
}

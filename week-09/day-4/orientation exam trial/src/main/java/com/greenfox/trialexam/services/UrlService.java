package com.greenfox.trialexam.services;

import com.greenfox.trialexam.models.UrlModel;

import java.util.List;

public interface UrlService {

    void createAlias(UrlModel urlModel);
    boolean isUrlPresent(String URL);
}

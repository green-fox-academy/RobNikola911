package com.greenfox.trialexam.services;

import com.greenfox.trialexam.models.UrlModel;
import com.greenfox.trialexam.models.UrlModelDTO;

import java.util.List;

public interface UrlService {

    void createAlias(UrlModel urlModel);
    Boolean checkAlias(String alias);

    String isAliasPresent(String alias);
    void save(UrlModel urlModel);

    String getUrl(String alias);

    List<UrlModel> getLinks();

    void deleteLink(Long Id, UrlModelDTO urlModelDTO);
}

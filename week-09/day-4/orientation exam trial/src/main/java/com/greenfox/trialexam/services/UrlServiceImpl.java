package com.greenfox.trialexam.services;

import com.greenfox.trialexam.models.UrlModel;
import com.greenfox.trialexam.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public List<UrlModel> findAll() {
        return urlRepository.findAll();
    }

    @Override
    public void createAlias(UrlModel urlModel) {
        urlRepository.save(urlModel);
    }
}

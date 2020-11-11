package com.greenfox.trialexam.services;

import com.greenfox.trialexam.exceptions.AliasNotFoundException;
import com.greenfox.trialexam.exceptions.ExistingLinkException;
import com.greenfox.trialexam.exceptions.InvalidSecretCodeException;
import com.greenfox.trialexam.exceptions.LinkNotFoundException;
import com.greenfox.trialexam.models.UrlModel;
import com.greenfox.trialexam.models.UrlModelDTO;
import com.greenfox.trialexam.repositories.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public void save(UrlModel urlModel) {
        if(urlRepository.findByAlias(urlModel.getAlias()).isPresent()){
            throw new ExistingLinkException();
        } else {
            Random r = new Random();

            String newSecretCode = String.format("%04d", r.nextInt(10000));
            urlModel.setSecretCode(newSecretCode);
            this.urlRepository.save(urlModel);
        }
    }

    @Override
    public String getUrl(String alias) {
        UrlModel urlModel = urlRepository.findByAlias(alias).orElseThrow(AliasNotFoundException::new);
        urlModel.setHitCount(urlModel.getHitCount() +1);
        urlRepository.save(urlModel);
        return urlModel.getUrl();
    }

    @Override
    public List<UrlModel> getLinks() {
        return urlRepository.findAll();
    }

    @Override
    public void deleteLink(Long Id, UrlModelDTO urlModelDTO) {

        UrlModel urlModel = urlRepository.findById(Id).orElseThrow(LinkNotFoundException::new);

        if(urlModel.getSecretCode().equals(urlModelDTO.getSecretCode())){
            urlRepository.deleteById(Id);
        } else {
            throw new InvalidSecretCodeException();
        }
    }


    @Override
    public void createAlias(UrlModel urlModel) {
        urlRepository.save(urlModel);

    }

    @Override
    public Boolean checkAlias(String alias) {
        return urlRepository.existsAliaserByAlias(alias);
    }

    @Override
    public String isAliasPresent(String alias) {
        return urlRepository.getUrlModelByAlias(alias);
    }

}

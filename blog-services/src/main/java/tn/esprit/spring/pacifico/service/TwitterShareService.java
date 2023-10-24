package tn.esprit.spring.pacifico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class TwitterShareService implements ShareService{
    private RestTemplate restTemplate;

    @Autowired
    public TwitterShareService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void share(String url) {
        String shareUrl = "https://twitter.com/intent/tweet?url=" + url;
        restTemplate.getForObject(shareUrl, String.class);
    }
}

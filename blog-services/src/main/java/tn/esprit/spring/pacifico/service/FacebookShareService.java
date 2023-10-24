package tn.esprit.spring.pacifico.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class FacebookShareService implements ShareService {
    private RestTemplate restTemplate;

    @Autowired
    public FacebookShareService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void share(String url) {
        String shareUrl = "https://www.facebook.com/sharer/sharer.php?u=" + url;
        restTemplate.getForObject(shareUrl, String.class);
    }

}

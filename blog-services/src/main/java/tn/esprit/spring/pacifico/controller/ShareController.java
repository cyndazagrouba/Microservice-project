package tn.esprit.spring.pacifico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.pacifico.service.ShareService;

@RestController
@RequestMapping("/api/share")
public class ShareController {


    ShareService facebookShareService;
    ShareService twitterShareService;



    @GetMapping("/facebook")
    public void shareOnFacebook(@RequestParam String url) {
        facebookShareService.share(url);
    }

    @GetMapping("/twitter")
    public void shareOnTwitter(@RequestParam String url) {
        twitterShareService.share(url);
    }
}

package com.example.eshopweb.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.IntStream;

@RestController
//@Slf4j
public class EmailController {

    /*
     * RESENI PROBLEMU S PROXY OBJEKTEM (V self JE PROXY OBJEKT!!!)
     * JESTE LEPE BY SE TENTO PROBLEM DAL VYRESIT POMOCI TRIDY EmailService,
     * kde by byla metoda sendEmail a v EmailController by byla beana EmailService ziskana pomoci @Autowired
     */
    @Lazy
    @Autowired
    private EmailController self;

    private static final Logger log = LoggerFactory.getLogger(EmailController.class);

    @GetMapping("/sendEmails") // !!! GET operace by mely byt idempotentni (anglicky idempotent), spravne by zde melo byt @PostMapping
    public void sendEmails() {
//        for (int i = 0; i < 100; i++) {
//            this.sendEmail(i);
//        }
        IntStream.range(0, 100)
                .forEach(self::sendEmail);
    }

    @Async
    public void sendEmail(int i) {
        log.info("sending email {}", i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

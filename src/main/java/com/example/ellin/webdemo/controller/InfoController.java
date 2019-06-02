package com.example.ellin.webdemo.controller;

import com.example.ellin.webdemo.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class InfoController {


    @GetMapping("/")
    public Info getInfo(){

        Info.InfoBuilder builder = Info.builder();

        String hostname;
        try {
            InetAddress ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            builder.hostname(hostname).ip(ip.toString());

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }

        return builder.build();
    }
}

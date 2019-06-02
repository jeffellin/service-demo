package com.example.ellin.webdemo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter
@Setter
public class Info {

    private String ip;
    private String hostname;

}

package com.java8.demo.biconsumer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TempDataBase {
    private String code;
    private String contents;

    public TempDataBase(String code, String content) {
        this.code = code;
        this.contents = content;
    }

    public void setCode(String code, String content) {
        this.code = code;
        this.contents = content;
    }
}

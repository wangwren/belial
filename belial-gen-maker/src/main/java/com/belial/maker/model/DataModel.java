package com.belial.maker.model;

import lombok.Data;

@Data
public class DataModel {

    private String author;

    private String outputText;

    /**
     * 控制是否循环
     */
    private Boolean loop = Boolean.FALSE;
}

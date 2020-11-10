package com.mini.msgateway;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Livre {


    private String isbn;

    private String title;

    private String description;

    private String author;

    private String editor;

    private Date dateEdition;


}

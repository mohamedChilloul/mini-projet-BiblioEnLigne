package com.mini.mslivrecatalogue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.common.value.qual.ArrayLen;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private int nbStars;
    private String remark;
    private Date ratingDate;
}

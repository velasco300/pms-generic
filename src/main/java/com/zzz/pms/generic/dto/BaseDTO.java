package com.zzz.pms.generic.dto;

import lombok.Data;

@Data
public class BaseDTO {
    private int pageNo;
    private int pageSize;
    private int total;
    private int totalPage;
}

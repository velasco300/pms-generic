package com.zzz.pms.pmsgeneric.dto;

import lombok.Data;

@Data
public class BaseDto {
    private int pageNo;
    private int pageSize;
    private int total;
    private int totalPage;
}

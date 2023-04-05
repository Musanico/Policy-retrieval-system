package com.musanico.all.entity;

import lombok.Data;

@Data
public class User {
    private Integer policyId;
    private String policyTitle;
    private String policyGrade;
    private String pubAgencyId;
    private String pubAgency;
    private String pubTime;
    private String province;
}

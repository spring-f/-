package com.tensquare.recruit.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_recruit")
public class recruit {
    @Id
    private String id;
    private String jobname;
    private String salary;
    private String condition;
    private String education;
    private String type;
    private String address;
    private String eid;
    private long createtime;
    private String url;
    private String lable;
    private String content1;
    private String content2;
    private String state;
}

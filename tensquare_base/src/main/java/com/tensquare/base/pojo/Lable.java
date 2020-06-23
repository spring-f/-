package com.tensquare.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_lable")
@Data
public class Lable implements Serializable {

    @Id
    private String id;
    private String labelname;
    private long count;
    private long fans;
    private String recommend;
    private String state;

}

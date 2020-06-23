package com.tensquare.qa.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tb_pl")
public class Pl implements Serializable {
    @Id
    private String problemId;
    @Id
    private String tableid;
}

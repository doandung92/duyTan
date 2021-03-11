package com.codegym.duytan.entity;

import com.codegym.duytan.constant.LogTypeOption;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class AuditLogging {

    @Id
    @Column(name = "LOG_ID")
    private Integer logId;
    @Column(name = "LOG_TYPE")
    private String logType;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "NAME")
    private String name;
    @Column(name = "TARGET")
    private String target;
    @Column(name = "PARAMETER")
    private String parameter;
    @Column(name = "COMMENT")
    private String comment;
    @Column(name = "ACCESS_IP")
    private String accessIp;
    @Column(name = "REG_DT")
    private LocalDate regDt;
}

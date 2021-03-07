package com.codegym.duytan.listener;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
// Class này CreatedBy luôn là String. Dùng generic là thừa
// Class này cũng k phải là 1 listener. Nó chỉ là một class để kế thừa
public class AbstractAuditable {

    // CreatedBy

    @CreatedBy
    @Column(name = "created_by")
    //CreatedBy
    protected String createBy;
    //CreatedDate
    //Class Instant sẽ không bị phụ thuộc và timezone
    @CreatedDate
    protected Instant createDate;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected String updateBy;

    @LastModifiedDate
    // thống nhất cách đặt tên với trường bên trên
    protected Instant updateDate;

}

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
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
// Class này CreatedBy luôn là String. Dùng generic là thừa
// Class này cũng k phải là 1 listener. Nó chỉ là một class để kế thừa
public class AuditListener<U> {

    // CreatedBy

    @CreatedBy
    @Column(name = "created_by")
    //CreatedBy
    protected U createBy;
    //CreatedDate
    //Class Instant sẽ không bị phụ thuộc và timezone
    @CreatedDate
    protected Date createDate;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected U lastModifiedBy;

    @LastModifiedDate
    protected Date lastModifiedDate;

}

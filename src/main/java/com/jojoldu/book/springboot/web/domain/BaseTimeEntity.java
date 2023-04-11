package com.jojoldu.book.springboot.web.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
/***
 * Entity들의  createdDate, modifiedDate를 자동으로 관리하는 역할을 한다.
 * @@MappedSuperclass : JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우 필드들도 Column으로 인식하게 한다.
 * @@EntityListeners(AuditingEntityListener.class) : Auditing 기능 추가
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}

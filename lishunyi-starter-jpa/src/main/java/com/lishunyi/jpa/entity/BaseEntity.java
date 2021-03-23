package com.lishunyi.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 基类，公共字段
 *
 * @author 李顺仪
 * @version 1.0
 * @since 2021/3/17 11:20
 **/
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)        //监听变动实体
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -6464890573950973456L;

	@Column
	@Id
	@GeneratedValue(generator = "snowflakeId")
	@GenericGenerator(name = "snowflakeId", strategy = "com.lishunyi.jpa.config.JpaIdGenerator")
	private Long id;

	@Column
	@CreatedDate
	private LocalDateTime createTime;

	@Column
	@CreatedBy
	private Long createBy;

	@Column
	@LastModifiedDate
	private LocalDateTime updateTime;

	@Column
	@LastModifiedBy
	private Long updateBy;

	@Column(name = "is_deleted")
	private Boolean deleted;
}

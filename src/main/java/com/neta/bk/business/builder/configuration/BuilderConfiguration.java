package com.neta.bk.business.builder.configuration;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import com.neta.bk.dto.BaseDTO;
import com.neta.bk.entity.BaseEntity;

/**
 * @author elddenmedio
 *
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface BuilderConfiguration {
	Class<? extends BaseEntity> entityClass();

	Class<? extends BaseDTO> dtoClass();
}

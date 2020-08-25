package com.neta.bk.business.builder.configuration;

import com.neta.bk.dto.BaseDTO;
import com.neta.bk.entity.BaseEntity;

/**
 * @author elddenmedio
 *
 */

public abstract class AbstractDTOBuilder {
	public abstract BaseDTO createDTO(final BaseEntity entity);
}

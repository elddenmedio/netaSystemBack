/**
 * 
 */
package com.neta.bk.business.builder;

import com.neta.bk.business.builder.configuration.AbstractDTOBuilder;
import com.neta.bk.business.builder.configuration.BuilderConfiguration;
import com.neta.bk.dto.BaseDTO;
import com.neta.bk.dto.CustomerDTO;
import com.neta.bk.entity.BaseEntity;
import com.neta.bk.entity.CustomerEntity;

/**
 * @author elddenmedio
 *
 */

@BuilderConfiguration(dtoClass = CustomerDTO.class, entityClass = CustomerEntity.class)
public class CustomerBuilder extends AbstractDTOBuilder {
	@Override
	public BaseDTO createDTO(BaseEntity entity) {
		System.out.println("Entidad:" + entity);
		final CustomerDTO localDTO = new CustomerDTO();
		final CustomerEntity localEntity = (CustomerEntity) entity;
		localDTO.setId(localEntity.getId());
		localDTO.setName(localEntity.getName());
		localDTO.setSurname(localEntity.getSurname());
		localDTO.setSecondsurname(localEntity.getSecondsurname());
		localDTO.setMail(localEntity.getMail());
		localDTO.setActive(localEntity.getActive());
		localDTO.setDeleted(localEntity.getDeleted());
		//localDTO.setCustomer_info(localEntity.getCustomer_info());

		return localDTO;
	}
}

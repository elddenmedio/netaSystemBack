/**
 * 
 */
package com.neta.bk.utils;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;

/**
 * @author elddenmedio
 *
 */
public class LocalDateConverter  implements AttributeConverter<LocalDate, Timestamp> {
	@Override
    public Timestamp convertToDatabaseColumn(LocalDate attribute) {
        return attribute != null ? Timestamp.valueOf(attribute.atStartOfDay()) : null;
    }

    @Override
    public LocalDate convertToEntityAttribute(Timestamp dbData) {
        return dbData != null ? dbData.toLocalDateTime().toLocalDate() : null;
    }
}

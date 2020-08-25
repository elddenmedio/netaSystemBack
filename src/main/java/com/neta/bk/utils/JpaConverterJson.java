/**
 * 
 */
package com.neta.bk.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author elddenmedio
 *
 */

@Converter
public class JpaConverterJson implements AttributeConverter<JSONObject, String> {
	//private static final Logger LOGGER = LoggerFactory.getLogger(ConektaBean.class);
	
	@Override
    public String convertToDatabaseColumn(JSONObject jsonObject) {
    	return jsonObject == null ? null : jsonObject.toString();
    }

    @Override
    public JSONObject convertToEntityAttribute(String s) {
    	if (s == null) return null;
        return new JSONObject(s);
    }
}

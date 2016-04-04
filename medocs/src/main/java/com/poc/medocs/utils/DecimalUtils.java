/**
 * 
 */
package com.poc.medocs.utils;

import java.math.BigDecimal;

import com.thoughtworks.xstream.converters.basic.BigDecimalConverter;

/**
 * @author x
 *
 */
public final class DecimalUtils {

	private static BigDecimalConverter converter = new BigDecimalConverter();

	public static BigDecimal getDecimal(String ph, int priceScale) {
		BigDecimal bd = (BigDecimal) converter.fromString(ph);
		bd.setScale(priceScale);
		return bd;
	}

}

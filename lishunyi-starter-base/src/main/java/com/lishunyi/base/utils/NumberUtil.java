package com.lishunyi.base.utils;

import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;
import org.springframework.util.NumberUtils;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName NumberUtil
 * @Description 数字类型工具类
 * @Author 李顺仪
 * @CreateDate 2019/12/14 11:53
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/12/14 11:53
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@UtilityClass
public class NumberUtil extends NumberUtils {

	static final byte[] DIGITS = {
		'0', '1', '2', '3', '4', '5',
		'6', '7', '8', '9', 'a', 'b',
		'c', 'd', 'e', 'f', 'g', 'h',
		'i', 'j', 'k', 'l', 'm', 'n',
		'o', 'p', 'q', 'r', 's', 't',
		'u', 'v', 'w', 'x', 'y', 'z',
		'A', 'B', 'C', 'D', 'E', 'F',
		'G', 'H', 'I', 'J', 'K', 'L',
		'M', 'N', 'O', 'P', 'Q', 'R',
		'S', 'T', 'U', 'V', 'W', 'X',
		'Y', 'Z'
	};

	/**
	 * 字符串转int, 默认值0
	 *
	 * @param str {@code String} 字符串
	 * @return {@code int}
	 */
	public static int toInt(final String str) {
		return ObjectUtil.toInt(str);
	}

	/**
	 * 字符串转int
	 *
	 * @param str          {@code String} 字符串
	 * @param defaultValue {@code int} 默认值
	 * @return {@code int}
	 */
	public static int toInt(@Nullable final String str, final int defaultValue) {
		return ObjectUtil.toInt(str, defaultValue);
	}

	/**
	 * 字符串转long
	 *
	 * @param str {@code String} 字符串
	 * @return {@code long}
	 */
	public static long toLong(final String str) {
		return ObjectUtil.toLong(str);
	}

	/**
	 * 字符串转long
	 *
	 * @param str          {@code String} 字符串
	 * @param defaultValue {@code int} 默认值
	 * @return {@code long}
	 */
	public static long toLong(@Nullable final String str, final long defaultValue) {
		return ObjectUtil.toLong(str, defaultValue);
	}

	public static String to62Str(long i) {
		int radix = DIGITS.length;
		byte[] buf = new byte[65];
		int charPos = 64;
		i = -i;
		while (i <= -radix) {
			buf[charPos--] = DIGITS[(int) (-(i % radix))];
			i = i / radix;
		}
		buf[charPos] = DIGITS[(int) -i];
		return new String(buf, charPos, (65 - charPos), StandardCharsets.UTF_8);
	}
}

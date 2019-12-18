package com.lishunyi.base.utils;

import com.lishunyi.base.constant.CharPool;
import com.lishunyi.base.constant.StringPool;
import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.util.HtmlUtils;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @ClassName StringUtil
 * @Description java类作用描述
 * @Author 李顺仪
 * @CreateDate 2019/12/13 10:33
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/12/13 10:33
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@UtilityClass
public class StringUtil extends StringUtils {

	/**
	 * 特殊字符正则，sql特殊字符和空白符.
	 */
	private static final Pattern SPECIAL_CHARS_REGEX = Pattern.compile("[`'\"|/,;()-+*%#·•�　\\s]");

	/***
	 * 随机数字符串因子
	 */
	private static final String INT_STR = "0123456789";
	private static final String STR_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String ALL_STR = INT_STR + STR_STR;

	/**
	 * 首字符转小写
	 *
	 * @param str {@code String} 字符串
	 * @return {@code String}
	 */
	public static String firstCharToLower(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= CharPool.UPPER_A && firstChar <= CharPool.UPPER_Z) {
			char[] arr = str.toCharArray();
			arr[0] += (CharPool.LOWER_A - CharPool.LOWER_Z);
			return new String(arr);
		}
		return str;
	}

	/**
	 * 首字符转大写
	 *
	 * @param str {@code String} 字符串
	 * @return {@code String}
	 */
	public static String firstCharToUpper(String str) {
		char firstChar = str.charAt(0);
		if (firstChar >= CharPool.LOWER_A && firstChar <= CharPool.LOWER_Z) {
			char[] arr = str.toCharArray();
			arr[0] -= (CharPool.LOWER_A - CharPool.LOWER_Z);
			return new String(arr);
		}
		return str;
	}

	/**
	 * 是否为空
	 *
	 * @param cs {@code CharSequence} 字符串
	 * @return {@code boolean}
	 */
	public static boolean isBlank(@Nullable final CharSequence cs) {
		return !StringUtil.hasLength(cs);
	}

	/**
	 * 是否不为空
	 *
	 * @param cs {@code CharSequence} 字符串
	 * @return {@code boolean}
	 */
	public static boolean isNotBlank(@Nullable final CharSequence cs) {
		return StringUtil.hasLength(cs);
	}

	/**
	 * 有任意一个为空
	 *
	 * @param css {@code CharSequence} 字符串列
	 * @return {@code boolean}
	 */
	public static boolean isAnyBlank(final CharSequence... css) {
		if (ObjectUtils.isEmpty(css)) {
			return true;
		}
		return Stream.of(css).anyMatch(StringUtil::isBlank);
	}

	/**
	 * 是否全部不是空
	 *
	 * @param css {@code CharSequence} 字符串列
	 * @return {@code boolean}
	 */
	public static boolean isNoneBlank(final CharSequence css) {
		if (ObjectUtils.isEmpty(css)) {
			return false;
		}
		return Stream.of(css).allMatch(StringUtil::isNoneBlank);
	}

	/**
	 * 判断字符串是否为数字
	 *
	 * @param cs {@code CharSequence} 字符串
	 * @return {@code boolean}
	 */
	public static boolean isNumeric(final CharSequence cs) {
		if (StringUtil.isBlank(cs)) {
			return false;
		}
		for (int i = cs.length(); --i >= 0; ) {
			int chr = cs.charAt(i);
			if (chr < 48 || chr > 57) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 将字符串中特定模式的字符替换成map对应key的值
	 *
	 * @param message {@code String} 转换前的字符串
	 * @param params  {@code Map<String, Object>} 转换所需的键值对
	 * @return {@code String} 转换后的字符串
	 */
	public static String format(@Nullable String message, @Nullable Map<String, Object> params) {
		// 如果message为空，返回“”
		if (StringUtil.isBlank(message)) {
			return StringPool.EMPTY;
		}
		// 如果参数为空，返回消息
		if (ObjectUtils.isEmpty(params)) {
			return message;
		}
		// 替换变量
		StringBuilder sb = new StringBuilder((int) (message.length() * 1.5));
		int cursor = 0;
		for (int start, end; (start = message.indexOf(StringPool.DOLLAR_LEFT_BRACE, cursor)) != -1 && (end = message.indexOf(CharPool.RIGHT_BRACE, start)) != -1; ) {
			sb.append(message, cursor, start);
			String key = message.substring(start + 2, end);
			Object value = params.get(StringUtil.trimWhitespace(key));
			sb.append(value == null ? StringPool.EMPTY : value);
			cursor = end + 1;
		}
		sb.append(message.substring(cursor));
		return sb.toString();
	}

	/**
	 * 同上，使用log模式
	 *
	 * @param message   {@code String} 转换前的字符串
	 * @param arguments {@code Object} 替换的变量
	 * @return {@code String} 转换后的字符串
	 */
	public static String format(@Nullable String message, @Nullable Object... arguments) {
		// 如果message为空，返回“”
		if (StringUtil.isBlank(message)) {
			return StringPool.EMPTY;
		}
		// 如果参数为空，返回消息
		if (ObjectUtils.isEmpty(arguments)) {
			return message;
		}
		StringBuilder sb = new StringBuilder((int) (message.length() * 1.5));
		int cursor = 0;
		int index = 0;
		int argsLength = arguments.length;
		for (int start, end; (start = message.indexOf(CharPool.LEFT_BRACE, cursor)) != -1 && (end = message.indexOf(CharPool.RIGHT_BRACE, start)) != -1 && index < argsLength; ) {
			sb.append(message, cursor, start);
			sb.append(arguments[index]);
			cursor = end + 1;
			index++;
		}
		sb.append(message.substring(cursor));
		return sb.toString();
	}

	/**
	 * @param coll {@code Collection} 集合
	 * @return {@code String}
	 */
	public static String join(@Nullable Collection<?> coll) {
		return StringUtil.collectionToCommaDelimitedString(coll);
	}

	/**
	 * @param coll      {@code Collection} 集合
	 * @param delimiter {@code String} 分隔符
	 * @return {@code String}
	 */
	public static String join(@Nullable Collection<?> coll, String delimiter) {
		return StringUtil.collectionToDelimitedString(coll, delimiter);
	}

	/**
	 * @param arr {@code Object[]} 数组
	 * @return {@code String}
	 */
	public static String join(@Nullable Object[] arr) {
		return StringUtil.arrayToCommaDelimitedString(arr);
	}

	/**
	 * @param arr       {@code Object[]} 数组
	 * @param delimiter {@code String} 分隔符
	 * @return {@code String}
	 */
	public static String join(@Nullable Object[] arr, String delimiter) {
		return StringUtil.arrayToDelimitedString(arr, delimiter);
	}

	/**
	 * 分隔字符串
	 *
	 * @param str       {@code String} 字符串
	 * @param delimiter {@code String} 分隔符
	 * @return {@code String[]}
	 */
	public static String[] split(@Nullable String str, @Nullable String delimiter) {
		return StringUtil.delimitedListToStringArray(str, delimiter);
	}

	/**
	 * 分隔字符串 删除常见空白符
	 *
	 * @param str       {@code String} 字符串
	 * @param delimiter {@code String} 分隔符
	 * @return {@code String[]}
	 */
	public static String[] splitTrim(@Nullable String str, @Nullable String delimiter) {
		return StringUtil.delimitedListToStringArray(str, delimiter, " \t\n\n\f");
	}

	/**
	 * 校验字符串是否符合表达式
	 *
	 * @param pattern {@code String} 表达式
	 * @param str     {@code String} 字符串
	 * @return {@code boolean} 是否匹配
	 */
	public static boolean simpleMatch(@Nullable String pattern, @Nullable String str) {
		return PatternMatchUtils.simpleMatch(pattern, str);
	}

	/**
	 * 校验字符串是否符合表达式数组
	 *
	 * @param patterns {@code String[]} 表达式
	 * @param str      {@code String} 字符串
	 * @return {@code boolean} 是否匹配
	 */
	public static boolean simpleMatch(@Nullable String[] patterns, String str) {
		return PatternMatchUtils.simpleMatch(patterns, str);
	}

	/**
	 * 生成UUID
	 *
	 * @return {@code String} UUID
	 */
	public static String getUUID() {
		ThreadLocalRandom random = ThreadLocalRandom.current();
		long lsb = random.nextLong();
		long msb = random.nextLong();
		byte[] buf = new byte[32];
		formatUnsignedLong(lsb, buf, 20, 12);
		formatUnsignedLong(lsb >>> 48, buf, 16, 4);
		formatUnsignedLong(msb, buf, 12, 4);
		formatUnsignedLong(msb >>> 16, buf, 8, 4);
		formatUnsignedLong(msb >>> 32, buf, 0, 8);
		return new String(buf, StandardCharsets.UTF_8);
	}

	private static void formatUnsignedLong(long val, byte[] buf, int offset, int len) {
		int charPos = offset + len;
		int radix = 1 << 4;
		int mask = radix - 1;
		do {
			buf[--charPos] = NumberUtil.DIGITS[((int) val) & mask];
			val >>>= 4;
		} while (charPos > offset);
	}

	public static String escapeHtml(String html) {
		return HtmlUtils.htmlEscape(html);
	}
}

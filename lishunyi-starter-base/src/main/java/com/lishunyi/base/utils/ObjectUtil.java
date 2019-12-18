package com.lishunyi.base.utils;

import lombok.experimental.UtilityClass;
import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.util.Objects;

/**
 * @ClassName ObjectUtil
 * @Description 对象工具类
 * @Author 李顺仪
 * @CreateDate 2019/12/14 13:22
 * @UpdateUser 李顺仪
 * @UpdateDate 2019/12/14 13:22
 * @UpdateRemark 修改内容
 * @Version 1.0
 **/
@UtilityClass
public class ObjectUtil extends ObjectUtils {

	/**
	 * 判断对象是否为null
	 *
	 * @param object {@code Object} 对象
	 * @return {@code boolean} 是否为null
	 */
	public static boolean isNull(@Nullable Object object) {
		return Objects.isNull(object);
	}

	/**
	 * 判断不为null
	 *
	 * @param object {@code Object} 对象
	 * @return {@code boolean} 是否不为null
	 */
	public static boolean isNotNull(@Nullable Object object) {
		return Objects.nonNull(object);
	}

	/**
	 * 判断对象为true
	 *
	 * @param object {@code Boolean} 对象
	 * @return {@code boolean} 是否为true
	 */
	public static boolean isTrue(@Nullable Boolean object) {
		return Boolean.TRUE.equals(object);
	}

	/**
	 * 判断对象为false
	 *
	 * @param object {@code Boolean} 对象
	 * @return {@code boolean} 是否为false
	 */
	public static boolean isFalse(@Nullable Boolean object) {
		return Boolean.FALSE.equals(object);
	}

	/**
	 * 判断数组不为空
	 *
	 * @param array {@code Object[]} 数组
	 * @return {@code boolean} 是否不为空
	 */
	public static boolean isNotEmpty(@Nullable Object[] array) {
		return !ObjectUtil.isEmpty(array);
	}

	/**
	 * 判断对象不为空
	 *
	 * @param object {@code Object} 对象
	 * @return {@code boolean} 是否不为空
	 */
	public static boolean isNotEmpty(@Nullable Object object) {
		return !ObjectUtil.isEmpty(object);
	}

	/**
	 * 判断对象equals
	 *
	 * @param o1 {@code Object} 对象1
	 * @param o2 {@code Object} 对象2
	 * @return {@code boolean} 是否相等
	 */
	public static boolean equals(@Nullable Object o1, Object o2) {
		return Objects.equals(o1, o2);
	}

	/**
	 * 判断对象不相等
	 *
	 * @param o1 {@code Object} 对象1
	 * @param o2 {@code Object} 对象2
	 * @return {@code boolean} 是否不相等
	 */
	public static boolean isNotEquals(@Nullable Object o1, @Nullable Object o2) {
		return !Objects.equals(o1, o2);
	}

	/**
	 * 返回对象hashCode
	 *
	 * @param object {@code Object} 对象
	 * @return {@code int} hashCode
	 */
	public static int hashCode(@Nullable Object object) {
		return Objects.hashCode(object);
	}

	/**
	 * 如果对象为null，返回默认值
	 *
	 * @param object       {@code Object} 对象
	 * @param defaultValue {@code Object} 默认值
	 * @return {@code Object} 对象
	 */
	public static Object defaultIfNull(@Nullable Object object, Object defaultValue) {
		return object != null ? object : defaultValue;
	}

	/**
	 * 对象强转String
	 *
	 * @param object       {@code Object} 对象
	 * @param defaultValue {@code String} 默认值
	 * @return {@code String}
	 */
	public static String toStr(@Nullable Object object, @Nullable String defaultValue) {
		if (null == object) {
			return defaultValue;
		}
		if (object instanceof CharSequence) {
			return ((CharSequence) object).toString();
		}
		return String.valueOf(object);
	}

	/**
	 * 对象强转String
	 *
	 * @param object {@code Object} 对象
	 * @return {@code String}
	 */
	public static String toStr(@Nullable Object object) {
		return toStr(object, null);
	}

	/**
	 * 对象转int
	 *
	 * @param object       {@code Object} 对象
	 * @param defaultValue {@code String} 默认值
	 * @return {@code int}
	 */
	public static int toInt(@Nullable Object object, int defaultValue) {
		if (object instanceof Number) {
			return ((Number) object).intValue();
		}
		if (object instanceof CharSequence) {
			String value = ((CharSequence) object).toString();
			try {
				return Integer.parseInt(value);
			} catch (final NumberFormatException nfe) {
				return defaultValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 对象转int，默认0
	 *
	 * @param object {@code Object} 对象
	 * @return {@code int}
	 */
	public static int toInt(@Nullable Object object) {
		return toInt(object, 0);
	}

	/**
	 * 对象转为 long （支持 String 和 Number），默认: 0L
	 *
	 * @param object Object
	 * @return long
	 */
	public static long toLong(@Nullable Object object) {
		return toLong(object, 0L);
	}

	/**
	 * 对象转为 long （支持 String 和 Number），默认: 0L
	 *
	 * @param object Object
	 * @return long
	 */
	public static long toLong(@Nullable Object object, long defaultValue) {
		if (object instanceof Number) {
			return ((Number) object).longValue();
		}
		if (object instanceof CharSequence) {
			String value = ((CharSequence) object).toString();
			try {
				return Long.parseLong(value);
			} catch (final NumberFormatException nfe) {
				return defaultValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 对象转为 Float
	 *
	 * @param object Object
	 * @return 结果
	 */
	public static float toFloat(@Nullable Object object) {
		return toFloat(object, 0.0f);
	}

	/**
	 * 对象转为 Float
	 *
	 * @param object       Object
	 * @param defaultValue float
	 * @return 结果
	 */
	public static float toFloat(@Nullable Object object, float defaultValue) {
		if (object instanceof Number) {
			return ((Number) object).floatValue();
		}
		if (object instanceof CharSequence) {
			String value = ((CharSequence) object).toString();
			try {
				return Float.parseFloat(value);
			} catch (NumberFormatException nfe) {
				return defaultValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 对象转为 Double
	 *
	 * @param object Object
	 * @return 结果
	 */
	public static double toDouble(@Nullable Object object) {
		return toDouble(object, 0.0d);
	}

	/**
	 * 对象转为 Double
	 *
	 * @param object       Object
	 * @param defaultValue double
	 * @return 结果
	 */
	public static double toDouble(@Nullable Object object, double defaultValue) {
		if (object instanceof Number) {
			return ((Number) object).doubleValue();
		}
		if (object instanceof CharSequence) {
			String value = ((CharSequence) object).toString();
			try {
				return Double.parseDouble(value);
			} catch (NumberFormatException nfe) {
				return defaultValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 对象转为 Byte
	 *
	 * @param object Object
	 * @return 结果
	 */
	public static byte toByte(@Nullable Object object) {
		return toByte(object, (byte) 0);
	}

	/**
	 * 对象转为 Byte
	 *
	 * @param object       Object
	 * @param defaultValue byte
	 * @return 结果
	 */
	public static byte toByte(@Nullable Object object, byte defaultValue) {
		if (object instanceof Number) {
			return ((Number) object).byteValue();
		}
		if (object instanceof CharSequence) {
			String value = ((CharSequence) object).toString();
			try {
				return Byte.parseByte(value);
			} catch (NumberFormatException nfe) {
				return defaultValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 对象转为 Short
	 *
	 * @param object Object
	 * @return 结果
	 */
	public static short toShort(@Nullable Object object) {
		return toShort(object, (short) 0);
	}

	/**
	 * 对象转为 Short
	 *
	 * @param object       Object
	 * @param defaultValue short
	 * @return 结果
	 */
	public static short toShort(@Nullable Object object, short defaultValue) {
		if (object instanceof Number) {
			return ((Number) object).byteValue();
		}
		if (object instanceof CharSequence) {
			String value = ((CharSequence) object).toString();
			try {
				return Short.parseShort(value);
			} catch (NumberFormatException nfe) {
				return defaultValue;
			}
		}
		return defaultValue;
	}

	/**
	 * 对象转为 Boolean
	 *
	 * @param object Object
	 * @return 结果
	 */
	@Nullable
	public static Boolean toBoolean(@Nullable Object object) {
		return toBoolean(object, null);
	}

	/**
	 * 对象转为 Boolean
	 *
	 * @param object       Object
	 * @param defaultValue 默认值
	 * @return 结果
	 */
	@Nullable
	public static Boolean toBoolean(@Nullable Object object, @Nullable Boolean defaultValue) {
		if (object instanceof Boolean) {
			return (Boolean) object;
		}
		if (object instanceof CharSequence) {
			String value = ((CharSequence) object).toString();
			try {
				return Boolean.parseBoolean(value.trim());
			} catch (NumberFormatException nfe) {
				return defaultValue;
			}
		}
		return defaultValue;
	}
}

/**
 * 
 */
package simbio.se.shiva.sqlmodels;

import java.lang.reflect.Field;
import java.util.HashMap;

import simbio.se.shiva.API;

/**
 * An Abstract Sql Model With the required methods to all thing work
 * 
 * @author Ademar Alves de Oliveira (ademar111190@gmail.com)
 * @date Nov 25, 2013 4:04:32 AM
 * @since {@link API#_1_0_0}
 * 
 */
public abstract class AbstractSqlModel {

	protected HashMap<Class<?>, String> toFromJavaTypeSqlType = new HashMap<Class<?>, String>();
	protected HashMap<Class<?>, String> toFromJavaObjectSqlPattern = new HashMap<Class<?>, String>();

	/**
	 * @param clazz
	 *            the {@link Class} to be generated a create query
	 * @return a {@link String} with sql Create query
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getCreateTableQuery(Class<?> clazz);

	/**
	 * @param clazz
	 *            the {@link Class} to be generated a drop query
	 * @return a {@link String} with sql Drop query
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getDropTableQuery(Class<?> clazz);

	/**
	 * @param object
	 *            the {@link Object} to be generated an insert query
	 * @return a {@link String} with sql insert query or <code>null</code> if object is <code>null</code>
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getInsertQuery(Object object);

	/**
	 * @param clazz
	 *            the {@link Class} to be generated a select query
	 * @return a {@link String} with sql Select query
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getSelectQuery(Class<?> clazz);

	/**
	 * @param clazz
	 *            the {@link Class} to be generated a delet query. Note, it generate a delete all rows query, to delete a specifique item use {@link AbstractSqlModel#getDeletQuery(Object)}.
	 * @return a {@link String} with sql Select query
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getDeletQuery(Class<?> clazz);

	/**
	 * @param object
	 *            the {@link Object} to be generated a delet query.
	 * @return a {@link String} with sql Select query
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getDeletQuery(Object object);

	/**
	 * @param clazz
	 *            the {@link Class} to be getted table name
	 * @return a {@link String} with sql table name
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getTableName(Class<?> clazz);

	/**
	 * @param object
	 *            the {@link Object} to be getted table name
	 * @return a {@link String} with sql table name
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getTableName(Object object);

	/**
	 * @param clazz
	 *            the java {@link Class} type to be casted to an sql type
	 * @return a {@link String} with the sql type or <code>null</code> if have no equivalent type
	 * @since {@link API#_1_0_0}
	 */
	public String getSqlTypeOfJavaTypeOrNull(Class<?> clazz) {
		return toFromJavaTypeSqlType.get(clazz);
	}

	/**
	 * @param object
	 *            the object to be formatted
	 * @return a {@link String} formatted to be used for example in insert querys
	 * @since {@link API#_1_0_0}
	 */
	public String getSqlQueryFormattedRepresentation(Object object) {
		if (object == null)
			return null;
		String pattern = toFromJavaObjectSqlPattern.get(object.getClass());
		if (pattern == null)
			return null;
		return String.format(pattern, object);
	}

	/**
	 * @param object
	 *            the {@link Object} to be mapped
	 * @return an {@link HashMap} with {@link Object} values mapped
	 * @since {@link API#_1_0_0}
	 */
	public HashMap<String, String> getHashMapWithVariableNamesAndValuesFormateds(Object object) {
		if (object == null)
			return null;

		Class<?> clazz = object.getClass();
		HashMap<String, String> hashColumnNameColumnValue = new HashMap<String, String>();
		String type;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			type = getSqlTypeOfJavaTypeOrNull(field.getType());
			if (type == null)
				continue;
			try {
				field.setAccessible(true);
				hashColumnNameColumnValue.put(field.getName(), getSqlQueryFormattedRepresentation(field.get(object)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return hashColumnNameColumnValue;
	}

}

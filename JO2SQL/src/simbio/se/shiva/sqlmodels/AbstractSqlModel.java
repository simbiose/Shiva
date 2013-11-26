/**
 * 
 */
package simbio.se.shiva.sqlmodels;

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

}

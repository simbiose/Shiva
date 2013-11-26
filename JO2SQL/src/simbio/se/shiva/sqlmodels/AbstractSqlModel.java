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

	protected HashMap<Class<?>, String> fromToJavaSqlType = new HashMap<Class<?>, String>();

	/**
	 * @param clazz
	 *            the {@link Class} to be created the sql table
	 * @return a {@link String} with sql Create query
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getCreateTableQuery(Class<?> clazz);

	/**
	 * @param clazz
	 *            the {@link Class} to be droped the sql table
	 * @return a {@link String} with sql Drop query
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getDropTableQuery(Class<?> clazz);

	/**
	 * @param clazz
	 *            the java {@link Class} type to be casted to an sql type
	 * @return an {@link String} with the sql type or <code>null</code> if have no equivalent type
	 * @since {@link API#_1_0_0}
	 */
	public String getSqlTypeOfJavaTypeOrNull(Class<?> clazz) {
		return fromToJavaSqlType.get(clazz);
	}

}

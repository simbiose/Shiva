/**
 * 
 */
package simbio.se.shiva.sqlmodels;

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

	/**
	 * @param clazz
	 *            the {@link Class} to be created the sql table
	 * @return a {@link String} with sql Create query
	 * @since {@link API#_1_0_0}
	 */
	public abstract String getCreateTableQuery(Class<?> clazz);

}

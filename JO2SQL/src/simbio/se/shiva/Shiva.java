/**
 * 
 */
package simbio.se.shiva;

import simbio.se.shiva.sqlmodels.AbstractSqlModel;
import simbio.se.shiva.sqlmodels.SQLite;

/**
 * Here the class to be used
 * 
 * @author Ademar Alves de Oliveira (ademar111190@gmail.com)
 * @date Nov 25, 2013 3:58:51 AM
 * @since {@link API#_1_0_0}
 */
public class Shiva {

	/**
	 * The {@link AbstractSqlModel} to be used. Default is {@link SQLite}
	 */
	private static AbstractSqlModel sqlModel = new SQLite();

	/**
	 * Change it if you use other sql software, like mysql or postgree. Default is {@link SQLite}
	 * 
	 * @param sqlModel
	 *            the New {@link AbstractSqlModel} to be used as base
	 * @since {@link API#_1_0_0}
	 */
	public static void changeSqlModel(AbstractSqlModel sqlModel) {
		Shiva.sqlModel = sqlModel;
	}

	/**
	 * @param clazz
	 *            the {@link Class} to be created the sql table
	 * @return a {@link String} with sql Create query
	 * @since {@link API#_1_0_0}
	 */
	public static String toCreateTableQuery(Class<?> clazz) {
		return sqlModel.getCreateTableQuery(clazz);
	}

}

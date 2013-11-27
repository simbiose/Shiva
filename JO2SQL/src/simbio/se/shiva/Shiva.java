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

	/**
	 * @param clazz
	 *            the {@link Class} to be droped the sql table
	 * @return a {@link String} with sql Drop query
	 * @since {@link API#_1_0_0}
	 */
	public static String toDropTableQuery(Class<?> clazz) {
		return sqlModel.getDropTableQuery(clazz);
	}

	/**
	 * @param object
	 *            the {@link Object} to be generated an insert
	 * @return a {@link String} with sql insert query or <code>null</code> if object is <code>null</code>
	 * @since {@link API#_1_0_0}
	 */
	public static String toInsertQuery(Object object) {
		return sqlModel.getInsertQuery(object);
	}

	/**
	 * @param clazz
	 *            the {@link Class} to be generated a select query
	 * @return a {@link String} with sql Select query
	 * @since {@link API#_1_0_0}
	 */
	public static String toSelectQuery(Class<?> clazz) {
		return sqlModel.getSelectQuery(clazz);
	}

	/**
	 * @param object
	 *            the {@link Object} to be generated an update query.
	 * @return a {@link String} with sql Update query
	 * @since {@link API#_1_0_0}
	 */
	public static String toUpdateQuery(Object object) {
		return sqlModel.getUpdateQuery(object);
	}

	/**
	 * @param clazz
	 *            the {@link Class} to be generated a delet query. Note, it generate a delete all rows query, to delete a specifique item use {@link Shiva#toDeletQuery(Object)}.
	 * @return a {@link String} with sql Select query
	 * @since {@link API#_1_0_0}
	 */
	public static String toDeletQuery(Class<?> clazz) {
		return sqlModel.getDeletQuery(clazz);
	}

	/**
	 * @param object
	 *            the {@link Object} to be generated a delet query.
	 * @return a {@link String} with sql Select query
	 * @since {@link API#_1_0_0}
	 */
	public static String toDeletQuery(Object object) {
		return sqlModel.getDeletQuery(object);
	}

	/**
	 * @param clazz
	 *            the {@link Class} to be getted table name
	 * @return a {@link String} with sql table name
	 * @since {@link API#_1_0_0}
	 */
	public static String toTableName(Class<?> clazz) {
		return sqlModel.getTableName(clazz);
	}

	/**
	 * @param clazz
	 *            the {@link Object} to be getted table name
	 * @return a {@link String} with sql table name
	 * @since {@link API#_1_0_0}
	 */
	public static String toTableName(Object object) {
		return sqlModel.getTableName(object);
	}

}

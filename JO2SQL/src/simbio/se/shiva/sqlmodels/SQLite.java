/**
 * 
 */
package simbio.se.shiva.sqlmodels;

import simbio.se.shiva.API;
import simbio.se.shiva.utils.SqlStrings;

/**
 * The SQLite Transformer
 * 
 * @author Ademar Alves de Oliveira (ademar111190@gmail.com)
 * @date Nov 25, 2013 4:10:24 AM
 * @since {@link API#_1_0_0}
 */
public class SQLite extends AbstractSqlModel {

	/*
	 * (non-Javadoc)
	 * 
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getCreateTableQuery(java.lang.Class)
	 */
	@Override
	public String getCreateTableQuery(Class<?> clazz) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(SqlStrings.CREATE).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.TABLE).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.removeDots(clazz.getCanonicalName()));
		stringBuilder.append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.SEMICOLON);

		return stringBuilder.toString();
	}
}

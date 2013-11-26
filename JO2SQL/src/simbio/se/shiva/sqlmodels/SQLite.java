/**
 * 
 */
package simbio.se.shiva.sqlmodels;

import java.lang.reflect.Field;

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

	/**
	 * 
	 */
	public SQLite() {
		fromToJavaSqlType.put(Integer.class, SqlStrings.INTEGER);
		fromToJavaSqlType.put(int.class, SqlStrings.INTEGER);
		fromToJavaSqlType.put(Byte.class, SqlStrings.INTEGER);
		fromToJavaSqlType.put(byte.class, SqlStrings.INTEGER);
		fromToJavaSqlType.put(String.class, SqlStrings.TEXT);
		fromToJavaSqlType.put(char.class, SqlStrings.TEXT);
		fromToJavaSqlType.put(Float.class, SqlStrings.REAL);
		fromToJavaSqlType.put(float.class, SqlStrings.REAL);
		fromToJavaSqlType.put(Double.class, SqlStrings.REAL);
		fromToJavaSqlType.put(double.class, SqlStrings.REAL);
		fromToJavaSqlType.put(Long.class, SqlStrings.NUMERIC);
		fromToJavaSqlType.put(long.class, SqlStrings.NUMERIC);
		fromToJavaSqlType.put(Boolean.class, SqlStrings.NUMERIC);
		fromToJavaSqlType.put(boolean.class, SqlStrings.NUMERIC);
	}

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
		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.PARENTHESIS_LEFT);

		String type;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			type = getSqlTypeOfJavaTypeOrNull(field.getType());
			if (type == null)
				continue;
			stringBuilder.append(field.getName()).append(SqlStrings.SPACE);
			stringBuilder.append(type).append(SqlStrings.SPACE).append(SqlStrings.COMMA);
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		stringBuilder.append(SqlStrings.PARENTHESIS_RIGHT).append(SqlStrings.SEMICOLON);

		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getDropTableQuery(java.lang.Class)
	 */
	@Override
	public String getDropTableQuery(Class<?> clazz) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(SqlStrings.DROP).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.TABLE).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.removeDots(clazz.getCanonicalName()));
		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.SEMICOLON);

		return stringBuilder.toString();
	}
}

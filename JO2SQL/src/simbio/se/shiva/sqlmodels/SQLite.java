/**
 * 
 */
package simbio.se.shiva.sqlmodels;

import java.lang.reflect.Field;
import java.util.HashMap;

import simbio.se.shiva.API;
import simbio.se.shiva.utils.SimbiLog;
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
	 * default constructor
	 * 
	 * @since {@link API#_1_0_0}
	 */
	public SQLite() {
		toFromJavaTypeSqlType.put(Integer.class, SqlStrings.INTEGER);
		toFromJavaTypeSqlType.put(int.class, SqlStrings.INTEGER);
		toFromJavaTypeSqlType.put(Byte.class, SqlStrings.INTEGER);
		toFromJavaTypeSqlType.put(byte.class, SqlStrings.INTEGER);
		toFromJavaTypeSqlType.put(String.class, SqlStrings.TEXT);
		toFromJavaTypeSqlType.put(char.class, SqlStrings.TEXT);
		toFromJavaTypeSqlType.put(Float.class, SqlStrings.REAL);
		toFromJavaTypeSqlType.put(float.class, SqlStrings.REAL);
		toFromJavaTypeSqlType.put(Double.class, SqlStrings.REAL);
		toFromJavaTypeSqlType.put(double.class, SqlStrings.REAL);
		toFromJavaTypeSqlType.put(Long.class, SqlStrings.NUMERIC);
		toFromJavaTypeSqlType.put(long.class, SqlStrings.NUMERIC);
		toFromJavaTypeSqlType.put(Boolean.class, SqlStrings.NUMERIC);
		toFromJavaTypeSqlType.put(boolean.class, SqlStrings.NUMERIC);

		toFromJavaObjectSqlPattern.put(Integer.class, "%d");
		toFromJavaObjectSqlPattern.put(int.class, "%d");
		toFromJavaObjectSqlPattern.put(Byte.class, "%d");
		toFromJavaObjectSqlPattern.put(byte.class, "%d");
		toFromJavaObjectSqlPattern.put(String.class, "\"%s\"");
		toFromJavaObjectSqlPattern.put(Character.class, "\"%s\"");
		toFromJavaObjectSqlPattern.put(char.class, "\"%s\"");
		toFromJavaObjectSqlPattern.put(Float.class, "%f");
		toFromJavaObjectSqlPattern.put(float.class, "%f");
		toFromJavaObjectSqlPattern.put(Double.class, "%f");
		toFromJavaObjectSqlPattern.put(double.class, "%f");
		toFromJavaObjectSqlPattern.put(Long.class, "%d");
		toFromJavaObjectSqlPattern.put(long.class, "%d");
		toFromJavaObjectSqlPattern.put(Boolean.class, "\"%s\"");
		toFromJavaObjectSqlPattern.put(boolean.class, "\"%s\"");
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
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getInsertQuery(java.lang.Object)
	 */
	@Override
	public String getInsertQuery(Object object) {
		if (object == null)
			return null;

		Class<?> clazz = object.getClass();
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(SqlStrings.INSERT).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.INTO).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.removeDots(clazz.getCanonicalName()));
		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.PARENTHESIS_LEFT);

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
				SimbiLog.logException(e);
			}
		}

		for (String columnName : hashColumnNameColumnValue.keySet())
			stringBuilder.append(columnName).append(SqlStrings.SPACE).append(SqlStrings.COMMA);
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);

		stringBuilder.append(SqlStrings.PARENTHESIS_RIGHT).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.VALUES).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.PARENTHESIS_LEFT).append(SqlStrings.SPACE);

		for (String columnName : hashColumnNameColumnValue.keySet())
			stringBuilder.append(hashColumnNameColumnValue.get(columnName)).append(SqlStrings.SPACE).append(SqlStrings.COMMA);
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

/**
 * 
 */
package simbio.se.shiva.sqlmodels;

import java.lang.reflect.Field;
import java.util.HashMap;

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
		if (clazz == null)
			return null;

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(SqlStrings.CREATE).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.TABLE).append(SqlStrings.SPACE);
		stringBuilder.append(getTableName(clazz));
		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.PARENTHESIS_LEFT);

		String type;
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			type = getSqlTypeOfJavaTypeOrNull(field.getType());
			if (type == null)
				continue;
			stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(field.getName());
			stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(SqlStrings.SPACE);
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
		HashMap<String, String> hashColumnNameColumnValue = getHashMapWithVariableNamesAndValuesFormateds(object);

		stringBuilder.append(SqlStrings.INSERT).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.INTO).append(SqlStrings.SPACE);
		stringBuilder.append(getTableName(clazz));
		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.PARENTHESIS_LEFT);

		for (String columnName : hashColumnNameColumnValue.keySet()) {
			stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(columnName).append(SqlStrings.GRAVE_ACCENT);
			stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.COMMA);
		}
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
		if (clazz == null)
			return null;

		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(SqlStrings.DROP).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.TABLE).append(SqlStrings.SPACE);
		stringBuilder.append(getTableName(clazz));
		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.SEMICOLON);

		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getSelectQuery(java.lang.Class)
	 */
	@Override
	public String getSelectQuery(Class<?> clazz) {
		if (clazz == null)
			return null;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(SqlStrings.SELECT).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.ASTERISK).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.FROM).append(SqlStrings.SPACE);
		stringBuilder.append(getTableName(clazz));
		stringBuilder.append(SqlStrings.SEMICOLON);

		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getSelectQueryWithWhereClause(java.lang.Class, java.util.HashMap)
	 */
	@Override
	public String getSelectQueryWithWhereClause(Class<?> clazz, HashMap<String, Object> columnsAndValuesToWhereClause) {
		if (clazz == null)
			return null;

		if (columnsAndValuesToWhereClause == null || columnsAndValuesToWhereClause.isEmpty())
			return getSelectQuery(clazz);

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(SqlStrings.SELECT).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.ASTERISK).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.FROM).append(SqlStrings.SPACE);
		stringBuilder.append(getTableName(clazz)).append(SqlStrings.SPACE).append(SqlStrings.WHERE);
		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.PARENTHESIS_LEFT);

		String type;
		Field field;
		for (String fieldName : columnsAndValuesToWhereClause.keySet()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				if (field == null)
					continue;
				field.setAccessible(true);
				type = getSqlTypeOfJavaTypeOrNull(field.getType());
				if (type == null)
					continue;
				stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(field.getName());
				stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(SqlStrings.SPACE);
				stringBuilder.append(SqlStrings.EQUAL).append(SqlStrings.SPACE);
				stringBuilder.append(getSqlQueryFormattedRepresentation(columnsAndValuesToWhereClause.get(fieldName)));
				stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.AND).append(SqlStrings.SPACE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length() - 1);

		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.PARENTHESIS_RIGHT);
		stringBuilder.append(SqlStrings.SEMICOLON);

		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getDeletQuery(java.lang.Class)
	 */
	@Override
	public String getDeletQuery(Class<?> clazz) {
		if (clazz == null)
			return null;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(SqlStrings.DELETE).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.FROM).append(SqlStrings.SPACE);
		stringBuilder.append(getTableName(clazz));
		stringBuilder.append(SqlStrings.SEMICOLON);

		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getDeletQuery(java.lang.Object)
	 */
	@Override
	public String getDeletQuery(Object object) {
		if (object == null)
			return null;

		Class<?> clazz = object.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		HashMap<String, String> hashColumnNameColumnValue = getHashMapWithVariableNamesAndValuesFormateds(object);

		stringBuilder.append(SqlStrings.DELETE).append(SqlStrings.SPACE);
		stringBuilder.append(SqlStrings.FROM).append(SqlStrings.SPACE);
		stringBuilder.append(getTableName(clazz));
		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.WHERE).append(SqlStrings.SPACE);

		for (String columnName : hashColumnNameColumnValue.keySet()) {
			stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(columnName);
			stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(SqlStrings.SPACE);
			stringBuilder.append(SqlStrings.EQUAL).append(SqlStrings.SPACE);
			stringBuilder.append(hashColumnNameColumnValue.get(columnName));
			stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.AND).append(SqlStrings.SPACE);
		}
		stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length() - 1);

		stringBuilder.append(SqlStrings.SEMICOLON);

		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getUpdateQuery(java.lang.Object)
	 */
	@Override
	public String getUpdateQuery(Object object) {
		if (object == null)
			return null;

		Class<?> clazz = object.getClass();
		StringBuilder stringBuilder = new StringBuilder();
		HashMap<String, String> hashColumnNameColumnValue = getHashMapWithVariableNamesAndValuesFormateds(object);

		stringBuilder.append(SqlStrings.UPDATE).append(SqlStrings.SPACE);
		stringBuilder.append(getTableName(clazz));
		stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.SET).append(SqlStrings.SPACE);

		for (String columnName : hashColumnNameColumnValue.keySet()) {
			stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(columnName);
			stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(SqlStrings.SPACE);
			stringBuilder.append(SqlStrings.EQUAL).append(SqlStrings.SPACE);
			stringBuilder.append(hashColumnNameColumnValue.get(columnName));
			stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.COMMA).append(SqlStrings.SPACE);
		}
		stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length() - 1);

		stringBuilder.append(SqlStrings.WHERE).append(SqlStrings.SPACE);

		for (String columnName : hashColumnNameColumnValue.keySet()) {
			stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(columnName);
			stringBuilder.append(SqlStrings.GRAVE_ACCENT).append(SqlStrings.SPACE);
			stringBuilder.append(SqlStrings.EQUAL).append(SqlStrings.SPACE);
			stringBuilder.append(hashColumnNameColumnValue.get(columnName));
			stringBuilder.append(SqlStrings.SPACE).append(SqlStrings.AND).append(SqlStrings.SPACE);
		}
		stringBuilder.delete(stringBuilder.length() - 5, stringBuilder.length() - 1);

		stringBuilder.append(SqlStrings.SEMICOLON);

		return stringBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getTableName(java.lang.Class)
	 */
	@Override
	public String getTableName(Class<?> clazz) {
		if (clazz == null)
			return null;
		return SqlStrings.removeDots(clazz.getCanonicalName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see simbio.se.shiva.sqlmodels.AbstractSqlModel#getTableName(java.lang.Object)
	 */
	@Override
	public String getTableName(Object object) {
		if (object == null)
			return null;
		return getTableName(object.getClass());
	}
}

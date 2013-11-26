/**
 * 
 */
package simbio.se.shiva.utils;

import simbio.se.shiva.API;

/**
 * A collection of strings
 * 
 * @author Ademar Alves de Oliveira (ademar111190@gmail.com)
 * @date Nov 25, 2013 4:49:20 AM
 * @since {@link API#_1_0_0}
 */
public class SqlStrings {

	public static final char ASTERISK = '*';
	public static final char COMMA = ',';
	public static final String CREATE = "CREATE";
	public static final char DOT = '.';
	public static final String DROP = "DROP";
	public static final String FROM = "FROM";
	public static final String INSERT = "INSERT";
	public static final String INTEGER = "INTEGER";
	public static final String INTO = "INTO";
	public static final String NONE = "NONE";
	public static final String NUMERIC = "NUMERIC";
	public static final char PARENTHESIS_LEFT = '(';
	public static final char PARENTHESIS_RIGHT = ')';
	public static final String REAL = "REAL";
	public static final String SELECT = "SELECT";
	public static final char SEMICOLON = ';';
	public static final String SPACE = " ";
	public static final String TABLE = "TABLE";
	public static final String TEXT = "TEXT";
	public static final char UNDERLINE = '_';
	public static final String VALUES = "VALUES";

	public static String removeDots(String string) {
		return string.replace(DOT, UNDERLINE);
	}

}

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

	public static final String CREATE = "CREATE";
	public static final char DOT = '.';
	public static final char SEMICOLON = ';';
	public static final String SPACE = " ";
	public static final String TABLE = "TABLE";
	public static final char UNDERLINE = '_';

	public static String removeDots(String string) {
		return string.replace(DOT, UNDERLINE);
	}

}

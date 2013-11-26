/**
 * 
 */
package simbio.se.shiva.utils;

/**
 * A class to log
 * 
 * @author Ademar Alves de Oliveira (ademar111190@gmail.com)
 * @date Nov 26, 2013 9:53:29 AM
 * 
 */
public class SimbiLog {

	/**
	 * @param params
	 *            the objects to be logged
	 */
	public static void log(Object... params) {
		for (Object param : params)
			System.out.println(param);
	}

}

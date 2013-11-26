/**
 * 
 */
package simbio.se.shiva.examples;

/**
 * Just a log class
 * 
 * @author Ademar Alves de Oliveira (ademar111190@gmail.com)
 * @date Nov 26, 2013 9:53:29 AM
 * 
 */
public class SimbiLog {

	public static final boolean LOG_ENABLE = true;
	public static final boolean LOG_EXCEPTION_ENABLE = true;

	/**
	 * @param params
	 *            the objects to be logged
	 */
	public static void log(Object... params) {
		if (LOG_ENABLE && params != null)
			for (Object param : params)
				System.out.println(param);
	}

	/**
	 * @param exception
	 *            the {@link Exception} to be logged
	 */
	public static void logException(Exception exception) {
		if (LOG_EXCEPTION_ENABLE && exception != null)
			exception.printStackTrace();
	}

}

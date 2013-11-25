/**
 * 
 */
package simbio.se.shiva.examples;

import simbio.se.shiva.API;
import simbio.se.shiva.Shiva;

/**
 * @author Ademar Alves de Oliveira (ademar111190@gmail.com)
 * @date Nov 25, 2013 4:17:04 AM
 * @since {@link API#_1_0_0}
 */
public class ShivaExample {

	public static void main(String[] args) {
		String query;

		query = Shiva.toCreateTableQuery(LittleFoo.class);
		log(query);

		query = Shiva.toCreateTableQuery(Foo.class);
		log(query);
	}

	public static void log(Object param) {
		System.out.println(param);
	}

}

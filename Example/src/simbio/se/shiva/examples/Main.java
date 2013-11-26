/**
 * 
 */
package simbio.se.shiva.examples;

import simbio.se.shiva.Shiva;

/**
 * @author Ademar Alves de Oliveira (ademar111190@gmail.com)
 * @date Nov 25, 2013 4:17:04 AM
 */
public class Main {

	public static void main(String[] args) {
		String query;

		query = Shiva.toDropTableQuery(LittleFoo.class);
		SimbiLog.log(query);

		query = Shiva.toDropTableQuery(Foo.class);
		SimbiLog.log(query);

		query = Shiva.toCreateTableQuery(LittleFoo.class);
		SimbiLog.log(query);

		query = Shiva.toCreateTableQuery(Foo.class);
		SimbiLog.log(query);

		query = Shiva.toInsertQuery(new LittleFoo());
		SimbiLog.log(query);

		query = Shiva.toInsertQuery(new Foo());
		SimbiLog.log(query);

		query = Shiva.toSelectQuery(LittleFoo.class);
		SimbiLog.log(query);

		query = Shiva.toSelectQuery(Foo.class);
		SimbiLog.log(query);

		query = Shiva.toDeletQuery(LittleFoo.class);
		SimbiLog.log(query);

		query = Shiva.toDeletQuery(Foo.class);
		SimbiLog.log(query);

		query = Shiva.toDeletQuery(new LittleFoo());
		SimbiLog.log(query);

		query = Shiva.toDeletQuery(new Foo());
		SimbiLog.log(query);
	}

}

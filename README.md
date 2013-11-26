Shiva
=====

Transformer of Java Objects into SQL Queries.

#What means Shiva?

Shiva is a Hindu Good of destruction and transformation

#What Shiva does?

Shiva is a java Library to convert java objects into sql queries

#How it works?

for example, if we have a class Foo with two variables, a String called fooName and a integer called fooValue, we can do it:

    Shiva.toDropTableQuery(Foo.class);

it will return:

    DROP TABLE package_path_Foo ;

or you can do:

    Shiva.toCreateTableQuery(Foo.class);

and it will return:

    CREATE TABLE package_path_Foo (fooName TEXT ,fooValue INTEGER );

Enjoy it and feel free to contribute, see LICENSE.md to more details

Shiva
=====

Transformer of Java Objects into SQL Queries.

#What means Shiva?

Shiva is a Hindu Good of destruction and transformation

#What Shiva does?

Shiva is a java Library to convert java objects into sql queries

#How it works?

for example, if we have a class named Foo with two variables, a String called fooName and a integer called fooValue, we can do it:

    Shiva.toCreateTableQuery(Foo.class);

and it will return:

    CREATE TABLE package_path_Foo (fooName TEXT ,fooValue INTEGER );

or you can do:

    Shiva.toDropTableQuery(Foo.class);

it will return:

    DROP TABLE package_path_Foo ;

#How To

add the .jar on binary folder to your project path and use it.

see the example on Example for more details.

#Android users

to android this library has improvements on SAU library so to use it go to one of these links:

- BitBucket <https://bitbucket.org/simbiose/sau/overview>
- GitHub <https://github.com/simbiose/SAU>

------

Enjoy it and feel free to contribute, it's a GPL project, see LICENSE to more details.

package com.example.kotlin.solid_principles

/*
[D] The Dependency Inversion Principle

(DIP) is the fifth principle of the SOLID design principles.
 It states that high-level modules should not depend on low-level modules,
  but both should depend on abstractions, meaning that
  a class should depend on abstractions rather than concretions.
   This principle promotes a design where the high-level modules
    (such as the business logic) are not tightly coupled to the low-level modules
     (such as the data access layer), making the code more flexible and maintainable.

An example of a bad practice that violates the DIP is a class that depends
on a specific implementation of a low-level module.
 */

class Order {
//    private val database = MySQLDatabase()

    fun saveOrder() {
//        database.save("orders","order_data")
    }
}

//In this example, the Order class depends on a specific implementation of a low-level module,
// the MySQLDatabase class. This violates the DIP principle because the Order class is
// tightly coupled to the specific implementation of the MySQLDatabase class.
// If we want to change the database to PostgreSQL or any other database,
// we need to change the Order class as well.
//
//A better practice would be to create an abstraction for the low-level module and
// have the high-level module depend on the abstraction.

interface Database {
    fun save(table: String, data: String)
}

class MySQLDatabase : Database {
    override fun save(table: String, data: String) {
        println("Saving data to MySQL database")
    }
}


class PostgresSQLDatabase : Database {
    override fun save(table: String, data: String) {
        println("Saving data to PostgresSQL database")
    }

}


class OrderD {
    private lateinit var database: Database

    fun setDatabase(database: Database) {
        this.database = database
    }

    fun saveOrder() {
        database.save("orders", "order_table")
    }
}

/*
n this example, the Order class depends on an abstraction, the Database interface,
rather than a specific implementation of a low-level module. This adheres to the DIP principle,
 making the code more flexible and maintainable. Now we can change the database
 to any other database by just creating a new implementation of the Database interface
 and injecting it into the Order class.
Summary

In conclusion, SOLID is intended to make software designs more understandable,
 flexible, and maintainable. Each principle promotes a specific aspect of software design,
 such as separation of concerns, extensibility, and decoupling. Adhering to
 these principles can lead to code that is easier to understand, modify, and test,
  making it more maintainable and flexible.
 */































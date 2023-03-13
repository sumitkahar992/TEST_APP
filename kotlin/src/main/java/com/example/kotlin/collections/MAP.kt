package com.example.kotlin.collections

fun main() {

    val justAuthors = Library.books
        .map { book ->
            book.authors
        }
        .map { authors ->
            authors.joinToString { it.name }
        }
        .joinToString(separator = "\n")

    println("===== Authors ====")
    println(justAuthors)


    val titleAndAuthors = Library.books
        .map { book ->
            val authors = book.authors.joinToString { it.name }
            "${book.title} by $authors"
        }.joinToString(separator = "\n")

    println("=== Title & Authors ===")
    println(titleAndAuthors)


    val booksWithIndex = Library.books
        .mapIndexed { index, book -> "$index - ${book.title}" }
        .joinToString(separator = "\n")

    println("=== Books With Index ===")
    println(booksWithIndex)


}
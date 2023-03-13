package com.example.kotlin
/*

data class User(
    val firstName: String,
    val lastName: String,
    val street: String,
    val houseNumber: String,
    val phone: String,
    val age: Int,
    val password: String
)

data class UserView(
    val name: String,
    val address: String,
    val telephone: String,
    val age: Int
)

// Extension Functions
fun User.toUserView() = UserView(
    name = "$firstName $lastName",
    address = "$street $houseNumber",
    telephone = phone,
    age = age
)

// Reflection Function
fun User.toUserViewReflection() = with(::UserView) {
    val propertiesByName = User::class.memberProperties.associateBy { it.name }
    callBy(parameters.associate { parameter ->
        parameter to when (parameter.name) {
            UserView::name.name -> "$firstName $lastName"
            UserView::address.name -> "$street $houseNumber"
            UserView::telephone.name -> phone
            else -> propertiesByName[parameter.name]?.get(this@toUserViewReflection)
        }
    })
}

 */
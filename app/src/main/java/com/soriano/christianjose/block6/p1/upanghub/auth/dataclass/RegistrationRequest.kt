package com.soriano.christianjose.block6.p1.upanghub.auth.dataclass

data class RegistrationRequest(
    val name: String,
    val email: String,
    val password: String,
    val user_type : String
)

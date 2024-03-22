package com.soriano.christianjose.block6.p1.upanghub.auth.dataclass

import com.soriano.christianjose.block6.p1.upanghub.dataclass.User

data class SignInResponse(
    val user : User,
    val token : String
)

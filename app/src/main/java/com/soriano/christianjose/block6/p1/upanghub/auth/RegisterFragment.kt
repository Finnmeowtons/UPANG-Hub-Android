package com.soriano.christianjose.block6.p1.upanghub.auth

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.soriano.christianjose.block6.p1.upanghub.auth.api.ApiAuth
import com.soriano.christianjose.block6.p1.upanghub.auth.dataclass.ApiAuthResponse
import com.soriano.christianjose.block6.p1.upanghub.auth.dataclass.RegistrationRequest
import com.soriano.christianjose.block6.p1.upanghub.databinding.FragmentRegisterBinding
import com.soriano.christianjose.block6.p1.upanghub.dataclass.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val BASE_URL = "http://152.42.166.163/"
    private var isName = false
    private var isEmail = false
    private var isStudentNumber = false
    private var isPassword = false
    private var isConfirmPassword = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = binding.root

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiAuth::class.java)

        binding.apply {

            btnRegister.setOnClickListener{
                val name = etName.text.toString()
                val email = etEmail.text.toString()
                val studentNumber = etstudentNumber1.text.toString()
                val password = etPassword.text.toString()
                val registrationRequest = RegistrationRequest(name, email, password, "user")
                Log.d("MyTag", "$registrationRequest")

                if(validation()) {

                    retrofit.registerUser(registrationRequest).enqueue(object : Callback<User>{
                        override fun onResponse(
                            call: Call<User>,
                            response: Response<User>
                        ) {
                            if (response.isSuccessful){
                                MaterialAlertDialogBuilder(requireContext())
                                    .setTitle("Registration Completed")
                                    .setNeutralButton("Ok") { _, _ ->
                                        Log.d("MyTag", "Dialog Ok")
                                    }
                                    .setOnDismissListener{
                                        Log.d("MyTag", "Dialog Dismissed")
                                    }
                                    .show()
                            } else {
                                Log.d("MyTag", "Response failed $call || $response")
                            }
                        }

                        override fun onFailure(call: Call<User>, t: Throwable) {
                            Log.d("MyTag", "Network failed $call ", t)

                        }
                    })

                }
            }




        }




        return view
    }

    fun validation(): Boolean{
        binding.apply {
            if (etName.text?.trim().isNullOrEmpty()) {
                nameLayout.error = "Field is empty"
                isName = false
            } else if (etName.text?.trim()?.length!! < 5) {
                nameLayout.error = "Should have at least 5 characters"
                isName = false
            } else {
                nameLayout.error = null
                isName = true
            }

            if (etEmail.text?.trim().isNullOrEmpty()) {
                emailLayout.error = "Field is empty"
                isEmail = false
            } else if (!etEmail.text.toString().contains(".com") && !etEmail.text.toString()
                    .contains("@")
            ) {
                emailLayout.error = "The email address is incomplete"
                isEmail = false
            } else {
                emailLayout.error = null
                isEmail = true
            }

            if (etstudentNumber1.text?.trim().isNullOrEmpty()) {
                studentNumberLayout1.error = "Field is empty"
                isStudentNumber = false
            } else if (etstudentNumber1.text.toString().length == 18 && etstudentNumber1.text.toString()[2] != '-' && etstudentNumber1.text.toString()[7] != '-') {
                studentNumberLayout1.error = "Invalid Format"
                isStudentNumber = false
            } else {
                studentNumberLayout1.error = null
                isStudentNumber = true
            }

            if (etPassword.text?.trim().isNullOrEmpty()) {
                passwordLayout.error = "Field is empty"
                isPassword = false
            } else if (etPassword.text?.trim()?.length!! < 8) {
                passwordLayout.error = "Should have at least 8 characters"
                isPassword = false
            } else {
                isPassword = true
                passwordLayout.error = null
            }

            if (etPasswordConfirmation.text?.trim().isNullOrEmpty()) {
                confirmPasswordLayout.error = "Field is empty"
                isConfirmPassword = false
            } else if (etPasswordConfirmation.text.toString()
                    .trim() != etPasswordConfirmation.text.toString().trim()
            ) {
                confirmPasswordLayout.error = "Passwords do not match"
                isConfirmPassword = false
            } else {
                isConfirmPassword = true
                confirmPasswordLayout.error = null
            }
        }

        return isEmail && isConfirmPassword && isName && isPassword && isStudentNumber
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
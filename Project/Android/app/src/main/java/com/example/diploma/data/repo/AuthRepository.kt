package com.example.diploma.data.repo

import android.content.Context
import android.content.SharedPreferences
import com.example.diploma.R
import com.example.diploma.data.DiplomaApi
import com.example.diploma.data.requestBody.LoginRequestBody
import com.example.diploma.data.requestBody.UserRequestBody
import com.example.diploma.data.responseBody.AuthResponse
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


@DelicateCoroutinesApi
class AuthRepository(
    private val api: DiplomaApi,
    private val sharedPreferences: SharedPreferences,
    private val context: Context
) : MainRepository() {

    suspend fun register(user: UserRequestBody): AuthResponse? {
        return try {
            withContext(Dispatchers.IO) {
                api.register(user)
            }
        } catch (e: Exception) {
            null
        }
    }

    suspend fun login(user: LoginRequestBody): AuthResponse? {
        return try {
            withContext(Dispatchers.IO) {
                api.login(user)
            }
        } catch (e: Exception) {
            null
        }
    }

    fun saveAuthResponse(response: AuthResponse) {
        sharedPreferences.edit().putString(context.getString(R.string.auth_token), response.refresh)
            .apply()
        sharedPreferences.edit().putString(context.getString(R.string.user_id), response.access)
            .apply()
    }
}
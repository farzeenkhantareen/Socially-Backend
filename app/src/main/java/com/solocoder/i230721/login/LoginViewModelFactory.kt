package com.solocoder.i230721.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.solocoder.i230721.data.LoginDataSource
import com.solocoder.i230721.data.LoginRepository
import com.solocoder.i230721.ui.login.LoginViewModel

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LoginViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
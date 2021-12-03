package com.vv.boostapp.auth_feature.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vv.boostapp.auth_feature.domain.models.LoginResult
import com.vv.boostapp.auth_feature.domain.use_case.LoginUseCase
import com.vv.boostapp.util.Resource
import com.vv.boostapp.util.UiEvent
import com.vv.boostapp.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _usernameText = mutableStateOf("")
    val usernameText : State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText


    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun setUsername(username : String){
        _usernameText.value = username
    }
    fun setPasswordText(password: String){
        _passwordText.value = password
    }



    fun checkLogin(){
        viewModelScope.launch {
            val loginResult = loginUseCase(
                email = usernameText.value,
                password = passwordText.value
            )
            if(loginResult.emailError != null) {
                _eventFlow.emit(
                    UiEvent.ShowSnackbar(loginResult.result?.uiText ?: UiText.unknownError())
                )
            }
            if(loginResult.passwordError != null) {
                _eventFlow.emit(
                    UiEvent.ShowSnackbar(loginResult.result?.uiText ?: UiText.unknownError())
                )
            }
            when(loginResult.result) {
                is Resource.Success -> {
                    println("login suscccesss")
                    _eventFlow.emit(UiEvent.OnLogin)
                    _eventFlow.emit(UiEvent.ShowSnackbar(
                        UiText.successful()
                    ))
                }
                is Resource.Error -> {
                    print("login error = " + loginResult.result.uiText) /*?: UiText.unknownError())*/
                    _eventFlow.emit(
                        UiEvent.ShowSnackbar(
                            loginResult.result.uiText ?: UiText.unknownError()
                        )
                    )
                }
            }
        }
    }
}
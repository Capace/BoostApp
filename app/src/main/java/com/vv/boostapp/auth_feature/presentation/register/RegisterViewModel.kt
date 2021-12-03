package com.vv.boostapp.auth_feature.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vv.boostapp.R
import com.vv.boostapp.auth_feature.domain.use_case.RegisterUseCase
import com.vv.boostapp.util.Resource
import com.vv.boostapp.util.UiEvent
import com.vv.boostapp.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerUseCase: RegisterUseCase
): ViewModel() {

    private val _emailState = mutableStateOf("")
    val emailState: State<String> = _emailState

    private val _usernameState = mutableStateOf("")
    val usernameState: State<String> = _usernameState

    private val _passwordState = mutableStateOf("")
    val passwordState: State<String> = _passwordState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventflow = _eventFlow.asSharedFlow()


    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.EnteredUsername -> {
                _usernameState.value = event.value
            }
            is RegisterEvent.EnteredEmail -> {
                _emailState.value = event.value
            }
            is RegisterEvent.EnteredPassword -> {
                _passwordState.value = event.value
            }
/*            is RegisterEvent.TogglePasswordVisibility -> {
                _passwordState.value = _passwordState.value
            }*/
            is RegisterEvent.Register -> {
                register()
            }
        }
    }

    fun register() {
        viewModelScope.launch {
            _usernameState.value = usernameState.value
            _emailState.value = emailState.value
            _passwordState.value = passwordState.value
            println(emailState.value)
            println(usernameState.value)
            println(passwordState.value)
            val registerResult = registerUseCase(
                email = emailState.value,
                username = usernameState.value,
                password = passwordState.value
            )
            if (registerResult.emailError != null) {
                _emailState.value = emailState.value
            }
            if (registerResult.usernameError != null) {
                _usernameState.value = _usernameState.value
            }
            if (registerResult.passwordError != null) {
                _passwordState.value = _passwordState.value
            }
            when (registerResult.result) {
                is Resource.Success -> {
                    _eventFlow.emit(
                        UiEvent.ShowSnackbar(UiText.StringResource(R.string.success_registration))
                    )
                    _usernameState.value = ""
                    _emailState.value = ""
                    _passwordState.value = ""
                }
                is Resource.Error -> {
                    _eventFlow.emit(
                        UiEvent.ShowSnackbar(registerResult.result.uiText ?: UiText.unknownError())
                    )
                }
            }
        }
    }
}

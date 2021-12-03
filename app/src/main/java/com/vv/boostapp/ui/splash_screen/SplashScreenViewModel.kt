package com.vv.boostapp.ui.splash_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vv.boostapp.R
import com.vv.boostapp.auth_feature.domain.use_case.AuthenticateUseCase
import com.vv.boostapp.ui.navigation.NavRoutes
import com.vv.boostapp.util.Resource
import com.vv.boostapp.util.UiEvent
import com.vv.boostapp.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val authenticateUseCase: AuthenticateUseCase
) : ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    init {
        viewModelScope.launch {
            when(authenticateUseCase()){
                is Resource.Success->{
                    _eventFlow.emit(UiEvent.Navigate(NavRoutes.MainScreen.route))
                }
                is Resource.Error->{
                    _eventFlow.emit(UiEvent.Navigate(NavRoutes.LoginScreen.route))
                    _eventFlow.emit(UiEvent.ShowSnackbar(uiText = UiText.StringResource(R.string.login_again)))
                }
            }

        }
    }
}
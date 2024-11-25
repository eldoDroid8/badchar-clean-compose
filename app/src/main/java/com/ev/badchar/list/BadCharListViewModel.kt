package com.ev.badchar.list

import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ev.badchar.R
import com.ev.badchar.domain.badchar.usecase.badchar.GetBadCharUseCase
import com.ev.badchar.domain.model.onFailure
import com.ev.badchar.domain.model.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BadCharListViewModel @Inject constructor(
    private val getBadCharUseCase: GetBadCharUseCase
) : ViewModel() {

    @StringRes
    val loadingMessage = R.string.all_loading

    private var _loadingVisible by mutableStateOf(false)
    val loadingVisible: Boolean
        get() = _loadingVisible

    init {
        loadBadChars()
    }

    private fun loadBadChars() {
        viewModelScope.launch {
            _loadingVisible = true
            delay(3000)
            getBadCharUseCase.invoke().onSuccess {
                _loadingVisible = false
            }.onFailure {
                _loadingVisible = false
            }
        }
    }
}
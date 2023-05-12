package dev.musicapp.ui.home

import dev.musicapp.domain.model.AudioItem
import dev.musicapp.domain.useCase.GetAllMusicListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    private val getAllMusicListUseCase: GetAllMusicListUseCase by inject()

    private val _audioList: MutableStateFlow<List<AudioItem>> =
        MutableStateFlow(value = emptyList())
    val audioList: StateFlow<List<AudioItem>> = _audioList

    private val _errorState: MutableStateFlow<String> = MutableStateFlow(value = "")
    val errorState: StateFlow<String> = _errorState

    init {
        getAllMusicList()
    }

    private fun getAllMusicList() {
        viewModelScope.launch {
            val response = getAllMusicListUseCase()
            response.onSuccess {
                _audioList.value = it
            }.onFailure {
                _errorState.value = it.message.orEmpty()
            }
        }
    }
}

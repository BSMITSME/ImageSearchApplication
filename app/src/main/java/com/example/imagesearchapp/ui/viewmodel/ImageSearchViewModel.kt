package com.example.imagesearchapp.ui.viewmodel

import androidx.lifecycle.*
import com.example.imagesearchapp.data.model.Document
import com.example.imagesearchapp.data.model.Images
import com.example.imagesearchapp.repository.ImageSearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class ImageSearchViewModel(
    private val imageSearchRepository: ImageSearchRepository
) : ViewModel() {
    //api
    private val _searchResult = MutableLiveData<Images>()
    val searchResult : LiveData<Images> get() = _searchResult

    fun searchImage(query : String) = viewModelScope.launch(Dispatchers.IO) {
        val response = imageSearchRepository.searchImage(query,"accuracy", 1,15)
        if (response.isSuccessful){
            //response.body()?
            //OkHttpClient의 LoggingIntercepter(로깅)에 찍힌 응답 (Response Body) 데이터는 정상적 반환
            //onResponse의 response.body().toString()의 값은 해당 인스턴스의 주소값으로 출력
            response.body().let {
                _searchResult.postValue(it)
            }
        }
    }

    //SavedState
//    var query = String()
//        set(value){
//            field = value
//            savedStateHandle.set(SAVE_STATE_KEY, value)
//        }
//    init {
//        query = savedStateHandle.get<String>(SAVE_STATE_KEY) ?: ""
//    }
//    companion object{
//        private const val SAVE_STATE_KEY ="query"
//    }
}
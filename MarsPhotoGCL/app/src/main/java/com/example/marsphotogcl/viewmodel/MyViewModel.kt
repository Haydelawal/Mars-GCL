package com.example.marsphotogcl.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.marsphotogcl.api.Api
import com.example.marsphotogcl.paging.MyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel
@Inject constructor(
    private val api: Api
) : ViewModel() {

    val listData = Pager(
        PagingConfig(
            pageSize = 1,
            enablePlaceholders = false
        )
    ) {
        MyPagingSource(api)
    }
        .flow
        .cachedIn(viewModelScope)
}
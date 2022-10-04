package com.example.marsphotogcl.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.marsphotogcl.api.Api
import com.example.marsphotogcl.model.MarsResponseItem
import retrofit2.HttpException
import java.io.IOException

class MyPagingSource
    (private val api: Api) : PagingSource<Int, MarsResponseItem>() {

    override fun getRefreshKey(state: PagingState<Int, MarsResponseItem>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MarsResponseItem> {

        val position = params.key ?: 1
        return try {

            val response = api.getAllPhotos()

            val photos = response

            LoadResult.Page(
                data = photos,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1

            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        }
        catch (exception: HttpException){
            LoadResult.Error(exception)

        }
    }
    }



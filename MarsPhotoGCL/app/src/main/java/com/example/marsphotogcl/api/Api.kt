package com.example.marsphotogcl.api

import com.example.marsphotogcl.Constants.END_POINT
import com.example.marsphotogcl.model.MarsResponse
import retrofit2.Response
import retrofit2.http.GET

interface Api {

            @GET(END_POINT)
            suspend fun getAllPhotos(
            ): MarsResponse
}
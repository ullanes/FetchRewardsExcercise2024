package ulysisllanes.fetchrewardstakehome.subunits.api

import ulysisllanes.fetchrewardstakehome.subunits.datamodel.FetchData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface FetchDataAPI {

    @GET("hiring.json")
    suspend fun getDataList(): Response<FetchData>
}
package ulysisllanes.fetchrewardstakehome.subunits.api

import retrofit2.Response

abstract class FetchAPIRequest {
    suspend fun <T : Any> fetchAPIRequest(call: suspend () -> Response<T>): AsyncResult<T> {
        return try {
            val response = call.invoke()
            AsyncResult.Success(response.body()!!)
        } catch (e: Exception) {
            AsyncResult.Error(e)
        }
    }
}

//class APIException (message:String) :IOException(message)
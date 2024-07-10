package ulysisllanes.fetchrewardstakehome.subunits.api

import java.lang.Exception


sealed class AsyncResult<out T> {
    data class Error(val exception: Exception) : AsyncResult<Nothing>()
    data class Success<T>(val data: T) : AsyncResult<T>()
}
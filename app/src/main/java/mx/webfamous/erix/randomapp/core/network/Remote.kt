package mx.webfamous.erix.randomapp.core.network

import retrofit2.Response

suspend fun <T, R> getRemote(
    call: suspend () -> Response<T>,
    mapper: (T) -> R
): NetworkResult<R> {
    try {
        val response = call()
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                val transformed = mapper(body)
                return NetworkResult.Success(transformed, response.code())
            }
        }
        return NetworkResult.Error(response.message(), response.code())
    } catch (e: Exception) {
        return NetworkResult.Error(e.message ?: e.toString())
    }
}

package mx.webfamous.erix.randomapp.core.network


sealed class NetworkResult<T> {
    data class Success<T>(val data: T, val statusCode: Int = 0) : NetworkResult<T>()
    data class Error<T>(val error: String, val statusCode: Int = 0) : NetworkResult<T>()
    class Loading<T> : NetworkResult<T>()
}

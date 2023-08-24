package mx.webfamous.erix.randomapp.products.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import mx.webfamous.erix.randomapp.core.network.NetworkResult
import mx.webfamous.erix.randomapp.core.utils.loge
import mx.webfamous.erix.randomapp.products.data.repository.ProductsRepository
import mx.webfamous.erix.randomapp.products.ui.events.ProductEvent
import mx.webfamous.erix.randomapp.products.ui.events.UiEvent
import mx.webfamous.erix.randomapp.products.ui.state.ProductState
import javax.inject.Inject


@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductsRepository
): ViewModel() {

    var state by mutableStateOf(ProductState())
    private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun dispatcherEvent(event: ProductEvent) {
        when(event) {
            is ProductEvent.GetProducts -> getProducts()
            is ProductEvent.GoToDetailProduct -> viewModelScope.launch { _uiEvent.send(UiEvent.GoToDetailProduct(event.product)) }
        }
    }

    private fun getProducts() = viewModelScope.launch {
        when(val result = repository.getProducts()) {
            is NetworkResult.Error -> Unit
            is NetworkResult.Loading -> Unit
            is NetworkResult.Success -> {
                state = state.copy(products = result.data)
            }
        }
    }
}
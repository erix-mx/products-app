package mx.webfamous.erix.randomapp.products.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mx.webfamous.erix.randomapp.core.network.ApiServices
import mx.webfamous.erix.randomapp.products.data.repository.ProductsRepository
import mx.webfamous.erix.randomapp.products.data.repository.ProductsRepositoryImpl
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ProductModule {

    @Singleton
    @Provides
    fun provideProductRepository(
        services: ApiServices
    ): ProductsRepository = ProductsRepositoryImpl(services=services)
}
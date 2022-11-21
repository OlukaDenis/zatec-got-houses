package com.domain.model.sealed

sealed class Resource<out R> {
    /**
     * Returns the loading state
     */
    object Loading : Resource<Nothing>()

    /**
     * Returns the success state of the resource
     * @param T any object
     * @property data
     */
    data class Success<out T>(val data: T) : Resource<T>()

    /**
     * Returns the error state of the resource
     * @property exception
     */
    data class Error(val exception: String) : Resource<Nothing>()
}

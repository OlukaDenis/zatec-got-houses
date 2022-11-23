package com.domain.model.sealed

import com.domain.annotations.ExcludeGenerated

@ExcludeGenerated
sealed class BaseState<out T> {
    object LoadingState : BaseState<Nothing>()
    data class ErrorState(var exception: Throwable) : BaseState<Nothing>()
    data class DataState<T>(var data: T) : BaseState<T>()
}
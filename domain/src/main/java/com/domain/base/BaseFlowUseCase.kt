package com.domain.base

import com.domain.annotations.ExcludeGenerated
import com.domain.dispacher.AppDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

/**
 * A base util class that is invoked flows on the IO thread asynchronously
 * Returns a coroutine flow
 */
abstract class BaseFlowUseCase<in Param, Result>(
    private val dispatcher: AppDispatcher
) where Param : Any {

    abstract fun run(param: Param?): Flow<Result>

     operator fun invoke(param: Param? = null) = run(param).flowOn(dispatcher.io)
}
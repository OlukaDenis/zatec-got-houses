package com.domain.base

import com.domain.annotations.ExcludeGenerated
import com.domain.dispacher.AppDispatcher
import kotlinx.coroutines.withContext

/**
 * A base util class that is invoked runs on the IO thread asynchronously
 * Returns a coroutine suspend function
 */
abstract class BaseSuspendUseCase<in Param, Result>(
    private val dispatcher: AppDispatcher
) where Param : Any {

    abstract suspend fun run(param: Param? = null): Result

    suspend operator fun invoke(param: Param? = null): Result =
        withContext(dispatcher.io) { run(param) }
}
package com.domain.repository

interface UtilRepository {

    /**
     * Extracts readable message from the throwable
     * @param throwable
     * @return string error
     */
    fun getNetworkError(throwable: Throwable): String
}
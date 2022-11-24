package com.zatec.got_houses.presentation.house_detail

import com.domain.annotations.ExcludeGenerated
import com.domain.model.House

@ExcludeGenerated
data class HouseDetailState(
    val house: House? = null
)
package com.zatec.got_houses.presentation.houses

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.zatec.got_houses.presentation.houses.components.HouseItem
import com.zatec.got_houses.presentation.util.Screen
import com.zatec.got_houses.ui.theme.Dimens.spacing_16
import com.zatec.got_houses.ui.theme.Dimens.spacing_4
import com.zatec.got_houses.ui.theme.Dimens.spacing_8
import timber.log.Timber

@Composable
fun HouseListScreen(
    navController: NavController,
    viewModel: HouseListViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center
                    )
                },
                elevation = spacing_4
            )
        }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val houses = viewModel.houses.collectAsLazyPagingItems()

            LazyColumn {

                when (val state = houses.loadState.prepend) {
                    is LoadState.NotLoading -> Unit
                    is LoadState.Loading -> {
                        loading()
                        Timber.d("Loading prepend")
                    }
                    is LoadState.Error -> {
//                        Error(message = state.error.message ?: "")
                        Timber.d(state.error.message)
                    }
                    else -> {}
                }

                when (val state = houses.loadState.refresh) {
                    is LoadState.NotLoading -> Unit
                    is LoadState.Loading -> {
                        loading()
                        Timber.d("Loading refresh")
                    }
                    is LoadState.Error -> {
//                        Error(message = state.error.message ?: "")
                        Timber.d(state.error.message)
                    }
                    else -> {}
                }

                items(houses) { house ->
                    house?.let { entity ->

                        HouseItem(
                            house = viewModel.domainHouse(entity),
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    navController.navigate(
                                        Screen.HouseDetailScreen.route + "?houseId=${entity.id}"
                                    )
                                },
                        )
                    }
                }

                when (val state = houses.loadState.append) {
                    is LoadState.NotLoading -> Unit
                    is LoadState.Loading -> {
                        loading()
                        Timber.d("Loading append")
                    }
                    is LoadState.Error -> {
//                        Error(message = state.error.message ?: "")
                        Timber.d(state.error.message)
                    }
                    else -> {}
                }
            }
        }
    }
}

private fun LazyListScope.loading() {
    item {
        Box(contentAlignment = Alignment.Center) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(modifier = Modifier.padding(spacing_8), strokeWidth = spacing_4)
            }
        }
    }
}

private fun LazyListScope.error(
    message: String
) {
    item {
        Text(
            text = message,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.error
        )
    }
}
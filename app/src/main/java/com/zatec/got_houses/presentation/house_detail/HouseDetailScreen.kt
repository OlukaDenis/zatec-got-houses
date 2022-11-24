package com.zatec.got_houses.presentation.house_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.People
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.zatec.got_houses.ui.theme.Dimens
import com.zatec.got_houses.ui.theme.Dimens.spacing_0_5
import com.zatec.got_houses.ui.theme.Dimens.spacing_1
import com.zatec.got_houses.ui.theme.Dimens.spacing_16
import com.zatec.got_houses.ui.theme.Dimens.spacing_30
import com.zatec.got_houses.ui.theme.Dimens.spacing_4
import com.zatec.got_houses.ui.theme.Dimens.spacing_6
import com.zatec.got_houses.ui.theme.Dimens.spacing_8
import com.zatec.got_houses.ui.theme.LightGray

@Composable
fun HouseDetailScreen(
    navController: NavController,
    viewModel: HouseDetailViewModel = hiltViewModel()
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    val houseState = viewModel.house.value
    val name = if (houseState.house == null) "" else houseState.house.name

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.onPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = if (navController.previousBackStackEntry != null) {
                    {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                imageVector = Icons.Filled.Close,
                                contentDescription = "Back"
                            )
                        }
                    }
                } else {
                    null
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            houseState.house?.let { house ->
                Card(
                    elevation = Dimens.spacing_0,
                    modifier = Modifier
                        .padding(Dimens.spacing_10)
                        .fillMaxSize()
                        .matchParentSize()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(spacing_16)
                    ) {

                        Text(
                            text = name,
                            style = MaterialTheme.typography.subtitle1,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(spacing_8))

                        Text(
                            text = house.coatOfArms,
                            style = MaterialTheme.typography.body2,
                        )

                        if (house.founded.isNotEmpty()) {
                            Spacer(modifier = Modifier.height(spacing_8))
                            Text(text = "Founded: ${house.founded}", style = MaterialTheme.typography.body2)
                        }

                        Spacer(modifier = Modifier.height(spacing_16))

                        if (house.seats.isNotEmpty()) {
                            val seats = house.seats.filter { s -> s.isNotEmpty() }
                            if (seats.isNotEmpty()) {
                                HouseItemList(title = "Seats", list = (house.seats))
                                Spacer(modifier = Modifier.height(spacing_16))
                            }
                        }

                        if (house.titles.isNotEmpty()) {
                            val titles = house.titles.filter { s -> s.isNotEmpty() }

                            if (titles.isNotEmpty()) {
                                HouseItemList(title = "Titles", list = (house.titles))
                                Spacer(modifier = Modifier.height(spacing_16))
                            }

                        }

                        if (house.ancestralWeapons.isNotEmpty()) {
                            val weapons = house.ancestralWeapons.filter { s -> s.isNotEmpty() }
                            if (weapons.isNotEmpty()) {
                                HouseItemList(
                                    title = "Ancestral Weapons",
                                    list = (house.ancestralWeapons)
                                )
                                Spacer(modifier = Modifier.height(spacing_16))
                            }

                        }

                        Spacer(modifier = Modifier.height(spacing_8))

                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val members = house.swornMembers.size.toString()
                            val branches = house.cadetBranches.size.toString()

                            ColumnItem(title = "Members", value = members, icon = Icons.Filled.People)

                            Spacer(modifier = Modifier.width(spacing_16))
                            Divider(
                                color = Color.LightGray, modifier = Modifier
                                    .height(spacing_30)
                                    .width(spacing_1)
                            )
                            Spacer(modifier = Modifier.width(spacing_16))

                            ColumnItem(title = "Branches", value = branches, icon = Icons.Filled.Hub)

                        }

                    }
                }
            }
        }
    }
}

@Composable
fun ColumnItem(
    title: String,
    value: String,
    icon: ImageVector
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            color = Color.Gray,
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.height(spacing_4))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier
                    .width(spacing_16)
                    .height(spacing_16),
                tint = Color.Gray
            )
            Spacer(modifier = Modifier.width(spacing_4))

            Text(
                text = value,
                color = Color.Gray,
                style = MaterialTheme.typography.body2
            )
        }
    }
}

@Composable
fun HouseItemList(
    title: String,
    list: List<String>
) {
    Column {
        Text(
            text = title,
            style = MaterialTheme.typography.body2,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(spacing_4))

        LazyColumn {
            itemsIndexed(items = list) { index, item ->

                if (index != 0) {
                    Divider(
                        color = LightGray, modifier = Modifier
                            .fillMaxWidth()
                            .width(spacing_0_5)
                    )
                }

                Box(modifier = Modifier.padding(spacing_6)) {
                    Text(text = item, style = MaterialTheme.typography.body2)
                }

                if (index == list.size - 1) {
                    Divider(
                        color = LightGray, modifier = Modifier
                            .fillMaxWidth()
                            .width(spacing_0_5)
                    )
                }
            }
        }
    }
}
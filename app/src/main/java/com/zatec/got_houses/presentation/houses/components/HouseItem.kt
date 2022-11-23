package com.zatec.got_houses.presentation.houses.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.People
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.data.local.model.HouseEntity
import com.domain.model.House
import com.zatec.got_houses.ui.theme.Dimens.spacing_0
import com.zatec.got_houses.ui.theme.Dimens.spacing_1
import com.zatec.got_houses.ui.theme.Dimens.spacing_10
import com.zatec.got_houses.ui.theme.Dimens.spacing_14
import com.zatec.got_houses.ui.theme.Dimens.spacing_16
import com.zatec.got_houses.ui.theme.Dimens.spacing_20
import com.zatec.got_houses.ui.theme.Dimens.spacing_24
import com.zatec.got_houses.ui.theme.Dimens.spacing_30
import com.zatec.got_houses.ui.theme.Dimens.spacing_4
import com.zatec.got_houses.ui.theme.Dimens.spacing_8

@Composable
fun HouseItem(
    house: HouseEntity,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        elevation = spacing_0,
        modifier = Modifier
            .padding(spacing_10)
            .fillMaxSize()
            .wrapContentHeight()
    ) {
        Box(modifier = modifier) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(spacing_20)
            ) {
                Text(
                    text = house.name,
                    style = MaterialTheme.typography.subtitle1,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(spacing_4))
                Text(
                    text = house.coatOfArms,
                    style = MaterialTheme.typography.body1,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(spacing_8))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val members = house.swornMembers.size.toString()
                    val branches = house.cadetBranches.size.toString()

                    Icon(
                        imageVector = Icons.Default.People,
                        contentDescription = "People",
                        modifier = Modifier
                            .width(spacing_16)
                            .height(spacing_16),
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(spacing_4))
                    Text(
                        text = members,
                        color = Color.Gray,
                        style = MaterialTheme.typography.body2
                    )

                    Spacer(modifier = Modifier.width(spacing_14))

                    Icon(
                        imageVector = Icons.Default.Hub,
                        contentDescription = "Branch",
                        modifier = Modifier
                            .width(spacing_16)
                            .height(spacing_16),
                        tint = Color.Gray
                    )
                    Spacer(modifier = Modifier.width(spacing_4))
                    Text(
                        text = branches,
                        color = Color.Gray,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }


}
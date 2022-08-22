package com.example.todoisthulapps.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoisthulapps.constants.Constants
import com.example.todoisthulapps.R

@Composable
fun TaskCard(task: String) {

    Column(modifier = Modifier.padding(bottom = 20.dp)) {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier
            .width(350.dp)
            .shadow(elevation = 7.dp, shape = RoundedCornerShape(10.dp))
            .clip(shape = RoundedCornerShape(13.dp))
            .background(color = Color.White)
            .padding(12.dp)) {
            Column(){
                Row(modifier = Modifier.fillMaxWidth(fraction = 0.5f),
                    horizontalArrangement = Arrangement.Start) {
                    Column() {
                        Text(text = task,
                            fontSize = 16.sp,
                            fontFamily = Constants.Inter,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier.padding(bottom = 10.dp)
                        )
                        Text(text = "To-Do",
                            fontFamily = Constants.OpenSans,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 12.sp,
                            color = Color(87, 16, 50),
                            modifier = Modifier
                                .background(
                                    color = Color(252, 238, 245),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(5.dp))

                    }
                }
            }
            Spacer(modifier = Modifier.fillMaxWidth(fraction = 0.7f))

            Row(modifier = Modifier.padding(top = 5.dp)) {
                FloatingActionButton(onClick = { /*TODO*/ },
                    backgroundColor = Color.Transparent,
                    modifier = Modifier,
                    elevation = FloatingActionButtonDefaults.elevation(0.dp,0.dp)) {
                    Icon(painter = painterResource(id = R.drawable.ic_edit_icon) , contentDescription = null,
                        tint = Color(242, 95, 76),
                        modifier = Modifier.size(20.dp))
                }
            }

        }
    }
}


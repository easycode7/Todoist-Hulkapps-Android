package com.example.todoisthulapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todoisthulapps.ui.theme.TodoistHulAppsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoistHulAppsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   Column {
                       TitleText()
                       Row(modifier = Modifier.fillMaxWidth(),
                           horizontalArrangement = Arrangement.Center) {
                           Column() {
                               TaskCard(task = "Task #1")
                               TaskCard(task = "Task #2")
                               TaskCard(task = "Task #3")
                               TaskCard(task = "Task #4 - Arrange Collumn")

                           }
                       }
                            Row(horizontalArrangement =  Arrangement.End,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(20.dp)) {
                                Column(verticalArrangement = Arrangement.Bottom,
                                modifier = Modifier.fillMaxHeight()) {
                                    AddButton()
                                }

                            }

                   }
                }
            }
        }
    }
}
val Inter = FontFamily(
    Font(R.font.inter_regular),
    Font(R.font.inter_semibold, FontWeight.SemiBold)
)
val OpenSans = FontFamily(
    Font(R.font.opensans_semibold, FontWeight.SemiBold)
)

@Composable
fun TitleText() {
    Text(text = "To Do List",
        modifier = Modifier
            .padding(top = 40.dp)
            .padding(bottom = 20.dp)
            .padding(start = 15.dp),
        fontSize = 25.sp,
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold
    )
}
@Composable
fun TaskCard(task: String) {

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp
    val screenHeight = configuration.screenHeightDp
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
                          fontFamily = Inter,
                          fontWeight = FontWeight.Normal,
                          modifier = Modifier.padding(bottom = 10.dp)
                      )
                      Text(text = "Medium",
                          fontFamily = OpenSans,
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
@Composable
fun AddButton() {
    FloatingActionButton(onClick = { /*do something*/},
    backgroundColor = Color(229, 49, 112)) {
        Icon(painter = painterResource(id = R.drawable.ic_add), contentDescription = null,
        tint = Color.White,)
    }
}



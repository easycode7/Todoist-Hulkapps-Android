package com.example.todoisthulapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
                           TaskCard(task = "Do some task.")
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
   Row(horizontalArrangement = Arrangement.Center,
       modifier = Modifier.border(width = 0.8.dp,
           Color.LightGray,
           shape = RoundedCornerShape(12.dp)).padding(18.dp)) {
       Column {
           Text(text = task,
           fontSize = 20.sp,
           fontFamily = Inter,
           fontWeight = FontWeight.Normal
           )
           Text(text = "High",
           fontFamily = OpenSans,
           fontWeight = FontWeight.SemiBold,
           fontSize = 12.sp,
           color = Color(87, 16, 50))
       }
       Spacer(modifier = Modifier.padding(horizontal = 70.dp))
       Row() {
           Icon(imageVector = Icons.Default.Edit, contentDescription = null,
           tint = Color(242, 95, 76))
           Icon(imageVector = Icons.Default.Delete, contentDescription = null,
           tint = Color(242, 95, 76))
       }
   }
}


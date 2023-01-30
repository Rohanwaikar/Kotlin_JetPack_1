package com.example.jetbizcard

import android.os.Bundle
import android.widget.Scroller
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.text.style.TextDrawStyle.Unspecified.color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBizCard(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {
        Card(modifier = Modifier
            .padding(5.dp)
            .size(200.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable {
                // After click //
            })
        {
               Column(
                   modifier = Modifier
                       .height(150.dp)
                       .width(150.dp)
                       .padding(5.dp)
                       .align(alignment = Alignment.CenterHorizontally),
                   verticalArrangement = Arrangement.Top,
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   ImageProfile()
               }
            Divider()

            Column(modifier = Modifier
                .padding(5.dp)
                .align(alignment = Alignment.CenterHorizontally)
                ) {
                Text(text = "Rohan Waikar",
                style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.onSurface ,
                fontSize = 40.sp)
                Text(text = "Android Compose Programmer",
                modifier = Modifier.padding(3.dp))
                Text(text = "@themilesCompose",
                modifier = Modifier.padding(3.dp),
                style = MaterialTheme.typography.titleMedium)
            }
            Column(modifier = Modifier.align(alignment = Alignment.CenterHorizontally)) {
            MaterialTheme(lightColorScheme()) {
                Column{ 
                    Row{
                        Button(onClick = {
 buttonClickedState.value = !buttonClickedState.value
                    }
                        )
                    {Text("Portfolio" )

                    }
                    }
                }
            }
            }
            if (buttonClickedState.value){
                Content()
            } else{
                Box{}
            }
           }

    }
    }
@Preview
@Composable
fun Content(){
  Box(modifier = Modifier
      .fillMaxWidth()
      .fillMaxHeight()
      .padding(5.dp))
  {
      Surface(modifier = Modifier
          .padding(3.dp)
          .fillMaxHeight()
          .fillMaxWidth(),
         shape = RoundedCornerShape(corner = CornerSize(6.dp)),
          border = BorderStroke(width = 2.dp, color = Color.LightGray)
          ) {
          Portfolio(data = listOf("Project 1", "Project 2","Project 3"))
      }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portfolio(data: List<String>) {
  LazyColumn{
      items(data){ item ->
         Card(modifier = Modifier
             .padding(4.dp)
             .fillMaxWidth(),
         shape = RectangleShape
          ) {
             Row(modifier = Modifier
                 .padding(8.dp). fillMaxWidth()
                 .background(MaterialTheme.colorScheme.surface)
                 .padding(1.dp)
                 ) {
                 ImageProfile(modifier = Modifier.size(5.dp))
                 Column( modifier = Modifier
                     .padding(7.dp)
                     .align(alignment = CenterVertically)) {
                     Text(item, fontWeight = FontWeight.Bold)
                     Text(text = "A great Project",
                      style = MaterialTheme.typography.bodyMedium)
                 }
             }
         }
          
      }
  }

}

@Composable
private fun ImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(130.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        shadowElevation = 4.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
    )
    {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
           modifier = modifier.size(5.dp),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}
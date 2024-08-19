package com.example.birthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import com.example.birthdaycard.ui.theme.BirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BirthdayCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    GreetingImage(message = "Happy Birthday Sam!", from = "From Hasham")
                }
            }
        }
    }
}


@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Text(
            text = message,
            fontSize = 95.sp,
            lineHeight = 116.sp,
            textAlign =  TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.CenterHorizontally)
            )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

@Composable
fun JetpackComposeImage(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = stringResource(R.string.intorduction_jetpack_compose),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(R.string.tutorial_jetpack_compose),
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun AllTaskDone(modifier: Modifier = Modifier){
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.completed_msg),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(R.string.nice_work),
            fontSize = 16.sp
        )
    }
}

@Composable
fun Quadrant(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.purple_200))
            .fillMaxHeight()
            .fillMaxWidth(),
    ) {
        Row (
            modifier = Modifier
                .background(color = colorResource(id = R.color.black))
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.5f),
        ){
            ColoredBoxed(color = Color(0xFFEADDFF), modifier = Modifier.fillMaxWidth(fraction = 0.5f))
            {
                HeadingText(text = stringResource(R.string.first_title))
                SubText(text = stringResource(R.string.first_description))
            }
            ColoredBoxed(color = Color(0xFFD0BCFF)){
                HeadingText(text = stringResource(R.string.second_title))
                SubText(text = stringResource(R.string.second_description))
            }
        }
        Row (
            modifier = Modifier
                .background(color = Color(0xFFEADDFF))
                .fillMaxWidth()
                .fillMaxHeight(fraction = 1f),
        ){
            ColoredBoxed(color = Color(0xFFB69DF8), modifier = Modifier.fillMaxWidth(fraction = 0.5f))
            {
                HeadingText(text = stringResource(R.string.third_title))
                SubText(text = stringResource(R.string.third_description))
            }
            ColoredBoxed(color = Color(0xFFF6EDFF)){
                HeadingText(text = stringResource(R.string.forth_title))
                SubText(text = stringResource(R.string.forth_description))
            }
        }
    }
}

@Composable
fun ColoredBoxed(color: Color , modifier: Modifier = Modifier, function: @Composable ()-> Unit){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = color)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        function()
    }
}

@Composable
fun HeadingText(text: String, modifier: Modifier = Modifier){
    Text(text = text, fontWeight = FontWeight.Bold, modifier = modifier.padding(bottom = 16.dp))
}

@Composable
fun SubText(text: String, modifier: Modifier = Modifier){
    Text(text = text, textAlign = TextAlign.Justify)
}

@Preview(showBackground = true, showSystemUi = true, name = "My Preview")
@Composable
fun BirthdayCardPreview() {
    BirthdayCardTheme {
        Quadrant()
//        AllTaskDone()
//        JetpackComposeImage()
//        GreetingImage(message = stringResource(R.string.happy_birthday_text), from = stringResource(
//            R.string.signature_text
//        )
//        )
    }
}

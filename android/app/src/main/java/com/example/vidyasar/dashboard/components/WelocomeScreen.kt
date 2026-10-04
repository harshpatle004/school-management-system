package com.example.vidyasar.dashboard.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vidyasar.R
import java.util.Calendar



@Composable
fun WelocomeScreen(
    firstName : String = "Harsh",
    school : String = "Ideal Public School Ghunadi"
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)

    ) {

        Image(
            painter = painterResource(R.drawable.welcome_school),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .padding(start = 24.dp)
                .padding(top = 20.dp)
        ) {
            Text(
                text = getGreeting(),
                fontSize = 15.sp

            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = firstName,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(2.dp))

            Text(
                text = school,
                fontSize = 15.sp,
                modifier = Modifier.width(200.dp)
            )

        }






    }


}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewWelcomeScreen(){
    WelocomeScreen()
}


fun getGreeting(): String {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)


    return when (hour) {
        in 5..11 -> "Good Morning,"
        in 12..16 -> "Good Afternoon,"
        in 17..20 -> "Good Evening,"
        else -> "Good Night,"
    }
}
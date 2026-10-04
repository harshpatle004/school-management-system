package com.example.vidyasar.dashboard.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vidyasar.ui.theme.VidyasaarBlue
import com.example.vidyasar.ui.theme.VidyasaarNavy


@Composable
fun TopBar(
    firstName: String = "Harsh",
    MenuClick : () -> Unit,
    onIconClick : ()-> Unit,
    onProfileClick : () -> Unit
){

    Box(){

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 13.dp),
            verticalAlignment = Alignment.CenterVertically

        ) {

            IconButton(onClick = MenuClick) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu"
                )

            }

            Text(
                text = buildAnnotatedString {

                    withStyle(
                        SpanStyle(
                            color = VidyasaarNavy,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Vidya")
                    }

                    withStyle(
                        SpanStyle(
                            color = VidyasaarBlue,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("saar")
                    }
                },
                fontSize = 24.sp,
                lineHeight = 48.sp
            )

            Spacer(modifier = Modifier.weight(1f))

           Row(
               verticalAlignment = Alignment.CenterVertically
           ) {
               Box(){

                   IconButton(onIconClick) {
                       Icon(
                           imageVector = Icons.Default.NotificationsNone,
                           contentDescription = "Notification Center"
                       )
                   }

               }

               Spacer(modifier = Modifier.width(8.dp))


               Box(
                   modifier = Modifier
                       .size(40.dp)
                       .clip(CircleShape)
                       .background(
                           VidyasaarBlue.copy(alpha = 0.10f)
                       )
                       .clickable {
                           onProfileClick()
                       },
                   contentAlignment = Alignment.Center
               ) {
                   Text(
                       text = firstName.firstOrNull()?.uppercase() ?: "A",
                       color = VidyasaarBlue,
                       fontSize = 17.sp,
                       fontWeight = FontWeight.Medium
                   )
               }
           }

        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewTopBar(){

    TopBar(MenuClick = { },
        onIconClick = { },
        onProfileClick = { }
        )
}

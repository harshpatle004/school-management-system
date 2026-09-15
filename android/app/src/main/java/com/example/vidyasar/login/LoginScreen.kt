package com.example.vidyasar.login

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.vidyasar.R
import com.example.vidyasar.ui.theme.VidyasaarBlue
import com.example.vidyasar.ui.theme.VidyasaarNavy
import androidx.compose.runtime.setValue
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController
) {

    var schoolId by remember {
        mutableStateOf("")
    }

    var role by remember {
        mutableStateOf("")
    }

    var roleExpanded by remember { mutableStateOf(false) }

    var userId by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize()
            .background(
                VidyasaarBlue.copy(alpha = 0.035f)
            )
    ) {

        // Components #1 - #4
        Column(
            modifier = Modifier
                .padding(
                    start = 43.dp,
                    top = 65.dp
                )
        ) {

            // Component #1 — VidyasaarWordmark
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
                fontSize = 42.sp,
                lineHeight = 48.sp
            )

            // Component #2 — BrandTagline
            Spacer(
                modifier = Modifier.height(6.dp)
            )

            Text(
                text = "Learn  •  Manage  •  Grow",
                modifier = Modifier.padding(start = 12.dp),
                fontSize = 15.sp,
                color = VidyasaarNavy.copy(alpha = 0.55f),
                fontWeight = FontWeight.Normal
            )

            // Component #3 — BrandDescription
            Spacer(
                modifier = Modifier.height(18.dp)
            )

            Text(
                text = "A smarter school for\na brighter tomorrow",
                modifier = Modifier.padding(start = 12.dp),
                fontSize = 16.sp,
                lineHeight = 23.sp,
                color = VidyasaarNavy.copy(alpha = 0.55f),
                fontWeight = FontWeight.Normal
            )

            // Component #4 — BlueAccentLine
            Spacer(
                modifier = Modifier.height(14.dp)
            )

            Box(
                modifier = Modifier
                    .padding(start = 12.dp)
                    .width(48.dp)
                    .height(4.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .background(VidyasaarBlue)
            )



        }


        // Component #5 — TopRightLeaves
        Image(
            painter = painterResource(R.drawable.leaf),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 10.dp)
                .size(
                    width = 105.dp,
                    height = 150.dp
                )
                .align(Alignment.TopEnd)
                .alpha(0.85f)
        )

//       Component #6 = TopRight text

        Image(
            painter = painterResource(R.drawable.logintextimage),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 115.dp)
                .padding(end = 35.dp)
                .size(
                    width = 100.dp,
                    height = 100.dp
                )
                .align(Alignment.TopEnd)
                .rotate(-10f)
                .alpha(0.7f)
        )

        Box(
            modifier = Modifier
                .size(
                    width = 200.dp,
                    height = 200.dp
                )
                .offset(
                    x = 240.dp,
                    y = -50.dp
                )
                .alpha(0.08f)
                .clip(CircleShape)
                .background(color = Color.Yellow)

        )
        Box(
            modifier = Modifier
                .size(
                    width = 320.dp,
                    height = 320.dp
                )
                .offset(
                    x = 140.dp,
                    y = -230.dp
                )
                .alpha(0.08f)
                .clip(CircleShape)
                .background(color = VidyasaarBlue)

        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(360.dp)
                .align(Alignment.BottomCenter)
        ) {
            // wave
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 250.dp
                )
                .clip(RoundedCornerShape(20.dp))
                .background(Color.White)
        ){

            Column(
                modifier = Modifier
                    .padding(start = 20.dp)
                    .padding(end = 20.dp)
                    .padding(top = 20.dp)
                    .padding(bottom = 20.dp)
            ) {
                Text(
                    text = "Welcome Back",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = VidyasaarNavy,

                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Sign in to Continue to Vidyasaar",
                    color = VidyasaarNavy.copy(alpha = 0.55f),
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp

                )

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = schoolId,
                    onValueChange = { schoolId = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),

                    placeholder = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.School,
                                contentDescription = null,
                                modifier = Modifier.size(21.dp),
                                tint = VidyasaarBlue
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "School ID",
                                fontSize = 14.sp,

                            )
                        }
                    },

                    singleLine = true,

                    shape = RoundedCornerShape(14.dp),

                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = VidyasaarBlue.copy(alpha = 0.06f),
                        unfocusedContainerColor = VidyasaarBlue.copy(alpha = 0.06f),
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )

                Spacer(modifier = Modifier.height(10.dp))

                ExposedDropdownMenuBox(
                    expanded = roleExpanded,
                    onExpandedChange = {
                        roleExpanded = !roleExpanded
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {

                    TextField(
                        value = role,
                        onValueChange = { },
                        readOnly = true,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .menuAnchor(),

                        placeholder = {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.SupervisorAccount,
                                    contentDescription = null,
                                    modifier = Modifier.size(21.dp),
                                    tint = VidyasaarBlue
                                )

                                Spacer(
                                    modifier = Modifier.width(10.dp)
                                )

                                Text(
                                    text = "Role",
                                    fontSize = 14.sp
                                )
                            }
                        },

                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(
                                expanded = roleExpanded
                            )
                        },

                        singleLine = true,

                        shape = RoundedCornerShape(14.dp),

                        colors = TextFieldDefaults.colors(
                            focusedContainerColor =
                                VidyasaarBlue.copy(alpha = 0.06f),

                            unfocusedContainerColor =
                                VidyasaarBlue.copy(alpha = 0.06f),

                            focusedIndicatorColor =
                                Color.Transparent,

                            unfocusedIndicatorColor =
                                Color.Transparent
                        )
                    )

                    ExposedDropdownMenu(
                        expanded = roleExpanded,
                        onDismissRequest = {
                            roleExpanded = false
                        }
                    ) {

                        val roles = listOf(
                            "STUDENT",
                            "TEACHER",
                            "STAFF",
                            "ADMIN"
                        )

                        roles.forEach { selectedRole ->

                            DropdownMenuItem(
                                text = {
                                    Text(selectedRole)
                                },
                                onClick = {
                                    role = selectedRole
                                    roleExpanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = userId,
                    onValueChange = { userId = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),

                    placeholder = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "User ID",
                                modifier = Modifier.size(21.dp),
                                tint = VidyasaarBlue
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "User ID",
                                fontSize = 14.sp,
                                color = VidyasaarNavy.copy(alpha = 0.55f)
                            )
                        }
                    },

                    singleLine = true,

                    shape = RoundedCornerShape(14.dp),

                    colors = TextFieldDefaults.colors(
                        focusedContainerColor =
                            VidyasaarBlue.copy(alpha = 0.06f),

                        unfocusedContainerColor =
                            VidyasaarBlue.copy(alpha = 0.06f),

                        focusedIndicatorColor =
                            Color.Transparent,

                        unfocusedIndicatorColor =
                            Color.Transparent
                    )
                )
                var visualTransformation =
                    if (passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation()


                // Component — Password Field
                Spacer(modifier = Modifier.height(10.dp))

                TextField(
                    value = password,
                    onValueChange = { password = it },

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),

                    placeholder = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Password",
                                modifier = Modifier.size(21.dp),
                                tint = VidyasaarBlue
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "Password",
                                fontSize = 14.sp,
                                color = VidyasaarNavy.copy(alpha = 0.55f)
                            )
                        }
                    },

                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.VisibilityOff,
                            contentDescription = "Show Password",
                            modifier = Modifier.size(21.dp),
                            tint = VidyasaarNavy.copy(alpha = 0.55f)
                        )
                    },

                    singleLine = true,

                    shape = RoundedCornerShape(14.dp),

                    colors = TextFieldDefaults.colors(
                        focusedContainerColor =
                            VidyasaarBlue.copy(alpha = 0.06f),

                        unfocusedContainerColor =
                            VidyasaarBlue.copy(alpha = 0.06f),

                        focusedIndicatorColor =
                            Color.Transparent,

                        unfocusedIndicatorColor =
                            Color.Transparent
                    )
                )


                // LOGIN BUTTON — PUT HERE
                Spacer(modifier = Modifier.height(18.dp))

                Button(
                    onClick = {
                        // Login action
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = VidyasaarBlue
                    )
                ) {
                    Text(
                        text = "Login",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Icon(
                        imageVector = Icons.Default.ArrowForward,
                        contentDescription = "Login",
                        modifier = Modifier.size(28.dp),
                        tint = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(7.dp))

            }

            }



            }


        }







@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        navController = rememberNavController()
    )
}
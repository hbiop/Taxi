package com.example.taxi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taxi.ui.theme.ButtonColor
import com.example.taxi.ui.theme.DrawerColor
import com.example.taxi.ui.theme.EditColor
import com.example.taxi.ui.theme.TaxiTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaxiTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "signin") {
                    composable("signin") { SignIn(navController) }
                    composable("registration") { Registration(navController) }
                    composable("mainscreen"){ StartScreen(navController)}
                    composable("history"){ History()}
                    composable("settings"){ Settings(navController)}
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SignIn(navController: NavController) {

        var message by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.back),
                    contentScale = ContentScale.FillBounds,
                    alpha = 0.4f
                ),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = EditColor
                ),
                value = message,
                onValueChange = { message = it },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, start = 20.dp, end = 20.dp),
                leadingIcon = { Icon(
                    painter = painterResource(id = R.drawable.log),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp))
                }

            )

            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = EditColor
                ),

                value = message,
                onValueChange = { message = it },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                leadingIcon = { Icon(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp))
                }
            )
            Text(
                text = "Forgot password?",
                modifier = Modifier.padding(bottom = 20.dp)
                    )
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
                onClick = {navController.navigate("mainscreen")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 100.dp, start = 20.dp, end = 20.dp),
                shape = RoundedCornerShape(60)
            ) {
                Text(text = "SIGN IN")
            }
            Text(text = "Create a New Account", modifier = Modifier
                .padding(bottom = 40.dp)
                .clickable { navController.navigate("registration") })
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Registration(navController: NavController)
    {
        var message by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.back),
                    contentScale = ContentScale.FillBounds,
                    alpha = 0.4f
                ),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = EditColor
                ),
                value = message,
                onValueChange = { message = it },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, start = 20.dp, end = 20.dp),
                leadingIcon = { Icon(
                    painter = painterResource(id = R.drawable.log),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp))
                }
            )
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = EditColor
                ),
                value = message,
                onValueChange = { message = it },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, start = 20.dp, end = 20.dp),
                leadingIcon = { Icon(
                    painter = painterResource(id = R.drawable.mail),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp))
                }

            )
            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = EditColor
                ),
                value = message,
                onValueChange = { message = it },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp, start = 20.dp, end = 20.dp),
                leadingIcon = { Icon(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp))
                }
            )

            TextField(
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    containerColor = EditColor
                ),
                value = message,
                onValueChange = { message = it },
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
                    .fillMaxWidth(),
                leadingIcon = { Icon(
                    painter = painterResource(id = R.drawable.password),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp))
                }
            )
            Button(
                colors = ButtonDefaults.buttonColors(containerColor = ButtonColor),
                onClick = {navController.navigate("mainscreen")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 100.dp, start = 20.dp, end = 20.dp),
                shape = RoundedCornerShape(60)
            ) {
                Text(text = "SIGN UP")
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun StartScreen(navController: NavController)
    {
        val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
        val scope = rememberCoroutineScope()
        ModalNavigationDrawer(drawerState = drawerState, modifier = Modifier.width(300.dp) ,scrimColor = DrawerColor,drawerContent = { Column {
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, top = 60.dp)){
                Image(painter = painterResource(id = R.drawable.user), contentDescription = "img", modifier = Modifier.size(40.dp))
                Column(modifier = Modifier.padding(start = 10.dp)) {
                    Text(text = "Ivanov Ivan", color = Color.White)
                    Text(text = "driver", color = Color.White)
                }

            }
            Row(modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.hist), contentDescription = "hist" )
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = DrawerColor, contentColor = Color.White),
                    onClick = {navController.navigate("history")}) {
                        Text(text = "history")
                }
            }
            Row(modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()) {
                Image(painter = painterResource(id = R.drawable.settings), contentDescription = "settings" )
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = DrawerColor, contentColor = Color.White),
                    onClick = {navController.navigate("settings")}) {
                    Text(text = "settings")
                }
            }
        } }) {

        }
        IconButton(onClick = { scope.launch { drawerState.apply { if (isClosed) {open()

        } else close() } }}) {
            Image(modifier = Modifier.size(100.dp),painter = painterResource(id = R.drawable.menu), contentDescription = "sdsd")
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun History()
    {
        Scaffold(

            topBar = { TopAppBar(navigationIcon = { Image(modifier = Modifier.size(20.dp),painter = painterResource(id = R.drawable.hist), contentDescription = "hist" )},colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = DrawerColor, titleContentColor = Color.White) ,title = { Text(text = "History")}) },
            content = { Column(modifier = Modifier.fillMaxSize()) {
            }}
        )
    }
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Settings(navController: NavController)
    {
        Scaffold(

            topBar = { TopAppBar(navigationIcon = { Image(modifier = Modifier.size(20.dp),painter = painterResource(id = R.drawable.settings), contentDescription = "hist" )},colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = DrawerColor, titleContentColor = Color.White) ,title = { Text(text = "Settings")}) },
            content = { Column(modifier = Modifier
                .fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.back),
                    contentScale = ContentScale.FillBounds,
                    alpha = 0.4f
                ), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {

                Text(text = "Ivanov Ivan",fontSize = 40.sp,modifier = Modifier.padding(bottom = 20.dp))
                Row(modifier = Modifier.padding(bottom = 20.dp))
                {
                    Text(text = "15 hours",fontSize = 20.sp)
                    Text(text = "$1510",fontSize = 20.sp, modifier = Modifier.padding(start = 10.dp))
                }
                Row(modifier = Modifier.padding(bottom = 100.dp))
                {
                    Text(text = "15 hours",fontSize = 20.sp)
                    Text(text = "$1510", fontSize = 20.sp, modifier = Modifier.padding(start = 10.dp))
                }
                Text(text = "E-mail: ivanov@gmail.com", modifier = Modifier.padding(bottom = 20.dp),fontSize = 20.sp)
                Button(modifier = Modifier.fillMaxWidth().padding(start = 20.dp,end = 20.dp,bottom = 100.dp),colors = ButtonDefaults.buttonColors(containerColor = DrawerColor, contentColor = Color.White),onClick = {navController.navigate("mainscreen")}) {
                    Text(text = "Exit")
                }
            }}
        )
    }
}
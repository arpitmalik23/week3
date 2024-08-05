package com.example.api_bkl


import PreviewMovieListScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppingapp.Screen


@Composable
fun nav(){

    val navcontroller = rememberNavController()
    NavHost(navController = (navcontroller), startDestination = Screen.MainScreen.route ){
        composable(route= Screen.MainScreen.route){
            MainScreen(navController = navcontroller)


        }

        composable(route = Screen.Trending.route){

            Trending( navcontroller)
        }

        composable(route= Screen.third.route){
            third(navcontroller)


        }
        composable(route= Screen.WatchLater.route){
            WatchLater(navcontroller)


        }


    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController){

    Column {


        Column(
            modifier = Modifier
                .padding(top = 42.dp)
                .fillMaxWidth()
                .height(450.dp)
                .background(color = Color.Black)
        ) {
            Button(onClick = {  } , enabled = false) {
                Text(text = "Home", fontSize = 30.sp, color = Color.White)

            }

            Spacer(modifier = Modifier.height(12.dp))

            Row() {


                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .width(250.dp)
                ) {

                    Firstimage()


                }

                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp), contentAlignment = Alignment.Center
                ) {

                    Button(onClick = {

                        navController.navigate(Screen.Trending.route)
                    }) {

                        Text(text = "Trending Movies", color = Color.White, fontSize = 20.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))


            Row(modifier = Modifier.fillMaxSize()) {
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .width(150.dp), contentAlignment = Alignment.Center
                ) {
                    Button(onClick = {

                        navController.navigate(Screen.Trending.route)
                    }) {
                        Text(text = "Popular Movies", color = Color.White, fontSize = 20.sp)
                    }
                }
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .width(300.dp)
                ) {
                    Secondimage()
                }
            }


        }
        Column(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black) , horizontalAlignment = Alignment.CenterHorizontally ) {


                    Text(text = "Movies for you", fontSize = 30.sp, color = Color.White)

            Row {
                Box(
                    modifier = Modifier
                        .height(250.dp)
                        .width(150.dp), contentAlignment = Alignment.Center
                ) {
                   Column {


                       Image(
                           painter = painterResource(id = R.drawable.img),
                           contentDescription = null,
                           contentScale = ContentScale.Fit,
                           modifier = Modifier.fillMaxSize(.7f)

                       )
                       Text(text = "  Intersteller", color = Color.White)
                   }
                    

                }
                Box(
                    modifier = Modifier
                        .height(250.dp)
                        .width(150.dp), contentAlignment = Alignment.Center
                ) {

                    Column {


                        Image(
                            painter = painterResource(id = R.drawable.img_1),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize(.7f)

                        )
                        Text(text = "  Inception", color = Color.White)
                    }

                }
                Box(
                    modifier = Modifier
                        .height(250.dp)
                        .width(150.dp), contentAlignment = Alignment.Center
                ) {


                    Column {


                        Image(
                            painter = painterResource(id = R.drawable.img_2),
                            contentDescription = null,
                            contentScale = ContentScale.Fit,
                            modifier = Modifier.fillMaxSize(.7f)

                        )
                        Text(text = " GodFather", color = Color.White)
                    }

                }
            }



        }
    }




}
@Composable
fun Trending(navcontroller: NavHostController) {

    PreviewMovieListScreen()

  Row(modifier = Modifier
      .fillMaxWidth()
      .padding(start = 250.dp, top = 300.dp)) {
      Button(onClick = {
          navcontroller.navigate(Screen.WatchLater.route)


      }) {
          Text(text = " GO To Watch later" , fontSize = 20.sp)

      }
  }



}

@Composable
fun third(navcontroller: NavHostController)
{
  PreviewMovieListScreen()
}
@Composable
fun WatchLater(navcontroller: NavHostController){
    
    Box ( modifier = Modifier.height(300.dp) ,contentAlignment = Alignment.Center){
        Text(text = "Watch Later", fontSize = 30.sp)



    }
    
    



}

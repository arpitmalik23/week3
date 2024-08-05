package com.example.api_bkl

import PreviewMovieListScreen
import SettingsRepository
import SettingsViewModel
import SettingsViewModelFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.activity.compose.setContent


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.Factory.Companion
import coil.compose.rememberImagePainter
import com.example.api_bkl.ui.theme.Api_bklTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var viewModel: SettingsViewModel



        val repository = SettingsRepository(context = this)


        viewModel = ViewModelProvider(this, SettingsViewModelFactory(repository)).get(SettingsViewModel::class.java)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Api_bklTheme {


            nav()





            }
        }
    }
}

@Composable
fun Firstimage(){
    Box(
        modifier = Modifier.fillMaxSize()

    ){
        val painter= rememberImagePainter(data = "https://tse2.mm.bing.net/th?id=OIP.10HvOdi78fxY-iyo4Y8MZgHaEK&pid=Api&P=0&h=180" , builder = {})


        Image(painter = painter, contentDescription = "1 image" ,Modifier.fillMaxSize(1f))


    }



}
@Composable
fun Secondimage(){
    Box(
        modifier = Modifier.fillMaxSize()

    ){
        val painter= rememberImagePainter(data = "https://tse1.mm.bing.net/th?id=OIP.Kts5b03i5QhemG6FG66d_QHaEo&pid=Api&P=0&h=180" , builder = {})


        Image(painter = painter, contentDescription = "1 image" ,Modifier.fillMaxSize(1f))


    }



}







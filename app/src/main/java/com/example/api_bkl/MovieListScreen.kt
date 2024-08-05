import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import coil.compose.rememberImagePainter
import com.example.api_bkl.moviejson
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel


@OptIn(ExperimentalMaterial3Api::class)
@JvmOverloads
@Composable
fun MovieListScreen(viewModel: MovieViewModel = MovieViewModel() ) {
    val movieSources by viewModel.movieSources

    Scaffold(
        topBar = {
            TopAppBar(

                title = {




                        Text(text = "Select The Movie  to Add to watch later", textAlign = TextAlign.Center)

                }
            )
        }
    ) { paddingValues ->
        MovieList(
            movieSources = movieSources,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun MovieList(movieSources: List<moviejson>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(movieSources) { source ->
            MovieItem(source)
        }
    }
}

@Composable
fun MovieItem(source: moviejson ) {




        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()) {

        Row {

            Column {


        Box(modifier = Modifier
            .height(100.dp)
            .width(100.dp)){
            val painter= rememberImagePainter(data =source.logo_100px , builder = {})


            Image(painter = painter, contentDescription = "1 image" ,Modifier.fillMaxSize(1f))


        }



                Text(text = source.name, style = MaterialTheme.typography.titleLarge)
                Text(text = source.type, style = MaterialTheme.typography.bodyMedium)
            }
            Spacer(modifier = Modifier.width(50.dp))



            var checkedState = remember { mutableStateOf(false) }


            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it })

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieListScreen() {

    MovieListScreen()
}




package com.danielcaballero.mynewcompose.basic_concepts

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import com.danielcaballero.mynewcompose.R

/**
 * LazyColumn ->  Vertical Scrolling
 * LazyRow -> Horizontal Scrolling
 * LazyVerticalGrid/ LazyHorizontalGrid -> Elements in cells
 * LazyVerticalGridFor -> Same as LazyVerticalGrid with diference allows u to
 * give an specific key for every element
 */
data class SuperHeroe(
    var superHeroeName: String,
    var realName: String,
    var publisher: String,
    @DrawableRes var photo: Int
)

fun getSuperHeroes(): List<SuperHeroe> = listOf(
    SuperHeroe("SpiderMan", "Peter Parker", "Marvel", R.drawable.spiderman),
    SuperHeroe("Wolverine", "Marvel", "DC", R.drawable.logan),
    SuperHeroe("Batman", "Bruce Wayne", "Dragoon Ball", R.drawable.batman),
    SuperHeroe("SpiderMan", "Thor Odison", "DC", R.drawable.thor),
    SuperHeroe("SpiderMan", "Peter Parker", "DC", R.drawable.spiderman),
    SuperHeroe("Wolverine", "DC", "Marvel", R.drawable.logan),
    SuperHeroe("Batman", "Bruce Wayne", "DC", R.drawable.batman),
    SuperHeroe("SpiderMan", "Thor Odison", "DC", R.drawable.thor)
)

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Aris", "Pepe", "Manolo", "Jaime")
    LazyColumn {
        item { Text(text = "Primer Item") }
        items(7) {
            Text(text = "Este es el item $it")
        }
        items(myList) {
            Text(text = "Hola me llamo $it")
        }
    }
}

@Composable
fun SuperHeroeWitSpecialControlsView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

//    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
//        items(getSuperHeroes()) { superHeroe ->
//            ItemHero(superHero = superHeroe)
//        }
//    }
    Column {
        LazyColumn(
            state = rvState, verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(getSuperHeroes()) { superHeroe ->
                ItemHero(superHero = superHeroe) {
                    Toast.makeText(context, it.superHeroeName, Toast.LENGTH_SHORT).show()
                }
            }
        }

        val isVisible by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }

        rvState.firstVisibleItemScrollOffset

        if (isVisible) {
            Button(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(text = "Boton")
            }
        }


    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroeStickyView() {
//    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
//        items(getSuperHeroes()) { superHeroe ->
//            ItemHero(superHero = superHeroe)
//        }
//    }
    val superHeroe: Map<String, List<SuperHeroe>> = getSuperHeroes().groupBy { it.publisher }
    val context = LocalContext.current

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        superHeroe.forEach { (publisher, mySuperHeroe) ->

            stickyHeader {
                Text(
                    text = publisher, modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green), fontSize = 16.sp, color = Color.White
                )
            }

            items(mySuperHeroe) { superHeroe ->
                ItemHero(superHero = superHeroe) {
                    Toast.makeText(
                        context,
                        it.superHeroeName,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}

@Composable
@Preview
fun SuperHeroeView() {
//    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
//        items(getSuperHeroes()) { superHeroe ->
//            ItemHero(superHero = superHeroe)
//        }
//    }
    val context = LocalContext.current
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroes()) { superHeroe ->
            ItemHero(superHero = superHeroe) {
                Toast.makeText(
                    context,
                    it.superHeroeName,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

}

@Composable
fun SuperHeroeGridView() {
//    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)){
//        items(getSuperHeroes()) { superHeroe ->
//            ItemHero(superHero = superHeroe)
//        }
//    }
    val context = LocalContext.current
//    LazyVerticalGrid(GridCells.Adaptive(50.dp), content = {
    LazyVerticalGrid(GridCells.Fixed(2), content = {
        items(getSuperHeroes()) { superHeroe ->
            ItemHero(superHero = superHeroe) {
                Toast.makeText(
                    context,
                    it.superHeroeName,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    })

//    }, contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp))


}

@Composable
fun ItemHero(superHero: SuperHeroe, onItemSelected: (SuperHeroe) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier
        .fillMaxWidth()
        .clickable { onItemSelected(superHero) }
        .padding(vertical = 8.dp, horizontal = 8.dp)) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "SuperHeroe Avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(text = superHero.superHeroeName, modifier = Modifier.align(CenterHorizontally))
            Text(
                text = superHero.realName,
                modifier = Modifier.align(CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp)
            )

        }

    }
}




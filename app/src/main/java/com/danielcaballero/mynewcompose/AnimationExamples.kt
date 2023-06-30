package com.danielcaballero.mynewcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

@Composable
fun ColorAnimationSimple() {
    Column() {

        var firstColor by rememberSaveable {
            mutableStateOf(false)
        }

        var realColor = if (firstColor) Color.Red else Color.Yellow

        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor }
        )

        Spacer(modifier = Modifier.size(200.dp))

        var secondColor by rememberSaveable {
            mutableStateOf(false)
        }

        val realColor2 by animateColorAsState(targetValue = if (secondColor) Color.Red else Color.Yellow)

        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor2)
            .clickable { secondColor = !secondColor }
        )
    }
}

@Composable
fun ColorAnimationPro() {
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }
    var showBox by rememberSaveable {
        mutableStateOf(true)
    }
    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Yellow,
        animationSpec = tween(durationMillis = 2000),
        finishedListener = { showBox = false }
    )
    if (showBox) {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor }
        )
    }
}

@Composable
fun SizeAnimation() {
    var smallsize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallsize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 1000),
        finishedListener = {
            if (!smallsize) {
            }
        }
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { smallsize = !smallsize })
}

@Composable
fun VisibilityAnimation() {

    var isVisible by remember {
        mutableStateOf(true)
    }
    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Mostrat/Ocultar")
        }

        Spacer(modifier = Modifier.size(50.dp))

        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }

    }


}

@Composable
fun CrossFadeExampleAnimation() {
    var myComponentType: ComponentType by remember {
        mutableStateOf(ComponentType.Text)
    }
    Column(Modifier.fillMaxSize()) {

        Button(onClick = { myComponentType = getComponentType() }) {
            Text(text = "Cambiar componente")
        }


        Crossfade(targetState = myComponentType) {
            when (it) {
                ComponentType.Image -> Icon(Icons.Default.AccountBox, contentDescription = "")
                ComponentType.Text -> Text(text = "SO")
                ComponentType.Box -> Box(
                    Modifier
                        .size(150.dp)
                        .background(Color.Red)
                )

                ComponentType.Error -> Text(text = "ERRORR")
            }
        }
    }

}

fun getComponentType(): ComponentType {
    val myNumber = nextInt(from = 0, until = 3)

    return when (myNumber) {
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}


enum class ComponentType() {
    Image, Text, Box, Error
}
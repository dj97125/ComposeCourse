package com.danielcaballero.mynewcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TweetDivider(){
    Divider(
        Modifier
            .height(2.dp)
            .padding(top = 4.dp)
            .fillMaxSize(),
        color = Color(0XFF7E8B98)
    )
}


@Composable
@Preview
fun TwiterPost() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        HeaderPost(Modifier.align(Alignment.TopStart))

    }
}

@Composable
fun HeaderPost(modifier: Modifier) {

    Row {
        Spacer(
            Modifier
                .size(5.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "logo",
            modifier = modifier
                .size(55.dp)
                .clip(CircleShape)
                .padding(top = 5.dp)
        )


        Column {
            Row() {
                Text(
                    text = "Aris",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .weight(.5f)
                        .padding(start = 60.dp)
                        .align(Alignment.CenterVertically),
                    color = Color(0xFFFDFDFD)
                )
                Text(
                    text = "@AristiDevs 4h",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    color = Color(0xFF929292)
                )

//                Spacer(modifier = Modifier.weight(1f))

                Image(
                    painter = painterResource(id = R.drawable.ic_dots),
                    contentDescription = "dots",
                    modifier = modifier
                        .size(24.dp)
                        .weight(2f)
                        .align(Alignment.CenterVertically)
                        .padding(end = 8.dp)
                )
            }

            Spacer(
                Modifier
                    .size(5.dp)
            )

            Text(
                text = "Descripcion Larga, Descripcion Larga",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .align(CenterHorizontally),
                color = Color(0xFFFDFDFD)
            )
            Text(
                text = "Descripcion Larga, Descripcion Larga",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .align(CenterHorizontally),
                color = Color(0xFFFDFDFD)
            )
            Text(
                text = "Descripcion Larga, Descripcion Larga",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .align(CenterHorizontally),
                color = Color(0xFFFDFDFD)
            )
            Text(
                text = "Descripcion Larga, Descripcion Larga",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .align(CenterHorizontally),
                color = Color(0xFFFDFDFD)
            )
            Text(
                text = "Descripcion Larga, Descripcion Larga",
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
                    .align(CenterHorizontally),
                color = Color(0xFFFDFDFD)
            )
            Spacer(
                Modifier
                    .size(20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "avatar",
                modifier = Modifier
                    .clip(RoundedCornerShape(10))
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            var fillVisibilityChat by remember { mutableStateOf(false) }
            var fillVisibilityRt by remember { mutableStateOf(false) }
            var fillVisibilityLike by remember { mutableStateOf(false) }

            var imageChat by remember { mutableStateOf(R.drawable.ic_chat) }
            var imageRt by remember { mutableStateOf(R.drawable.ic_rt) }
            var imageLike by remember { mutableStateOf(R.drawable.ic_like) }


            var reactionChat by remember { mutableStateOf("1") }
            var reactionRt by remember { mutableStateOf("1") }
            var reactionLike by remember { mutableStateOf("1") }

            if (fillVisibilityChat) {
                imageChat = R.drawable.ic_chat_filled
                reactionChat = "2"

            } else {
                imageChat = R.drawable.ic_chat
                reactionChat = "1"
            }

            if (fillVisibilityRt) {
                imageRt = R.drawable.ic_rt_filled
                reactionRt = "2"

            } else {
                imageRt = R.drawable.ic_rt
                reactionRt = "1"
            }

            if (fillVisibilityLike) {
                imageLike = R.drawable.ic_like_filled
                reactionLike = "2"

            } else {
                imageLike = R.drawable.ic_like
                reactionLike = "1"
            }



            Row(Modifier.align(CenterHorizontally)) {
                IconButton(onClick = {
                    fillVisibilityChat = !fillVisibilityChat
                }) {
                    Icon(
                        painter = painterResource(id = imageChat),
                        contentDescription = "chatLogo",
                        modifier = Modifier.weight(1f)
                    )
                }
                Text(
                    text = reactionChat,
                    Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterVertically),
                    fontSize = 12.sp,
                    color = Color(0xFFFEFFFF)
                )

                IconButton(onClick = {
                    fillVisibilityRt = !fillVisibilityRt
                }) {
                    Icon(
                        painter = painterResource(id = imageRt),
                        contentDescription = "rtLogo",
                        modifier = Modifier.weight(1f)
                    )
                }
                Text(
                    text = reactionRt,
                    Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterVertically),
                    fontSize = 12.sp,
                    color = Color(0xFFFEFFFF)
                )

                IconButton(onClick = {
                    fillVisibilityLike = !fillVisibilityLike
                }) {
                    Icon(
                        painter = painterResource(id = imageLike),
                        contentDescription = "likeLogo",
                        modifier = Modifier.weight(1f)
                    )
                }
                Text(
                    text = reactionLike,
                    Modifier
                        .padding(vertical = 4.dp)
                        .align(Alignment.CenterVertically),
                    fontSize = 12.sp,
                    color = Color(0xFFFEFFFF)
                )


            }


        }
    }

}
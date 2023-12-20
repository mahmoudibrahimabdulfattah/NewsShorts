package com.example.newsinshort.ui.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsinshort.R
import com.example.newsinshort.data.entity.Articles
import com.example.newsinshort.data.entity.NewsResponse
import com.example.newsinshort.ui.theme.Purple40

@Composable
fun Loader() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
    }
}


@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        fontSize = 18.sp,
        modifier = Modifier.padding(8.dp),
        color = Purple40,
        fontWeight = FontWeight.Normal
    )
}

@Composable
fun HadingTextComponent(value: String) {
    Text(
        text = value, fontSize = 20.sp, color = Color.Black,
        modifier = Modifier.padding(8.dp),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun NewsRowComponent(article: Articles?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(240.dp),
            model = article?.urlToImage,
            contentDescription = "",
            contentScale = ContentScale.Fit,
            placeholder = painterResource(id = R.drawable.ic_placeholder_imae),
            error = painterResource(id = R.drawable.ic_placeholder_imae)
        )

        Spacer(modifier = Modifier.size(20.dp))

        HadingTextComponent(article?.title ?: "")

        Spacer(modifier = Modifier.size(20.dp))

        NormalTextComponent(article?.description ?: "")

        Spacer(modifier = Modifier.weight(1f))

        AuthorDetailsComponent(article?.author, article?.source?.name)
    }
}

@Composable
fun AuthorDetailsComponent(authorName: String?, authorSource: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp, bottom = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        authorName?.also {
            Text(text = it)
        }
        authorSource?.also {
            Text(text = it)
        }
    }

}
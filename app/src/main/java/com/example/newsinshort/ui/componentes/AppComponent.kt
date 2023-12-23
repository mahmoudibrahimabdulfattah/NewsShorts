package com.example.newsinshort.ui.componentes

import androidx.compose.foundation.Image
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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsinshort.R
import com.example.newsinshort.data.entity.Articles
import com.example.newsinshort.ui.theme.NewsInShortTheme
import com.example.newsinshort.ui.theme.OnPrimaryColor
import com.example.newsinshort.ui.theme.PrimaryColor

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
        color = PrimaryColor,
        fontWeight = FontWeight.Normal

    )
}

@Composable
fun HadingTextComponent(value: String) {
    Text(
        text = value, fontSize = 20.sp,
        color = OnPrimaryColor,
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
            .background(MaterialTheme.colorScheme.background)
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
            Text(
                text = it,
                color = MaterialTheme.colorScheme.secondary
            )
        }
        authorSource?.also {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }

}


@Composable
fun IsError() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_no_internet),
            contentDescription = "Check Your Internet!"
        )
        Text(text = "Check Your Internet!")
    }
}

@Preview(showBackground = true)
@Composable
fun DesignPreview() {
    NewsInShortTheme {
        IsError()
    }
}
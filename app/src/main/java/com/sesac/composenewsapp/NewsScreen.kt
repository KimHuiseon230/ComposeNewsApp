package com.sesac.composenewsapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsScreen(viewModel: NewsViewModel = viewModel()) {
    val newsList by viewModel.newsList.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchNews()
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text("News App") }) }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(newsList) { article ->
                NewsItem(article)
            }
        }
    }
}

@Composable
fun NewsItem(article: Article) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            article.urlToImage?.let { imageUrl ->
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()
                )
            }
            Text(text = article.title, style = MaterialTheme.typography.titleMedium)
            Text(
                text = article.description ?: "No description",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

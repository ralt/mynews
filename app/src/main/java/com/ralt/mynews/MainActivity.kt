package com.ralt.mynews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ralt.mynews.ui.feed.NewsFeedScreen
import com.ralt.mynews.ui.feed.NewsFeedViewModel
import com.ralt.mynews.ui.theme.MyNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val appModule = (application as MyNewsApplication).appModule
        setContent {
            MyNewsTheme {
                val viewModel: NewsFeedViewModel = viewModel(
                    factory = NewsFeedViewModel.Factory(appModule.newsRepository)
                )
                NewsFeedScreen(viewModel = viewModel)
            }
        }
    }
}

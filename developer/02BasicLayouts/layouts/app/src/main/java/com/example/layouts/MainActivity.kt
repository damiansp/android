package com.example.layouts

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.Size
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.layouts.ui.theme.LayoutsTheme

class MainActivity: ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val windowSizeClass = calculateWindowSizeClass(this)
            SootheApp(windowSizeClass)
            /*
            LayoutsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }
            */
        }
    }
}


@Composable
fun SootheApp(windowSize: WindowSizeClass) {
    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> { SootheAppPortrait() }
        WinodwWidthSizeClass.Expanded -> { SootheAppLandscape() }
    }
}


@Composable
fun SootheAppPortrait() {
    LayoutsTheme {
        Scaffold(bottomBar = { SootheBottomNavigation() }) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(Modifier.height(16.dp))
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            FavoriteCollectionsGrid()
        }
        Spacer(Modifier.height(16.dp))
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE, heightDp = 180)
@Composable
fun HomeScreenPreview() {
    LayoutsTheme {
        HomeScreen()
    }
}


@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.surface,
            focusedContainerColor = MaterialTheme.colorScheme.surface),
        placeholder = { Text(stringResource(R.string.search)) },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp))
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun SearchBarPreview() {
    LayoutsTheme { SearchBar(Modifier.padding(8.dp)) }
}


@Composable
fun HomeSection(
        @StringRes title: Int, modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(modifier) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp))
        content()
    }
}


@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun HomeSectionPreview() {
    LayoutsTheme {
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
    }
}


@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 16.dp),
            modifier = modifier) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(drawable = item.drawable, text = item.text)
        }
    }
}


@Composable
fun AlignYourBodyElement(
        @DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape))
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun AlignYourBodyElementPreview() {
    LayoutsTheme {
        AlignYourBodyElement(
            drawable = R.drawable.ab1_inversions,
            text = R.string.ab1_inversions,
            modifier = Modifier.padding(8.dp))
    }
}


@Composable
fun FavoriteCollectionsGrid(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.height(168.dp)) {
        items(favoriteCollectionsData) { item ->
            FavoriteCollectionCard(drawable = item.drawable, text = item.text)
        }
    }
}

@Composable
fun FavoriteCollectionCard(
        @DrawableRes drawable: Int, @StringRes text: Int, modifier: Modifier = Modifier) {
    Surface(shape = MaterialTheme.shapes.medium, modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.width(255.dp)) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp))
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun FavoriteCollectionCardPreview() {
    LayoutsTheme {
        FavoriteCollectionCard(
            text = R.string.fc2_nature_meditations,
            drawable = R.drawable.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp))
    }
}


@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(containerColor = MaterialTheme.colorScheme.surfaceVariant, modifier = modifier) {
        NavigationBarItem(
            selected = true,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
            label = { Text(text= stringResource(R.string.bottom_nav_home)) })
        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text(text= stringResource(R.string.bottom_nav_profile)) })
    }
}


@Composable
fun SootheAppLandscape() {
    LayoutsTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            Row {
                SootheNavigationRail()
                HomeScreen()
            }
        }
    }
}


@Composable
private fun SootheNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(
            modifier = modifier.padding(start = 8.dp, end = 8.dp),
            containerColor = MaterialTheme.colorScheme.background) {
        Column(
                modifier = modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
            NavigationRailItem(
                selected = true,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = Icons.Default.Home, contentDescription = null) },
                label = { Text(stringResource(R.string.bottom_nav_home)) })
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },
                label = { Text(stringResource(R.string.bottom_nav_profile)) })
        }
    }
}
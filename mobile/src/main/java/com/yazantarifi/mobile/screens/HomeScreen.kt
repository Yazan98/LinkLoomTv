package com.yazantarifi.mobile.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yazantarifi.linkloom.mobile.R
import com.yazantarifi.mobile.RedPrimary

class HomeScreen: ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black)
                    .padding(30.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Link Loom Mobile Application", color = RedPrimary)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Share Websites Links Directly to TV", color = Color.White)
                }
                
                Column(modifier = Modifier.fillMaxWidth()) {
                    var websiteLink by remember { mutableStateOf("") }
                    OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = websiteLink, onValueChange = {
                        websiteLink = it
                    }, placeholder = {
                        Text(text = "Example (www.example.com)")
                    }, label = {
                        Text(text = "Website Url", color = Color.White)
                    }, colors = TextFieldDefaults.textFieldColors(focusedTextColor = Color.Black))

                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        modifier = Modifier,
                        onClick = {

                        }
                    ) {
                        Text(text = getString(R.string.add_new), color = Color.White, modifier = Modifier.background(Color.Transparent))
                    }
                }

                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "Link Loom Work only with Link Loom TV Application", color = Color.White)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Make Sure All Devices Connected to Same Network", color = Color.Gray)
                }
            }
        }
    }
}
package com.example.funfact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.funfact.ui.theme.FunFactTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FunFactTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.primary,
                            ),
                            title = {
                                Text("")
                            }
                        )
                    }
                    ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ){
                        Fact()
                    }

                }
            }
        }
    }
}


@Composable
fun Fact(){
    fun randnum(from:Int, to:Int):Int{
        return (from..to).random();
    }
    // Facts from https://www.sciencefocus.com/science/fun-facts
    var quotes = arrayOf("A cloud weighs around a million tonnes. A cloud typically has a volume of around 1km3 and a density of around 1.003kg per m3 – that's a density that’s around 0.4 per cent lower than the air surrounding it (this is how they are able to float).",
        "Giraffes are 30 times more likely to get hit by lightning than people. True, there are only five well-documented fatal lightning strikes on giraffes between 1996 and 2010. But due to the population of the species being just 140,000 during this time, it makes for about 0.003 lightning deaths per thousand giraffes each year. This is 30 times the equivalent fatality rate for humans.",
        "Identical twins don’t have the same fingerprints. You can’t blame your crimes on your twin, after all. This is because environmental factors during development in the womb (umbilical cord length, position in the womb, and the rate of finger growth) impact your fingerprint.",
        "Earth’s rotation is changing speed. It's actually slowing. This means that, on average, the length of a day increases by around 1.8 seconds per century. 600 million years ago a day lasted just 21 hours.",
        "Your brain is constantly eating itself. This process is called phagocytosis, where cells envelop and consume smaller cells or molecules to remove them from the system. Don’t worry! Phagocytosis isn't harmful, but actually helps preserve your grey matter.",
        "The largest piece of fossilised dinosaur poo discovered is over 30cm long and over two litres in volume. Believed to be a Tyrannosaurus rex turd, the fossilised dung (also named a 'coprolite') is helping scientists better understand what the dinosaur ate.")
    var temp by remember { mutableStateOf(0) }

    Column (modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,){

        Row(){
           Text("Facts from https://www.sciencefocus.com/science/fun-facts\n",
               color= Color.Red, fontSize=20.sp,
               fontStyle = androidx.compose.ui.text.font.FontStyle.Italic, fontWeight = FontWeight.Bold)
        }

        Row(){
            Text(quotes[temp], color= Color.Blue, fontSize=20.sp,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
        }
        Row(){
            TextButton(
                onClick = {
                    temp = temp+1
                    if (temp >= quotes.size){
                        temp=0
                    }
                }
            ) {
                Text("Next Fact", color = Color.Black, fontSize = 30.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}



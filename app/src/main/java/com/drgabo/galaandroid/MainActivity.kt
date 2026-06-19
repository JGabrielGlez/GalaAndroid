package com.drgabo.galaandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity(){
     override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(
            savedInstanceState
        )
        setContent{
            //aquí ya se pueden empezar a llamar elementos composables para construir la app
            MaterialTheme(){
                Greetin("Soy Gabriel ")
            }
        }
    }
}

@Composable
fun Greetin(name:String){
        Text(text = "oHola mundo $name")
}

@Preview
@Composable
fun PreviewRange(){
    Greetin("Gabriel")
}
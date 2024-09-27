
package com.example.waterfootprint

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.sp
import com.example.myfirstapp.scanner.R

data class WaterFootprintInputs(
    val cerealKgPerWeek: Float,
    val meatKgPerWeek: Float,
    val dairyKgPerWeek: Float,
    val eggsPerWeek: Int,
    val coffeeCupsPerDay: Int,
    val teaCupsPerDay: Int,
    val showersPerDay: Int,
    val showerDurationMin: Float,
    val showerHeadType: String,
    val bathsPerWeek: Int,
    val brushShavePerDay: Int,
    val tapRunningWhenBrushing: Boolean,
    val laundryLoadsPerWeek: Int
)

@Composable
fun WaterFootprintCalculator() {
    Box(modifier = Modifier.fillMaxSize()){

        Image(
            painter = painterResource(id = R.drawable.weather5),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        var inputs by remember {
            mutableStateOf(
                WaterFootprintInputs(
                    cerealKgPerWeek = 0f,
                    meatKgPerWeek = 0f,
                    dairyKgPerWeek = 0f,
                    eggsPerWeek = 0,
                    coffeeCupsPerDay = 0,
                    teaCupsPerDay = 0,
                    showersPerDay = 0,
                    showerDurationMin = 0f,
                    showerHeadType = "Standard",
                    bathsPerWeek = 0,
                    brushShavePerDay = 0,
                    tapRunningWhenBrushing = false,
                    laundryLoadsPerWeek = 0
                )
            )
        }

        var results by remember { mutableStateOf<Map<String, Float>>(emptyMap()) }

        Column(
            modifier = Modifier
                .padding(16.dp)
                //    .background(Color.Cyan)
                .padding(start = 20.dp)
                .fillMaxWidth()
        ) {

            LazyColumn {
                item {
                    Spacer(modifier = Modifier.height(35.dp))

                    Text(
                        "Water Footprint",
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 40.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )


                    Text(
                        "   Calculator ",
                        style = MaterialTheme.typography.headlineLarge,
                        fontSize = 45.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(25.dp))



                    Spacer(modifier = Modifier.height(25.dp))

                    InputField("Cereal (kg per week) ", inputs.cerealKgPerWeek ) { value ->
                        inputs = inputs.copy(cerealKgPerWeek = value)
                    }

                    Spacer(modifier = Modifier.height(25.dp))
                    InputField("Meat (kg per week)", inputs.meatKgPerWeek) { value ->
                        inputs = inputs.copy(meatKgPerWeek = value)
                    }

                    Spacer(modifier = Modifier.height(25.dp))
                    InputField("Dairy (kg per week)", inputs.dairyKgPerWeek) { value ->
                        inputs = inputs.copy(dairyKgPerWeek = value)
                    }

                    Spacer(modifier = Modifier.height(25.dp))
                    InputField("Eggs (number per week)", inputs.eggsPerWeek) { value ->
                        inputs = inputs.copy(eggsPerWeek = value)
                    }

                    Spacer(modifier = Modifier.height(25.dp))
                    InputField("Coffee cups per day", inputs.coffeeCupsPerDay) { value ->
                        inputs = inputs.copy(coffeeCupsPerDay = value)
                    }

                    Spacer(modifier = Modifier.height(25.dp))
                    InputField("Tea cups per day", inputs.teaCupsPerDay) { value ->
                        inputs = inputs.copy(teaCupsPerDay = value)
                    }

                    Spacer(modifier = Modifier.height(25.dp))
                    InputField("Showers per day", inputs.showersPerDay) { value ->
                        inputs = inputs.copy(showersPerDay = value)
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    InputField("Shower duration (minutes)", inputs.showerDurationMin) { value ->
                        inputs = inputs.copy(showerDurationMin = value)
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    Text("Shower head type :", fontSize = 25.sp, fontWeight = FontWeight.Bold)

                    Spacer(modifier = Modifier.height(28.dp))

                    Row {
                        Text("Standard" , color = Color.White , fontWeight = FontWeight.Bold)
                        RadioButton(
                            selected = inputs.showerHeadType == "Standard",
                            onClick = { inputs = inputs.copy(showerHeadType = "Standard") }
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Row {
                        Text("Low-flow" , color = Color.White , fontWeight = FontWeight.Bold)
                        RadioButton(
                            selected = inputs.showerHeadType == "Low-flow",
                            onClick = { inputs = inputs.copy(showerHeadType = "Low-flow") }
                        )
                    }


                    Spacer(modifier = Modifier.height(25.dp))

                    InputField("Baths per week", inputs.bathsPerWeek) { value ->
                        inputs = inputs.copy(bathsPerWeek = value)
                    }
                    Spacer(modifier = Modifier.height(15.dp))

                    InputField("Brush/Shave per day", inputs.brushShavePerDay) { value ->
                        inputs = inputs.copy(brushShavePerDay = value)
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    Row(modifier = Modifier.padding(vertical = 8.dp)) {
                        Text("Tap running when brushing?"  , fontWeight = FontWeight.Bold , fontSize = 20.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Checkbox(
                            checked = inputs.tapRunningWhenBrushing,
                            onCheckedChange = { checked ->
                                inputs = inputs.copy(tapRunningWhenBrushing = checked)
                            }
                        )
                    }
                    InputField("Laundry loads per week", inputs.laundryLoadsPerWeek) { value ->
                        inputs = inputs.copy(laundryLoadsPerWeek = value)
                    }


                    Spacer(modifier = Modifier.height(25.dp))

                    Button(modifier = Modifier.height(60.dp).width(350.dp).border(10.dp , colorResource(R.color.apna), RoundedCornerShape(1.dp)), onClick = {
                        results = calculateWaterFootprint(inputs)
                    } ,
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.apna) , contentColor = colorResource(R.color.white))) {
                        Text("Calculate Water Footprint" )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    results.forEach { (label, value) ->
                        Text(
                            "$label: ${"%.2f".format(value)} liters",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = Color.White ,
                                fontSize = 24.sp ,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }

        }
    }
}

@Composable
fun InputField(label: String, value: Float, onValueChange: (Float) -> Unit) {
    Box(
        modifier = Modifier
            .padding(4.dp) // Add padding to ensure the text field fits well inside the box
    ) {
        OutlinedTextField(
            value = value.toString(),
            onValueChange = { newValue ->
                newValue.toFloatOrNull()?.let { onValueChange(it) }
            },
            label = { Text(label, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 20.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
//
        )
    }
}


@Composable
fun InputField(label: String, value: Int, onValueChange: (Int) -> Unit) {
    OutlinedTextField(
        value = value.toString(),
        onValueChange = { newValue ->
            newValue.toIntOrNull()?.let { onValueChange(it) }
        },
        label = { Text(label , color = Color.White , fontWeight = FontWeight.Bold , fontSize = 20.sp)  },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

fun calculateWaterFootprint(inputs: WaterFootprintInputs): Map<String, Float> {
    val cerealWaterFootprint = inputs.cerealKgPerWeek * 1800f // Liters per kg
    val meatWaterFootprint = inputs.meatKgPerWeek * 15000f // Liters per kg
    val dairyWaterFootprint = inputs.dairyKgPerWeek * 1000f // Liters per kg
    val eggsWaterFootprint = inputs.eggsPerWeek * 3300f // Liters per kg

    val coffeeWaterFootprint = inputs.coffeeCupsPerDay * 140f // Liters per cup
    val teaWaterFootprint = inputs.teaCupsPerDay * 40f // Liters per cup

    val showerWaterFootprint = when (inputs.showerHeadType) {
        "Low-flow" -> inputs.showerDurationMin * 6 * inputs.showersPerDay
        else -> inputs.showerDurationMin * 9 * inputs.showersPerDay
    }
    val bathWaterFootprint = inputs.bathsPerWeek * 175f // Average liters per bath
    val brushingWaterFootprint = if (inputs.tapRunningWhenBrushing) inputs.brushShavePerDay * 10f else 0f

    val laundryWaterFootprint = inputs.laundryLoadsPerWeek * 50f // Example value

    return mapOf(
        "Cereal" to cerealWaterFootprint,
        "Meat" to meatWaterFootprint,
        "Dairy" to dairyWaterFootprint,
        "Eggs" to eggsWaterFootprint,
        "Coffee" to coffeeWaterFootprint,
        "Tea" to teaWaterFootprint,
        "Showers" to showerWaterFootprint,
        "Baths" to bathWaterFootprint,
        "Brushing" to brushingWaterFootprint,
        "Laundry" to laundryWaterFootprint
    )
}



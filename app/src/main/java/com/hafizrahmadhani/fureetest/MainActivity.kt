package com.hafizrahmadhani.fureetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hafizrahmadhani.fureetest.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FureeTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CallAllLayout()
                }
            }
        }
    }
}

@Composable
fun AppBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 22.dp, horizontal = 20.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
        Card(shape = RoundedCornerShape(8.dp), border = BorderStroke(1.dp, color = Color.Gray)) {
            Icon(Icons.Filled.Menu ,contentDescription = null, modifier = Modifier.padding(8.dp))
        }
        Text(
            text = "Appointment",
            fontFamily = poppins,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )
        Card(shape = RoundedCornerShape(8.dp), border = BorderStroke(1.dp, color = Color.Gray)) {
            Icon(Icons.Outlined.Notifications ,contentDescription = null, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ProfileLayout(){
    Card(shape = RoundedCornerShape(12.dp), modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp), backgroundColor = DarkBlue) {
        Row(modifier = Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.doctor_picture), contentDescription = "Profile Picture", modifier = Modifier
                .size(85.dp)
                .clip(
                    CircleShape
                ), contentScale = ContentScale.Crop)
            Column(modifier = Modifier.padding(start = 20.dp)) {
                Text(
                    text = "Dr. Corrie Anderson",
                    fontSize = 15.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )
                Text(
                    text = "Cardiovascular",
                    fontSize = 13.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "01 hour consultation",
                    fontSize = 14.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun CostLayout(){
    Card(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        backgroundColor = Color.White
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = "Appointment Cost",
                    fontFamily = poppins,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "$95.00",
                    fontFamily = poppins,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Consultation fee for 01 hour",
                fontFamily = poppins,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "Admin Fee",
                    fontFamily = poppins,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "$05.00",
                    fontFamily = poppins,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    text = "To Pay",
                    fontFamily = poppins,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "$100.00",
                    fontFamily = poppins,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Divider(thickness = 1.dp, color = Color.LightGray)
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = { /*WillLinkToPromoCodeScreen*/ },
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = LightOrange),
                border = BorderStroke(width = 1.dp, color = Orange)
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                    Icon(painter = painterResource(id = R.drawable.promo), contentDescription = "null", tint = Orange)
                    Text(
                        text = "Use Promo Code",
                        fontFamily = poppins,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Icon(painter = painterResource(id = R.drawable.right_arrow), contentDescription = "null", tint = Orange)
                }
            }
        }
    }
}

@Composable
fun PaymentLayout(){
    val statusPayment = remember { mutableStateOf("Paypal")}
    
    Card(modifier = Modifier
        .padding(horizontal = 20.dp)
        .fillMaxWidth(),shape = RoundedCornerShape(12.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Payment Options",
                fontFamily = poppins,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))
            Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), border = BorderStroke(1.dp, color = Color.LightGray)) {
                Column{
                    Row(modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Row {
                            RadioButton(
                                selected = statusPayment.value == "Paypal",
                                onClick = { statusPayment.value = "Paypal" },
                                colors = RadioButtonDefaults.colors(DarkBlue))
                            Text(
                                text = "Paypal",
                                fontFamily = poppins,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        }
                        Image(painter = painterResource(id = R.drawable.paypal), contentDescription = "Paypal", modifier = Modifier.width(70.dp).padding(end = 6.dp))
                    }
                    Divider(thickness = 1.dp, color = Color.LightGray)
                    Row(modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Row {
                            RadioButton(
                                selected = statusPayment.value == "Credit Card",
                                onClick = { statusPayment.value = "Credit Card" },
                                colors = RadioButtonDefaults.colors(DarkBlue))
                            Text(
                                text = "Credit Card",
                                fontFamily = poppins,
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.padding(start = 10.dp)
                            )
                        }
                        Image(painter = painterResource(id = R.drawable.credit_card), contentDescription = "Visa Mastercard", modifier = Modifier.width(110.dp).padding(end = 6.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonPay(){
    Button(
        onClick = { /*WillLinkToPaymentScreen*/ },
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Orange)
    ) {
        Text(
            text = "Pay & Confirm",
            textAlign = TextAlign.Center,
            fontFamily = poppins,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            color = Color.White,
            modifier = Modifier.padding(4.dp)
        )
    }
}

@Composable
fun CallAllLayout(){
    val scrollState =  rememberScrollState()
    Column(
        Modifier
            .verticalScroll(scrollState)
            .fillMaxSize()
            .background(color = BoneWhite)) {
        AppBar()
        ProfileLayout()
        CostLayout()
        PaymentLayout()
        ButtonPay()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FureeTestTheme {
        CallAllLayout()
    }
}
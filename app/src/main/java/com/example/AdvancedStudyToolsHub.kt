package com.example

import android.content.Context
import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.*

// ==============================================================================
// 🌟 FEATURE 2: INTERACTIVE FORMULA & MATH/PHYSICS STEP-BY-STEP SOLVER
// ==============================================================================

enum class SolverCategory(val titleSinhala: String, val icon: String, val color: Color) {
  QUADRATIC("වර්ගජ සමීකරණ", "📐", Color(0xFFEA580C)),
  TRIGONOMETRY("ත්‍රිකෝණමිතිය & පයිතගරස්", "📏", Color(0xFF0284C7)),
  MOTION("චලිත සමීකරණ (Newton)", "🚀", Color(0xFF16A34A)),
  ENERGY("කාර්යය & ශක්තිය", "⚡", Color(0xFFD97706)),
  VOLUME("පරිමාව & වර්ගඵලය", "🧊", Color(0xFF7C3AED)),
  ELECTRICITY("ධාරා විද්‍යුතය & ඕම් (V=IR)", "💡", Color(0xFF0EA5E9)),
  FORCE_MOMENTUM("බලය & පීඩනය (F=ma, P=F/A)", "⚙️", Color(0xFFF43F5E)),
  CHEMISTRY_MOLE("රසායනික මවුල (n=m/M)", "🧪", Color(0xFF10B981)),
  COMMERCE_FINANCE("වාණිජ පොලී (I=PNR/100)", "💰", Color(0xFFEAB308))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormulaSolverScreen(
  onBack: () -> Unit
) {
  var selectedCategory by remember { mutableStateOf(SolverCategory.QUADRATIC) }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "🧮 සූත්‍ර විසඳුම් මෙවලම (Step-by-Step Solver)",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = "ගණිතය & භෞතික විද්‍යාව ගැටලු පියවරෙන් පියවර විසඳුම්",
              fontSize = 10.sp,
              color = Color(0xFFBAE6FD)
            )
          }
        },
        navigationIcon = {
          IconButton(
            onClick = onBack,
            modifier = Modifier.testTag("formula_solver_back_btn")
          ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
      )
    }
  ) { padding ->
    Column(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0B132B))
        .padding(padding)
    ) {
      // Category Navigation Tabs
      LazyRow(
        modifier = Modifier
          .fillMaxWidth()
          .background(Color(0xFF1E293B))
          .padding(horizontal = 12.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        items(SolverCategory.values()) { category ->
          val isSelected = selectedCategory == category
          Surface(
            onClick = { selectedCategory = category },
            shape = RoundedCornerShape(12.dp),
            color = if (isSelected) category.color else Color.White.copy(alpha = 0.08f),
            border = BorderStroke(1.dp, if (isSelected) category.color else Color.White.copy(alpha = 0.2f))
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(category.icon, fontSize = 12.sp)
              Spacer(modifier = Modifier.width(6.dp))
              Text(
                text = category.titleSinhala,
                fontSize = 11.5.sp,
                fontWeight = FontWeight.Bold,
                color = if (isSelected) Color.White else Color(0xFFCBD5E1)
              )
            }
          }
        }
      }

      // Solver Body
      Box(
        modifier = Modifier
          .fillMaxSize()
          .padding(14.dp)
      ) {
        when (selectedCategory) {
          SolverCategory.QUADRATIC -> QuadraticEquationSolverView()
          SolverCategory.TRIGONOMETRY -> TrigonometryAndPythagorasSolverView()
          SolverCategory.MOTION -> MotionEquationsSolverView()
          SolverCategory.ENERGY -> WorkAndEnergySolverView()
          SolverCategory.VOLUME -> AreaAndVolumeSolverView()
          SolverCategory.ELECTRICITY -> ElectricityAndOhmSolverView()
          SolverCategory.FORCE_MOMENTUM -> ForcePressureDensitySolverView()
          SolverCategory.CHEMISTRY_MOLE -> ChemistryMoleConcentrationSolverView()
          SolverCategory.COMMERCE_FINANCE -> CommerceSimpleCompoundInterestSolverView()
        }
      }
    }
  }
}

@Composable
fun QuadraticEquationSolverView() {
  var aText by remember { mutableStateOf("1") }
  var bText by remember { mutableStateOf("-5") }
  var cText by remember { mutableStateOf("6") }

  val a = aText.toDoubleOrNull()
  val b = bText.toDoubleOrNull()
  val c = cText.toDoubleOrNull()

  val isValid = a != null && b != null && c != null

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFEA580C).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "📐 වර්ගජ සමීකරණ ආකෘතිය: ax² + bx + c = 0",
            color = Color(0xFFFDBA74),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "a, b සහ c අගයන් ඇතුළත් කරන්න. සූත්‍ර ක්‍රමය මඟින් පියවරෙන් පියවර විසඳුම එවෙලෙම ගණනය වේ.",
            color = Color(0xFFCBD5E1),
            fontSize = 11.sp
          )
          Spacer(modifier = Modifier.height(10.dp))

          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            OutlinedTextField(
              value = aText,
              onValueChange = { aText = it },
              label = { Text("a අගය", fontSize = 10.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              singleLine = true,
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
              )
            )
            OutlinedTextField(
              value = bText,
              onValueChange = { bText = it },
              label = { Text("b අගය", fontSize = 10.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              singleLine = true,
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
              )
            )
            OutlinedTextField(
              value = cText,
              onValueChange = { cText = it },
              label = { Text("c අගය", fontSize = 10.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              singleLine = true,
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
              )
            )
          }
        }
      }
    }

    // Step-by-Step Solution Card
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text(
            text = "📝 පියවරෙන් පියවර විසඳීමේ ක්‍රමය (Step-by-Step):",
            color = Color(0xFF38BDF8),
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
          )
          Spacer(modifier = Modifier.height(8.dp))

          if (!isValid) {
            Text(
              text = "කරුණාකර නිවැරදි සංඛ්‍යාත්මක අගයන් ඇතුළත් කරන්න.",
              color = Color(0xFF94A3B8),
              fontSize = 12.sp,
              fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )
          } else {
            val aa = a!!
            val bb = b!!
            val cc = c!!

            if (aa == 0.0) {
              Text(
                text = "අවවාදයයි: 'a' අගය 0 විය නොහැක. (එය වර්ගජ සමීකරණයක් නොවේ, සරල රේඛීය සමීකරණයකි).",
                color = Color(0xFFFCA5A5),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
              )
              if (bb != 0.0) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                  text = "රේඛීය විසඳුම: x = -c / b = ${String.format("%.3f", -cc / bb)}",
                  color = Color.White,
                  fontFamily = FontFamily.Monospace,
                  fontSize = 13.sp
                )
              }
            } else {
              val discriminant = (bb * bb) - (4 * aa * cc)

              Text(
                text = "පියවර 1: වර්ගජ සූත්‍රය යෙදීම\n   x = [-b ± √(b² - 4ac)] / 2a",
                color = Color.White,
                fontFamily = FontFamily.Monospace,
                fontSize = 12.sp
              )
              Spacer(modifier = Modifier.height(6.dp))

              Text(
                text = "පියවර 2: විවේචකය (Discriminant Δ) සෙවීම\n   Δ = b² - 4ac\n   Δ = ($bb)² - 4($aa)($cc) = $discriminant",
                color = Color(0xFFBAE6FD),
                fontSize = 12.sp,
                fontFamily = FontFamily.Monospace
              )
              Spacer(modifier = Modifier.height(6.dp))

              val natureOfRoots = when {
                discriminant > 0 -> "විවේචකය Δ > 0 බැවින් මූල දෙකක් ඇත (සැබෑ හා වෙනස් මූල)."
                discriminant == 0.0 -> "විවේචකය Δ = 0 බැවින් සමපාත මූල දෙකක් (තනි මූලයක්) ඇත."
                else -> "විවේචකය Δ < 0 බැවින් තාත්වික මූල නොපවතී (සංකීර්ණ මූල)."
              }
              Text(
                text = "පියවර 3: මූලයන්හි ස්වභාවය\n   $natureOfRoots",
                color = if (discriminant >= 0) Color(0xFF86EFAC) else Color(0xFFFCA5A5),
                fontSize = 11.5.sp
              )
              Spacer(modifier = Modifier.height(8.dp))

              if (discriminant >= 0) {
                val root1 = (-bb + sqrt(discriminant)) / (2 * aa)
                val root2 = (-bb - sqrt(discriminant)) / (2 * aa)
                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = Color(0xFF10B981).copy(alpha = 0.2f),
                  border = BorderStroke(1.dp, Color(0xFF10B981))
                ) {
                  Column(modifier = Modifier.padding(10.dp)) {
                    Text(
                      text = "🎯 අවසන් මූලයන් (Roots):",
                      color = Color(0xFF86EFAC),
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                      text = if (discriminant == 0.0) "x = ${String.format("%.3f", root1)}" 
                             else "x₁ = ${String.format("%.3f", root1)}\nx₂ = ${String.format("%.3f", root2)}",
                      color = Color.White,
                      fontWeight = FontWeight.ExtraBold,
                      fontSize = 14.sp,
                      fontFamily = FontFamily.Monospace
                    )
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun TrigonometryAndPythagorasSolverView() {
  var mode by remember { mutableStateOf(0) } // 0: Pythagoras, 1: Trig Ratios
  var aSide by remember { mutableStateOf("3") }
  var bSide by remember { mutableStateOf("4") }
  var angleDeg by remember { mutableStateOf("30") }

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Button(
          onClick = { mode = 0 },
          colors = ButtonDefaults.buttonColors(
            containerColor = if (mode == 0) Color(0xFF0284C7) else Color.White.copy(alpha = 0.1f)
          ),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("පයිතගරස් ප්‍රමේයය (a² + b² = c²)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
        Button(
          onClick = { mode = 1 },
          colors = ButtonDefaults.buttonColors(
            containerColor = if (mode == 1) Color(0xFF0284C7) else Color.White.copy(alpha = 0.1f)
          ),
          shape = RoundedCornerShape(10.dp),
          modifier = Modifier.weight(1f)
        ) {
          Text("ත්‍රිකෝණමිතික අනුපාත (Sin, Cos, Tan)", fontSize = 11.sp, fontWeight = FontWeight.Bold)
        }
      }
    }

    if (mode == 0) {
      item {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Text("📐 ඍජුකෝණී ත්‍රිකෝණයක කර්ණය (Hypotenuse c) සෙවීම:", color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold, fontSize = 13.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
              OutlinedTextField(
                value = aSide,
                onValueChange = { aSide = it },
                label = { Text("පාදය a", fontSize = 10.sp) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
                colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
              )
              OutlinedTextField(
                value = bSide,
                onValueChange = { bSide = it },
                label = { Text("පාදය b", fontSize = 10.sp) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.weight(1f),
                colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
              )
            }
            Spacer(modifier = Modifier.height(10.dp))
            val a = aSide.toDoubleOrNull() ?: 3.0
            val b = bSide.toDoubleOrNull() ?: 4.0
            val c = sqrt(a * a + b * b)

            Text("පියවර 1: c² = a² + b²", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
            Text("පියවර 2: c² = ($a)² + ($b)² = ${(a*a)} + ${(b*b)} = ${a*a + b*b}", color = Color(0xFFBAE6FD), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
            Text("පියවර 3: c = √${a*a + b*b} = ${String.format("%.3f", c)}", color = Color(0xFF86EFAC), fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 13.sp)
          }
        }
      }
    } else {
      item {
        Card(
          shape = RoundedCornerShape(12.dp),
          colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
          border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f))
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Text("📏 කෝණය (θ) අංශක වලින් ඇතුළත් කරන්න:", color = Color(0xFF38BDF8), fontWeight = FontWeight.Bold, fontSize = 13.sp)
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextField(
              value = angleDeg,
              onValueChange = { angleDeg = it },
              label = { Text("කෝණය θ (°)", fontSize = 10.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.fillMaxWidth(),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            Spacer(modifier = Modifier.height(10.dp))
            val deg = angleDeg.toDoubleOrNull() ?: 30.0
            val rad = Math.toRadians(deg)
            val sinVal = sin(rad)
            val cosVal = cos(rad)
            val tanVal = if (abs(cosVal) < 1e-6) Double.NaN else tan(rad)

            Surface(shape = RoundedCornerShape(8.dp), color = Color(0xFF0F172A)) {
              Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text("• Sin ($deg°) = ${String.format("%.4f", sinVal)}", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
                Text("• Cos ($deg°) = ${String.format("%.4f", cosVal)}", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
                Text("• Tan ($deg°) = ${if (tanVal.isNaN()) "අනන්තය (Undefined)" else String.format("%.4f", tanVal)}", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text("විභාග ඉඟිය: Sin θ = සම්මුඛ පාදය / කර්ණය | Cos θ = බද්ධ පාදය / කර්ණය | Tan θ = සම්මුඛ / බද්ධ", color = Color(0xFFFDBA74), fontSize = 10.sp)
              }
            }
          }
        }
      }
    }
  }
}

@Composable
fun MotionEquationsSolverView() {
  var uText by remember { mutableStateOf("0") } // Initial velocity
  var aText by remember { mutableStateOf("9.8") } // Acceleration
  var tText by remember { mutableStateOf("5") } // Time

  val u = uText.toDoubleOrNull() ?: 0.0
  val a = aText.toDoubleOrNull() ?: 9.8
  val t = tText.toDoubleOrNull() ?: 5.0

  val v = u + (a * t)
  val s = (u * t) + (0.5 * a * t * t)

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF16A34A).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("🚀 ඒකාකාර ත්වරණයෙන් චලිතය වන වස්තුවක් සඳහා:", color = Color(0xFF86EFAC), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
              value = uText,
              onValueChange = { uText = it },
              label = { Text("ආරම්භක ප්‍රවේගය u (ms⁻¹)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = aText,
              onValueChange = { aText = it },
              label = { Text("ත්වරණය a (ms⁻²)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = tText,
              onValueChange = { tText = it },
              label = { Text("කාලය t (s)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
          }
        }
      }
    }

    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("📊 ගණනය කළ අවසන් ප්‍රතිඵල:", color = Color(0xFF86EFAC), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))

          Text("1. අවසාන ප්‍රවේගය (Final Velocity v):\n   v = u + at = $u + ($a × $t) = ${String.format("%.2f", v)} ms⁻¹", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Spacer(modifier = Modifier.height(6.dp))
          Text("2. විස්ථාපනය (Displacement s):\n   s = ut + ½at² = ($u × $t) + ½($a)($t)² = ${String.format("%.2f", s)} m", color = Color(0xFFBAE6FD), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Spacer(modifier = Modifier.height(6.dp))
          Text("3. v² = u² + 2as පරික්ෂාව:\n   v² = ${String.format("%.2f", v*v)} | u² + 2as = ${String.format("%.2f", u*u + 2*a*s)}", color = Color(0xFFFDE68A), fontFamily = FontFamily.Monospace, fontSize = 11.5.sp)
        }
      }
    }
  }
}

@Composable
fun WorkAndEnergySolverView() {
  var massText by remember { mutableStateOf("10") } // kg
  var velocityText by remember { mutableStateOf("4") } // ms-1
  var heightText by remember { mutableStateOf("5") } // m

  val m = massText.toDoubleOrNull() ?: 10.0
  val v = velocityText.toDoubleOrNull() ?: 4.0
  val h = heightText.toDoubleOrNull() ?: 5.0
  val g = 9.8

  val ek = 0.5 * m * v * v
  val ep = m * g * h

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFD97706).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("⚡ කාර්යය, චාලක ශක්තිය (Ek) සහ විභව ශක්තිය (Ep):", color = Color(0xFFFDE68A), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
              value = massText,
              onValueChange = { massText = it },
              label = { Text("ස්කන්ධය m (kg)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = velocityText,
              onValueChange = { velocityText = it },
              label = { Text("ප්‍රවේගය v (ms⁻¹)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = heightText,
              onValueChange = { heightText = it },
              label = { Text("උස h (m)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
          }
        }
      }
    }

    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFFF59E0B).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("💡 පියවර සහ ශක්ති ගණනය:", color = Color(0xFFFDE68A), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          Text("• චාලක ශක්තිය (Ek) = ½mv²\n  Ek = ½ × $m × ($v)² = ${String.format("%.2f", ek)} J (ජූල්)", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Spacer(modifier = Modifier.height(6.dp))
          Text("• ගුරුත්වාකර්ෂණ විභව ශක්තිය (Ep) = mgh\n  Ep = $m × 9.8 × $h = ${String.format("%.2f", ep)} J (ජූල්)", color = Color(0xFFBAE6FD), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Spacer(modifier = Modifier.height(6.dp))
          Text("• මුළු යාන්ත්‍රික ශක්තිය E = Ek + Ep = ${String.format("%.2f", ek + ep)} J", color = Color(0xFF86EFAC), fontWeight = FontWeight.Bold, fontFamily = FontFamily.Monospace, fontSize = 13.sp)
        }
      }
    }
  }
}

@Composable
fun AreaAndVolumeSolverView() {
  var radiusText by remember { mutableStateOf("7") }
  var heightText by remember { mutableStateOf("10") }

  val r = radiusText.toDoubleOrNull() ?: 7.0
  val h = heightText.toDoubleOrNull() ?: 10.0
  val pi = 22.0 / 7.0

  val cylVol = pi * r * r * h
  val coneVol = (1.0 / 3.0) * pi * r * r * h
  val sphereVol = (4.0 / 3.0) * pi * r * r * r

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF7C3AED).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("🧊 සිලින්ඩර, කේතු සහ ගෝල පරිමා ගණකය:", color = Color(0xFFC4B5FD), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
              value = radiusText,
              onValueChange = { radiusText = it },
              label = { Text("අරය r (cm)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = heightText,
              onValueChange = { heightText = it },
              label = { Text("උස h (cm)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
          }
        }
      }
    }

    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFFA78BFA).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
          Text("🎯 පරිමාවන් (Volume Calculation):", color = Color(0xFFC4B5FD), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Text("1. සිලින්ඩර පරිමාව (V = πr²h):\n   V = 22/7 × ($r)² × $h = ${String.format("%.2f", cylVol)} cm³", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("2. කේතු පරිමාව (V = ⅓πr²h):\n   V = ⅓ × 22/7 × ($r)² × $h = ${String.format("%.2f", coneVol)} cm³", color = Color(0xFFBAE6FD), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("3. ගෝල පරිමාව (V = ⁴⁄₃πr³):\n   V = ⁴⁄₃ × 22/7 × ($r)³ = ${String.format("%.2f", sphereVol)} cm³", color = Color(0xFF86EFAC), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        }
      }
    }
  }
}

@Composable
fun ElectricityAndOhmSolverView() {
  var voltageText by remember { mutableStateOf("12") }
  var currentText by remember { mutableStateOf("2") }
  var timeText by remember { mutableStateOf("60") }

  val v = voltageText.toDoubleOrNull() ?: 12.0
  val i = currentText.toDoubleOrNull() ?: 2.0
  val t = timeText.toDoubleOrNull() ?: 60.0

  val r = if (i > 0) v / i else 0.0
  val p = v * i
  val energy = p * t

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF0EA5E9).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("💡 ඕම් නියමය සහ විද්‍යුත් ජවය ගණකය:", color = Color(0xFF7DD3FC), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
              value = voltageText,
              onValueChange = { voltageText = it },
              label = { Text("විභව අන්තරය V (Volts)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = currentText,
              onValueChange = { currentText = it },
              label = { Text("ධාරාව I (Amperes)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = timeText,
              onValueChange = { timeText = it },
              label = { Text("කාලය t (Seconds)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
          }
        }
      }
    }

    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
          Text("🎯 ගණනය කළ ප්‍රතිඵල (Ohm & Power Results):", color = Color(0xFF7DD3FC), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Text("1. ප්‍රතිරෝධය (R = V / I):\n   R = $v V / $i A = ${String.format("%.2f", r)} Ω (ඕම්)", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("2. විද්‍යුත් ජවය (P = V × I):\n   P = $v V × $i A = ${String.format("%.2f", p)} W (වොට්)", color = Color(0xFFBAE6FD), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("3. විද්‍යුත් ශක්තිය (E = P × t):\n   E = ${String.format("%.2f", p)} W × $t s = ${String.format("%.2f", energy)} J (ජූල්) [${String.format("%.4f", energy / 3600000.0)} kWh]", color = Color(0xFF86EFAC), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        }
      }
    }
  }
}

@Composable
fun ForcePressureDensitySolverView() {
  var massText by remember { mutableStateOf("5") }
  var accelText by remember { mutableStateOf("2") }
  var areaText by remember { mutableStateOf("0.5") }
  var volText by remember { mutableStateOf("0.002") }

  val m = massText.toDoubleOrNull() ?: 5.0
  val a = accelText.toDoubleOrNull() ?: 2.0
  val area = areaText.toDoubleOrNull() ?: 0.5
  val vol = volText.toDoubleOrNull() ?: 0.002

  val force = m * a
  val weight = m * 9.8
  val pressure = if (area > 0) force / area else 0.0
  val density = if (vol > 0) m / vol else 0.0

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFF43F5E).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("⚙️ බලය, පීඩනය සහ ඝනත්වය ගණකය:", color = Color(0xFFFDA4AF), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
              value = massText,
              onValueChange = { massText = it },
              label = { Text("ස්කන්ධය m (kg)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = accelText,
              onValueChange = { accelText = it },
              label = { Text("ත්වරණය a (ms⁻²)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
          }
          Spacer(modifier = Modifier.height(6.dp))
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
              value = areaText,
              onValueChange = { areaText = it },
              label = { Text("වර්ගඵලය A (m²)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = volText,
              onValueChange = { volText = it },
              label = { Text("පරිමාව V (m³)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
          }
        }
      }
    }

    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFFFB7185).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
          Text("🎯 ගණනය කළ ප්‍රතිඵල (Newton & Pressure Results):", color = Color(0xFFFDA4AF), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Text("1. ප්‍රභව බලය (F = ma):\n   F = $m kg × $a ms⁻² = ${String.format("%.2f", force)} N (නිව්ටන්)", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("2. ගුරුත්වජ බර (W = mg, g=9.8):\n   W = $m kg × 9.8 ms⁻² = ${String.format("%.2f", weight)} N", color = Color(0xFFBAE6FD), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("3. පීඩනය (P = F / A):\n   P = ${String.format("%.2f", force)} N / $area m² = ${String.format("%.2f", pressure)} Pa (N m⁻²)", color = Color(0xFFFDE047), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("4. ඝනත්වය (d = m / V):\n   d = $m kg / $vol m³ = ${String.format("%.2f", density)} kg m⁻³", color = Color(0xFF86EFAC), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        }
      }
    }
  }
}

@Composable
fun ChemistryMoleConcentrationSolverView() {
  var massText by remember { mutableStateOf("10") }
  var molarMassText by remember { mutableStateOf("40") }
  var solutionVolText by remember { mutableStateOf("500") }

  val mass = massText.toDoubleOrNull() ?: 10.0
  val molarMass = molarMassText.toDoubleOrNull() ?: 40.0
  val volMl = solutionVolText.toDoubleOrNull() ?: 500.0

  val moles = if (molarMass > 0) mass / molarMass else 0.0
  val volLiters = volMl / 1000.0
  val concentration = if (volLiters > 0) moles / volLiters else 0.0
  val particles = moles * 6.022e23

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFF10B981).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("🧪 රසායනික මවුල සහ සාන්ද්‍රණ ගණකය:", color = Color(0xFF6EE7B7), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
              value = massText,
              onValueChange = { massText = it },
              label = { Text("ස්කන්ධය m (g)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = molarMassText,
              onValueChange = { molarMassText = it },
              label = { Text("මවුලික ස්කන්ධය M (g/mol)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = solutionVolText,
              onValueChange = { solutionVolText = it },
              label = { Text("ද්‍රාවණ පරිමාව V (cm³/mL)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
          }
        }
      }
    }

    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFF34D399).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
          Text("🎯 ගණනය කළ ප්‍රතිඵල (Mole & Molarity Results):", color = Color(0xFF6EE7B7), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Text("1. මවුල ගණන (n = m / M):\n   n = $mass g / $molarMass g mol⁻¹ = ${String.format("%.4f", moles)} mol", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("2. මවුලික සාන්ද්‍රණය (C = n / V_L):\n   C = ${String.format("%.4f", moles)} mol / ${String.format("%.3f", volLiters)} dm³ = ${String.format("%.3f", concentration)} mol dm⁻³", color = Color(0xFFBAE6FD), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("3. අංශු ගණන (N = n × L, L=6.022×10²³):\n   N = ${String.format("%.3e", particles)} අංශු (පරමාණු/අණු)", color = Color(0xFFFDE047), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        }
      }
    }
  }
}

@Composable
fun CommerceSimpleCompoundInterestSolverView() {
  var principalText by remember { mutableStateOf("100000") }
  var rateText by remember { mutableStateOf("12") }
  var timeYearsText by remember { mutableStateOf("2") }

  val p = principalText.toDoubleOrNull() ?: 100000.0
  val r = rateText.toDoubleOrNull() ?: 12.0
  val t = timeYearsText.toDoubleOrNull() ?: 2.0

  val simpleInterest = (p * r * t) / 100.0
  val simpleTotal = p + simpleInterest
  val compoundTotal = p * Math.pow(1 + (r / 100.0), t)
  val compoundInterest = compoundTotal - p

  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
  ) {
    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, Color(0xFFEAB308).copy(alpha = 0.5f))
      ) {
        Column(modifier = Modifier.padding(14.dp)) {
          Text("💰 වාණිජ ගණිතය - සරල සහ වැල් පොලී ගණකය:", color = Color(0xFFFDE047), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Spacer(modifier = Modifier.height(8.dp))
          Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedTextField(
              value = principalText,
              onValueChange = { principalText = it },
              label = { Text("මූලධනය P (රු.)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = rateText,
              onValueChange = { rateText = it },
              label = { Text("පොලී අනුපාතිකය R (%)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
            OutlinedTextField(
              value = timeYearsText,
              onValueChange = { timeYearsText = it },
              label = { Text("කාලය N (වසර)", fontSize = 9.sp) },
              keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
              modifier = Modifier.weight(1f),
              colors = OutlinedTextFieldDefaults.colors(focusedTextColor = Color.White, unfocusedTextColor = Color.White)
            )
          }
        }
      }
    }

    item {
      Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
        border = BorderStroke(1.dp, Color(0xFFFACC15).copy(alpha = 0.4f))
      ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
          Text("🎯 ගණනය කළ පොලී ප්‍රතිඵල (Interest Calculations):", color = Color(0xFFFDE047), fontWeight = FontWeight.Bold, fontSize = 13.sp)
          Text("1. සරල පොලිය (I = PNR / 100):\n   I = (රු. $p × $t × $r) / 100 = රු. ${String.format("%.2f", simpleInterest)}", color = Color.White, fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("   මුළු මුදල (A = P + I) = රු. ${String.format("%.2f", simpleTotal)}", color = Color(0xFFBAE6FD), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Spacer(modifier = Modifier.height(4.dp))
          Text("2. වාර්ෂික වැල් පොලිය [A = P(1 + R/100)ᴺ]:\n   A = රු. $p × (1 + $r/100)^$t = රු. ${String.format("%.2f", compoundTotal)}", color = Color(0xFF86EFAC), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
          Text("   වැල් පොලී ආදායම = රු. ${String.format("%.2f", compoundInterest)} (වැඩි ලාභය: රු. ${String.format("%.2f", compoundInterest - simpleInterest)})", color = Color(0xFFFBBF24), fontFamily = FontFamily.Monospace, fontSize = 12.sp)
        }
      }
    }
  }
}

// ==============================================================================
// 🌟 FEATURE 5: TRI-LINGUAL GLOSSARY (SCIENCE, MATHS, ICT, COMMERCE)
// ==============================================================================

data class GlossaryTermItem(
  val id: String,
  val englishTerm: String,
  val sinhalaTerm: String,
  val tamilTerm: String,
  val subject: String,
  val definitionSinhala: String,
  val examTip: String
)

val sampleGlossaryTerms: List<GlossaryTermItem>
  get() = TrilingualGlossaryRepository.allGlossaryTerms

data class GlossarySubjectInfo(
  val code: String,
  val nameSinhala: String,
  val nameEnglish: String,
  val icon: String,
  val subtitle: String,
  val accentColor: Color,
  val secondaryColor: Color,
  val borderColor: Color,
  val tagText: String
)

val glossarySubjectsList = listOf(
  GlossarySubjectInfo(
    code = "SCIENCE",
    nameSinhala = "විද්‍යාව",
    nameEnglish = "Science Terms",
    icon = "🔬",
    subtitle = "භෞතික • රසායනික • ජීව විද්‍යා ත්‍රිභාෂා පද",
    accentColor = Color(0xFF0D9488),
    secondaryColor = Color(0xFF042F2E),
    borderColor = Color(0xFF14B8A6),
    tagText = "වචන 100 (10x10)"
  ),
  GlossarySubjectInfo(
    code = "MATH",
    nameSinhala = "ගණිතය",
    nameEnglish = "Mathematics Terms",
    icon = "📐",
    subtitle = "වීජ ගණිතය • ජ්‍යාමිතිය • සංඛ්‍යාන පද",
    accentColor = Color(0xFF2563EB),
    secondaryColor = Color(0xFF1E3A8A),
    borderColor = Color(0xFF3B82F6),
    tagText = "වචන 100 (10x10)"
  ),
  GlossarySubjectInfo(
    code = "ICT",
    nameSinhala = "තොරතුරු තාක්ෂණය (ICT)",
    nameEnglish = "Information Technology",
    icon = "💻",
    subtitle = "දත්ත • මෘදුකාංග • Hardware & Programming",
    accentColor = Color(0xFF0284C7),
    secondaryColor = Color(0xFF082F49),
    borderColor = Color(0xFF38BDF8),
    tagText = "වචන 100 (10x10)"
  ),
  GlossarySubjectInfo(
    code = "COMMERCE",
    nameSinhala = "වාණිජ හා ගිණුම්කරණය",
    nameEnglish = "Commerce & Accounting",
    icon = "📊",
    subtitle = "ද්විත්ව සටහන් • බැංකු • කළමනාකරණ පද",
    accentColor = Color(0xFF7C3AED),
    secondaryColor = Color(0xFF2E1065),
    borderColor = Color(0xFF8B5CF6),
    tagText = "වචන 100 (10x10)"
  ),
  GlossarySubjectInfo(
    code = "HISTORY",
    nameSinhala = "ඉතිහාසය",
    nameEnglish = "History Terms",
    icon = "🏛️",
    subtitle = "පුරාවිද්‍යාව • රාජධානි • සන්ධිස්ථාන පාරිභාෂික",
    accentColor = Color(0xFFD97706),
    secondaryColor = Color(0xFF451A03),
    borderColor = Color(0xFFF59E0B),
    tagText = "පද මාලාව"
  ),
  GlossarySubjectInfo(
    code = "CIVICS",
    nameSinhala = "පුරවැසි අධ්‍යාපනය",
    nameEnglish = "Civics Terms",
    icon = "⚖️",
    subtitle = "ආණ්ඩුක්‍රම • ප්‍රජාතන්ත්‍රවාදය • මානව හිමිකම්",
    accentColor = Color(0xFFDC2626),
    secondaryColor = Color(0xFF450A0A),
    borderColor = Color(0xFFEF4444),
    tagText = "පද මාලාව"
  ),
  GlossarySubjectInfo(
    code = "GEOGRAPHY",
    nameSinhala = "භූගෝල විද්‍යාව",
    nameEnglish = "Geography Terms",
    icon = "🌍",
    subtitle = "භූමි රූප • කාලගුණය • සිතියම් පාරිභාෂික පද",
    accentColor = Color(0xFF059669),
    secondaryColor = Color(0xFF064E3B),
    borderColor = Color(0xFF10B981),
    tagText = "පද මාලාව"
  ),
  GlossarySubjectInfo(
    code = "BUDDHISM",
    nameSinhala = "බුද්ධ ධර්මය",
    nameEnglish = "Buddhism Terms",
    icon = "☸️",
    subtitle = "චතුරාර්ය සත්‍යය • ත්‍රිපිටක • ධර්ම පාරිභාෂික පද",
    accentColor = Color(0xFFEA580C),
    secondaryColor = Color(0xFF431407),
    borderColor = Color(0xFFF97316),
    tagText = "පද මාලාව"
  ),
  GlossarySubjectInfo(
    code = "ENGLISH",
    nameSinhala = "ඉංග්‍රීසි (English)",
    nameEnglish = "English Language Terms",
    icon = "✍️",
    subtitle = "Grammar • Vocabulary • Literary Terms",
    accentColor = Color(0xFF4F46E5),
    secondaryColor = Color(0xFF1E1B4B),
    borderColor = Color(0xFF6366F1),
    tagText = "පද මාලාව"
  )
)

@Composable
fun GlossarySubjectMiniCard(
  subj: GlossarySubjectInfo,
  onClick: () -> Unit
) {
  Card(
    onClick = onClick,
    shape = RoundedCornerShape(14.dp),
    colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
    border = BorderStroke(1.2.dp, subj.accentColor.copy(alpha = 0.5f)),
    modifier = Modifier
      .fillMaxWidth()
      .height(118.dp)
      .testTag("glossary_subject_card_${subj.code}")
  ) {
    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Box(
          modifier = Modifier
            .size(34.dp)
            .clip(CircleShape)
            .background(subj.accentColor.copy(alpha = 0.22f)),
          contentAlignment = Alignment.Center
        ) {
          Text(text = subj.icon, fontSize = 17.sp)
        }
        Surface(
          shape = RoundedCornerShape(10.dp),
          color = subj.accentColor.copy(alpha = 0.2f)
        ) {
          Text(
            text = subj.tagText,
            fontSize = 9.5.sp,
            fontWeight = FontWeight.Bold,
            color = subj.accentColor,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
          )
        }
      }

      Column {
        Text(
          text = subj.nameSinhala,
          fontSize = 13.sp,
          fontWeight = FontWeight.Bold,
          color = Color.White,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
        Text(
          text = subj.nameEnglish,
          fontSize = 10.sp,
          color = subj.accentColor,
          fontWeight = FontWeight.SemiBold,
          maxLines = 1,
          overflow = TextOverflow.Ellipsis
        )
      }

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = subj.subtitle,
          fontSize = 8.5.sp,
          color = Color(0xFF94A3B8),
          maxLines = 1,
          overflow = TextOverflow.Ellipsis,
          modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
          text = "විවෘත කරන්න →",
          fontSize = 9.sp,
          fontWeight = FontWeight.Bold,
          color = subj.accentColor
        )
      }
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TriLingualGlossaryScreen(
  onBack: () -> Unit
) {
  val clipboardManager = LocalClipboardManager.current
  val context = LocalContext.current

  // Active Subject selection: null means user is on the Initial Subject Selection Screen!
  var activeSubject by remember { mutableStateOf<String?>(null) }
  var subjectSearchQuery by remember { mutableStateOf("") }

  var searchQuery by remember { mutableStateOf("") }
  var selectedGroupFilter by remember { mutableIntStateOf(0) } // 0 = All, 1..10 = Groups of 10

  val currentSubject = remember(activeSubject) {
    glossarySubjectsList.find { it.code == activeSubject } ?: glossarySubjectsList.first()
  }

  // Hardware / Gesture BackHandler: returns to colorful cards grid from a subject content screen
  if (activeSubject != null) {
    BackHandler {
      activeSubject = null
      searchQuery = ""
      selectedGroupFilter = 0
    }
  }

  val groupLabels = listOf(
    0 to "සියලු කාණ්ඩ (1-100)",
    1 to "කාණ්ඩය 1 (1-10)",
    2 to "කාණ්ඩය 2 (11-20)",
    3 to "කාණ්ඩය 3 (21-30)",
    4 to "කාණ්ඩය 4 (31-40)",
    5 to "කාණ්ඩය 5 (41-50)",
    6 to "කාණ්ඩය 6 (51-60)",
    7 to "කාණ්ඩය 7 (61-70)",
    8 to "කාණ්ඩය 8 (71-80)",
    9 to "කාණ්ඩය 9 (81-90)",
    10 to "කාණ්ඩය 10 (91-100)"
  )

  val filteredTerms = remember(searchQuery, activeSubject, selectedGroupFilter) {
    if (activeSubject == null) {
      emptyList()
    } else {
      TrilingualGlossaryRepository.allGlossaryTerms.filter { item ->
        val matchesSearch = if (searchQuery.isBlank()) true else {
          item.englishTerm.contains(searchQuery, ignoreCase = true) ||
              item.sinhalaTerm.contains(searchQuery, ignoreCase = true) ||
              item.tamilTerm.contains(searchQuery, ignoreCase = true) ||
              item.definitionSinhala.contains(searchQuery, ignoreCase = true)
        }

        val matchesSubject = when (activeSubject) {
          "SCIENCE" -> item.subject.contains("විද්‍යා")
          "MATH" -> item.subject.contains("ගණිත")
          "ICT" -> item.subject.contains("ICT") || item.subject.contains("තොරතුරු")
          "COMMERCE" -> item.subject.contains("වාණිජ") || item.subject.contains("Commerce")
          "HISTORY" -> item.subject.contains("ඉතිහාස")
          "CIVICS" -> item.subject.contains("පුරවැසි")
          "GEOGRAPHY" -> item.subject.contains("භූගෝල")
          "BUDDHISM" -> item.subject.contains("බුද්ධ") || item.subject.contains("ආගම")
          "ENGLISH" -> item.subject.contains("English") || item.subject.contains("ඉංග්‍රීසි")
          else -> true
        }

        val itemGroup = TrilingualGlossaryRepository.getGroupNumber(item)
        val matchesGroup = if (selectedGroupFilter == 0) true else itemGroup == selectedGroupFilter

        matchesSearch && matchesSubject && matchesGroup
      }
    }
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = if (activeSubject == null) "📖 ත්‍රිභාෂා පාරිභාෂික ශබ්ද මාලාව (Glossary)" else "${currentSubject.icon} ${currentSubject.nameSinhala} ත්‍රිභාෂා පද මාලාව",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = if (activeSubject == null) "O/L විද්‍යාව • ගණිතය • ICT • වාණිජ සිංහල-English Terms" else "${currentSubject.nameEnglish} • පද ${filteredTerms.size}",
              fontSize = 10.sp,
              color = Color(0xFFBAE6FD)
            )
          }
        },
        navigationIcon = {
          IconButton(
            onClick = {
              if (activeSubject != null) {
                activeSubject = null
                searchQuery = ""
                selectedGroupFilter = 0
              } else {
                onBack()
              }
            },
            modifier = Modifier.testTag("glossary_back_btn")
          ) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
      )
    }
  ) { padding ->
    LazyColumn(
      modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFF0B132B))
        .padding(padding)
        .padding(12.dp),
      verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      if (activeSubject == null) {
        // ================================================================
        // 🌟 INITIAL SCREEN: SUBJECT SELECTION ONLY (NO TERMS SHOWN)
        // ================================================================
        // Search Bar for Subjects
        item(key = "subject_search_bar") {
          OutlinedTextField(
            value = subjectSearchQuery,
            onValueChange = { subjectSearchQuery = it },
            placeholder = { Text("විෂය නම සොයන්න (උදා: විද්‍යාව, ගණිතය, ICT, වාණිජ, බුද්ධ ධර්මය...)", fontSize = 11.5.sp, color = Color(0xFF64748B)) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF38BDF8), modifier = Modifier.size(18.dp)) },
            trailingIcon = {
              if (subjectSearchQuery.isNotBlank()) {
                IconButton(onClick = { subjectSearchQuery = "" }) {
                  Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color(0xFF94A3B8), modifier = Modifier.size(16.dp))
                }
              }
            },
            singleLine = true,
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
              focusedContainerColor = Color(0xFF1E293B),
              unfocusedContainerColor = Color(0xFF1E293B),
              focusedBorderColor = Color(0xFF38BDF8),
              unfocusedBorderColor = Color(0xFF334155),
              focusedTextColor = Color.White,
              unfocusedTextColor = Color.White
            ),
            modifier = Modifier.fillMaxWidth().height(48.dp)
          )
        }

        // Section Title
        item(key = "subject_section_label") {
          Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "📂 විෂය තෝරන්න (Select Subject to View Terms):",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF38BDF8)
            )
            Text(
              text = "100% O/L සිලබස්",
              fontSize = 10.sp,
              fontWeight = FontWeight.Bold,
              color = Color(0xFF10B981)
            )
          }
        }

        // 2-column Grid of Colorful Compact Subject Cards
        val displayedSubjects = glossarySubjectsList.filter { subj ->
          subjectSearchQuery.isBlank() ||
              subj.nameSinhala.contains(subjectSearchQuery, ignoreCase = true) ||
              subj.nameEnglish.contains(subjectSearchQuery, ignoreCase = true) ||
              subj.subtitle.contains(subjectSearchQuery, ignoreCase = true)
        }
        val chunkedSubjects = displayedSubjects.chunked(2)
        items(chunkedSubjects) { rowItems ->
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            rowItems.forEach { subj ->
              Box(modifier = Modifier.weight(1f)) {
                GlossarySubjectMiniCard(
                  subj = subj,
                  onClick = {
                    activeSubject = subj.code
                    selectedGroupFilter = 0
                    searchQuery = ""
                  }
                )
              }
            }
            if (rowItems.size == 1) {
              Spacer(modifier = Modifier.weight(1f))
            }
          }
        }
      } else {
        // ================================================================
        // 🌟 SUBJECT CONTENT SCREEN (SHOWN ONLY WHEN A SUBJECT IS CLICKED)
        // ================================================================
        // 1. Horizontal Subject Selector Bar (User requested: "මේ අනු කොටසේ විෂය තෝරාගන්න තීරුවක් දෙන්න")
        item(key = "subject_horizontal_selector_bar") {
          Surface(
            shape = RoundedCornerShape(12.dp),
            color = Color(0xFF1E293B),
            border = BorderStroke(1.dp, Color(0xFF334155)),
            modifier = Modifier.fillMaxWidth()
          ) {
            LazyRow(
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp, horizontal = 6.dp),
              horizontalArrangement = Arrangement.spacedBy(6.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              // Button to return to all subjects grid
              item {
                Surface(
                  onClick = {
                    activeSubject = null
                    searchQuery = ""
                    selectedGroupFilter = 0
                  },
                  shape = RoundedCornerShape(10.dp),
                  color = Color(0xFF0F172A),
                  border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.7f))
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Icon(
                      imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                      contentDescription = "All Subjects",
                      tint = Color(0xFF38BDF8),
                      modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                      text = "සියලු විෂයන් (Cards)",
                      fontSize = 11.sp,
                      fontWeight = FontWeight.Bold,
                      color = Color(0xFF38BDF8)
                    )
                  }
                }
              }

              // Chips for each of the 9 subjects
              items(glossarySubjectsList) { subj ->
                val isSelected = activeSubject == subj.code
                Surface(
                  onClick = {
                    activeSubject = subj.code
                    selectedGroupFilter = 0
                  },
                  shape = RoundedCornerShape(10.dp),
                  color = if (isSelected) subj.accentColor.copy(alpha = 0.25f) else Color(0xFF0F172A),
                  border = BorderStroke(
                    1.dp,
                    if (isSelected) subj.accentColor else Color(0xFF334155)
                  )
                ) {
                  Row(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 7.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(subj.icon, fontSize = 13.sp)
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                      text = subj.nameSinhala,
                      fontSize = 11.5.sp,
                      fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                      color = if (isSelected) Color.White else Color(0xFF94A3B8)
                    )
                  }
                }
              }
            }
          }
        }

        // 2. Terms Search Bar
        item(key = "terms_search_bar") {
          OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("වචනය සොයන්න (උදා: Osmosis, ආස්‍රැතිය, RAM)...", fontSize = 11.5.sp, color = Color(0xFF94A3B8)) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = Color(0xFF38BDF8)) },
            trailingIcon = {
              if (searchQuery.isNotEmpty()) {
                IconButton(onClick = { searchQuery = "" }) {
                  Icon(Icons.Default.Close, contentDescription = "Clear", tint = Color.White)
                }
              }
            },
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
              focusedTextColor = Color.White,
              unfocusedTextColor = Color.White,
              focusedContainerColor = Color(0xFF1E293B),
              unfocusedContainerColor = Color(0xFF1E293B)
            )
          )
        }

        // 3. 10 Groups Filter Chips
        item(key = "groups_filter_row") {
          Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text("දහයේ කාණ්ඩ 10 (වචන 100):", fontSize = 11.sp, color = Color(0xFF94A3B8), fontWeight = FontWeight.SemiBold)
            LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
              items(groupLabels) { (grpId, label) ->
                val isSelected = selectedGroupFilter == grpId
                FilterChip(
                  selected = isSelected,
                  onClick = { selectedGroupFilter = grpId },
                  label = { Text(label, fontSize = 10.5.sp, fontWeight = FontWeight.SemiBold) },
                  colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = Color(0xFF059669),
                    selectedLabelColor = Color.White,
                    containerColor = Color(0xFF1E293B),
                    labelColor = Color(0xFFCBD5E1)
                  )
                )
              }
            }
          }
        }

        // 4. Terms Count Summary
        item(key = "terms_count_summary") {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(
              text = "පෙන්වන්නේ පාරිභාෂික පද ${filteredTerms.size}",
              fontSize = 11.sp,
              fontWeight = FontWeight.SemiBold,
              color = Color(0xFF94A3B8)
            )
            Text(
              text = "100% O/L විභාග ප්‍රමිතිය",
              fontSize = 10.sp,
              color = Color(0xFF10B981),
              fontWeight = FontWeight.Bold
            )
          }
        }

        // 5. Terms List Cards
        items(filteredTerms, key = { it.id }) { item ->
          val groupNum = TrilingualGlossaryRepository.getGroupNumber(item)
          val itemNum = TrilingualGlossaryRepository.getItemIndexInSubject(item)

          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.3f)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column(modifier = Modifier.weight(1f)) {
                  Text(
                    text = item.sinhalaTerm,
                    color = Color.White,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold
                  )
                  Text(
                    text = "${item.englishTerm} • ${item.tamilTerm}",
                    color = Color(0xFF38BDF8),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold
                  )
                }
                Column(horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.spacedBy(4.dp)) {
                  Surface(
                    color = Color(0xFF059669),
                    shape = RoundedCornerShape(6.dp)
                  ) {
                    Text(
                      text = "කාණ්ඩය $groupNum (#$itemNum)",
                      color = Color.White,
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                  Surface(
                    color = Color(0xFF0284C7),
                    shape = RoundedCornerShape(6.dp)
                  ) {
                    Text(
                      text = item.subject,
                      color = Color.White,
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                }
              }

              Spacer(modifier = Modifier.height(8.dp))
              Text(
                text = item.definitionSinhala,
                color = Color(0xFFE2E8F0),
                fontSize = 11.5.sp,
                lineHeight = 16.sp
              )

              Spacer(modifier = Modifier.height(8.dp))
              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF0F172A),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(8.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("💡", fontSize = 12.sp)
                  Spacer(modifier = Modifier.width(6.dp))
                  Text(
                    text = item.examTip,
                    color = Color(0xFFFDBA74),
                    fontSize = 10.5.sp,
                    lineHeight = 14.sp,
                    modifier = Modifier.weight(1f)
                  )
                  IconButton(
                    onClick = {
                      if (AppSecurityManager.canCopyContent(context)) {
                        clipboardManager.setText(AnnotatedString("${item.sinhalaTerm} (${item.englishTerm}): ${item.definitionSinhala}"))
                      } else {
                        Toast.makeText(context, "ආරක්ෂක නීති අනුව සටහන් පිටපත් කිරීම (Copy) අවහිර කර ඇත (Admin Only).", Toast.LENGTH_SHORT).show()
                      }
                    },
                    modifier = Modifier.size(24.dp)
                  ) {
                    Icon(Icons.Default.ContentCopy, contentDescription = "Copy", tint = Color(0xFF94A3B8), modifier = Modifier.size(16.dp))
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

// ==============================================================================
// 🌟 FEATURE 6: TIMED PAST PAPER SIMULATOR (YEAR-BY-YEAR MCQ EXAM)
// ==============================================================================

data class PastPaperQuestion(
  val id: Int,
  val questionText: String,
  val options: List<String>,
  val correctOptionIndex: Int,
  val explanationSinhala: String,
  val topicCategory: String = "",
  val year: String = "",
  val subject: String = ""
)

val samplePastPaperQuestions = listOf(
  PastPaperQuestion(
    id = 1,
    questionText = "ශාක සෛලයක පමණක් දක්නට ලැබෙන අතර සත්ත්ව සෛලවල නොමැති ඉන්ද්‍රයිකාව කුමක්ද?",
    options = listOf("මයිටොකොන්ඩ්‍රියා", "හරිතලව (Chloroplast)", "රයිබොසෝම", "න්‍යෂ්ටිය"),
    correctOptionIndex = 1,
    explanationSinhala = "හරිතලව සහ සෙලියුලෝස් සෛල බිත්තිය ශාක සෛලවලට පමණක් සීමා වූ ව්‍යුහයන් වේ.",
    topicCategory = "ජීව විද්‍යාව"
  ),
  PastPaperQuestion(
    id = 2,
    questionText = "ජලය විද්‍යුත් විච්ඡේදනය කිරීමේදී කැතෝඩය අසල පිටවන වායුව කුමක්ද?",
    options = listOf("ඔක්සිජන් වායුව", "හයිඩ්‍රජන් වායුව", "කාබන් ඩයොක්සයිඩ් වායුව", "නයිට්‍රජන් වායුව"),
    correctOptionIndex = 1,
    explanationSinhala = "කැතෝඩය (-) අසල හයිඩ්‍රජන් වායුවත් (H₂), ඇනෝඩය (+) අසල ඔක්සිජන් වායුවත් (O₂) පිටවේ. පරිමා අනුපාතය 2:1 කි.",
    topicCategory = "රසායන විද්‍යාව"
  ),
  PastPaperQuestion(
    id = 3,
    questionText = "නිව්ටන්ගේ දෙවන චලිත නියමය ගණිතමය ලෙස දක්වන්නේ කෙසේද?",
    options = listOf("F = ma", "v = u + at", "W = Fd", "P = W / t"),
    correctOptionIndex = 0,
    explanationSinhala = "F = ma (අසමතුලිත බලය = ස්කන්ධය × ත්වරණය).",
    topicCategory = "භෞතික විද්‍යාව"
  ),
  PastPaperQuestion(
    id = 4,
    questionText = "ලංකාවේ ප්‍රථම ඓතිහාසික රජු ලෙස මහාවංශයේ සැලකෙන්නේ කවුරුන්ද?",
    options = listOf("දේවානම්පියතිස්ස රජු", "විජය රජු", "පණ්ඩුකාභය රජු", "දුටුගැමුණු රජු"),
    correctOptionIndex = 1,
    explanationSinhala = "ක්‍රි.පූ. 543 දී ඉන්දියාවේ සිට පැමිණි විජය කුමරු ලංකාවේ ප්‍රථම ඓතිහාසික පාලකයා ලෙස සැලකේ.",
    topicCategory = "ඉතිහාසය"
  ),
  PastPaperQuestion(
    id = 5,
    questionText = "බුදුරජාණන් වහන්සේ ප්‍රථම ධර්ම දේශනාව වන ධම්මචක්කප්පවත්තන සූත්‍රය දේශනා කළේ කාහටද?",
    options = listOf("සැරියුත් මුගලන් දෙනමට", "පස්වග තවුසන්ට", "කාශ්‍යප සොහොයුරන්ට", "ආනන්ද හිමියන්ට"),
    correctOptionIndex = 1,
    explanationSinhala = "බරණැස ඉසිපතන මිගදායේදී කොණ්ඩඤ්ඤ, භද්දිය, වප්ප, මහානාම, අස්සජි යන පස්වග තවුසන්ට ප්‍රථම ධර්ම දේශනාව පවත්වන ලදී.",
    topicCategory = "බුද්ධ ධර්මය"
  )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimedPastPaperSimulatorScreen(
  onBack: () -> Unit
) {
  var selectedYear by remember { mutableStateOf("2023") }
  var selectedSubject by remember { mutableStateOf("විද්‍යාව (Science)") }
  var examDurationMinutes by remember { mutableIntStateOf(60) } // Default 60 Minutes as requested
  var isExamRunning by remember { mutableStateOf(false) }
  var isExamFinished by remember { mutableStateOf(false) }
  var currentQuestionIndex by remember { mutableIntStateOf(0) }
  val studentAnswers = remember { mutableStateMapOf<Int, Int>() } // questionId -> optionIndex
  var remainingSeconds by remember { mutableIntStateOf(60 * 60) } // 60 minutes = 3600 seconds

  // Fetch exactly 60 questions for the selected subject and year, strictly interleaved across diverse topics
  val examQuestions = remember(selectedSubject, selectedYear) {
    TimedPastPaperRepository.getQuestionsForExam(selectedSubject, selectedYear)
  }

  // Countdown Timer Effect
  LaunchedEffect(isExamRunning, remainingSeconds) {
    if (isExamRunning && remainingSeconds > 0) {
      delay(1000L)
      remainingSeconds--
    } else if (isExamRunning && remainingSeconds == 0) {
      isExamRunning = false
      isExamFinished = true
    }
  }

  val examListState = rememberLazyListState()
  // Auto-scroll to top of question on question change
  LaunchedEffect(currentQuestionIndex) {
    examListState.animateScrollToItem(0)
  }

  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Column {
            Text(
              text = "⏱️ Timed Past Paper Simulator",
              fontSize = 15.sp,
              fontWeight = FontWeight.Bold,
              color = Color.White
            )
            Text(
              text = if (isExamRunning) {
                "විභාග කාලය: ${remainingSeconds / 60}m ${String.format("%02d", remainingSeconds % 60)}s • ප්‍රශ්න 60"
              } else {
                "$selectedSubject - $selectedYear O/L (ප්‍රශ්න 60 • විනාඩි 60)"
              },
              fontSize = 10.5.sp,
              color = if (isExamRunning && remainingSeconds < 300) Color(0xFFF87171) else Color(0xFFBAE6FD)
            )
          }
        },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
          }
        },
        actions = {
          if (isExamRunning) {
            Button(
              onClick = {
                isExamRunning = false
                isExamFinished = true
              },
              colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFDC2626)),
              shape = RoundedCornerShape(8.dp),
              contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
            ) {
              Text("අවසන් කරන්න", fontSize = 10.sp, fontWeight = FontWeight.Bold)
            }
          }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF0F172A))
      )
    }
  ) { padding ->
    if (!isExamRunning && !isExamFinished) {
      // 1. Pre-Exam Setup View (100% Scrollable Top-to-Bottom)
      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .background(Color(0xFF0B132B))
          .padding(padding)
          .padding(horizontal = 14.dp),
        contentPadding = PaddingValues(top = 14.dp, bottom = 200.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
      ) {
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f))
          ) {
            Column(modifier = Modifier.padding(16.dp)) {
              Text(
                text = "🎯 විභාග ප්‍රශ්න පත්‍රය සහ වසර තෝරන්න:",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
              )
              Spacer(modifier = Modifier.height(10.dp))

              Text("විෂය (Subject):", color = Color(0xFFBAE6FD), fontSize = 11.5.sp)
              val subjects = listOf(
                "විද්‍යාව (Science)", 
                "ඉතිහාසය (History)", 
                "බුද්ධ ධර්මය (Buddhism)", 
                "සිංහල (Sinhala)",
                "ගණිතය (Mathematics)",
                "ඉංග්‍රීසි (English)"
              )
              LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.padding(vertical = 4.dp)) {
                items(subjects) { subj ->
                  FilterChip(
                    selected = selectedSubject == subj,
                    onClick = { selectedSubject = subj },
                    label = { Text(subj, fontSize = 11.sp) }
                  )
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              Text("වසර (Year):", color = Color(0xFFBAE6FD), fontSize = 11.5.sp)
              val years = listOf("2024", "2023", "2022", "2021", "2020", "2019", "2018")
              LazyRow(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.padding(vertical = 4.dp)) {
                items(years) { yr ->
                  FilterChip(
                    selected = selectedYear == yr,
                    onClick = { selectedYear = yr },
                    label = { Text(yr, fontSize = 11.sp) }
                  )
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              Text("කාල සීමාව (Exam Duration):", color = Color(0xFFBAE6FD), fontSize = 11.5.sp)
              Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                FilterChip(
                  selected = examDurationMinutes == 60,
                  onClick = { examDurationMinutes = 60 },
                  label = { Text("🏛️ 60 Min Standard (ප්‍රශ්න 60)", fontSize = 11.sp, fontWeight = FontWeight.Bold) }
                )
                FilterChip(
                  selected = examDurationMinutes == 45,
                  onClick = { examDurationMinutes = 45 },
                  label = { Text("⚡ 45 Min Speed Run", fontSize = 11.sp) }
                )
              }

              Spacer(modifier = Modifier.height(12.dp))

              Surface(
                shape = RoundedCornerShape(8.dp),
                color = Color(0xFF0284C7).copy(alpha = 0.15f),
                border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.3f)),
                modifier = Modifier.fillMaxWidth()
              ) {
                Row(
                  modifier = Modifier.padding(10.dp),
                  verticalAlignment = Alignment.CenterVertically
                ) {
                  Text("💡", fontSize = 16.sp)
                  Spacer(modifier = Modifier.width(8.dp))
                  Text(
                    text = "ප්‍රශ්න පත්‍රයේ ප්‍රශ්න 60 ක් අන්තර්ගත වන අතර, එකම මාතෘකාවේ ප්‍රශ්න එක ළඟ නොයන පරිදි විෂය නිර්දේශයේ සියලු ඒකක මනාව බෙදා මිශ්‍ර කර (Interleaved) ඇත.",
                    color = Color(0xFFE2E8F0),
                    fontSize = 11.sp,
                    lineHeight = 16.sp
                  )
                }
              }

              Spacer(modifier = Modifier.height(16.dp))

              Button(
                onClick = {
                  remainingSeconds = examDurationMinutes * 60
                  studentAnswers.clear()
                  currentQuestionIndex = 0
                  isExamRunning = true
                  isExamFinished = false
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.fillMaxWidth()
              ) {
                Text("විභාගය ආරම්භ කරන්න (විනාඩි 60 • ප්‍රශ්න 60) 🚀", fontSize = 12.5.sp, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }
    } else if (isExamRunning) {
      // 2. Active Exam Running View (100% Scrollable Top-to-Bottom)
      val questionsList = examQuestions.ifEmpty { samplePastPaperQuestions }
      val currentQ = questionsList[currentQuestionIndex.coerceIn(0, questionsList.size - 1)]

      LazyColumn(
        state = examListState,
        modifier = Modifier
          .fillMaxSize()
          .background(Color(0xFF0B132B))
          .padding(padding)
          .padding(horizontal = 14.dp),
        contentPadding = PaddingValues(top = 14.dp, bottom = 200.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
      ) {
        // Question Progress & Timer Bar
        item {
          Card(
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column {
                  Text(
                    text = "ප්‍රශ්න අංක ${currentQuestionIndex + 1} / ${questionsList.size}",
                    color = Color(0xFF38BDF8),
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp
                  )
                  if (currentQ.topicCategory.isNotEmpty()) {
                    Text(
                      text = "🏷️ ${currentQ.topicCategory}",
                      color = Color(0xFFFEF08A),
                      fontSize = 10.sp,
                      fontWeight = FontWeight.SemiBold
                    )
                  }
                }

                Surface(
                  shape = RoundedCornerShape(8.dp),
                  color = if (remainingSeconds < 300) Color(0xFFEF4444).copy(alpha = 0.2f) else Color(0xFF10B981).copy(alpha = 0.2f),
                  border = BorderStroke(1.dp, if (remainingSeconds < 300) Color(0xFFEF4444) else Color(0xFF10B981))
                ) {
                  Text(
                    text = "⏳ ඉතිරි කාලය: ${remainingSeconds / 60}:${String.format("%02d", remainingSeconds % 60)}",
                    color = if (remainingSeconds < 300) Color(0xFFFCA5A5) else Color(0xFF86EFAC),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 11.5.sp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                  )
                }
              }

              Spacer(modifier = Modifier.height(8.dp))

              LinearProgressIndicator(
                progress = { (currentQuestionIndex + 1).toFloat() / questionsList.size },
                modifier = Modifier
                  .fillMaxWidth()
                  .height(6.dp),
                color = Color(0xFF38BDF8),
                trackColor = Color(0xFF334155)
              )
            }
          }
        }

        // Quick Question Jump Bar (1..60)
        item {
          Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
            border = BorderStroke(1.dp, Color(0xFF334155)),
            modifier = Modifier.fillMaxWidth()
          ) {
            LazyRow(
              modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp),
              horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
              items(questionsList.size) { idx ->
                val qId = questionsList[idx].id
                val isAnswered = studentAnswers.containsKey(qId)
                val isCurrent = idx == currentQuestionIndex
                Surface(
                  onClick = { currentQuestionIndex = idx },
                  shape = RoundedCornerShape(6.dp),
                  color = when {
                    isCurrent -> Color(0xFF0284C7)
                    isAnswered -> Color(0xFF059669)
                    else -> Color(0xFF1E293B)
                  },
                  border = BorderStroke(
                    1.dp, 
                    if (isCurrent) Color(0xFF38BDF8) else if (isAnswered) Color(0xFF34D399) else Color(0xFF475569)
                  ),
                  modifier = Modifier.size(30.dp)
                ) {
                  Box(contentAlignment = Alignment.Center) {
                    Text(
                      text = "${idx + 1}",
                      fontSize = 10.sp,
                      fontWeight = if (isCurrent) FontWeight.ExtraBold else FontWeight.Medium,
                      color = Color.White
                    )
                  }
                }
              }
            }
          }
        }

        // Active Question Surface
        item {
          Card(
            shape = RoundedCornerShape(14.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFF38BDF8).copy(alpha = 0.4f)),
            modifier = Modifier.fillMaxWidth()
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Text(
                text = currentQ.questionText,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                lineHeight = 20.sp
              )

              Spacer(modifier = Modifier.height(12.dp))

              currentQ.options.forEachIndexed { optIndex, optionText ->
                val isSelected = studentAnswers[currentQ.id] == optIndex
                Surface(
                  onClick = {
                    studentAnswers[currentQ.id] = optIndex
                  },
                  shape = RoundedCornerShape(8.dp),
                  color = if (isSelected) Color(0xFF0284C7).copy(alpha = 0.35f) else Color.White.copy(alpha = 0.05f),
                  border = BorderStroke(1.dp, if (isSelected) Color(0xFF38BDF8) else Color.White.copy(alpha = 0.15f)),
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 3.5.dp)
                ) {
                  Row(
                    modifier = Modifier.padding(10.dp),
                    verticalAlignment = Alignment.CenterVertically
                  ) {
                    Text(
                      text = "(${optIndex + 1})",
                      color = if (isSelected) Color(0xFF38BDF8) else Color(0xFF94A3B8),
                      fontWeight = FontWeight.Bold,
                      fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                      text = optionText,
                      color = Color.White,
                      fontSize = 12.5.sp
                    )
                  }
                }
              }

              Spacer(modifier = Modifier.height(14.dp))

              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                OutlinedButton(
                  onClick = { if (currentQuestionIndex > 0) currentQuestionIndex-- },
                  enabled = currentQuestionIndex > 0,
                  shape = RoundedCornerShape(8.dp),
                  colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                ) {
                  Text("⬅️ පෙර ප්‍රශ්නය", fontSize = 11.sp)
                }

                Text(
                  text = "Q ${currentQuestionIndex + 1} / ${questionsList.size}",
                  color = Color(0xFF38BDF8),
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold
                )

                if (currentQuestionIndex < questionsList.size - 1) {
                  Button(
                    onClick = { currentQuestionIndex++ },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7))
                  ) {
                    Text("ඊළඟ ප්‍රශ්නය ➔", fontSize = 11.sp)
                  }
                } else {
                  Button(
                    onClick = {
                      isExamRunning = false
                      isExamFinished = true
                    },
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF10B981))
                  ) {
                    Text("පිළිතුරු භාරදෙන්න ✅", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                  }
                }
              }
            }
          }
        }
      }
    } else {
      // 3. Result Sheet & Detailed Explanations (100% Scrollable Top-to-Bottom LazyColumn)
      val questionsList = examQuestions.ifEmpty { samplePastPaperQuestions }
      var score = 0
      questionsList.forEach { q ->
        if (studentAnswers[q.id] == q.correctOptionIndex) score++
      }
      val percent = if (questionsList.isNotEmpty()) (score * 100) / questionsList.size else 0
      val grade = when {
        percent >= 75 -> "A (විශිෂ්ට සාමාර්ථ්‍යයක්)"
        percent >= 65 -> "B (ඉතා හොඳ සාමාර්ථ්‍යයක්)"
        percent >= 55 -> "C (සම්මාන සාමාර්ථ්‍යයක්)"
        percent >= 35 -> "S (සාමාන්‍ය සාමාර්ථ්‍යයක්)"
        else -> "W (නැවත පුහුණු වන්න)"
      }

      LazyColumn(
        modifier = Modifier
          .fillMaxSize()
          .background(Color(0xFF0B132B))
          .padding(padding)
          .padding(horizontal = 14.dp),
        contentPadding = PaddingValues(top = 14.dp, bottom = 200.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
      ) {
        item {
          Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
            border = BorderStroke(1.dp, Color(0xFF10B981))
          ) {
            Column(
              modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
              horizontalAlignment = Alignment.CenterHorizontally
            ) {
              Text("🏆 විභාග ලකුණු වාර්තාව (Exam Results)", color = Color(0xFF86EFAC), fontWeight = FontWeight.Bold, fontSize = 15.sp)
              Spacer(modifier = Modifier.height(8.dp))
              Text("$score / ${questionsList.size}", fontSize = 34.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
              Text("ප්‍රතිශතය: $percent% • ශ්‍රේණිය: $grade", fontSize = 13.5.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFDE68A))
              Text("විභාගය: $selectedSubject ($selectedYear) • විනාඩි 60", fontSize = 11.sp, color = Color(0xFF94A3B8))
              Spacer(modifier = Modifier.height(12.dp))
              Button(
                onClick = {
                  isExamFinished = false
                  isExamRunning = false
                },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7))
              ) {
                Text("නැවත විභාගයක් කරන්න 🔄", fontSize = 11.5.sp)
              }
            }
          }
        }

        item {
          Text(
            text = "📝 ප්‍රශ්නෝත්තර සහ සිංහල විවරණ (ප්‍රශ්න 60):", 
            color = Color.White, 
            fontWeight = FontWeight.Bold, 
            fontSize = 13.sp
          )
        }

        items(questionsList) { q ->
          val userAns = studentAnswers[q.id]
          val isCorrect = userAns == q.correctOptionIndex
          Card(
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0F172A)),
            border = BorderStroke(1.dp, if (isCorrect) Color(0xFF10B981) else Color(0xFFEF4444).copy(alpha = 0.6f))
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Text(
                  text = "ප්‍රශ්නය ${q.id}:",
                  color = Color(0xFF38BDF8),
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold
                )
                if (q.topicCategory.isNotEmpty()) {
                  Text(
                    text = q.topicCategory,
                    color = Color(0xFFFEF08A),
                    fontSize = 9.5.sp
                  )
                }
              }
              Spacer(modifier = Modifier.height(3.dp))
              Text(
                text = q.questionText,
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
              )
              Spacer(modifier = Modifier.height(6.dp))
              val ansText = if (userAns != null && userAns < q.options.size) q.options[userAns] else "පිළිතුරක් සලකුණු කර නැත"
              val statusEmoji = if (isCorrect) "✅" else "❌"
              Text(
                text = "ඔබේ පිළිතුර: $ansText $statusEmoji",
                color = if (isCorrect) Color(0xFF86EFAC) else Color(0xFFFCA5A5),
                fontSize = 11.sp
              )
              if (!isCorrect) {
                Text(
                  text = "නිවැරදි පිළිතුර: (${q.correctOptionIndex + 1}) ${q.options[q.correctOptionIndex]}",
                  color = Color(0xFF86EFAC),
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Bold
                )
              }
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "විවරණය: ${q.explanationSinhala}",
                color = Color(0xFFBAE6FD),
                fontSize = 10.5.sp
              )
            }
          }
        }
      }
    }
  }
}

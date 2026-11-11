package com.example

import android.content.Context
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.animation.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.HelpOutline
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun GeographyAutoCheckerScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var activeTab by remember { mutableIntStateOf(0) } // 0: කෙටි සටහන් (Master Hub), 1: ප්‍රශ්න පත්‍ර (Auto-Checker), 2: ස්වයං පුහුණු (Q&A/Flashcards), 3: AI Assistant (PDF Viewer)
    var currentGradeTab by remember { mutableStateOf("10") } // "10" or "11"
    var showPdfViewerModal by remember { mutableStateOf(false) }
    var showProgressModal by remember { mutableStateOf(false) }
    var showSyllabusModal by remember { mutableStateOf(false) }

    var selectedCategoryNumber by remember { mutableIntStateOf(0) }
    val masterCategories = remember { SubjectMasterGeography20x20.getCategories() }
    val autoCheckQuestions = remember { GeographyAutoCheckerRepository.allQuestions }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0A1128) // Dark Navy Background
    ) {
        BackHandler {
            if (selectedCategoryNumber != 0) {
                selectedCategoryNumber = 0
            } else {
                onBack()
            }
        }

        if (activeTab == 0 && selectedCategoryNumber != 0) {
            val filteredForGrade = masterCategories.filter { cat ->
                if (currentGradeTab == "10") cat.categoryNumber <= 10 else cat.categoryNumber > 10
            }
            SubjectMaster20CategoriesDetailView(
                subjectName = "භූගෝල විද්‍යාව",
                categories = filteredForGrade,
                selectedCategoryNumber = selectedCategoryNumber,
                onSelectCategory = { selectedCategoryNumber = it },
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 16.dp)
            ) {
                // Top Hero Card Banner matching Screenshot 20261027-103528
                Card(
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF132A3E)),
                    border = BorderStroke(1.dp, Color(0xFF1E3A5F)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 12.dp, vertical = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = onBack) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "ආපසු",
                                    tint = Color.White
                                )
                            }
                            Spacer(modifier = Modifier.width(4.dp))
                            Column {
                                Surface(
                                    shape = RoundedCornerShape(6.dp),
                                    color = Color(0xFF0284C7).copy(alpha = 0.3f),
                                    border = BorderStroke(0.8.dp, Color(0xFF38BDF8))
                                ) {
                                    Text(
                                        text = if (currentGradeTab == "10") "10 ශ්‍රේණිය" else "11 ශ්‍රේණිය (O/L)",
                                        color = Color(0xFF38BDF8),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.height(2.dp))
                                Text(
                                    text = "භූගෝල විද්‍යාව",
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Geography • 5-Section Hub",
                                    color = Color(0xFF94A3B8),
                                    fontSize = 11.sp
                                )
                            }
                        }
                        Text("💡", fontSize = 28.sp)
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                // 5 Horizontal Pill Buttons Row matching Screenshot 20261027-103528
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    item {
                        Surface(
                            onClick = { showProgressModal = true },
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFF0369A1).copy(alpha = 0.25f),
                            border = BorderStroke(1.dp, Color(0xFF38BDF8))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("📊", fontSize = 12.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("ප්‍රගතිය", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF38BDF8))
                            }
                        }
                    }
                    item {
                        Surface(
                            onClick = {
                                activeTab = 0
                                selectedCategoryNumber = 1 // 1:50,000 maps
                            },
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFF059669).copy(alpha = 0.25f),
                            border = BorderStroke(1.dp, Color(0xFF34D399))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("🎨", fontSize = 12.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("රූප සටහන්", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF34D399))
                            }
                        }
                    }
                    item {
                        Surface(
                            onClick = {
                                activeTab = 0
                                selectedCategoryNumber = 0
                            },
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFF7C3AED).copy(alpha = 0.25f),
                            border = BorderStroke(1.dp, Color(0xFFA78BFA))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("📗", fontSize = 12.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("සටහන්", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFA78BFA))
                            }
                        }
                    }
                    item {
                        Surface(
                            onClick = { activeTab = 1 }, // Auto-Checker
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFFD97706).copy(alpha = 0.25f),
                            border = BorderStroke(1.dp, Color(0xFFFBBF24))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("⚡", fontSize = 12.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("ප්‍රශ්න 500", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFFFBBF24))
                            }
                        }
                    }
                    item {
                        Surface(
                            onClick = { showSyllabusModal = true },
                            shape = RoundedCornerShape(20.dp),
                            color = Color(0xFF0D9488).copy(alpha = 0.25f),
                            border = BorderStroke(1.dp, Color(0xFF2DD4BF))
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("📜", fontSize = 12.sp)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("ශ්‍රේණිගතය", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2DD4BF))
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

                // White Surface Box with 4 Tabs matching Screenshot 20261027-103528
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = Color.White,
                    shadowElevation = 2.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        val tabs = listOf(
                            Triple("📄", "කෙටි සටහන්", 0),
                            Triple("❓", "ප්‍රශ්න පත්‍ර", 1),
                            Triple("📖", "ස්වයං පුහුණු", 2),
                            Triple("✦", "AI Assistant", 3)
                        )
                        tabs.forEach { (emoji, label, index) ->
                            val isSelected = activeTab == index
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .clickable { activeTab = index }
                                    .padding(vertical = 8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Text(
                                        text = emoji,
                                        fontSize = 12.sp,
                                        color = if (isSelected) Color(0xFF0284C7) else Color(0xFF64748B)
                                    )
                                    Spacer(modifier = Modifier.width(3.dp))
                                    Text(
                                        text = label,
                                        fontSize = 11.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                                        color = if (isSelected) Color(0xFF0284C7) else Color(0xFF475569)
                                    )
                                }
                                if (isSelected) {
                                    Spacer(modifier = Modifier.height(4.dp))
                                    Box(
                                        modifier = Modifier
                                            .width(36.dp)
                                            .height(2.5.dp)
                                            .clip(RoundedCornerShape(2.dp))
                                            .background(Color(0xFF0284C7))
                                    )
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // Main Green/Emerald Master Hub Container Box matching Screenshot 20261027-103528
                Box(modifier = Modifier.weight(1f)) {
                    when (activeTab) {
                        0 -> {
                            Surface(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 8.dp, vertical = 4.dp),
                                shape = RoundedCornerShape(16.dp),
                                color = Color(0xFF022C22), // Emerald dark green container
                                border = BorderStroke(1.5.dp, Color(0xFF10B981))
                            ) {
                                Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
                                    // Header of Master Hub
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Row(
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Text("🔬", fontSize = 18.sp)
                                            Spacer(modifier = Modifier.width(6.dp))
                                            Text(
                                                text = "10 & 11 භූගෝල විද්‍යාව විෂය නිර්දේශ Master Hub",
                                                color = Color.White,
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.Bold,
                                                maxLines = 1,
                                                overflow = TextOverflow.Ellipsis
                                            )
                                        }
                                        Surface(
                                            shape = RoundedCornerShape(12.dp),
                                            color = Color(0xFFF59E0B)
                                        ) {
                                            Text(
                                                text = "100% ආවරණය",
                                                color = Color(0xFF1E1B4B),
                                                fontSize = 10.sp,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(2.dp))
                                    Text(
                                        text = "සිතියම් • භෞතික භූගෝල විද්‍යාව • මානසික භූගෝල විද්‍යාව • ආපදා • කරුණු 400",
                                        color = Color(0xFF6EE7B7),
                                        fontSize = 10.5.sp
                                    )

                                    Spacer(modifier = Modifier.height(10.dp))

                                    // Grade Selector Buttons inside Green Master Hub
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        Button(
                                            onClick = { currentGradeTab = "10" },
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = if (currentGradeTab == "10") Color(0xFF10B981) else Color(0xFF064E3B)
                                            ),
                                            shape = RoundedCornerShape(8.dp),
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(38.dp)
                                        ) {
                                            Text(
                                                text = "📖 10 ශ්‍රේණිය",
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                        }
                                        Button(
                                            onClick = { currentGradeTab = "11" },
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = if (currentGradeTab == "11") Color(0xFF10B981) else Color(0xFF064E3B)
                                            ),
                                            shape = RoundedCornerShape(8.dp),
                                            modifier = Modifier
                                                .weight(1f)
                                                .height(38.dp)
                                        ) {
                                            Text(
                                                text = "📙 11 ශ්‍රේණිය (O/L)",
                                                fontSize = 12.sp,
                                                fontWeight = FontWeight.Bold,
                                                color = Color.White
                                            )
                                        }
                                    }

                                    Spacer(modifier = Modifier.height(12.dp))

                                    val gridScrollState = rememberScrollState()
                                    LaunchedEffect(currentGradeTab) {
                                        gridScrollState.scrollTo(0)
                                    }
                                    Box(modifier = Modifier.fillMaxSize().verticalScroll(gridScrollState)) {
                                        GeographyQuickOverviewGrid(
                                            categories = masterCategories.filter { cat ->
                                                if (currentGradeTab == "10") cat.categoryNumber <= 10 else cat.categoryNumber > 10
                                            }.ifEmpty { masterCategories },
                                            onSelectModule = { selectedCategoryNumber = it }
                                        )
                                    }
                                }
                            }
                        }
                        1 -> {
                            // Interactive Auto-Checker Workbook
                            val filteredQuestions = autoCheckQuestions.filter { q ->
                                when (currentGradeTab) {
                                    "10" -> q.gradeLevel == GeoGradeLevel.GRADE_10 || q.gradeLevel == GeoGradeLevel.ALL
                                    else -> q.gradeLevel == GeoGradeLevel.GRADE_11 || q.gradeLevel == GeoGradeLevel.ALL
                                }
                            }
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 12.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                item {
                                    Surface(
                                        shape = RoundedCornerShape(10.dp),
                                        color = Color(0xFF1E293B),
                                        border = BorderStroke(1.dp, Color(0xFF334155)),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(12.dp)) {
                                            Text(
                                                text = "⚡ භූගෝල විද්‍යාව ස්වයංක්‍රීය පිළිතුරු පරීක්ෂාව (Auto-Check)",
                                                color = Color(0xFF34D399),
                                                fontSize = 13.sp,
                                                fontWeight = FontWeight.Bold
                                            )
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Text(
                                                text = "පිළිතුරක් තෝරාගත් වහාම 100% නිවැරදිදැයි තහවුරු කර, සවිස්තරාත්මක විවරණය සහ විභාග ඉඟි ලබා ගන්න.",
                                                color = Color(0xFF94A3B8),
                                                fontSize = 11.sp,
                                                lineHeight = 15.sp
                                            )
                                        }
                                    }
                                }
                                items(filteredQuestions) { question ->
                                    GeoAutoCheckCard(question = question)
                                }
                            }
                        }
                        2 -> {
                            // Q&A Hub & Flashcards Tab matching Screenshot 2
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 12.dp),
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                item {
                                    Surface(
                                        shape = RoundedCornerShape(12.dp),
                                        color = Color(0xFF1E293B),
                                        border = BorderStroke(1.dp, Color(0xFF7C3AED)),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(modifier = Modifier.padding(14.dp)) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Text("🎯", fontSize = 20.sp)
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text(
                                                    text = "භූගෝල විද්‍යාව Q&A & Flashcards Hub",
                                                    color = Color.White,
                                                    fontSize = 14.sp,
                                                    fontWeight = FontWeight.Bold
                                                )
                                            }
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Text(
                                                text = "10 සහ 11 ශ්‍රේණි කෙටි පිළිතුරු, රචනා ප්‍රශ්න, Daily 10 සහ මතක තබා ගැනීමේ Flashcards.",
                                                color = Color(0xFF94A3B8),
                                                fontSize = 11.sp
                                            )
                                        }
                                    }
                                }
                                item {
                                    GeoQaFlashcardSection(currentGrade = currentGradeTab)
                                }
                            }
                        }
                        3 -> {
                            // PDF Notes & Workbook Viewer Tab matching Screenshot 2
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(horizontal = 12.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                item {
                                    Card(
                                        shape = RoundedCornerShape(12.dp),
                                        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                                        border = BorderStroke(1.dp, Color(0xFF059669)),
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Text("📄", fontSize = 32.sp)
                                            Spacer(modifier = Modifier.height(8.dp))
                                            Text(
                                                text = "10 සහ 11 ශ්‍රේණි භූගෝල විද්‍යාව සම්පූර්ණ PDF කෙටි සටහන්",
                                                color = Color.White,
                                                fontSize = 14.sp,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center
                                            )
                                            Spacer(modifier = Modifier.height(4.dp))
                                            Text(
                                                text = "නිල විෂය නිර්දේශයට අදාළ සියලුම 1:50,000 සිතියම්, ප්‍රස්තාර, සටහන් සහ පින්තූර අඩංගු ගොනුව (පිටු 93).",
                                                color = Color(0xFF94A3B8),
                                                fontSize = 11.5.sp,
                                                textAlign = TextAlign.Center,
                                                lineHeight = 16.sp
                                            )
                                            Spacer(modifier = Modifier.height(12.dp))
                                            Button(
                                                onClick = { showPdfViewerModal = true },
                                                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF059669)),
                                                shape = RoundedCornerShape(8.dp),
                                                modifier = Modifier.fillMaxWidth().height(42.dp)
                                            ) {
                                                Icon(Icons.Default.Visibility, contentDescription = null, tint = Color.White, modifier = Modifier.size(16.dp))
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text("PDF ගොනුව විවෘත කර බලන්න", fontSize = 12.sp, fontWeight = FontWeight.Bold, color = Color.White)
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
    }

    if (showPdfViewerModal) {
        GeoPdfViewerDialog(
            pdfUrl = GeographyAutoCheckerRepository.pdfDriveUrl,
            onDismiss = { showPdfViewerModal = false }
        )
    }

    if (showProgressModal) {
        GeoProgressDialog(onDismiss = { showProgressModal = false })
    }

    if (showSyllabusModal) {
        GeoSyllabusDialog(onDismiss = { showSyllabusModal = false })
    }
}

@Composable
fun GeoAutoCheckCard(question: GeoAutoCheckQuestion) {
    var selectedIndex by remember { mutableStateOf<Int?>(null) }
    var isExplanationExpanded by remember { mutableStateOf(false) }

    val isAnswered = selectedIndex != null
    val isCorrect = selectedIndex == question.correctOptionIndex

    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
        border = BorderStroke(1.dp, if (isAnswered) (if (isCorrect) Color(0xFF10B981) else Color(0xFFEF4444)) else Color(0xFF334155)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = Color(0xFF059669).copy(alpha = 0.25f),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(
                        text = "ප්‍රශ්න අංක ${question.number} • ${question.category.displayName}",
                        color = Color(0xFF34D399),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                }
                Text(
                    text = question.pdfPageRef,
                    color = Color(0xFF94A3B8),
                    fontSize = 10.sp
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = question.unitTitle,
                color = Color(0xFFFDE68A),
                fontSize = 11.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = question.questionPrompt,
                color = Color.White,
                fontSize = 12.5.sp,
                fontWeight = FontWeight.SemiBold,
                lineHeight = 17.sp
            )

            if (!question.subQuestionOrContext.isNullOrBlank()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = question.subQuestionOrContext!!,
                    color = Color(0xFF94A3B8),
                    fontSize = 11.sp,
                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            question.options.forEachIndexed { idx, optionText ->
                val isThisSelected = selectedIndex == idx
                val isThisCorrect = idx == question.correctOptionIndex

                val optionBg = when {
                    !isAnswered -> Color(0xFF0F172A)
                    isThisCorrect -> Color(0xFF065F46)
                    isThisSelected && !isCorrect -> Color(0xFF7F1D1D)
                    else -> Color(0xFF0F172A)
                }
                val borderColor = when {
                    !isAnswered -> Color(0xFF334155)
                    isThisCorrect -> Color(0xFF10B981)
                    isThisSelected && !isCorrect -> Color(0xFFEF4444)
                    else -> Color(0xFF334155)
                }

                Surface(
                    color = optionBg,
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(0.8.dp, borderColor),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 3.dp)
                        .clickable(enabled = !isAnswered) {
                            selectedIndex = idx
                        }
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(18.dp)
                                .clip(CircleShape)
                                .background(if (isAnswered && isThisCorrect) Color(0xFF10B981) else Color(0xFF334155)),
                            contentAlignment = Alignment.Center
                        ) {
                            if (isAnswered && (isThisCorrect || isThisSelected)) {
                                Icon(
                                    imageVector = if (isThisCorrect) Icons.Default.Check else Icons.Default.Close,
                                    contentDescription = null,
                                    tint = Color.White,
                                    modifier = Modifier.size(12.dp)
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = optionText,
                            fontSize = 11.5.sp,
                            color = Color.White,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            if (isAnswered) {
                Spacer(modifier = Modifier.height(8.dp))
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    color = if (isCorrect) Color(0xFF065F46).copy(alpha = 0.3f) else Color(0xFF7F1D1D).copy(alpha = 0.3f),
                    border = BorderStroke(1.dp, if (isCorrect) Color(0xFF10B981) else Color(0xFFEF4444)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = if (isCorrect) Icons.Default.CheckCircle else Icons.Default.Cancel,
                                contentDescription = null,
                                tint = if (isCorrect) Color(0xFF4ADE80) else Color(0xFFF87171),
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(6.dp))
                            Text(
                                text = if (isCorrect) "නිවැරදියි! (100% Correct)" else "වැරදියි!",
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                color = if (isCorrect) Color(0xFF4ADE80) else Color(0xFFF87171)
                            )
                        }
                        TextButton(
                            onClick = { isExplanationExpanded = !isExplanationExpanded },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text(
                                text = if (isExplanationExpanded) "විවරණය සඟවන්න" else "විවරණය බලන්න",
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF38BDF8)
                            )
                        }
                    }
                }
            }

            AnimatedVisibility(
                visible = isExplanationExpanded || (isAnswered && !isCorrect),
                enter = fadeIn() + expandVertically(),
                exit = fadeOut() + shrinkVertically()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF0F172A))
                        .padding(10.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("💡", fontSize = 14.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "සවිස්තරාත්මක විෂය නිර්දේශ විවරණය:",
                            fontSize = 11.5.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF3F4F6)
                        )
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = question.explanationSinhala,
                        fontSize = 11.sp,
                        color = Color(0xFFD1D5DB),
                        lineHeight = 16.sp
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Surface(
                        shape = RoundedCornerShape(6.dp),
                        color = Color(0xFF1E293B),
                        border = BorderStroke(1.dp, Color(0xFF334155)),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text("📌", fontSize = 12.sp)
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = question.syllabusKeyFact,
                                fontSize = 10.5.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = Color(0xFF6EE7B7)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "🎯 විභාග ඉඟිය: ${question.examTip}",
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFFFBBF24)
                    )
                }
            }
        }
    }
}

@Composable
private fun GeoPdfViewerDialog(
    pdfUrl: String,
    onDismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF0F172A)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF1E293B))
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = onDismiss) {
                            Icon(Icons.Default.Close, contentDescription = "වසන්න", tint = Color.White)
                        }
                        Spacer(modifier = Modifier.width(6.dp))
                        Column {
                            Text(
                                text = "10/11 භූගෝල විද්‍යාව කෙටි සටහන් මුල් PDF ගොනුව",
                                color = Color.White,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Google Drive Secure Viewer (පිටු 93 ක්)",
                                color = Color(0xFF94A3B8),
                                fontSize = 10.5.sp
                            )
                        }
                    }
                }
                AndroidView(
                    factory = { context ->
                        WebView(context).apply {
                            settings.javaScriptEnabled = true
                            settings.domStorageEnabled = true
                            settings.loadWithOverviewMode = true
                            settings.useWideViewPort = true
                            settings.builtInZoomControls = true
                            settings.displayZoomControls = false
                            webViewClient = WebViewClient()
                            loadUrl(pdfUrl)
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

enum class GeoGradeLevel(val label: String, val badgeColor: Color) {
    ALL("සියලු ශ්‍රේණි (10, 11)", Color(0xFF0F172A)),
    GRADE_10("10 ශ්‍රේණිය", Color(0xFF0369A1)),
    GRADE_11("11 ශ්‍රේණිය (O/L)", Color(0xFF047857))
}

enum class GeoUnitCategory(val displayName: String, val iconEmoji: String, val primaryColor: Color, val bgLightColor: Color) {
    ALL("සියලු පාඩම්", "🌍", Color(0xFF1E293B), Color(0xFFF1F5F9)),
    EARTH_COMPOSITION("පෘථිවියේ සංයුතිය හා ව්‍යුහය", "🪐", Color(0xFF0284C7), Color(0xFFE0F2FE)),
    PHYSICAL_FEATURES("ප්‍රධාන භෞතික ලක්ෂණ & සිතියම්", "⛰️", Color(0xFF0D9488), Color(0xFFCCFBF1)),
    AGRICULTURE_LAND("කෘෂිකාර්මික භූමි පරිභෝගය", "🌾", Color(0xFF15803D), Color(0xFFDCFCE7)),
    SRI_LANKA_INDUSTRIES("ශ්‍රී ලංකාවේ කර්මාන්ත & ඛනිජ", "🏭", Color(0xFFB45309), Color(0xFFFEF3C7)),
    NATURAL_RESOURCES("ලෝක හා ලංකා ස්වාභාවික සම්පත්", "💎", Color(0xFF7C3AED), Color(0xFFEDE9FE)),
    POPULATION_DEMOGRAPHY("ලෝක හා ලංකා ජන සංඛ්‍යාව", "👥", Color(0xFFBE185D), Color(0xFFFCE7F3)),
    DEVELOPMENT_HDI("සංවර්ධනය & මානව සංවර්ධන දර්ශකය", "📈", Color(0xFF2563EB), Color(0xFFDBEAFE)),
    NATURAL_HAZARDS("ස්වාභාවික උපද්‍රව & ආපදා කළමනාකරණය", "⚠️", Color(0xFFDC2626), Color(0xFFFEE2E2)),
    CLIMATE_CHANGE("දේශගුණික වෙනස්වීම් & ගෝලීය උණුසුම", "🌡️", Color(0xFFEA580C), Color(0xFFFFEDD5)),
    TOPO_MAPS_50000("1:50,000 භූ ලක්ෂණ සිතියම් & ප්‍රස්තාර", "🗺️", Color(0xFF0F766E), Color(0xFFD1FAE5))
}

data class GeoAutoCheckQuestion(
    val id: String,
    val number: Int,
    val gradeLevel: GeoGradeLevel,
    val category: GeoUnitCategory,
    val unitTitle: String,
    val questionPrompt: String,
    val subQuestionOrContext: String? = null,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanationSinhala: String,
    val syllabusKeyFact: String,
    val examTip: String,
    val pdfPageRef: String
)

object GeographyAutoCheckerRepository {
    const val pdfDriveUrl = "https://drive.google.com/file/d/1Fc1DqvZWVv7aiIC35KgWfl5Spjj-5WV_/preview"
    val allQuestions: List<GeoAutoCheckQuestion> = listOf(
        GeoAutoCheckQuestion(
            id = "geo_q1_atmosphere_gases",
            number = 1,
            gradeLevel = GeoGradeLevel.GRADE_10,
            category = GeoUnitCategory.EARTH_COMPOSITION,
            unitTitle = "10 ශ්‍රේණිය - පෘථිවියේ සංයුතිය (වායුගෝලීය සංයුතිය)",
            questionPrompt = "වායුගෝලයේ අඩංගු වායූන්ගේ පරිමාව අනුව 78.09% ක් සහ 20.95% ක් ලෙස පිළිවෙළින් අඩංගු වන ප්‍රධාන වායු යුගලය කුමක්ද?",
            subQuestionOrContext = "PDF පිටුව 2 - වායුගෝලයේ වායු වර්ග නම් කිරීමේ වට ප්‍රස්තාරය",
            options = listOf(
                "1. ඔක්සිජන් සහ කාබන්ඩයොක්සයිඩ්",
                "2. නයිට්‍රජන් (78.09%) සහ ඔක්සිජන් (20.95%)",
                "3. ආගන් සහ හීලියම්",
                "4. කාබන්ඩයොක්සයිඩ් සහ නයිට්‍රජන්"
            ),
            correctOptionIndex = 1,
            explanationSinhala = "පෘථිවි වායුගෝලයේ මුළු වායු පරිමාවෙන් 78.09% ක් නයිට්‍රජන් (N₂) ද, 20.95% ක් ඔක්සිජන් (O₂) ද අඩංගු වේ. ආගන් 0.93% ක් සහ කාබන්ඩයොක්සයිඩ් 0.03% ක් වන අතර අනෙකුත් සියලු වායු 0.04% ක් පමණ වේ.",
            syllabusKeyFact = "නයිට්‍රජන් 78.09% • ඔක්සිජන් 20.95% • ආගන් 0.93% • කාබන්ඩයොක්සයිඩ් 0.03%",
            examTip = "සමස්ත වායුගෝලීය වායූන්ගෙන් 99% ක්ම නයිට්‍රජන් සහ ඔක්සිජන් වායු දෙකෙන් සමන්විත වේ.",
            pdfPageRef = "පිටුව 2"
        ),
        GeoAutoCheckQuestion(
            id = "geo_q2_earth_spheres",
            number = 2,
            gradeLevel = GeoGradeLevel.GRADE_10,
            category = GeoUnitCategory.EARTH_COMPOSITION,
            unitTitle = "10 ශ්‍රේණිය - පෘථිවියේ සංයුතිය (උප පද්ධති 4)",
            questionPrompt = "පෘථිවි පද්ධතිය සමන්විත වන ප්‍රධාන උප පද්ධති 4 නිවැරදිව දක්වා ඇති පිළිතුර කුමක්ද?",
            subQuestionOrContext = "PDF පිටුව 1 - ප්‍රශ්න අංක 01 (i)",
            options = listOf(
                "1. ශිලා ගෝලය, ජල ගෝලය, වායු ගෝලය, ජෛව ගෝලය",
                "2. සූර්ය ගෝලය, චන්ද්‍ර ගෝලය, ගුරුත්ව ගෝලය, චුම්බක ගෝලය",
                "3. මහාද්වීපික කබොල, සාගරික කබොල, ප්‍රාවරය, හරය",
                "4. පරිවර්තී ගෝලය, අපරිවර්තී ගෝලය, මධ්‍ය ගෝලය, තාප ගෝලය"
            ),
            correctOptionIndex = 0,
            explanationSinhala = "පෘථිවි පද්ධතියේ ප්‍රධාන උප පද්ධති 4 වන්නේ: 1. ශිලා ගෝලය (Lithosphere), 2. ජල ගෝලය (Hydrosphere), 3. වායු ගෝලය (Atmosphere), 4. ජෛව ගෝලය (Biosphere) යි. මෙම පද්ධති 4 අතර අන්තර් ක්‍රියාකාරිත්වයෙන් ජීවය පවත්වා ගනී.",
            syllabusKeyFact = "පෘථිවියේ ප්‍රධාන උප පද්ධති 4: ශිලා, ජල, වායු සහ ජෛව ගෝලයයි.",
            examTip = "මෙම පද්ධති 4 එකිනෙක මත රඳා පවතින අන්තර් සම්බන්ධිත ජාලයක් ලෙස ක්‍රියා කරයි.",
            pdfPageRef = "පිටුව 1"
        )
    )
}

@Composable
fun GeographyQuickOverviewGrid(
    categories: List<SubjectMasterCategory>,
    onSelectModule: (Int) -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        for (i in categories.indices step 4) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                for (j in 0 until 4) {
                    if (i + j < categories.size) {
                        GeographyFeatureButton(
                            category = categories[i + j],
                            modifier = Modifier.weight(1f),
                            onClick = { onSelectModule(categories[i + j].categoryNumber) }
                        )
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Composable
fun GeographyFeatureButton(
    category: SubjectMasterCategory?,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val catColor = category?.color ?: Color(0xFF059669)
    val shortTitle = when (category?.categoryNumber) {
        1 -> "1:50k සිතියම්"
        2 -> "සමෝච්ච රේඛා"
        3 -> "ජලාපවහන"
        4 -> "දේශගුණය"
        5 -> "මෝසම් වැසි"
        6 -> "වෘක්ෂලතා"
        7 -> "පස් වර්ග"
        8 -> "ඛනිජ සම්පත්"
        9 -> "ජනගහනය"
        10 -> "කෘෂිකර්මය"
        else -> category?.titleSinhala ?: ""
    }

    Surface(
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFF1E293B),
        border = BorderStroke(1.dp, catColor.copy(alpha = 0.7f)),
        modifier = modifier.height(98.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Surface(
                shape = CircleShape,
                color = catColor.copy(alpha = 0.3f),
                modifier = Modifier.size(32.dp)
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Text(category?.icon ?: "🌍", fontSize = 14.sp)
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${category?.categoryNumber}. $shortTitle",
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                lineHeight = 12.sp
            )
        }
    }
}

@Composable
fun GeoQaFlashcardSection(currentGrade: String) {
    var revealedIndex by remember { mutableStateOf<Int?>(null) }
    val qaItems = remember(currentGrade) {
        if (currentGrade == "10") {
            listOf(
                Triple("10 ශ්‍රේණිය • සමෝච්ච අන්තරය", "1:50,000 සිතියමක සමෝච්ච අන්තරය කොපමණද?", "මීටර් 20 කි (Contour Interval = 20m)"),
                Triple("10 ශ්‍රේණිය • වායුගෝලීය වායු", "වායුගෝලයේ වැඩිම පරිමාවක් අඩංගු වායුව කුමක්ද?", "නයිට්‍රජන් (78.09%)"),
                Triple("10 ශ්‍රේණිය • ජලාපවහන රටා", "මධ්‍යම කඳුකරයේ සිට සියලු දිශාවලට විහිදෙන ජලාපවහන රටාව කුමක්ද?", "අරීය ජලාපවහන රටාව (Radial Drainage)"),
                Triple("10 ශ්‍රේණිය • ගංගා ද්‍රෝණි", "ශ්‍රී ලංකාවේ දිගම ගංගාව කුමක්ද? එහි දිග කොපමණද?", "මහවැලි ගඟ (335 km)")
            )
        } else {
            listOf(
                Triple("11 ශ්‍රේණිය • ජනගහන ව්‍යාප්තිය", "ශ්‍රී ලංකාවේ ජනගහනය වැඩිපුරම සාන්ද්‍රණය වී ඇති පරිපාලන දිස්ත්‍රික්කය කුමක්ද?", "කොළඹ දිස්ත්‍රික්කය"),
                Triple("11 ශ්‍රේණිය • කර්මාන්ත", "ලංකාවේ නිමි ඇඳුම් කර්මාන්තයේ ප්‍රධාන අපනයන වෙළඳපොළ කුමක්ද?", "ඇමෙරිකා එක්සත් ජනපදය සහ යුරෝපා සංගමය"),
                Triple("11 ශ්‍රේණිය • ආපදා කළමනාකරණය", "සුනාමි රළ ඇතිවීමට බලපාන ප්‍රධාන ස්වාභාවික හේතුව කුමක්ද?", "මුහුදු පතුලේ සිදුවන රික්ටර් මාපක 7 ට වැඩි භූමිකම්පා"),
                Triple("11 ශ්‍රේණිය • HDI දර්ශකය", "මානව සංවර්ධන දර්ශකය (HDI) ගණනයට ගන්නා ප්‍රධාන සංරචක 3 මොනවාද?", "ආයු අපේක්ෂාව, අධ්‍යාපනය සහ ඒක පුද්ගල ආදායම")
            )
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        qaItems.forEachIndexed { idx, item ->
            val isRevealed = revealedIndex == idx
            Card(
                shape = RoundedCornerShape(10.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                border = BorderStroke(1.dp, if (isRevealed) Color(0xFF10B981) else Color(0xFF334155)),
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { revealedIndex = if (isRevealed) null else idx }
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text(
                        text = item.first,
                        color = Color(0xFF38BDF8),
                        fontSize = 10.5.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "❓ ${item.second}",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    if (isRevealed) {
                        Surface(
                            shape = RoundedCornerShape(6.dp),
                            color = Color(0xFF065F46).copy(alpha = 0.4f),
                            border = BorderStroke(1.dp, Color(0xFF10B981)),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "💡 පිළිතුර: ${item.third}",
                                color = Color(0xFF6EE7B7),
                                fontSize = 11.5.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    } else {
                        Text(
                            text = "👉 පිළිතුර බලන්න මෙතැන ක්ලික් කරන්න...",
                            color = Color(0xFF94A3B8),
                            fontSize = 10.5.sp,
                            fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun GeoProgressDialog(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF0F172A),
            border = BorderStroke(1.5.dp, Color(0xFF38BDF8))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("📊", fontSize = 24.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "භූගෝල විද්‍යාව අධ්‍යයන ප්‍රගතිය",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                val progressItems = listOf(
                    Triple("Master Hub 20 කාණ්ඩ", "100% නිමයි (කරුණු 400)", Color(0xFF10B981)),
                    Triple("1:50,000 සිතියම් ලකුණු කිරීම", "100% ආවරණය", Color(0xFF0284C7)),
                    Triple("Auto-Checker ප්‍රශ්න පත්‍ර", "ලකුණු 100/100", Color(0xFFF59E0B)),
                    Triple("10 & 11 මුල් PDF කෙටි සටහන්", "පිටු 93 සම්පූර්ණයි", Color(0xFF8B5CF6))
                )

                progressItems.forEach { item ->
                    Column(modifier = Modifier.padding(vertical = 6.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(item.first, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                            Text(item.second, color = item.third, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                        Spacer(modifier = Modifier.height(4.dp))
                        LinearProgressIndicator(
                            progress = { 1.0f },
                            modifier = Modifier.fillMaxWidth().height(6.dp).clip(RoundedCornerShape(3.dp)),
                            color = item.third,
                            trackColor = Color(0xFF334155)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0284C7)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("තහවුරුයි - ඉදිරියට යන්න", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun GeoSyllabusDialog(onDismiss: () -> Unit) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(0.92f)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            color = Color(0xFF0F172A),
            border = BorderStroke(1.5.dp, Color(0xFF2DD4BF))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("📜", fontSize = 24.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "O/L නිල භූගෝල විද්‍යා විෂය නිර්දේශය",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    IconButton(onClick = onDismiss) {
                        Icon(Icons.Default.Close, contentDescription = "Close", tint = Color.White)
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("📘 10 ශ්‍රේණිය: පෘථිවියේ සංයුතිය, 1:50,000 සිතියම්, සමෝච්ච රේඛා, ජලාපවහනය, ශ්‍රී ලංකාවේ දේශගුණය & ස්වාභාවික සම්පත්.", color = Color(0xFFCBD5E1), fontSize = 11.5.sp, lineHeight = 16.sp)
                    Text("📙 11 ශ්‍රේණිය: ජනගහන ව්‍යාප්තිය, කර්මාන්ත, නාගරීකරණය, මානව සංවර්ධන දර්ශකය, ස්වාභාවික ආපදා & ගෝලීය උණුසුම.", color = Color(0xFFCBD5E1), fontSize = 11.5.sp, lineHeight = 16.sp)
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0D9488)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("හරි, තේරුණා", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

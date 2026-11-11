package com.example

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

// ==============================================================================
// GEOMETRY STRUCTURED QUESTIONS & RIDERS DATA MODELS
// 20 Categories x 20 Questions = 400 Total O/L Structured Geometry Questions
// ==============================================================================

data class GeometryStep(
  val statement: String,
  val reason: String
)

data class GeometryRiderQuestion(
  val subNumber: String,
  val questionText: String,
  val solutionSteps: List<String>,
  val finalAnswer: String
)

data class GeometryStructuredQuestion(
  val questionNumber: Int, // 1 to 20
  val questionTitle: String,
  val structuredQuestionText: String,
  val givenData: String,
  val toProve: String,
  val construction: String = "අවශ්‍ය නොවේ.",
  val proofSteps: List<GeometryStep>,
  val riderExplanation: String,
  val riderQuestion: GeometryRiderQuestion,
  val examTips: String
)

data class GeometryCategory(
  val categoryId: Int, // 1 to 20
  val titleSinhala: String,
  val shortTitle: String,
  val theoremConcept: String,
  val gradeLevel: String, // "10 ශ්‍රේණිය" or "11 ශ්‍රේණිය (O/L)"
  val diagramType: String,
  val generalSolvingStrategy: String,
  val questions: List<GeometryStructuredQuestion> // exactly 20 questions
)

// Legacy item definition for compatibility if needed
data class GeometryCategoryItem(
  val categoryId: Int,
  val titleSinhala: String,
  val theoremConcept: String,
  val gradeLevel: String,
  val diagramType: String,
  val structuredQuestionText: String,
  val givenData: String,
  val toProve: String,
  val construction: String,
  val proofSteps: List<GeometryStep>,
  val riderExplanation: String,
  val riderQuestions: List<GeometryRiderQuestion>,
  val examTips: String
)

// ==============================================================================
// CUSTOM GEOMETRIC DIAGRAM COMPONENT
// ==============================================================================

@Composable
fun GeometricDiagramCanvas(
  diagramType: String,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .height(180.dp)
      .clip(RoundedCornerShape(12.dp))
      .background(Color(0xFFF8FAFC))
      .border(1.dp, Color(0xFFCBD5E1), RoundedCornerShape(12.dp)),
    contentAlignment = Alignment.Center
  ) {
    Canvas(modifier = Modifier.fillMaxSize().padding(16.dp)) {
      val w = size.width
      val h = size.height
      val strokeColor = Color(0xFF1E293B)
      val accentColor = Color(0xFF2563EB)
      val dashedColor = Color(0xFFDC2626)
      val strokeW = 3f

      when (diagramType) {
        "CHORD", "ANGLE_CENTER", "SAME_SEGMENT", "SEMI_CIRCLE", "CYCLIC_QUAD", "TANGENT", "ALT_SEGMENT" -> {
          // Draw Circle
          val center = Offset(w / 2f, h / 2f)
          val radius = minOf(w, h) * 0.42f
          drawCircle(
            color = Color(0xFFE2E8F0),
            radius = radius,
            center = center
          )
          drawCircle(
            color = strokeColor,
            radius = radius,
            center = center,
            style = Stroke(width = strokeW)
          )
          // Draw Center dot
          drawCircle(color = accentColor, radius = 5f, center = center)

          if (diagramType == "CHORD") {
            // Draw Chord AB and Perpendicular ON
            val pA = Offset(center.x - radius * 0.8f, center.y + radius * 0.5f)
            val pB = Offset(center.x + radius * 0.8f, center.y + radius * 0.5f)
            val pN = Offset(center.x, center.y + radius * 0.5f)
            drawLine(strokeColor, pA, pB, strokeWidth = strokeW)
            drawLine(dashedColor, center, pN, strokeWidth = strokeW)
            drawLine(Color(0xFF10B981), center, pA, strokeWidth = 2f)
            drawLine(Color(0xFF10B981), center, pB, strokeWidth = 2f)
          } else if (diagramType == "SEMI_CIRCLE") {
            // Diameter AB & Point C
            val pA = Offset(center.x - radius, center.y)
            val pB = Offset(center.x + radius, center.y)
            val pC = Offset(center.x + radius * 0.3f, center.y - radius * 0.95f)
            drawLine(strokeColor, pA, pB, strokeWidth = strokeW + 1f)
            drawLine(accentColor, pA, pC, strokeWidth = strokeW)
            drawLine(accentColor, pB, pC, strokeWidth = strokeW)
          } else if (diagramType == "ANGLE_CENTER") {
            val pA = Offset(center.x - radius * 0.7f, center.y + radius * 0.7f)
            val pB = Offset(center.x + radius * 0.7f, center.y + radius * 0.7f)
            val pP = Offset(center.x, center.y - radius)
            drawLine(strokeColor, center, pA, strokeWidth = strokeW)
            drawLine(strokeColor, center, pB, strokeWidth = strokeW)
            drawLine(accentColor, pP, pA, strokeWidth = strokeW)
            drawLine(accentColor, pP, pB, strokeWidth = strokeW)
          } else if (diagramType == "SAME_SEGMENT") {
            val pA = Offset(center.x - radius * 0.8f, center.y + radius * 0.6f)
            val pB = Offset(center.x + radius * 0.8f, center.y + radius * 0.6f)
            val pP = Offset(center.x - radius * 0.4f, center.y - radius * 0.9f)
            val pQ = Offset(center.x + radius * 0.4f, center.y - radius * 0.9f)
            drawLine(strokeColor, pA, pB, strokeWidth = strokeW)
            drawLine(accentColor, pP, pA, strokeWidth = 2f)
            drawLine(accentColor, pP, pB, strokeWidth = 2f)
            drawLine(Color(0xFFD97706), pQ, pA, strokeWidth = 2f)
            drawLine(Color(0xFFD97706), pQ, pB, strokeWidth = 2f)
          } else if (diagramType == "CYCLIC_QUAD") {
            val pA = Offset(center.x - radius * 0.7f, center.y - radius * 0.7f)
            val pB = Offset(center.x + radius * 0.7f, center.y - radius * 0.7f)
            val pC = Offset(center.x + radius * 0.85f, center.y + radius * 0.5f)
            val pD = Offset(center.x - radius * 0.6f, center.y + radius * 0.8f)
            val quad = Path().apply {
              moveTo(pA.x, pA.y)
              lineTo(pB.x, pB.y)
              lineTo(pC.x, pC.y)
              lineTo(pD.x, pD.y)
              close()
            }
            drawPath(quad, accentColor, style = Stroke(width = strokeW))
          } else if (diagramType == "TANGENT" || diagramType == "ALT_SEGMENT") {
            // Tangent Line at Bottom
            val pContact = Offset(center.x, center.y + radius)
            val tLeft = Offset(center.x - radius * 1.3f, center.y + radius)
            val tRight = Offset(center.x + radius * 1.3f, center.y + radius)
            drawLine(dashedColor, tLeft, tRight, strokeWidth = strokeW)
            drawLine(accentColor, center, pContact, strokeWidth = 2f) // Radius to tangent
            // Triangle in alternate segment
            val pTop = Offset(center.x, center.y - radius)
            val pSide = Offset(center.x - radius * 0.8f, center.y + radius * 0.2f)
            drawLine(strokeColor, pContact, pTop, strokeWidth = strokeW)
            drawLine(strokeColor, pContact, pSide, strokeWidth = strokeW)
            drawLine(strokeColor, pTop, pSide, strokeWidth = strokeW)
          }
        }
        "PARALLELOGRAM" -> {
          // Draw Parallelogram ABCD
          val pA = Offset(w * 0.2f, h * 0.75f)
          val pB = Offset(w * 0.7f, h * 0.75f)
          val pC = Offset(w * 0.85f, h * 0.25f)
          val pD = Offset(w * 0.35f, h * 0.25f)
          val path = Path().apply {
            moveTo(pA.x, pA.y)
            lineTo(pB.x, pB.y)
            lineTo(pC.x, pC.y)
            lineTo(pD.x, pD.y)
            close()
          }
          drawPath(path, strokeColor, style = Stroke(width = strokeW))
          drawLine(dashedColor, pA, pC, strokeWidth = 2f) // Diagonal AC
          drawLine(dashedColor, pB, pD, strokeWidth = 2f) // Diagonal BD
        }
        "MIDPOINT", "PROPORTION", "SIMILAR" -> {
          // Triangle with Midpoints / Parallel Line DE // BC
          val pA = Offset(w * 0.5f, h * 0.15f)
          val pB = Offset(w * 0.15f, h * 0.85f)
          val pC = Offset(w * 0.85f, h * 0.85f)
          val pD = Offset(w * 0.325f, h * 0.5f)
          val pE = Offset(w * 0.675f, h * 0.5f)
          val path = Path().apply {
            moveTo(pA.x, pA.y)
            lineTo(pB.x, pB.y)
            lineTo(pC.x, pC.y)
            close()
          }
          drawPath(path, strokeColor, style = Stroke(width = strokeW))
          drawLine(accentColor, pD, pE, strokeWidth = strokeW + 1f) // DE // BC
        }
        "PARALLEL" -> {
          // Parallel lines AB & CD cut by transversal EF
          drawLine(strokeColor, Offset(w * 0.1f, h * 0.35f), Offset(w * 0.9f, h * 0.35f), strokeWidth = strokeW)
          drawLine(strokeColor, Offset(w * 0.1f, h * 0.75f), Offset(w * 0.9f, h * 0.75f), strokeWidth = strokeW)
          drawLine(dashedColor, Offset(w * 0.25f, h * 0.15f), Offset(w * 0.75f, h * 0.95f), strokeWidth = strokeW)
        }
        "ISOSCELES" -> {
          // Isosceles Triangle AB = AC with altitude AD
          val pA = Offset(w * 0.5f, h * 0.15f)
          val pB = Offset(w * 0.2f, h * 0.85f)
          val pC = Offset(w * 0.8f, h * 0.85f)
          val pD = Offset(w * 0.5f, h * 0.85f)
          val path = Path().apply {
            moveTo(pA.x, pA.y)
            lineTo(pB.x, pB.y)
            lineTo(pC.x, pC.y)
            close()
          }
          drawPath(path, strokeColor, style = Stroke(width = strokeW))
          drawLine(accentColor, pA, pD, strokeWidth = 2f)
        }
        else -> {
          // General Triangle
          val pA = Offset(w * 0.5f, h * 0.15f)
          val pB = Offset(w * 0.15f, h * 0.85f)
          val pC = Offset(w * 0.85f, h * 0.85f)
          val pD = Offset(w * 0.5f, h * 0.85f)
          val path = Path().apply {
            moveTo(pA.x, pA.y)
            lineTo(pB.x, pB.y)
            lineTo(pC.x, pC.y)
            close()
          }
          drawPath(path, strokeColor, style = Stroke(width = strokeW))
          drawLine(dashedColor, pA, pD, strokeWidth = 2f) // Altitude / Median
        }
      }
    }
  }
}

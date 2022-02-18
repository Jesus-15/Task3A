package com.example.task3a

import android.content.Context
import android.util.AttributeSet
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.Style
import android.graphics.Typeface
import android.view.View

public class CustView : View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    //circle and text colors
    private val circleCol: Int = Color.RED
    private val labelCol: Int = Color.YELLOW
    private val backCol: Int = Color.rgb(250,250,200)
    //label text
    private val wordsText: String = "Hello World"
    //paint variables
    private var circlePaint: Paint
    private var backPaint: Paint
    private var wordsPaint: Paint

    private var dotPaint: Paint

    private var xSep: Float = 80f
    private var ySep: Float = 80f
    val columns = 5
    val rows = 10

    init {
        //paint object for drawing circles in onDraw -- also configure it
        circlePaint = Paint().apply {
            setStyle(Style.FILL)
            setAntiAlias(true)

            //set the paint color using the circle color specified
            setColor(circleCol)
        }

        backPaint = Paint().apply {
            // Set up the paint style
            setStyle(Style.FILL)
            setColor(backCol)
        }

        wordsPaint = Paint().apply {
            setColor(labelCol)

            //set text properties
            setTextAlign(Paint.Align.CENTER)
            setTextSize(100.toFloat())
            setTypeface(Typeface.SANS_SERIF)
        }

        dotPaint = Paint().apply {
            // Controls the size of the dot
            setStrokeWidth(1f)
            setStrokeCap(Paint.Cap.ROUND)

            //set the paint color
            setColor(Color.RED)
        }
    }
    override fun onDraw(canvas: Canvas) {
        //draw the View
        // Background
// Measure the size of the canvas, we could take into account padding here
        val canvasWidth = width.toFloat()
        val separationWidth = canvasWidth / (columns + 1)
        val canvasHeight = height.toFloat()
        val separationHeight = canvasHeight / (rows + 1)

// Draw rectangle with drawRect(topleftX, topLeftY, bottomRightX, bottomRightY, Paint)
// Use Ctrl-P to see the parameters for a function
        canvas.drawRect(0f, 0f, canvasWidth, canvasHeight, backPaint)

        // Circle
//get half of the width and height to locate the centre of the screen
        val viewWidthHalf = canvasWidth / 2f
        val viewHeightHalf = canvasHeight / 2f

//get the radius as half of the width or height, whichever is smaller
//subtract twenty so that it has some space around it
        val radius: Float = minOf(viewWidthHalf,viewHeightHalf) - 20

        //canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, circlePaint)

        for (x in 1..columns) {
            for (y in 1..rows) {
                canvas.drawLine(x*separationWidth, y*separationHeight, x*separationWidth*2, y*separationHeight*5,  dotPaint)
            }
        }

        // Text
//draw the text using the string attribute and chosen properties
        //canvas.drawText(wordsText, viewWidthHalf, viewHeightHalf, wordsPaint)
    }
}
package `in`.vedantnukte.moderncalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //clearing the screen
        findViewById<Button>(R.id.allclear).setOnClickListener { createExpression("", true) }

        //entering the numbers
        findViewById<Button>(R.id.zero).setOnClickListener { createExpression("0", false) }
        findViewById<Button>(R.id.one).setOnClickListener { createExpression("1", false) }
        findViewById<Button>(R.id.two).setOnClickListener { createExpression("2", false) }
        findViewById<Button>(R.id.three).setOnClickListener { createExpression("3", false) }
        findViewById<Button>(R.id.four).setOnClickListener { createExpression("4", false) }
        findViewById<Button>(R.id.five).setOnClickListener { createExpression("5", false) }
        findViewById<Button>(R.id.six).setOnClickListener { createExpression("6", false) }
        findViewById<Button>(R.id.seven).setOnClickListener { createExpression("7", false) }
        findViewById<Button>(R.id.eight).setOnClickListener { createExpression("8", false) }
        findViewById<Button>(R.id.nine).setOnClickListener { createExpression("9", false) }
        findViewById<Button>(R.id.dot).setOnClickListener { createExpression(".", false) }

        //entering the operators
        findViewById<Button>(R.id.plus).setOnClickListener { createExpression(" + ", false) }
        findViewById<Button>(R.id.min).setOnClickListener { createExpression(" - ", false) }
        findViewById<Button>(R.id.mul).setOnClickListener { createExpression(" * ", false) }
        findViewById<Button>(R.id.div).setOnClickListener { createExpression(" / ", false) }

        //canceling the last character
        findViewById<Button>(R.id.cancel).setOnClickListener { cancelOne() }

        //evaluating the expression
        findViewById<Button>(R.id.equals).setOnClickListener { evaluate() }
    }

    fun cancelOne() {
        val expression = findViewById<TextView>(R.id.tvnumbers).text.toString()
        if(expression.isNotEmpty()){
            findViewById<TextView>(R.id.tvnumbers).text = expression.substring(0, expression.length - 1)
        }
    }
    fun evaluate() {

       val expression = ExpressionBuilder(findViewById<TextView>(R.id.tvnumbers).text.toString()).build()
       val result = expression.evaluate()
       findViewById<TextView>(R.id.tvresult).text = result.toDouble().toString()
    }

    fun createExpression(string: String, clear: Boolean) {

        if (clear) {
            findViewById<TextView>(R.id.tvnumbers).text = ""
            findViewById<TextView>(R.id.tvresult).text = ""
        } else {
            findViewById<TextView>(R.id.tvnumbers).append(string)
        }
    }
}
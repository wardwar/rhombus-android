package app.by.wildan.rhombus

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            val star =
                if (textInputCount.text.toString().isNotEmpty()) textInputCount.text.toString()
                    .toInt() else 0
            textResult.text = calculate(star)
        }
    }

    private fun calculate(star: Int): String {
        return when {
            star < 5 -> {
                Toast.makeText(this, "Min star is 5", Toast.LENGTH_LONG).show()
                ""
            }
            star > 100 -> {
                Toast.makeText(this, "Max star is 100", Toast.LENGTH_LONG).show()
                ""
            }
            else -> {
                val stringBuilder = StringBuilder()
                var space = 0
                for (i in 0 until star/2) {
                    if (i == 0 || i == star - 1) {
                        if (star % 2 == 1) {
                            stringBuilder.append("*")
                        } else {
                            stringBuilder.append("**")
                        }
                    } else {
                        stringBuilder.append("*")
                    }
                    if (space > 0) {
                        stringBuilder.append(" ".repeat(space))
                        stringBuilder.append("*")
                    }
                    stringBuilder.append(System.getProperty("line.separator"))
                    space++

                }

                if (star % 2 == 0) {
                    space--
                }

                for (i in star/2 until star) {
                    if (i == star-1) {
                        if (star % 2 == 1) {
                            stringBuilder.append("*")
                        } else {
                            stringBuilder.append("**")
                        }
                    }else{
                        stringBuilder.append("*")
                    }

                    if (space > 0) {
                        stringBuilder.append(" ".repeat(space))
                        stringBuilder.append("*")
                    }
                    stringBuilder.append(System.getProperty("line.separator"))
                    space--
                }
                stringBuilder.toString()
            }
        }

    }
}

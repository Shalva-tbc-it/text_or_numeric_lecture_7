package com.example.textornumeric

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.print.PrintAttributes.Margins
import android.text.InputType
import android.util.TypedValue
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import androidx.core.view.setMargins
import com.example.textornumeric.R.color.black_with_alpha
import com.example.textornumeric.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onCheck()
        onClick()

    }

    private fun onCheck() {
        binding.chbTextOrNumeric.setOnCheckedChangeListener { btn, isChecked ->
            btn.setOnClickListener {
                if (isChecked) {
                    binding.chbTextOrNumeric.text = getString(R.string.numeric_checked)
                }else {
                    binding.chbTextOrNumeric.text = getString(R.string.text_uncheck)
                }
            }
        }
    }

    private fun onClick() {

        binding.btnRemoveAllField.setOnClickListener {
            binding.llContainer.removeAllViews()
        }

        binding.btnAddField.setOnClickListener {

            if (binding.chbTextOrNumeric.isChecked) {
                val bottomMarginView = View(this@MainActivity).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        (10 * resources.displayMetrics.density).toInt()
                    )
                }
                val editText = EditText(this@MainActivity).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                    )
                    val hintColor = ContextCompat.getColor(context, black_with_alpha)
                    hint = getString(R.string.numeric)
                    setHintTextColor(hintColor)
                    background = getDrawable(R.drawable.ed_corner)
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_CLASS_NUMBER
                    val dp = 12
                    val density = resources.displayMetrics.density
                    val pixels = (dp * density).toInt()
                    setPadding(pixels, pixels, pixels, pixels)
                }
                binding.llContainer.addView(editText)
                binding.llContainer.addView(bottomMarginView)
            } else {
                val bottomMarginView = View(this@MainActivity).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        (10 * resources.displayMetrics.density).toInt()
                    )
                }
                val editText = EditText(this@MainActivity).apply {
                    layoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                    )
                    val hintColor = ContextCompat.getColor(context, black_with_alpha)
                    hint = getString(R.string.text)
                    setHintTextColor(hintColor)
                    inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_CLASS_TEXT
                    background = getDrawable(R.drawable.ed_corner)
                    val dp = 12
                    val density = resources.displayMetrics.density
                    val pixels = (dp * density).toInt()
                    setPadding(pixels, pixels, pixels, pixels)
                }
                binding.llContainer.addView(editText)
                binding.llContainer.addView(bottomMarginView)
            }
        }

    }

}
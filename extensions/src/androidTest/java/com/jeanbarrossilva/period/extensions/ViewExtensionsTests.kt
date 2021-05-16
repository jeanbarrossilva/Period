package com.jeanbarrossilva.period.extensions

import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.afollestad.materialdialogs.utils.MDUtil.updatePadding
import com.jeanbarrossilva.period.extensions.view.searchFor
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ViewExtensionsTests {
    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    @Test
    fun searchFor_findsTextViewInFrameLayoutWithLayoutChild() {
        TextView(context).let { textView ->
            FrameLayout(context).let { layout ->
                layout.addView(
                    RelativeLayout(context).apply {
                        addView(textView)
                    }
                )

                assertEquals(textView, layout.searchFor<TextView>())
            }
        }
    }

    @Test
    fun updatePadding_paddingEquals90() {
        View(context).apply {
            updatePadding(left = 90, top = 90, right = 90, bottom = 90)
            listOf(paddingLeft, paddingTop, paddingRight, paddingBottom).forEach { padding ->
                assertEquals(padding, 90)
            }
        }
    }
}
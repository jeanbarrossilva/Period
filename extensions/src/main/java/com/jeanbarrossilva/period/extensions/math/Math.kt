package com.jeanbarrossilva.period.extensions

import kotlin.math.hypot

fun hypot(x: Int, y: Int) = hypot(x.toFloat(), y.toFloat())
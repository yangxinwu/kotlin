package org.jetbrains.kotlin.tools.projectWizard.core

import org.jetbrains.kotlin.tools.projectWizard.core.context.ReadingContext

typealias Checker = ReadingContext.() -> Boolean

val ALWAYS_AVAILABLE_CHECKER = checker { true }

fun checker(check: Checker) = check

interface ContextOwner {
    val context: Context
}

interface ActivityCheckerOwner {
    val isAvailable: Checker

    fun isActive(readingContext: ReadingContext) = isAvailable(readingContext)
}
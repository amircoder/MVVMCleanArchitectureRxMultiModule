package com.aba.core.extension

import org.mockito.ArgumentCaptor


/**
 * Returns ArgumentCaptor.capture() as nullable type to avoid java.lang.IllegalStateException
 * when null is returned.
 */
fun <T> capture(argumentCaptor: ArgumentCaptor<T>): T = argumentCaptor.capture()


/**
 * Helper function for creating an argumentCaptor in kotlin.
 */
inline fun <reified T : Any> argumentCaptor():  ArgumentCaptor<T> =
    ArgumentCaptor.forClass(T::class.java)
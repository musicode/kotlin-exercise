package com.musicode.weather.domain.command

interface Command<T> {
    fun execute(): T
}
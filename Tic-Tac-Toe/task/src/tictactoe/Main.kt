package tictactoe

import java.util.*
import kotlin.math.abs

val scanner = Scanner(System.`in`)
const val size = 3
var bfR = Array(size){Array<Char>(size){' '}}
var cells = ""
var isGameOver = false
var le = 'X'

fun main() {
    printField()
    while (!isGameOver) {
        userMove()
        printField()
        checkStatus()
        le = if (le == 'X') 'O' else 'X'
    }
}

fun userMove(){
    var isCorrect = false
    while(!isCorrect) {
        print("Enter the coordinates: ")
        val y = scanner.next()
        val x = scanner.next()
        if (!x[0].isDigit() || !y[0].isDigit()) {
            println("You should enter numbers!")
        }
        if (y.toInt() in 1..3 && x.toInt() in 1..3) {
            if (bfR[y.toInt() - 1][x.toInt() - 1] == ' ') {
                isCorrect = true
                bfR[y.toInt() - 1][x.toInt() - 1] = le
            } else {
                println("This cell is occupied! Choose another one!")
            }
        } else {
            println("Coordinates should be from 1 to 3!")
        }
    }
}

fun printField () {
    println("---------")
    bfR.forEach { println("| " + it.joinToString(" ") + " |") }
    println("---------")

}

fun checkStatus() {
    when {
        isWIn('X') -> {
            isGameOver = true
            println("X wins")
        }
        isWIn('O') -> {
            isGameOver = true
            println("O wins")
        }
        bfR.all { !it.contains(' ') } -> {
            isGameOver = true
            println("Draw")
        }
    }
}

fun isWIn(le: Char): Boolean {
    return bfR.get(0).get(0) == le && bfR.get(1).get(0) == le && bfR.get(2).get(0) == le ||
            bfR.get(0).get(1) == le && bfR.get(1).get(1) == le && bfR.get(2).get(1) == le ||
            bfR.get(0).get(2) == le && bfR.get(1).get(2) == le && bfR.get(2).get(2) == le ||
            bfR.get(0).get(2) == le && bfR.get(0).get(1) == le && bfR.get(0).get(0) == le ||
            bfR.get(1).get(2) == le && bfR.get(1).get(1) == le && bfR.get(1).get(0) == le ||
            bfR.get(2).get(2) == le && bfR.get(2).get(1) == le && bfR.get(2).get(0) == le ||
            bfR.get(0).get(0) == le && bfR.get(1).get(1) == le && bfR.get(2).get(2) == le ||
            bfR.get(2).get(0) == le && bfR.get(1).get(1) == le && bfR.get(0).get(2) == le
}
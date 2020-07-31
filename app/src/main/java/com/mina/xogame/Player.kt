package com.mina.xogame

class Player(val playerName: String, private val playerSymbol: Symbol, private val gameBoard: GameBoard) {

    fun play(cellNumber: Int): Boolean {
        val isSuccessfullyDrawn = gameBoard.draw(cellNumber, playerSymbol)
        if (isSuccessfullyDrawn) playerOneTurn = !playerOneTurn
        return isSuccessfullyDrawn
    }

    companion object {
        var playerOneTurn: Boolean = true
            private set
        fun setTurnToPlayerOne(){
            playerOneTurn = !playerOneTurn
        }
    }
}
package com.mina.xogame

class Player(val playerName:String,val playerSymbol: Symbol,val gameBoard: GameBoard) {

    fun play(cellNumber:Int):Boolean{
        val isSuccessfullyDrawn =gameBoard.draw(cellNumber,playerSymbol)
        if (isSuccessfullyDrawn) playerOneTurn=!playerOneTurn
        return isSuccessfullyDrawn
    }
    companion object{
        // true for player one and false for player two
        var playerOneTurn:Boolean=true
    }
}
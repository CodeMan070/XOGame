package com.mina.xogame

class GameBoard {
    private var cells: Array<Cell> = Array(9, init = { Cell(Symbol.BLANK) })
    var gameState: GameState = GameState.PLAYING
        private set

    fun draw(cellNumber: Int, symbol: Symbol): Boolean {
        var isDrawn = false
        if (gameState == GameState.PLAYING && cells[cellNumber].symbol == Symbol.BLANK) {
            cells[cellNumber].symbol = symbol
            isDrawn = true
        }
        checkIfPlayerWon(symbol)
        checkIfAllCellsFilled()
        return isDrawn

    }

    fun resetGame() {
        cells = Array<Cell>(9, init = { Cell(Symbol.BLANK) })
        gameState = GameState.PLAYING
        Player.setTurnToPlayerOne()
    }

    private fun checkIfPlayerWon(symbol: Symbol) {
        if (symbol == Symbol.X && (checkRows(symbol) || checkCols(symbol) || checkDiagonals(symbol))) {
            gameState = GameState.PLAYER_ONE_WON
        } else if (symbol == Symbol.O && (checkRows(symbol) || checkCols(symbol) || checkDiagonals(
                symbol
            ))
        ) {
            gameState = GameState.PLAYER_TWO_WON
        }
    }

    private fun checkRows(symbol: Symbol): Boolean {
        val topRow =
            symbol == cells[0].symbol && symbol == cells[1].symbol && symbol == cells[2].symbol
        val midRow =
            symbol == cells[3].symbol && symbol == cells[4].symbol && symbol == cells[5].symbol
        val bottomRow =
            symbol == cells[6].symbol && symbol == cells[7].symbol && symbol == cells[8].symbol

        return topRow || midRow || bottomRow
    }

    private fun checkCols(symbol: Symbol): Boolean {
        val topCol =
            symbol == cells[0].symbol && symbol == cells[3].symbol && symbol == cells[6].symbol
        val midCol =
            symbol == cells[1].symbol && symbol == cells[4].symbol && symbol == cells[7].symbol
        val bottomCol =
            symbol == cells[2].symbol && symbol == cells[5].symbol && symbol == cells[8].symbol

        return topCol || midCol || bottomCol
    }

    private fun checkDiagonals(symbol: Symbol): Boolean {
        val main =
            symbol == cells[0].symbol && symbol == cells[4].symbol && symbol == cells[8].symbol
        val sec =
            symbol == cells[2].symbol && symbol == cells[4].symbol && symbol == cells[6].symbol
        return main || sec
    }


    private fun checkIfAllCellsFilled() {
        var isAllCellsFilled = true
        for (cell in cells) {
            if (cell.symbol == Symbol.BLANK) {
                isAllCellsFilled = false
            }
        }
        if (isAllCellsFilled && gameState != GameState.PLAYER_ONE_WON && gameState != GameState.PLAYER_TWO_WON) {
            gameState = GameState.DRAW
        }
    }


}
package com.mina.xogame

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var gameBoard: GameBoard
    lateinit var player1: Player
    lateinit var player2: Player
    lateinit var cells: Array<ImageButton?>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        gameBoard = GameBoard()
        player1 = Player("Player 1", Symbol.X, gameBoard)
        player2 = Player("Player 2", Symbol.O, gameBoard)
        cells = Array(9) {
            val x = when (it) {
                0 -> button_1
                1 -> button_2
                2 -> button_3
                3 -> button_4
                4 -> button_5
                5 -> button_6
                6 -> button_7
                7 -> button_8
                8 -> button_9
                else -> null
            }
            x
        }
        for (button in cells) {
            button?.setOnClickListener(this)
            button?.scaleType =ImageView.ScaleType.FIT_XY
        }
//        button_1.setOnClickListener(this)
//        button_2.setOnClickListener(this)
//        button_3.setOnClickListener(this)
//        button_4.setOnClickListener(this)
//        button_5.setOnClickListener(this)
//        button_6.setOnClickListener(this)
//        button_7.setOnClickListener(this)
//        button_8.setOnClickListener(this)
//        button_9.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
//        when (gameBoard.gameState) {
//            GameState.PLAYING -> {
//                play(v)
//            }
//            GameState.PLAYER_ONE_WON -> {
//                Toast.makeText(this, "${player1.playerName} won !!", Toast.LENGTH_SHORT).show()
//            }
//            GameState.PLAYER_TWO_WON -> {
//                Toast.makeText(this, "${player2.playerName} won !!", Toast.LENGTH_SHORT).show()
//            }
//            GameState.DRAW -> {
//                Toast.makeText(this, "Game ended with no winner", Toast.LENGTH_SHORT).show()
//            }
//        }
        if (gameBoard.gameState == GameState.PLAYING) play(v)
        if (gameBoard.gameState == GameState.PLAYER_ONE_WON) Toast.makeText(
            this,
            "${player1.playerName} won !!",
            Toast.LENGTH_SHORT
        ).show()

        if (gameBoard.gameState == GameState.PLAYER_TWO_WON) Toast.makeText(
            this,
            "${player2.playerName} won !!",
            Toast.LENGTH_SHORT
        ).show()

        if (gameBoard.gameState == GameState.DRAW) Toast.makeText(
            this,
            "Game ended with no winner",
            Toast.LENGTH_SHORT
        ).show()

    }

    private fun play(v: View?) {
        if (Player.playerOneTurn) {
            when (v) {
                button_1 -> {
                    if (player1.play(0)) button_1.setImageResource(R.drawable.x_symbol)
                }
                button_2 -> {
                    if (player1.play(1)) button_2.setImageResource(R.drawable.x_symbol)
                }
                button_3 -> {
                    if (player1.play(2)) button_3.setImageResource(R.drawable.x_symbol)
                }
                button_4 -> {
                    if (player1.play(3)) button_4.setImageResource(R.drawable.x_symbol)
                }
                button_5 -> {
                    if (player1.play(4)) button_5.setImageResource(R.drawable.x_symbol)

                }
                button_6 -> {
                    if (player1.play(5)) button_6.setImageResource(R.drawable.x_symbol)
                }
                button_7 -> {
                    if (player1.play(6)) button_7.setImageResource(R.drawable.x_symbol)

                }
                button_8 -> {
                    if (player1.play(7)) button_8.setImageResource(R.drawable.x_symbol)
                }
                button_9 -> {
                    if (player1.play(8)) button_9.setImageResource(R.drawable.x_symbol)
                }
            }
        } else {
            when (v) {
                button_1 -> {
                    if (player2.play(0)) button_1.setImageResource(R.drawable.o_symbol)
                }
                button_2 -> {
                    if (player2.play(1)) button_2.setImageResource(R.drawable.o_symbol)
                }
                button_3 -> {
                    if (player2.play(2)) button_3.setImageResource(R.drawable.o_symbol)
                }
                button_4 -> {
                    if (player2.play(3)) button_4.setImageResource(R.drawable.o_symbol)
                }
                button_5 -> {
                    if (player2.play(4)) button_5.setImageResource(R.drawable.o_symbol)

                }
                button_6 -> {
                    if (player2.play(5)) button_6.setImageResource(R.drawable.o_symbol)
                }
                button_7 -> {
                    if (player2.play(6)) button_7.setImageResource(R.drawable.o_symbol)

                }
                button_8 -> {
                    if (player2.play(7)) button_8.setImageResource(R.drawable.o_symbol)
                }
                button_9 -> {
                    if (player2.play(8)) button_9.setImageResource(R.drawable.o_symbol)
                }
            }
        }
        Log.d(TAG, "onClick: here to baby")
    }


    companion object {
        private const val TAG = "MainActivity"
    }

    fun resetGame(view: View) {
        for (cell in cells) {
            cell?.setImageResource(R.drawable.ic_baseline_info_24)
        }
        gameBoard.resetGame()
    }

}

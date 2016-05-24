package com.j.images;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2015/7/27.
 */
public class PinBallActivity extends Activity {
    Random random = new Random();
    //桌面
    int tableWidth;
    int tableHeight;
    //球
    int ballSize = 36;
    //    int ballX = random.nextInt(20) + ballSize;
//    int ballY = random.nextInt(10) + ballSize;
    int ballX = ballSize + 10;
    int ballY = ballSize + 10;
    //球拍
    int racketX = random.nextInt(100);
    //    int racketX = 0;
    int racketY;
    int racket_width = 200;
    int racket_height = 30;
    //
    int ySpeed = 30;
    double xyRate = random.nextDouble() - 0.5;
    int xSpeed = (int) (ySpeed * xyRate * 2);

    boolean isGameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final GameView gameView = new GameView(this);
        setContentView(gameView);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        display.getMetrics(displayMetrics);

        tableWidth = displayMetrics.widthPixels;
        tableHeight = displayMetrics.heightPixels;
        racketY = tableHeight - 200;

        gameView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                racketX = (int) event.getX();
                racketY = (int) event.getY();
                gameView.invalidate();
                return true;
            }
        });

        final Handler handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
                if (msg.what == 0x123) {
                    gameView.invalidate();
                }
            }
        };

        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int ballLeft = ballX - ballSize;
                int ballRight = ballX + ballSize;
                int ballTop = ballY - ballSize;
                int ballBottom = ballY + ballSize;
                if (ballLeft <= 0 || ballRight >= tableWidth) {
                    xSpeed = -xSpeed;
                }
                if (ballBottom > racketY && (ballX < racketX || ballX > racketX + racket_width)) {
                    timer.cancel();
                    isGameOver = true;
                } else if (ballTop <= 0 || (ballBottom >= racketY
                        && ballX > racketX && ballX <= racketX + racket_width)) {
                    ySpeed = -ySpeed;
                }
                ballY += ySpeed;
                ballX += xSpeed;
                handler.sendEmptyMessage(0x123);
            }
        }, 0, 100);
    }


    class GameView extends View {
        Paint paint = new Paint();

        public GameView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            paint.setStyle(Paint.Style.FILL);
            if (isGameOver) {
                paint.setColor(Color.RED);
                paint.setTextSize(60);
                canvas.drawText("游戏结束", tableWidth / 2 - 100, 200, paint);
            } else {
                paint.setColor(Color.rgb(255, 0, 0));
                canvas.drawCircle(ballX, ballY, ballSize, paint);
                paint.setColor(Color.BLUE);
                canvas.drawRect(racketX, racketY, racketX + racket_width, racketY + racket_height, paint);
            }

        }
    }

}

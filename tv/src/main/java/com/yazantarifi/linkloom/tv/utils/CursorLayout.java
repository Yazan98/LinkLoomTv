package com.yazantarifi.linkloom.tv.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class CursorLayout extends FrameLayout {
    public static final int CURSOR_DISAPPEAR_TIMEOUT = 5000;
    public static int CURSOR_RADIUS = 0;
    public static float CURSOR_STROKE_WIDTH = 0.0f;
    public static float MAX_CURSOR_SPEED = 0.0f;
    public static int SCROLL_START_PADDING = 100;
    public static final int UNCHANGED = -100;
    public int EFFECT_DIAMETER;
    public int EFFECT_RADIUS;
    private Callback callback;
    /* access modifiers changed from: private */
    public Point cursorDirection = new Point(0, 0);
    /* access modifiers changed from: private */
    public Runnable cursorHideRunnable = new Runnable() {
        public void run() {
            CursorLayout.this.invalidate();
        }
    };
    /* access modifiers changed from: private */
    public PointF cursorPosition = new PointF(0.0f, 0.0f);
    /* access modifiers changed from: private */
    public PointF cursorSpeed = new PointF(0.0f, 0.0f);
    private Runnable cursorUpdateRunnable = new Runnable() {
        public void run() {
            if (CursorLayout.this.getHandler() != null) {
                CursorLayout.this.getHandler().removeCallbacks(CursorLayout.this.cursorHideRunnable);
            }
            long currentTimeMillis = System.currentTimeMillis();
            long access$100 = currentTimeMillis - CursorLayout.this.lastCursorUpdate;
            CursorLayout.this.lastCursorUpdate = currentTimeMillis;
            float f = ((float) access$100) * 0.05f;
            PointF access$200 = CursorLayout.this.cursorSpeed;
            CursorLayout cursorLayout = CursorLayout.this;
            float f2 = cursorLayout.cursorSpeed.x;
            CursorLayout cursorLayout2 = CursorLayout.this;
            float access$400 = cursorLayout.bound(f2 + (cursorLayout2.bound((float) cursorLayout2.cursorDirection.x, 1.0f) * f), CursorLayout.MAX_CURSOR_SPEED);
            CursorLayout cursorLayout3 = CursorLayout.this;
            float f3 = cursorLayout3.cursorSpeed.y;
            CursorLayout cursorLayout4 = CursorLayout.this;
            access$200.set(access$400, cursorLayout3.bound(f3 + (cursorLayout4.bound((float) cursorLayout4.cursorDirection.y, 1.0f) * f), CursorLayout.MAX_CURSOR_SPEED));
            if (Math.abs(CursorLayout.this.cursorSpeed.x) < 0.1f) {
                CursorLayout.this.cursorSpeed.x = 0.0f;
            }
            if (Math.abs(CursorLayout.this.cursorSpeed.y) < 0.1f) {
                CursorLayout.this.cursorSpeed.y = 0.0f;
            }
            if (CursorLayout.this.cursorDirection.x == 0 && CursorLayout.this.cursorDirection.y == 0 && CursorLayout.this.cursorSpeed.x == 0.0f && CursorLayout.this.cursorSpeed.y == 0.0f) {
                if (CursorLayout.this.getHandler() != null) {
                    CursorLayout.this.getHandler().postDelayed(CursorLayout.this.cursorHideRunnable, 5000);
                }
                return;
            }
            CursorLayout.this.tmpPointF.set(CursorLayout.this.cursorPosition);
            CursorLayout.this.cursorPosition.offset(CursorLayout.this.cursorSpeed.x, CursorLayout.this.cursorSpeed.y);
            Log.d("cursor1234_xxxx", String.valueOf(CursorLayout.this.cursorPosition.x));
            Log.d("cursor1234_yyyy", String.valueOf(CursorLayout.this.cursorPosition.y));
            if (CursorLayout.this.cursorPosition.x < 0.0f) {
                CursorLayout.this.cursorPosition.x = 0.0f;
            } else if (CursorLayout.this.cursorPosition.x > ((float) (CursorLayout.this.getWidth() - 1))) {
                CursorLayout.this.cursorPosition.x = (float) (CursorLayout.this.getWidth() - 1);
            }
            if (CursorLayout.this.cursorPosition.y < 0.0f) {
                CursorLayout.this.cursorPosition.y = 0.0f;
            } else if (CursorLayout.this.cursorPosition.y > ((float) (CursorLayout.this.getHeight() - 1))) {
                CursorLayout.this.cursorPosition.y = (float) (CursorLayout.this.getHeight() - 1);
            }
            if (!CursorLayout.this.tmpPointF.equals(CursorLayout.this.cursorPosition) && CursorLayout.this.dpadCenterPressed) {
                CursorLayout cursorLayout5 = CursorLayout.this;
                cursorLayout5.dispatchMotionEvent(cursorLayout5.cursorPosition.x, CursorLayout.this.cursorPosition.y, 2);
            }
            View childAt = CursorLayout.this.getChildAt(0);
            if (childAt != null) {
                if (CursorLayout.this.cursorPosition.y > ((float) (CursorLayout.this.getHeight() - CursorLayout.SCROLL_START_PADDING))) {
                    if (CursorLayout.this.cursorSpeed.y > 0.0f && childAt.canScrollVertically((int) CursorLayout.this.cursorSpeed.y)) {
                        childAt.scrollTo(childAt.getScrollX(), childAt.getScrollY() + ((int) CursorLayout.this.cursorSpeed.y));
                    }
                } else if (CursorLayout.this.cursorPosition.y < ((float) CursorLayout.SCROLL_START_PADDING) && CursorLayout.this.cursorSpeed.y < 0.0f && childAt.canScrollVertically((int) CursorLayout.this.cursorSpeed.y)) {
                    childAt.scrollTo(childAt.getScrollX(), childAt.getScrollY() + ((int) CursorLayout.this.cursorSpeed.y));
                }
                if (CursorLayout.this.cursorPosition.x > ((float) (CursorLayout.this.getWidth() - CursorLayout.SCROLL_START_PADDING))) {
                    if (CursorLayout.this.cursorSpeed.x > 0.0f && childAt.canScrollHorizontally((int) CursorLayout.this.cursorSpeed.x)) {
                        childAt.scrollTo(childAt.getScrollX() + ((int) CursorLayout.this.cursorSpeed.x), childAt.getScrollY());
                    }
                } else if (CursorLayout.this.cursorPosition.x < ((float) CursorLayout.SCROLL_START_PADDING) && CursorLayout.this.cursorSpeed.x < 0.0f && childAt.canScrollHorizontally((int) CursorLayout.this.cursorSpeed.x)) {
                    childAt.scrollTo(childAt.getScrollX() + ((int) CursorLayout.this.cursorSpeed.x), childAt.getScrollY());
                }
            }
            CursorLayout.this.invalidate();
            if (CursorLayout.this.getHandler() != null) {
                CursorLayout.this.getHandler().post(this);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean dpadCenterPressed = false;
    /* access modifiers changed from: private */
    public long lastCursorUpdate = System.currentTimeMillis();
    private Paint paint = new Paint();
    PointF tmpPointF = new PointF();

    public interface Callback {
        void onUserInteraction();
    }

    /* access modifiers changed from: private */
    public float bound(float f, float f2) {
        if (f > f2) {
            return f2;
        }
        float f3 = -f2;
        return f < f3 ? f3 : f;
    }

    public CursorLayout(Context context) {
        super(context);
        init();
    }

    public CursorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            this.paint.setAntiAlias(true);
            setWillNotDraw(false);
            Display defaultDisplay = ((WindowManager) getContext().getSystemService(getContext().WINDOW_SERVICE)).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            this.EFFECT_RADIUS = point.x / 20;
            this.EFFECT_DIAMETER = this.EFFECT_RADIUS * 2;
            CURSOR_STROKE_WIDTH = (float) (point.x / 400);
            CURSOR_RADIUS = point.x / 110;
            MAX_CURSOR_SPEED = (float) (point.x / 25);
            SCROLL_START_PADDING = point.x / 15;
        }
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onUserInteraction();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!isInEditMode()) {
            this.cursorPosition.set(((float) i) / 2.0f, ((float) i2) / 2.0f);
            if (getHandler() != null) {
                getHandler().postDelayed(this.cursorHideRunnable, 5000);
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onUserInteraction();
        }
        int keyCode = keyEvent.getKeyCode();
        if (!(keyCode == 66 || keyCode == 160)) {
            switch (keyCode) {
                case 19:
                    if (keyEvent.getAction() == 0) {
                        if (this.cursorPosition.y <= 0.0f) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        handleDirectionKeyEvent(keyEvent, -100, -1, true);
                    } else if (keyEvent.getAction() == 1) {
                        handleDirectionKeyEvent(keyEvent, -100, 0, false);
                    }
                    return true;
                case 20:
                    if (keyEvent.getAction() == 0) {
                        if (this.cursorPosition.y >= ((float) getHeight())) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        handleDirectionKeyEvent(keyEvent, -100, 1, true);
                    } else if (keyEvent.getAction() == 1) {
                        handleDirectionKeyEvent(keyEvent, -100, 0, false);
                    }
                    return true;
                case 21:
                    if (keyEvent.getAction() == 0) {
                        if (this.cursorPosition.x <= 0.0f) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        handleDirectionKeyEvent(keyEvent, -1, -100, true);
                    } else if (keyEvent.getAction() == 1) {
                        handleDirectionKeyEvent(keyEvent, 0, -100, false);
                    }
                    return true;
                case 22:
                    if (keyEvent.getAction() == 0) {
                        if (this.cursorPosition.x >= ((float) getWidth())) {
                            return super.dispatchKeyEvent(keyEvent);
                        }
                        handleDirectionKeyEvent(keyEvent, 1, -100, true);
                    } else if (keyEvent.getAction() == 1) {
                        handleDirectionKeyEvent(keyEvent, 0, -100, false);
                    }
                    return true;
                case 23:
                    break;
                default:
                    switch (keyCode) {
                        case 268:
                            if (keyEvent.getAction() == 0) {
                                handleDirectionKeyEvent(keyEvent, -1, -1, true);
                            } else if (keyEvent.getAction() == 1) {
                                handleDirectionKeyEvent(keyEvent, 0, 0, false);
                            }
                            return true;
                        case 269:
                            if (keyEvent.getAction() == 0) {
                                handleDirectionKeyEvent(keyEvent, -1, 1, true);
                            } else if (keyEvent.getAction() == 1) {
                                handleDirectionKeyEvent(keyEvent, 0, 0, false);
                            }
                            return true;
                        case 270:
                            if (keyEvent.getAction() == 0) {
                                handleDirectionKeyEvent(keyEvent, 1, -1, true);
                            } else if (keyEvent.getAction() == 1) {
                                handleDirectionKeyEvent(keyEvent, 0, 0, false);
                            }
                            return true;
                        case 271:
                            if (keyEvent.getAction() == 0) {
                                handleDirectionKeyEvent(keyEvent, 1, 1, true);
                            } else if (keyEvent.getAction() == 1) {
                                handleDirectionKeyEvent(keyEvent, 0, 0, false);
                            }
                            return true;
                    }
            }
        }
        if (!isCursorDissappear()) {
            if (keyEvent.getAction() == 0 && !getKeyDispatcherState().isTracking(keyEvent)) {
                getKeyDispatcherState().startTracking(keyEvent, this);
                this.dpadCenterPressed = true;
                dispatchMotionEvent(this.cursorPosition.x, this.cursorPosition.y, 0);
            } else if (keyEvent.getAction() == 1) {
                getKeyDispatcherState().handleUpEvent(keyEvent);
                dispatchMotionEvent(this.cursorPosition.x, this.cursorPosition.y, 1);
                this.dpadCenterPressed = false;
            }
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: private */
    public void dispatchMotionEvent(float f, float f2, int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long uptimeMillis2 = SystemClock.uptimeMillis();
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = 0;
        pointerProperties.toolType = MotionEvent.TOOL_TYPE_FINGER;
        MotionEvent.PointerProperties[] pointerPropertiesArr = {pointerProperties};
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.x = f;
        pointerCoords.y = f2;
        pointerCoords.pressure = 1.0f;
        pointerCoords.size = 1.0f;
        dispatchTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis2, i, 1, pointerPropertiesArr, new MotionEvent.PointerCoords[]{pointerCoords}, 0, 0, 1.0f, 1.0f, 0, 0, 0, 0));
    }

    private void handleDirectionKeyEvent(KeyEvent keyEvent, int i, int i2, boolean z) {
        this.lastCursorUpdate = System.currentTimeMillis();
        if (!z) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
            this.cursorSpeed.set(0.0f, 0.0f);
        } else if (!getKeyDispatcherState().isTracking(keyEvent)) {
            Handler handler = getHandler();
            handler.removeCallbacks(this.cursorUpdateRunnable);
            handler.post(this.cursorUpdateRunnable);
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else {
            return;
        }
        Point point = this.cursorDirection;
        if (i == -100) {
            i = point.x;
        }
        if (i2 == -100) {
            i2 = this.cursorDirection.y;
        }
        point.set(i, i2);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!isInEditMode() && !isCursorDissappear()) {
            float f = this.cursorPosition.x;
            float f2 = this.cursorPosition.y;
            this.paint.setColor(Color.argb(128, 255, 255, 255));
            this.paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f, f2, (float) CURSOR_RADIUS, this.paint);
            this.paint.setColor(-7829368);
            this.paint.setStrokeWidth(CURSOR_STROKE_WIDTH);
            this.paint.setStyle(Paint.Style.STROKE);
            canvas.drawCircle(f, f2, (float) CURSOR_RADIUS, this.paint);
        }
    }

    private boolean isCursorDissappear() {
        return System.currentTimeMillis() - this.lastCursorUpdate > 5000;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }}
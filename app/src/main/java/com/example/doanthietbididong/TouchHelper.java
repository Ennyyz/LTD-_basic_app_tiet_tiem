package com.example.doanthietbididong;

import android.graphics.Canvas;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator;

public class TouchHelper extends  ItemTouchHelper.SimpleCallback {
    // import thư viện vào gradle
    // implementation 'it.xabaras.android:recyclerview-swipedecorator:1.4'
    private MyAdapter adapter;
    public TouchHelper(MyAdapter adapter) {
        super(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
        this.adapter = adapter;
    }
    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        final int positon = viewHolder.getAdapterPosition();
        if(direction == ItemTouchHelper.LEFT) {
            adapter.notifyDataSetChanged();
        } else {
            adapter.deleteData(positon);
        }
    }
    // xem ví dụ tại
    //https://github.com/xabaras/RecyclerViewSwipeDecorator

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                .addSwipeRightBackgroundColor(Color.RED)
                .addSwipeRightActionIcon(R.drawable.baseline_delete_24)
                .create()
                .decorate();
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
    }
}
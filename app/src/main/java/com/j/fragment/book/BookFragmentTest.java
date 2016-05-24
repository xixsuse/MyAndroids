package com.j.fragment.book;

import android.app.Activity;
import android.os.Bundle;

import com.j.R;


public class BookFragmentTest extends Activity implements
        BookListFragment.Callbacks {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_main);
    }

    // 实现Callbacks接口必须实现的方法
    @Override
    public void onItemSelected(Integer id) {
        // 创建Bundle，准备向Fragment传入参数
        Bundle bundle = new Bundle();
        bundle.putInt(BookDetailFragment.ITEM_ID, id);
        // 创建BookDetailFragment对象
        BookDetailFragment fragment = new BookDetailFragment();
        // 向Fragment传入参数
        fragment.setArguments(bundle);
        // 使用fragment替换book_detail_container容器当前显示的Fragment
        getFragmentManager().beginTransaction()
                .replace(R.id.BookMain_detailContainer, fragment)
                .commit();  // ①
    }

}


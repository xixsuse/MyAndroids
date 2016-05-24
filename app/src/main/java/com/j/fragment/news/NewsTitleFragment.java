package com.j.fragment.news;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.j.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2015/9/10.
 */
public class NewsTitleFragment extends Fragment {
    ListView newsTitleListView;
    ArrayList<News> newsList;
    NewsAdapter adapter;
    boolean isTwoPane;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        newsList = initNews();
        adapter = new NewsAdapter(activity, R.layout.news_item, newsList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_fragment, container, false);
        newsTitleListView = (ListView) view.findViewById(R.id.NewsTitleFragment_listView);
        newsTitleListView.setAdapter(adapter);
        newsTitleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                News news = newsList.get(position);
                if (isTwoPane) {
                    NewsContentFragment newsContentFragment = (NewsContentFragment) getFragmentManager().findFragmentById(R.id.NewsMain_newsContentFragment);
                    newsContentFragment.refresh(news.getTitle(), news.getContent());
                } else {
                    NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
                }
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isTwoPane = getActivity().findViewById(R.id.NewsMain_newsContentFragment) != null;
    }

    ArrayList<News> initNews() {
        ArrayList<News> list = new ArrayList<>();
        News news1 = new News("Succeed in College as a Learning Disabled Student", "College freshmen will soon learn to live with a roommate, adjust to a new social scene and survive less-than-stellar dining hall food. Students with learning disabilities will face these transitions while also grappling with a few more hurdles.");
        News news2 = new News("Google Android exec poached by China's Xiaomi", "China's Xiaomi has poached a key Google executive involved in the tech giant's Android phones, in a move seen as a coup for the rapidly growing Chinese smartphone maker.");
        list.add(news1);
        list.add(news2);
        return list;
    }

}

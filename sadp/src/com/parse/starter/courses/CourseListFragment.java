package com.parse.starter.courses;

import com.parse.starter.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class CourseListFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.course_list_fragment, container, false);
		
		ListView courseListView = (ListView)root.findViewById(R.id.CourseListView);
		courseListView.setAdapter(getMockListAdapter());
		
		return root;
	}
	
	private ListAdapter getMockListAdapter() {
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        // Add Items
        adapter.add("情報システム設計論Ⅰ");
        adapter.add("情報システム設計論Ⅱ");
        adapter.add("情報システム分析論");
        return adapter;
	}
}

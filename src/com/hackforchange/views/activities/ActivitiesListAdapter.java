package com.hackforchange.views.activities;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.hackforchange.R;
import com.hackforchange.models.activities.Activities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ActivitiesListAdapter extends ArrayAdapter<Activities> {
  Context context;
  int layoutResourceId;
  List<Activities> data = null;
  View row;

  public ActivitiesListAdapter (Context context, int layoutResourceId, List<Activities> data) {
    super(context, layoutResourceId, data);
    this.layoutResourceId = layoutResourceId;
    this.context = context;
    this.data = data;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    row = convertView;
    ActivitiesHolder holder = null;

    if(row == null)
    {
      LayoutInflater inflater = ((Activity)context).getLayoutInflater();
      row = inflater.inflate(layoutResourceId, parent, false);

      holder = new ActivitiesHolder();
      //holder.imgIcon = (ImageView)row.findViewById(R.id.imgIcon);
      holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
      holder.startDate = (TextView)row.findViewById(R.id.startDate);
      holder.endDate = (TextView)row.findViewById(R.id.endDate);

      row.setTag(holder);
    }
    else
      holder = (ActivitiesHolder)row.getTag();

    Activities project = data.get(position);
    holder.txtTitle.setText(project.getTitle());
    DateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
    Date d = new Date(project.getStartDate());
    holder.startDate.setText("Start: "+parser.format(d));
    d = new Date(project.getEndDate());
    holder.endDate.setText("End: "+parser.format(d));

    return row;
  }
}

class ActivitiesHolder {
  //ImageView imgIcon;
  TextView txtTitle;
  TextView startDate;
  TextView endDate;
}
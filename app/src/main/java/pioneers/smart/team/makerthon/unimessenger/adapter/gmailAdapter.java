package pioneers.smart.team.makerthon.unimessenger.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import pioneers.smart.team.makerthon.unimessenger.R;
import pioneers.smart.team.makerthon.unimessenger.helper.MailItem;

public class gmailAdapter extends BaseAdapter
{
    Context mContext;
    ArrayList<MailItem> mList;

    public gmailAdapter(Context aContext, ArrayList<MailItem> aList)
    {
        this.mContext = aContext;
        this.mList = aList;
    }

    @Override
    public int getCount() { return mList.size(); }

    @Override
    public Object getItem(int position) { return mList.get(position); }

    @Override
    public long getItemId(int position) { return 0; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View rowview = convertView;
        ViewHolder holder;

        if (rowview == null)
        {
            holder = new ViewHolder();
            final LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowview = inflater.inflate(R.layout.row_gmail_list, parent, false);
            holder.userImageView = (ImageView) rowview.findViewById(R.id.mail_pic);
            holder.subjectView = (TextView)rowview.findViewById(R.id.mail_subject);
            holder.fromView = (TextView)rowview.findViewById(R.id.mail_from);
            rowview.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }

        MailItem aItem = (MailItem) getItem(position);
        holder.userImageView.setImageDrawable(aItem.getAvatar());
        holder.subjectView.setText(aItem.getSubject());
        holder.fromView.setText(aItem.getSenderName());
        return rowview;
    }

    static class ViewHolder
    {
        ImageView userImageView;
        TextView fromView;
        TextView subjectView;
    }
}
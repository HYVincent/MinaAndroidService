package com.example.vincent.minaandroidservice.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vincent.minaandroidservice.R;
import com.example.vincent.minaandroidservice.bean.MsgBean;

import java.util.List;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name MinaAndroidService
 * @page com.example.vincent.minaandroidservice.adapter
 * @class describe
 * @date 2018/3/29 10:17
 */
public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgViewHolder> {

    private List<MsgBean> data;
    private Context mContext;

    public MsgAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<MsgBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MsgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        return new MsgViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_layout_msg,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MsgViewHolder holder, int position) {
        MsgBean bean = data.get(position);
        if(bean.getType() == 0){
            //client
            holder.msgType.setText("client:");
        }else {
            //service
            holder.msgType.setText("service:");
        }
        holder.msgContext.setText(bean.getContent());
    }

    @Override
    public int getItemCount() {
        return data == null?0:data.size();
    }

    class MsgViewHolder extends RecyclerView.ViewHolder{

        private TextView msgType,msgContext;

        public MsgViewHolder(View itemView) {
            super(itemView);
            msgType = itemView.findViewById(R.id.item_msg_type);
            msgContext = itemView.findViewById(R.id.item_msg_content);
        }
    }
}

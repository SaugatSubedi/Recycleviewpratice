package com.saugat.recycleviewpratice;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsAdapter  extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {

    Context mContext;
    List<Contacts> contactsList;

    public ContactsAdapter(Context mContext, List<Contacts> contactsList){
        this.mContext = mContext;
        this.contactsList = contactsList;
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contactview, parent, false);
        return new ContactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsViewHolder holder, int position) {
        final Contacts contacts = contactsList.get(position);
        holder.imgProfile.setImageResource(contacts.getImageId());
        holder.tvName.setText(contacts.getName());
        holder.tvMessage.setText(contacts.getMessage());
        holder.tvTime.setText(contacts.getTime());

        // Adding Click Listener in an image view
        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ContactDetails.class);
                intent.putExtra("image", contacts.getImageId());
                intent.putExtra("name", contacts.getName());
                intent.putExtra("message", contacts.getMessage());
                intent.putExtra("time", contacts.getTime());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    class ContactsViewHolder extends RecyclerView.ViewHolder {

        ImageView imgProfile;
        TextView tvName, tvMessage, tvTime;


        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imageProfile);
            tvName = itemView.findViewById(R.id.textName);
            tvMessage = itemView.findViewById(R.id.textMessage);
            tvTime = itemView.findViewById(R.id.textTime);
        }
    }
}

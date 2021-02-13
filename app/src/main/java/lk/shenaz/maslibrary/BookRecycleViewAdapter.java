package lk.shenaz.maslibrary;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class BookRecycleViewAdapter extends RecyclerView.Adapter<BookRecycleViewAdapter.MyViewHolder> {

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvbookName, tvbookAuthor, tvbookRating,tvbookDes;
        Button btnVideo;

        public  MyViewHolder(@NonNull View itemView){
            super(itemView);
            tvbookName =(TextView) itemView.findViewById(R.id.tvbookName);
            tvbookAuthor =(TextView) itemView.findViewById(R.id.tvbookAuthor);
            tvbookRating =(TextView) itemView.findViewById(R.id.tvbookRating);
            tvbookDes =(TextView) itemView.findViewById(R.id.tvbookDes);
            btnVideo =(Button) itemView.findViewById(R.id.btnyoutube);

        }
    }

    private Context context;
    private List<Book> bookList;

    public BookRecycleViewAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View itemView=layoutInflater.inflate(R.layout.activity_book_row_item, parent,false);//xml to java object
        MyViewHolder myViewHolder= new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BookRecycleViewAdapter.MyViewHolder holder, int position) {// this ia like an loop
        final Book book = bookList.get(position);//goes from the 0
        holder.tvbookName.setText(book.getBookName());
        holder.tvbookAuthor.setText(book.getBookAuthor());
        holder.tvbookRating.setText(book.getRating());
        holder.tvbookDes.setText(book.getDescription());

        holder.btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, YoutubeActivity.class);
                intent.putExtra("url", book.getVideo());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() { //you can dynamiclly load the item
        return bookList.size();
    }





}

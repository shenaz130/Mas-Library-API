package lk.shenaz.maslibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LibraryArrayAdapter extends ArrayAdapter<Book> {

    class ViewHolder {
        TextView tvbookName;
        TextView tvbookAuthor;
        TextView tvbookRating;
        TextView tvbookDes;

        public ViewHolder(View convertView) {
            tvbookName = (TextView) convertView.findViewById(R.id.tvbookName);
            tvbookAuthor = (TextView) convertView.findViewById(R.id.tvbookAuthor);
            tvbookRating = (TextView) convertView.findViewById(R.id.tvbookRating);
            tvbookDes = (TextView) convertView.findViewById(R.id.tvbookDes);
        }

    }
    private Context context;
    private List<Book> bookList;


    public LibraryArrayAdapter(@NonNull Context context, List<Book> bookList) {
        super(context, 0);
        this.context =context;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return this.bookList.size();
    }

    @Nullable
    @Override
    public Book getItem(int position) {
        return this.bookList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater layoutInflater =LayoutInflater.from(context);
            convertView =layoutInflater.inflate(R.layout.activity_book_row_item,parent, false);
            viewHolder = new  ViewHolder(convertView);
            convertView.setTag(viewHolder);

        } else {
            viewHolder  = (ViewHolder) convertView.getTag();
        }

        Book book = this.bookList.get(position);
        viewHolder.tvbookName.setText(book.getBookName());
        viewHolder.tvbookAuthor.setText(book.getBookAuthor());
        viewHolder.tvbookRating.setText(book.getRating());
        viewHolder.tvbookDes.setText(book.getDescription());




        return convertView;
    }
}
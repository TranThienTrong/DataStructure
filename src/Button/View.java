package Button;

public class View {

    public void setOnClickListener(View.OnClickListener view) {
        view.onClick(this);
    }

    public interface OnClickListener {
        void onClick(View view);
    }

}

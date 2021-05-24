package Button;

import Button.View;

public class UI implements View.OnClickListener{

    public ViewChild viewChild = new ViewChild(1);
    public ViewChild viewChild2 = new ViewChild(2);

    void doSth(){
        viewChild2.setOnClickListener(this);
        viewChild.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        System.out.println(view);
    }
}
